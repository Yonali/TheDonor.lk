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

    <title>Emergency</title>
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

</div>

<script src="<%=request.getContextPath()%>/public/scripts/switch.js"></script>

<!----------------  NEW Card View ----------------->

<div class="container" id="container_progress">
    <c:set var="theCount" value="0" scope="page"/>
    <c:forEach var="emergency" items="${listEmergency}">
        <jsp:useBean id="now" class="java.util.Date"/>

    <c:if test="${theCount <= 2}">
    <div class="column <c:out value="${emergency.bloodbank_code}"/>">
        </c:if>
        <c:if test="${theCount > 2}">
        <div class="column container_more <c:out value="${emergency.bloodbank_code}"/>">
                <%--   progress more-> more--%>
            </c:if>


            <div class="post-module">
                <!-- Thumbnail-->
                <div class="thumbnail">
                    <img src="<%=request.getContextPath()%>/public/images/emergency.png"/>
                </div>
                <!-- Post Content-->
                <div class="post-content">
                    <!-- <div class="category open">Open</div> -->
                    <div class="category rejected"><c:out value="${emergency.blood_group}"/></div>
                    <h1 class="title"><c:out value="${emergency.bloodbank_name}"/></h1>
                    <h2 class="sub_title">Emergency Requirement From <br><c:out value="${emergency.date}"/></h2>
                    <p class="description">Blood Bank - <c:out value="${emergency.bloodbank_name}"/> <br>Blood Bank
                        Contact - <c:out value="${emergency.bloodbank_contact}"/> <br>Blood Bank Address - <c:out
                                value="${emergency.bloodbank_address_street}, ${emergency.bloodbank_address_city}"/>
                        <br>Blood Bank Email - <c:out value="${emergency.bloodbank_email}"/>
                    </p>
                        <%--                    <div class="post-meta"><span class="comments"><i class="fa fa-edit"></i><a href="#" class="editBtn">--%>
                        <%--                            Edit</a></span></div>--%>
                </div>
            </div>


        </div>
        <c:set var="theCount" value="${theCount + 1}" scope="page"/>

        </c:forEach>
    </div>

    <button class="newbtn" onclick="appShowMore()" id="appShowMoreBtn">Show more</button>
</body>
</html>
