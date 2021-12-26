<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    if (session.getAttribute("username") == null || !session.getAttribute("role").equals("donor")) {
        response.sendRedirect(request.getContextPath() + "/login.jsp");
    }
    Object role = session.getAttribute("role");
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

    <title>Campaigns</title>

</head>

<body>
<div class="switch-box">
    <div style="text-align: center; align-items: center; justify-content: center; padding: 15px;">
        <span style="color: aliceblue;">Blood Bank</span>
        <div class="custom-select">
            <select class="box" id="bank_switch">
                <option value="all">All</option>
                <c:forEach var="bank" items="${listBloodBank}">
                    <option value="<c:out value="${bank.code}"/>"><c:out value="${bank.name}"/></option>
                </c:forEach>
            </select>
        </div>
    </div>
    <div class="switch-button" id="type_switch" onclick="change_type()">
        <input class="switch-button-checkbox" id="switch_type" type="checkbox" value="progress"></input>
        <label class="switch-button-label"><span class="switch-button-label-span">In Progress</span></label>
    </div>
</div>

<script src="<%=request.getContextPath()%>/public/scripts/switch.js"></script>

<!----------------  NEW Card View ----------------->
<div class="container" id="container_progress">
    <c:set var="theCount" value="0" scope="page"/>
    <c:forEach var="campaign" items="${listCampaign}">
        <jsp:useBean id="now" class="java.util.Date"/>

        <c:set var="start" value="${campaign.date} ${campaign.start_time}"/>
        <c:set var="end" value="${campaign.date} ${campaign.end_time}"/>

        <fmt:parseDate value="${start}" var="parsedStartDate" pattern="yyyy-MM-dd HH:mm:ss"/>
        <fmt:parseDate value="${end}" var="parsedEndDate" pattern="yyy-MM-dd HH:mm:ss"/>

    <c:if test="${(parsedStartDate le now) && (parsedEndDate ge now)}">
    <c:if test="${theCount <= 2}">
    <div class="column <c:out value="${campaign.bloodbank_code}"/>">
        </c:if>
        <c:if test="${theCount > 2}">
        <div class="column container_progress_more <c:out value="${campaign.bloodbank_code}"/>">
            </c:if>
            <div class="post-module">
                <!-- Thumbnail-->
                <div class="thumbnail">
                    <img src="<%=request.getContextPath()%>/public/images/progress.png"/>
                </div>
                <!-- Post Content-->
                <div class="post-content">
                    <div class="category completed">In Progress</div>
                    <h1 class="title">Date - <c:out value="${campaign.date}"/> <br>Time - <c:out
                            value="${campaign.start_time}"/> - <c:out value="${campaign.end_time}"/></h1>
                    <h2 class="sub_title"><c:out value="${campaign.name}"/> <br>@ <c:out
                            value="${campaign.address_street}, ${campaign.address_city}"/></h2>
                    <p class="description">Blood Bank - <c:out value="${campaign.bloodbank_name}"/> <br>Blood Bank
                        Contact - <c:out value="${campaign.bloodbank_contact}"/> <br>Blood Bank Address - <c:out
                                value="${campaign.bloodbank_address_street}, ${campaign.bloodbank_address_city}"/>
                        <br>Blood Bank Email - <c:out value="${campaign.bloodbank_email}"/>
                    </p>

                </div>
            </div>
        </div>
        <c:set var="theCount" value="${theCount + 1}" scope="page"/>
        </c:if>
        </c:forEach>
    </div>
    <button class="newbtn" onclick="progressShowMore()" id="progressShowMoreBtn">Show more</button>


    <div class="container" id="container_upcoming">
        <c:set var="theCount" value="0" scope="page"/>
        <c:forEach var="campaign" items="${listCampaign}">

            <c:set var="start" value="${campaign.date} ${campaign.start_time}"/>
            <c:set var="end" value="${campaign.date} ${campaign.end_time}"/>

            <fmt:parseDate value="${start}" var="parsedStartDate" pattern="yyyy-MM-dd HH:mm:ss"/>
            <fmt:parseDate value="${end}" var="parsedEndDate" pattern="yyy-MM-dd HH:mm:ss"/>

        <c:if test="${(parsedStartDate ge now) && (parsedEndDate ge now)}">
        <c:if test="${theCount <= 2}">
        <div class="column <c:out value="${campaign.bloodbank_code}"/>">
            </c:if>
            <c:if test="${theCount > 2}">
            <div class="column container_upcoming_more <c:out value="${campaign.bloodbank_code}"/>">
                </c:if>
                <div class="post-module">
                    <!-- Thumbnail-->
                    <div class="thumbnail">
                        <img src="<%=request.getContextPath()%>/public/images/upcoming.png"/>
                    </div>
                    <!-- Post Content-->
                    <div class="post-content">
                        <div class="category open">Upcoming</div>
                        <h1 class="title">Date - <c:out value="${campaign.date}"/> <br>Time - <c:out
                                value="${campaign.start_time}"/> - <c:out value="${campaign.end_time}"/></h1>
                        <h2 class="sub_title"><c:out value="${campaign.name}"/> <br>@ <c:out
                                value="${campaign.address_street}, ${campaign.address_city}"/></h2>
                        <p class="description">Blood Bank - <c:out value="${campaign.bloodbank_name}"/> <br>Blood
                            Bank
                            Contact - <c:out value="${campaign.bloodbank_contact}"/> <br>Blood Bank Address - <c:out
                                    value="${campaign.bloodbank_address_street}, ${campaign.bloodbank_address_city}"/>
                            <br>Blood Bank Email - <c:out value="${campaign.bloodbank_email}"/>
                        </p>

                    </div>
                </div>
            </div>
            <c:set var="theCount" value="${theCount + 1}" scope="page"/>
            </c:if>
            </c:forEach>
        </div>
        <button class="newbtn" onclick="upcomingShowMore()" id="upcomingShowMoreBtn">Show more</button>

</body>

</html>