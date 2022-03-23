<%@ page import="java.util.List" %>
<%@ page import="com.example.thedonorlk.Bean.NotificationBean" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    if (session.getAttribute("username") == null) {
        response.sendRedirect(request.getContextPath() + "/login.jsp");
    }
    Object user_id = session.getAttribute("user_id");
    List<NotificationBean> notifications = (List<NotificationBean>) request.getAttribute("notifications");
%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Timeline</title>

    <link rel="stylesheet" href="<%=request.getContextPath()%>/public/css/profile.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <script src="<%=request.getContextPath()%>/public/scripts/scripts.js"></script>

    <link rel="stylesheet" href="<%=request.getContextPath()%>/public/css/notification.css">

    <style>
        <%
        if (!session.getAttribute("role").equals("donor")) {
        %>
            .profile-info {
                margin-top: 100px;
            }
            .post-col-timeline {
                color: #3f0404;
            }
        <%
        }
        %>
    </style>
</head>

<body>
<div class="profile-container">
    <div class="profile-info">
        <div class="post-col-timeline">
            <h1>Notifications</h1>

            <!-- --------------------------- Posts ---------------------------------------------->
            <%for (NotificationBean notification : notifications) {%>
            <div class="post-container <%=notification.getStatus().equals("0")? "new": ""%>">
                <div class="post-row">
                    <div class="user-profile">
                        <div>
                            <p class="<%=notification.getStatus().equals("0")? "new": ""%>"><%=notification.getType()%></p>
                            <span class="<%=notification.getStatus().equals("0")? "new": ""%>"><%=notification.getDatetime()%></span>
                        </div>
                    </div>
                </div>
                <p class="post-text <%=notification.getStatus().equals("0")? "new": ""%>">
                    <%=notification.getMessage()%>
                </p>
            </div>
            <%}%>
            <!-- --------------------------- Posts ---------------------------------------------->

            <button type="button" class="load-more-btn">Loadmore</button>
        </div>
    </div>
</div>

    <!-- --------------------back to up------------------------------------------------ -->
    <div>
        <!-- <h4>Top</h4> -->
        <a onclick="topFunction()" id="myBtn" title="Go to top">
            <i class="fa fa-arrow-up" aria-hidden="true"></i>
        </a>
        <script src="<%=request.getContextPath()%>/public/scripts/backtotop.js"></script>
    </div>
    <!-- --------------------back to up------------------------------------------------ -->

</body>
</html>