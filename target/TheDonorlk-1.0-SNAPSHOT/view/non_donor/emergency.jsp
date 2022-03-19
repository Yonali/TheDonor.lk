<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.util.*" %>
<%@ page import="com.example.thedonorlk.Bean.DonorBean" %>

<%
    if (session.getAttribute("username") == null) {
        response.sendRedirect(request.getContextPath() + "/login.jsp");
    }
    Object role = session.getAttribute("role");
    Object bloodbank = session.getAttribute("bloodbank");

    List<DonorBean> sendToDonorList = (List<DonorBean>) request.getAttribute("SendToDonorList");
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

    <% if (request.getAttribute("Message") != null) { %>
    <script>
        $(document).ready(function () {
            $.ajax({
                url: "https://meghaduta.dhahas.com/sms/sendSMS",
                type: "POST",
                data: JSON.stringify({
                    "senders": [
                        <% for (DonorBean sendToDonor : sendToDonorList) { %>
                        "+94<%=sendToDonor.getContact()%>",
                        <% } %>
                    ], "message": "<%=request.getAttribute("Message")%>", "apiKey": "61df3f8b36fe65003089ed1b"
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

    <div class="recent-grid">
        <div class="card">
            <div class="card-header">
                <h3>Emergency Blood Requirements</h3>
                <%--<div class="search-wrapper">
                    <span class="las la-search"></span>
                    <input type="search" placeholder="search here"/>
                    <input type="date" id="emergency-date-search">
                </div>--%>
                <div class="buttons">
                    <% if (role.equals("bloodbank")) { %>
                    <a href="<%=request.getContextPath()%>/emergencyShowNewForm">New</a>
                    <% } %>
                </div>
            </div>
            <div class="card-body">
                <div class="table-responsive">
                    <table width="100%" id="table_id">
                        <thead>
                        <tr>
                            <td>ID</td>
                            <td>Blood Group</td>
                            <td>Date</td>
                            <td>Time</td>
                            <td>Blood Bank</td>
                            <td>Status</td>
                            <% if (role.equals("bloodbank")) { %>
                            <td>Action</td>
                            <% } %>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="emergency" items="${listEmergency}">
                            <tr>
                                <td>
                                    <c:out value="${emergency.id}"/>
                                </td>
                                <td>
                                    <c:out value="${emergency.blood_group}"/>
                                </td>
                                <td>
                                    <c:out value="${emergency.date}"/>
                                </td>
                                <td>
                                    <c:out value="${emergency.time}"/>
                                </td>
                                <td>
                                    <c:out value="${emergency.bloodbank_code}"/>
                                </td>
                                <td>
                                    <c:if test="${emergency.status == 'Open'}">
                                        <span class="status open">Open</span>
                                    </c:if>
                                    <c:if test="${emergency.status == 'Closed'}">
                                        <span class="status close">Closed</span>
                                    </c:if>
                                </td>

                                <% if (role.equals("bloodbank")) { %>
                                <td>
                                    <c:if test="${emergency.bloodbank_code == bloodbank}">

                                        <a href="<%=request.getContextPath()%>/emergencyShowEditForm?id=<c:out value='${emergency.id}' />">Edit</a>
                                        &nbsp;&nbsp;&nbsp;&nbsp; <a onclick="confirmation(event)"
                                                                    href="emergencyDelete?id=<c:out value='${emergency.id}' />">Delete</a>

                                    </c:if>
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

</div>

</body>

</html>