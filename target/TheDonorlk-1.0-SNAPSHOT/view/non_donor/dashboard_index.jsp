<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    if (session.getAttribute("username") == null || session.getAttribute("role").equals("donor")) {
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
    <title>TheDonor.lk</title>
    <link rel="stylesheet"
          href="https://maxst.icons8.com/vue-static/landings/line-awesome/line-awesome/1.3.0/css/line-awesome.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/public/css/styles.css">

    <script src="<%=request.getContextPath()%>/public/scripts/scripts.js"></script>
</head>

<body>
<!-- <input type="checkbox" id="nav-toggle"> -->

<div class="sidebar">
    <div class="logo">
        <img src="<%=request.getContextPath()%>/public/images/Logo%20-%20White.png" height="100px">
    </div>

    <div class="sidebar-menu">
        <ul>
            <li>
                <a href="<%=request.getContextPath()%>/view/non_donor/dashboard.jsp" target="iframe"><span
                        class="las la-tachometer-alt"></span>
                    <span>Dashboard</span></a>
            </li>
            <% if (role.equals("admin") || role.equals("bloodbank") || role.equals("nurse") || role.equals("doctor")) { %>
            <li>
                <a href="<%=request.getContextPath()%>/view/non_donor/donations.jsp" target="iframe"><span
                        class="las la-tint"></span>
                    <span>Donations</span></a>
            </li>
            <% } %>
            <% if (role.equals("admin") || role.equals("bloodbank") || role.equals("doctor") || role.equals("nurse")) { %>
            <li>
                <a href="<%=request.getContextPath()%>/view/non_donor/campaigns.jsp" target="iframe"><span
                        class="las la-users"></span>
                    <span>Campaigns</span></a>
            </li>
            <% } %>
            <% if (role.equals("admin") || role.equals("bloodbank") || role.equals("doctor") || role.equals("nurse")) { %>
            <li>
                <a href="<%=request.getContextPath()%>/view/non_donor/appointments.jsp" target="iframe"><span
                        class="las la-clipboard-list"></span>
                    <span>Appointments</span></a>
            </li>
            <% } %>
            <% if (role.equals("admin") || role.equals("bloodbank") || role.equals("doctor") || role.equals("nurse")) { %>
            <li>
                <a href="<%=request.getContextPath()%>/view/non_donor/emergency.jsp" target="iframe"><span
                        class="las la-ambulance"></span>
                    <span>Emergency Requirements</span></a>
            </li>
            <% } %>
            <li>
                <a href="#"><span class="las la-percentage"></span>
                    <span>Blood Stock Management</span></a>
                <ul class="stock-show">
                    <% if (role.equals("admin") || role.equals("bloodbank") || role.equals("doctor") || role.equals("nurse")) { %>
                    <li><a href="<%=request.getContextPath()%>/view/non_donor/stock.jsp" target="iframe"><span
                            class="las la-angle-right"></span><span>Blood
                                    Stock</span></a></li>
                    <% } %>
                    <% if (role.equals("admin") || role.equals("bloodbank")) { %>
                    <li><a href="<%=request.getContextPath()%>/view/non_donor/request_sent.jsp" target="iframe"><span
                            class="las la-angle-right"></span><span>
                                    Request Sent</span></a></li>
                    <% } %>
                    <% if (role.equals("admin") || role.equals("bloodbank")) { %>
                    <li><a href="<%=request.getContextPath()%>/view/non_donor/request_received.jsp"
                           target="iframe"><span class="las la-angle-right"></span><span>
                                        Request Received</span></a></li>
                    <% } %>
                    <% if (role.equals("admin") || role.equals("bloodbank")) { %>
                    <li><a href="<%=request.getContextPath()%>/view/non_donor/transfer.jsp" target="iframe"><span
                            class="las la-angle-right"></span><span>
                                    Transfer History</span></a></li>
                    <% } %>
                </ul>
            </li>
            <% if (role.equals("admin") || role.equals("bloodbank") || role.equals("doctor")) { %>
            <li>
                <a href="<%=request.getContextPath()%>/view/non_donor/donors.jsp" target="iframe"><span
                        class="las la-user-tag"></span>
                    <span>Donors</span></a>
            </li>
            <% } %>
            <% if (role.equals("admin") || role.equals("bloodbank")) { %>
            <li>
                <a href="#"><span class="las la-user-circle"></span>
                    <span>System Users</span></a>
                <ul class="user-show">
                    <% if (role.equals("admin")) { %>
                    <li><a href="<%=request.getContextPath()%>/userBloodBank" target="iframe"><span
                            class="las la-angle-right"></span><span>Blood Banks</span></a></li>
                    <% } %>
                    <% if (role.equals("admin") || role.equals("bloodbank")) { %>
                    <li><a href="<%=request.getContextPath()%>/userDoctor" target="iframe"><span
                            class="las la-angle-right"></span><span>Doctors</span></a></li>
                    <% } %>
                    <% if (role.equals("admin") || role.equals("bloodbank")) { %>
                    <li><a href="<%=request.getContextPath()%>/userNurse" target="iframe"><span
                            class="las la-angle-right"></span><span>Nurses</span></a></li>
                    <% } %>
                    <% if (role.equals("admin")) { %>
                    <li><a href="<%=request.getContextPath()%>/userAdmin" target="iframe"><span
                            class="las la-angle-right"></span><span>System
                                    Admins</span></a></li>
                    <% } %>
                </ul>
            </li>
            <% } %>
            <% if (role.equals("admin")) { %>
            <li>
                <a href="<%=request.getContextPath()%>/view/non_donor/violation_Report.jsp" target="iframe"><span
                        class="fa fa-exclamation-triangle"></span>
                    <span>Violation Report</span></a>
            </li>
            <% } %>
            <!-- <li>
                <a href=""><span class="las la-cog"></span>
                    <span>Settings</span></a>
            </li>
            <li>
                <a href=""><span class="las la-sign-out-alt"></span>
                    <span>Logout</span></a>
            </li> -->
        </ul>
    </div>
</div>

<div class="main-content">
    <header>
        <h2>
            <label>
                <span class="las la-bars"></span>
            </label>
            NBTS Narahenpita
        </h2>
        <div class="dropdown">
            <div class="user-wrapper">
                <img src="<%=request.getContextPath()%>/public/images/anne-doe.jpg" width="40px" height="40px" alt="">
                <div>
                    <h4><%=session.getAttribute("username")%></h4>
                    <small><%=role%></small>
                </div>
            </div>
            <div class="dropdown-content">
                <a href="#">Settings</a>
                <a href="<%=request.getContextPath()%>/logout">Logout</a>
            </div>
        </div>

    </header>

    <div class="content">
        <iframe id="icontent" target="_self" name="iframe"
                scrolling="yes" style="width:100%;height:99vh;border:none;"></iframe>
    </div>
</div>
</body>

</html>