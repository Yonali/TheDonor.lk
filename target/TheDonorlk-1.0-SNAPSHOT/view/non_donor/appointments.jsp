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
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
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
    <%----------------------------calendar----------------------------------------%>
    <%--<div class="container">
        <div class="calendar">
            <div class="month">
                <i class="fa fa-angle-left prev"></i>
                <div class="date">
                    <h1></h1>
                    <p></p>
                </div>

                <i class="fa fa-angle-right next"></i>
            </div>
            <div class="weekdays">
                <div>Sun</div>
                <div>Mon</div>
                <div>Tue</div>
                <div>Wed</div>
                <div>Thu</div>
                <div>Fri</div>
                <div>Sat</div>
            </div>
            <div class="days"></div>
        </div>
    </div>--%>
    <%---------------------------------------------------------------------------------%>

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
                <h3>Appointments</h3>
                <%--<div class="search-wrapper">
                    <span class="las la-search"></span>
                    <input type="search" placeholder="search here"/>
                    <input type="date" id="appointment-date-search">
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
                            <td>Donor Name</td>
                            <td>Donor NIC</td>
                            <td>Date</td>
                            <td>Time</td>
                            <td>Status</td>
                            <% if (role.equals("bloodbank")) { %>
                            <td>Actions</td>
                            <% } %>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="appointment" items="${listAppointment}">
                            <c:if test="${appointment.bloodbank_code == bloodbank}">
                                <tr>
                                    <td>
                                        <c:out value="${appointment.id}"/>
                                    </td>
                                    <td>
                                        <c:out value="${appointment.bloodbank_code}"/>
                                    </td>
                                    <td>
                                        <c:out value="${appointment.donor_name}"/>
                                    </td>
                                    <td>
                                        <c:out value="${appointment.donor_contact}"/>
                                    </td>
                                    <td>
                                        <c:out value="${appointment.appointment_date}"/>
                                    </td>
                                    <td>
                                        <c:out value="${appointment.appointment_time}"/>
                                    </td>
                                    <td>
                                        <c:if test="${appointment.status == 'New'}">
                                            <span class="status open">New</span>
                                        </c:if>
                                        <c:if test="${appointment.status == 'Accepted'}">
                                            <span class="status progress">Accepted</span>
                                        </c:if>
                                        <c:if test="${appointment.status == 'Rejected'}">
                                            <span class="status close">Rejected</span>
                                        </c:if>
                                        <c:if test="${appointment.status == 'Completed'}">
                                            <span class="status consulted">Completed</span>
                                        </c:if>
                                    </td>
                                    <% if (role.equals("bloodbank")) { %>
                                    <td>
                                        <a onclick="appointment_confirmation(event)"
                                           href="<%=request.getContextPath()%>/appointmentStatus?type=Accepted&id=<c:out value='${appointment.id}'/>">Accept</a>
                                        <a onclick="appointment_confirmation(event)"
                                           href="<%=request.getContextPath()%>/appointmentStatus?type=Rejected&id=<c:out value='${appointment.id}'/>">Reject</a>
                                        <a onclick="appointment_confirmation(event)"
                                           href="<%=request.getContextPath()%>/appointmentStatus?type=Completed&id=<c:out value='${appointment.id}'/>">Complete</a>
                                        <a onclick="appointment_confirmation(event)"
                                           href="<%=request.getContextPath()%>/appointmentStatus?type=Deleted&id=<c:out value="${appointment.id}" />">Delete</a>
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


<!-- The Popup Modal -->
<div id="myModal" class="modal">
    <div class="modal-content">
        <div class="modal-header">
            <span class="close-popup">&times;</span>
            <h3>Enter Appointment Details</h3>
        </div>

        <div class="modal-body">
            <!-- The form inside popup modal -->
            <form>
                <div class="fields">
                    <div class="field-single">
                        <span>Donor Name</span>
                        <input type="text"/>
                    </div>
                    <div class="field-single">
                        <span>Date</span>
                        <input type="date" id="appointment-date">
                    </div>
                    <div class="field-single">
                        <span>Donor NIC</span>
                        <input type="text"/>
                    </div>
                    <div class="field-single">
                        <span>Time</span>
                        <input type="text"/>
                    </div>
                </div>
                <div class="modal-submit-button">
                    <div class="buttons">
                        <button type="submit">Submit</button>
                    </div>
                </div>
            </form>
        </div>

        <div class="modal-footer">
            <img src="<%=request.getContextPath()%>/public/images/Logo%20-%20White.png" height="100px">
            <p>Many people would not be alive today if it wasn't for the generosity of our donors. <br>Donating
                Blood Makes a Big Difference in the Lives of Others.
            </p>
        </div>
    </div>

    <!-- IMPORTANT -->
    <!-- Javascript file with popup modal function should be called here just after the popup modal -->
    <script src="<%=request.getContextPath()%>/public/scripts/popup_modal_dashboard.js"></script>
</div>

</body>

</html>
