<%@ page import="com.example.thedonorlk.Bean.ProfileBean" %>
<%@ page import="org.apache.commons.codec.binary.Base64" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    if (session.getAttribute("username") == null || session.getAttribute("role").equals("donor")) {
        response.sendRedirect(request.getContextPath() + "/login.jsp");
    }
    Object role = session.getAttribute("role");
    Object user_id = session.getAttribute("user_id");
    Object bloodbank = session.getAttribute("bloodbank");
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
    <link rel="stylesheet" href="<%=request.getContextPath()%>/public/css/styles2.css">

    <script src="<%=request.getContextPath()%>/public/scripts/scripts.js"></script>
</head>

<body>
<!-- <input type="checkbox" id="nav-toggle"> -->

<div class="sidebar" id="sidebar">
    <div class="logo">
        <img src="<%=request.getContextPath()%>/public/images/Logo%20-%20White.png" height="100px">
    </div>

    <div class="sidebar-menu">
        <ul>
            <li>
                <a href="<%=request.getContextPath()%>/dashboard" target="iframe"><span
                        class="las la-tachometer-alt"></span>
                    <span>Dashboard</span></a>
            </li>
            <% if (role.equals("admin") || role.equals("bloodbank") || role.equals("nurse") || role.equals("doctor")) { %>
            <li>
                <a href="<%=request.getContextPath()%>/donation" target="iframe"><span
                        class="las la-tint"></span>
                    <span>Donations</span></a>
            </li>
            <% } %>
            <% if (role.equals("admin") || role.equals("bloodbank") || role.equals("doctor") || role.equals("nurse")) { %>
            <li>
                <a href="<%=request.getContextPath()%>/campaign" target="iframe"><span
                        class="las la-users"></span>
                    <span>Campaigns</span></a>
            </li>
            <% } %>
            <% if (role.equals("admin") || role.equals("bloodbank") || role.equals("doctor") || role.equals("nurse")) { %>
            <li>
                <a href="<%=request.getContextPath()%>/appointment" target="iframe"><span
                        class="las la-clipboard-list"></span>
                    <span>Appointments</span></a>
            </li>
            <% } %>
            <% if (role.equals("admin") || role.equals("bloodbank") || role.equals("doctor") || role.equals("nurse")) { %>
            <li>
                <a href="<%=request.getContextPath()%>/emergency" target="iframe"><span
                        class="las la-ambulance"></span>
                    <span>Emergency Requirements</span></a>
            </li>
            <% } %>
            <li>
                <a href="#"><span class="las la-percentage"></span>
                    <span>Blood Stock Management</span></a>
                <ul class="stock-show">
                    <% if (role.equals("admin") || role.equals("bloodbank") || role.equals("doctor") || role.equals("nurse")) { %>
                    <li><a href="<%=request.getContextPath()%>/bloodStock?bank=all" target="iframe"><span
                            class="las la-angle-right"></span><span>Blood
                                    Stock</span></a></li>
                    <% } %>
                    <% if (role.equals("admin") || role.equals("bloodbank")) { %>
                    <li><a href="<%=request.getContextPath()%>/bloodRequestSent" target="iframe"><span
                            class="las la-angle-right"></span><span>
                                    Request Sent</span></a></li>
                    <% } %>
                    <% if (role.equals("admin") || role.equals("bloodbank")) { %>
                    <li><a href="<%=request.getContextPath()%>/bloodRequestReceived"
                           target="iframe"><span class="las la-angle-right"></span><span>
                                        Request Received</span></a></li>
                    <% } %>
                    <% if (role.equals("admin") || role.equals("bloodbank")) { %>
                    <li><a href="<%=request.getContextPath()%>/bloodTransfer" target="iframe"><span
                            class="las la-angle-right"></span><span>
                                    Transfer History</span></a></li>
                    <% } %>
                </ul>
            </li>
            <% if (role.equals("admin") || role.equals("bloodbank") || role.equals("doctor") || role.equals("nurse")) { %>
            <li>
                <a href="<%=request.getContextPath()%>/donor" target="iframe"><span
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
                <a href="<%=request.getContextPath()%>/violation" target="iframe"><span
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

<div class="main-content" id="main-content">
    <header id="header">
        <h2>
            <label>
                <span class="las la-bars" id="sidebar_btn"></span>
            </label>
            <% if (!role.equals("admin")) { %>
                <%=session.getAttribute("bloodbank")%>
            <% } %>
        </h2>
        <script src="<%=request.getContextPath()%>/public/scripts/sidebar_button.js"></script>
        <div class="dropdown">
            <div class="user-wrapper">
                <% ProfileBean profile = (ProfileBean) request.getAttribute("profile");
                    String base64Encoded=null;
                    if (profile.getImgBytes() != null) {
                        byte[] bytes = profile.getImgBytes();
                        byte[] encodeBase64 = Base64.encodeBase64(bytes);
                        base64Encoded = new String(encodeBase64, "UTF-8");
                    }
                %>
                <img src="data:image/jpeg;base64,<%=base64Encoded%>" onerror="this.src='<%=request.getContextPath()%>/public/images/no-profile.jpg'"
                     style="width:40px;height:40px;">
                <div>
                    <h4><%=session.getAttribute("username")%>
                    </h4>
                    <small><%=role%>
                    </small>
                </div>
            </div>
            <div class="dropdown-content">
                <a href="<%=request.getContextPath()%>/nonDonorShowSettingForm?id=<%= user_id %>&role=<%= role %>"
                   target="iframe">Settings</a>
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