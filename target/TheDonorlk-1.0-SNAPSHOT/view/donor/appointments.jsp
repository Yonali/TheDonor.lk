<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    if (session.getAttribute("username") == null || !session.getAttribute("role").equals("donor")) {
        response.sendRedirect(request.getContextPath() + "/login.jsp");
    }
    Object d_id = session.getAttribute("id");
%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/public/css/appointments_campaign.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
    <script src="<%=request.getContextPath()%>/public/scripts/cardview_toggle.js"></script>
    <script src="<%=request.getContextPath()%>/public/scripts/popup_modal.js"></script>

    <script src="<%=request.getContextPath()%>/public/scripts/delete_confirmation.js"></script>
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
</head>

<body>
<div class="create-box">
    <div class="current">
        <div class="current_boxes">
            <div class="c">
                <div class="BB_name">Create New Appointment</div>
                <a href="<%=request.getContextPath()%>/appointmentShowNewForm">
                    <button class="newbtn">New</button>
                </a>
            </div>
        </div>
    </div>
</div>

<!----------------  NEW Card View ----------------->
<div class="container" id="container_progress">
    <c:set var="theCount" value="0" scope="page"/>
    <c:forEach var="appointment" items="${listAppointment}">

        <c:set var="idAsString">${appointment.donor_id}</c:set>
        <c:set var="dd_id"><%= session.getAttribute("id") %></c:set>
    <c:if test="${idAsString == dd_id}">

    <c:if test="${theCount <= 2}">
    <div class="column <c:out value="${appointment.bloodbank_code}"/>">
        </c:if>
        <c:if test="${theCount > 2}">
        <div class="column container_more <c:out value="${appointment.bloodbank_code}"/>">
            </c:if>
            <div class="post-module">
                <!-- Thumbnail-->
                <div class="thumbnail">
                    <c:if test="${appointment.status == 'New'}">
                        <img src="<%=request.getContextPath()%>/public/images/open.png"/>
                    </c:if>
                    <c:if test="${appointment.status == 'Accepted'}">
                        <img src="<%=request.getContextPath()%>/public/images/accepted.png"/>
                    </c:if>
                    <c:if test="${appointment.status == 'Rejected'}">
                        <img src="<%=request.getContextPath()%>/public/images/rejected.png"/>
                    </c:if>
                    <c:if test="${appointment.status == 'Completed'}">
                        <img src="<%=request.getContextPath()%>/public/images/completed.png"/>
                    </c:if>
                </div>
                <!-- Post Content-->
                <div class="post-content">
                    <c:if test="${appointment.status == 'New'}">
                        <div class="category open">New</div>
                    </c:if>
                    <c:if test="${appointment.status == 'Accepted'}">
                        <div class="category accepted">Accepted</div>
                    </c:if>
                    <c:if test="${appointment.status == 'Rejected'}">
                        <div class="category rejected">Rejected</div>
                    </c:if>
                    <c:if test="${appointment.status == 'Completed'}">
                        <div class="category completed">Completed</div>
                    </c:if>
                    <h1 class="title">No - <c:out value="${appointment.id}"/> <br>Date - <c:out
                            value="${appointment.appointment_date}"/><br>Time - <c:out
                            value="${appointment.appointment_time}"/></h1>
                    <h2 class="sub_title"><c:out value="${appointment.bloodbank_name}"/></h2>
                    <p class="description">Donor - <%= session.getAttribute("name") %><br>Blood
                        Bank
                        Contact - <c:out value="${appointment.bloodbank_contact}"/> <br>Blood Bank Address - <c:out
                                value="${appointment.bloodbank_address_street}, ${appointment.bloodbank_address_city}"/>
                        <br>Blood Bank Email - <c:out value="${appointment.bloodbank_email}"/>
                    </p>
                    <div class="post-meta"><span class="comments">
                        <i class="fa fa-edit"></i><a
                            href="<%=request.getContextPath()%>/appointmentShowEditForm?id=<c:out value='${appointment.id}' />">Edit</a>&nbsp;&nbsp;&nbsp;&nbsp;
                        <i class="fa fa-trash"></i><a onclick="confirmation(event)"
                                                      href="appointmentDelete?id=<c:out value='${appointment.id}' />">Delete</a></span>
                    </div>
                </div>

            </div>
        </div>
        <c:set var="theCount" value="${theCount + 1}" scope="page"/>
        </c:if>
        </c:forEach>
    </div>

    <button class="newbtn" onclick="appShowMore()" id="appShowMoreBtn">Show more</button>

</body>

</html>