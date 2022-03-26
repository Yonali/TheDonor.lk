<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.util.*" %>
<%@ page import="static sun.misc.MessageUtils.out" %>

<%
    if (session.getAttribute("username") == null) {
        response.sendRedirect(request.getContextPath() + "/login.jsp");
    }
    Object role = session.getAttribute("role");
%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>TheDonor.lk</title>
    <link rel="stylesheet"
          href="https://maxst.icons8.com/vue-static/landings/line-awesome/line-awesome/1.3.0/css/line-awesome.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/public/css/styles.css">

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

    <% if (request.getAttribute("SendTo") != null) {
        System.out.println("Test"); %>
    <script>
        $(document).ready(function () {
            $.ajax({
                url: "https://meghaduta.dhahas.com/sms/sendSMS",
                type: "POST",
                data: JSON.stringify({"senders": [ "+94<%=request.getAttribute("SendTo")%>" ], "message": "<%=request.getAttribute("Message")%>", "apiKey": "61df3f8b36fe65003089ed1b"}),
                dataType:'json',
                contentType: 'application/json',
                success: function (response) {console.log(response); },
                error: function(error){ console.log("Something went wrong", error); }
            });
        });
    </script>
    <% } %>
</head>

<body>
<main>
    <%
        String reg_msg = "";
        reg_msg = reg_msg == null ? "": (String) request.getAttribute("error");
        if (reg_msg != null) {
    %>
    <div id="error_message">
        <%= reg_msg %>
    </div>
    <% } %>

    <div class="recent-grid">
        <% if (role.equals("nurse") || role.equals("doctor")) { %>
        <div class="card">
            <form action="<%=request.getContextPath()%>/donationSearch" method="post">
                <div class="modal-body">
                    <input type="hidden" name="User_Role" value="<%= role %>"/>
                    <div class="fields">
                        <div class="field-single">
                            <span>Scan Blood Barcode</span>
                            <input type="text" name="Blood_Barcode" id="Blood_Barcode"/>
                        </div>
                        <div class="field-single">
                            <span>Type NIC</span>
                            <input type="text" name="NIC" id="NIC"/>
                        </div>
                    </div>
                </div>
                <div class="modal-submit-button" style="padding-top: 0px;">
                    <div class="buttons">
                        <button type="submit" class="bottom-full">Next</button>
                    </div>
                </div>
            </form>
        </div>
        <% } %>
    </div>

    <div class="recent-grid">
        <div class="card">
            <div class="card-header">
                <h3>Donations</h3>
                <%--<div class="search-wrapper">
                    <span class="las la-search"></span>
                    <input type="search" placeholder="search here"/>
                    <!-- <span class="las la-calendar-week"></span> -->
                    <input type="date" id="donation-date-search">
                </div>--%>
                <div class="buttons">

                </div>
            </div>

            <div class="card-body">
                <div class="table-responsive">
                    <table width="100%" id="table_id">
                        <thead>
                        <tr>
                            <td>Donation ID</td>
                            <td>Blood Bank</td>
                            <td>Blood Barcode</td>
                            <td>Donor Name</td>
                            <td>Donor NIC</td>
                            <td>Date</td>
                            <td>Time</td>
                            <td>Status</td>
                            <%--<% if (role.equals("nurse") || role.equals("doctor")) { %>
                            <td>Actions</td>
                            <% } %>--%>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="donation" items="${listDonation}">
                            <c:if test="${donation.bloodbank_code == bloodbank}">
                                <tr>
                                    <td><c:out value="${donation.id}"/></td>
                                    <td><c:out value="${donation.bloodbank_code}"/></td>
                                    <td><c:out value="${donation.blood_id}"/></td>
                                    <td><c:out value="${donation.donor_name}"/></td>
                                    <td><c:out value="${donation.donor_nic}"/></td>
                                    <td><c:out value="${donation.date}"/></td>
                                    <td><c:out value="${donation.time}"/></td>
                                    <td>
                                        <c:if test="${donation.status == 'New'}">
                                            <span class="status open">New</span>
                                        </c:if>
                                        <c:if test="${donation.status == 'Counselled'}">
                                            <span class="status consulted">Counselled</span>
                                        </c:if>
                                        <c:if test="${donation.status == 'Completed'}">
                                            <span class="status progress">Completed</span>
                                        </c:if>
                                        <c:if test="${donation.status == 'Cancelled'}">
                                            <span class="status cancelled">Cancelled</span>
                                        </c:if>
                                        <c:if test="${donation.status == 'Deferred'}">
                                            <span class="status close">Deferred</span>
                                        </c:if>
                                    </td>
                                    <%--<% if (role.equals("nurse") || role.equals("doctor")) { %>
                                    <td>
                                        <a href="<%=request.getContextPath()%>/donorShowEditForm?id=<c:out value='${donation.id}'/>">Edit</a>
                                    </td>
                                    <% } %>--%>
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