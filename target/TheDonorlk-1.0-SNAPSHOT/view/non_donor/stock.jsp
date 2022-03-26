<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.util.*" %>

<%
    if (session.getAttribute("username") == null) {
        response.sendRedirect(request.getContextPath() + "/login.jsp");
    }
    Object role = session.getAttribute("role");
    Object bloodbank = session.getAttribute("bloodbank");

    String selected_bank = String.valueOf(request.getAttribute("selectedBank"));
%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>TheDonor.lk</title>
    <link rel="stylesheet"
          href="https://maxst.icons8.com/vue-static/landings/line-awesome/line-awesome/1.3.0/css/line-awesome.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/public/css/styles.css">

    <script src="<%=request.getContextPath()%>/public/scripts/action_confirmation.js"></script>
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.11.5/css/jquery.dataTables.css">
    <link rel="stylesheet" type="text/css"
          href="https://cdn.datatables.net/searchpanes/2.0.0/css/searchPanes.dataTables.min.css">
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/select/1.3.4/css/select.dataTables.min.css">
    <script type="text/javascript" charset="utf8"
            src="https://cdn.datatables.net/1.11.5/js/jquery.dataTables.js"></script>
    <script type="text/javascript" charset="utf8"
            src="https://code.jquery.com/jquery-3.5.1.js"></script>
    <script type="text/javascript" charset="utf8"
            src="https://cdn.datatables.net/1.11.5/js/jquery.dataTables.min.js"></script>
    <script type="text/javascript" charset="utf8"
            src="https://cdn.datatables.net/searchpanes/2.0.0/js/dataTables.searchPanes.min.js"></script>
    <script type="text/javascript" charset="utf8"
            src="https://cdn.datatables.net/select/1.3.4/js/dataTables.select.min.js"></script>
    <script>
        $(document).ready(function () {
            /*$('#one tfoot th').each(function() {
                var title = $(this).text();
                $(this).html('<input type="text" placeholder="Search ' + title + '" />');
            });*/

            var table = $('#table_id').DataTable({
                "order": [[0, "desc"]],
                searchPanes: {
                    columns: [3, 2, 4]
                },
                dom: 'Plfrtip'
            });

            /*table.columns().every( function() {
                var that = this;

                $('input', this.footer()).on('keyup change', function() {
                    if (that.search() !== this.value) {
                        that
                            .search(this.value)
                            .draw();
                    }
                });
            });*/

        });
    </script>

    <% if (request.getAttribute("SendTo") != null) {
        System.out.println("Test"); %>
    <script>
        $(document).ready(function () {
            $.ajax({
                url: "https://meghaduta.dhahas.com/sms/sendSMS",
                type: "POST",
                data: JSON.stringify({
                    "senders": ["+94<%=request.getAttribute("SendTo")%>"],
                    "message": "<%=request.getAttribute("Message")%>",
                    "apiKey": "61df3f8b36fe65003089ed1b"
                }),
                dataType: 'json',
                contentType: 'application/json',
                success: function (response) {
                    console.log(response);
                },
                error: function (error) {
                    console.log("Something went wrong", error);
                }
            });
        });
    </script>
    <% } %>
</head>

<body>
<main>
    <%
        String reg_msg = "";
        reg_msg = reg_msg == null ? "" : (String) request.getAttribute("error");
        if (reg_msg != null) {
    %>
    <div id="error_message">
        <%= reg_msg %>
    </div>
    <% } %>

    <%--Custom Blood bank filter--%>
    <%--<div class="recent-grid">
        <form action="bloodStock" method="post">
            <div class="card">
                <div class="modal-body">
                    <div class="fields" style="grid-template-columns: repeat(1, 1fr); justify-content: center;">
                        <div class="field-single" style="justify-content: center;">
                            <span style="padding: 10px;">Select Blood Bank</span>
                            <select class="box" name="bank" id="bank_switch">
                                <option value="all">All</option>
                                <c:set var="s_bank" value="<%= selected_bank %>"/>
                                <c:forEach var="bank" items="${listBloodBank}">
                                    <option value="<c:out value='${bank.code}'/>" ${bank.code == s_bank ? 'selected': ''}>
                                        <c:out value="${bank.name}"/></option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="modal-submit-button" style="padding-top: 0px;">
                    <div class="buttons">
                        <button type="submit" class="bottom-full">Next</button>
                    </div>
                </div>
            </div>
        </form>
    </div>--%>

    <div class="recent-grid">
        <div class="card">
            <div class="card-header">
                <h3>Blood Stock</h3>
                <%--<div class="search-wrapper">
                    <span class="las la-search"></span>
                    <input type="search" placeholder="search here"/>
                    <span class="las la-calendar-week"></span>
                </div>--%>
                <div class="buttons">
                </div>
                <div></div>
            </div>

            <div class="card-body">
                <div class="table-responsive">
                    <table width="100%" id="table_id">
                        <thead>
                        <tr>
                            <td>Blood ID</td>
                            <td>Blood Barcode</td>
                            <td>Blood Product</td>
                            <td>Blood Group</td>
                            <td>Blood Bank</td>
                            <td>Col Date</td>
                            <td>Pro Date</td>
                            <td>Exp Time</td>
                            <td>Status</td>
                            <% if (role.equals("bloodbank")) { %>
                            <td>Actions</td>
                            <% } %>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="stock" items="${listStock}">
                            <tr>
                                <td><c:out value="${stock.id}"/></td>
                                <td><c:out value="${stock.blood_barcode}"/></td>
                                <td><c:out value="${stock.blood_product}"/></td>
                                <td><c:out value="${stock.blood_group}"/></td>
                                <td><c:out value="${stock.bloodbank_code}"/></td>
                                <td><c:out value="${stock.collected_date}"/></td>
                                <td><c:out value="${stock.processed_date}"/></td>
                                <td>
                                    <c:out value="${stock.expiry_date}"/>

                                    <jsp:useBean id="now" class="java.util.Date"/>

                                    <c:set var="expiry" value="${stock.expiry_date}"/>
                                    <fmt:parseDate value="${expiry}" var="parsedExpiryDate"
                                                   pattern="yyyy-MM-dd"/>

                                    <c:if test="${parsedExpiryDate ge now && stock.status == 'Active'}">
                                        <span class="status Removed">Expired</span>
                                    </c:if>
                                </td>
                                <td>
                                    <c:if test="${stock.status == 'NOT_Processed'}">
                                        <span class="status open">NOT_Processed</span>
                                    </c:if>
                                    <c:if test="${stock.status == 'Processed'}">
                                        <span class="status cancelled">Processed</span>
                                    </c:if>
                                    <c:if test="${stock.status == 'Active'}">
                                        <span class="status progress">Active</span>
                                    </c:if>
                                    <c:if test="${stock.status == 'Transfused'}">
                                        <span class="status consulted">Transfused</span>
                                    </c:if>
                                    <c:if test="${stock.status == 'Discarded'}">
                                        <span class="status close">Discarded</span>
                                    </c:if>
                                </td>
                                <% if (role.equals("bloodbank")) { %>
                                <td>
                                    <c:choose>
                                        <c:when test="${stock.status == 'NOT_Processed' && stock.bloodbank_code == bloodbank}">
                                            <a href="bloodProcessingShowForm?id=<c:out value='${stock.id}'/>&barcode=<c:out value='${stock.blood_barcode}'/>&colDate=<c:out value='${stock.collected_date}'/>">
                                                Blood Processing</a>
                                            <a href="bloodTransferingShowForm?id=<c:out value='${stock.id}'/>">Internal
                                                Blood Transfer</a>
                                        </c:when>
                                        <c:when test="${stock.status == 'Active' && stock.bloodbank_code == bloodbank}">
                                            <a onclick="stock_confirmation(event)"
                                               href="bloodStockUpdate?id=<c:out value='${stock.id}'/>&status=Transfused&bank=<%= selected_bank %>">Transfuse</a>
                                            <a onclick="stock_confirmation(event)"
                                               href="bloodStockUpdate?id=<c:out value='${stock.id}'/>&status=Discarded&bank=<%= selected_bank %>">Discard</a>
                                            <a href="bloodTransferingShowForm?id=<c:out value='${stock.id}'/>">Internal
                                                Blood Transfer</a>
                                        </c:when>
                                    </c:choose>
                                    <% if (role.equals("admin")) { %>
                                    <a href="bloodShowEditForm?id=<c:out value='${stock.id}'/>">Edit</a>
                                    <% } %>
                                </td>
                                <% } %>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</main>
</body>

</html>
