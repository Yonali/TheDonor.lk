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
    <script type="text/javascript" charset="utf8"
            src="https://cdn.datatables.net/1.11.5/js/jquery.dataTables.js"></script>
    <script>
        $(document).ready(function () {
            $('#table_id').DataTable({
                "order": [[ 0, "desc" ]]
            });
        });
    </script>
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

    <div class="recent-grid">
        <div class="card">
            <div class="card-header">
                <h3>Blood Request - Received</h3>
                <%--<div class="search-wrapper">
                    <span class="las la-search"></span>
                    <input type="search" placeholder="search here"/>
                    <input type="date" id="request-date-search">
                </div>--%>
                <div class="buttons">

                </div>
            </div>

            <div class="card-body">
                <div class="table-responsive">
                    <table width="100%" id="table_id">
                        <thead>
                        <tr>
                            <td>ID</td>
                            <td>Blood Bank</td>
                            <td>Blood Group</td>
                            <td>Blood Product</td>
                            <td>Count</td>
                            <td>Remark</td>
                            <td>Date</td>
                            <td>Time</td>
                            <td>Status</td>
                            <% if (!role.equals("admin")) { %>
                            <td>Actions</td>
                            <% } %>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="request" items="${listRequest}">
                            <c:if test="${request.to_bloodbank_code == bloodbank}">
                                <tr>
                                    <td><c:out value="${request.id}"/></td>
                                    <td><c:out value="${request.from_bloodbank_code}"/></td>
                                    <td><c:out value="${request.blood_group}"/></td>
                                    <td><c:out value="${request.blood_product}"/></td>
                                    <td><c:out value="${request.required_count}"/></td>
                                    <td><c:out value="${request.remark}"/></td>
                                    <td><c:out value="${request.request_date}"/></td>
                                    <td><c:out value="${request.request_time}"/></td>
                                    <td>
                                        <c:if test="${request.status == 'New'}">
                                            <span class="status open">New</span>
                                        </c:if>
                                        <c:if test="${request.status == 'Accepted'}">
                                            <span class="status progress">Accepted</span>
                                        </c:if>
                                        <c:if test="${request.status == 'Declined'}">
                                            <span class="status close">Declined</span>
                                        </c:if>
                                        <c:if test="${request.status == 'Cancelled'}">
                                            <span class="status cancelled">Cancelled</span>
                                        </c:if>
                                    </td>
                                    <% if (!role.equals("admin")) { %>
                                    <td>
                                        <c:if test="${request.status != 'Cancelled'}">
                                            <c:if test="${request.status != 'Accepted'}">
                                            <a onclick="request_confirmation(event)"
                                               href="bloodRequestUpdate?id=<c:out value='${request.id}'/>&status=Accepted">
                                                Accept</a>
                                            </c:if>
                                            <c:if test="${request.status != 'Declined'}">
                                            <a onclick="request_confirmation(event)"
                                               href="bloodRequestUpdate?id=<c:out value='${request.id}'/>&status=Declined">
                                                Decline</a>
                                            </c:if>
                                        </c:if>
                                    </td>
                                    <% } %>
                                </tr>
                            </c:if>
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