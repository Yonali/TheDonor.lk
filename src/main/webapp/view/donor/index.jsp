<%@ page import="com.example.thedonorlk.Bean.ProfileBean" %>
<%@ page import="org.apache.commons.codec.binary.Base64" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%
    if (session.getAttribute("username") == null || !session.getAttribute("role").equals("donor")) {
        response.sendRedirect(request.getContextPath() + "/login.jsp");
    }
    Object user_id = session.getAttribute("user_id");
%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Timeline</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/public/css/timeline.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>

<body>
    <div class="maincontainer">
        <nav class="navcontainer">
            <div class="col-1">
                <div class="logo">
                    <img src="<%=request.getContextPath()%>/public/images/Logo.png" height="75px">
                </div>
                <!-- ---------------------responsive logo------------------------------- -->
                <div class="logo_responsive">
                    <img src="<%=request.getContextPath()%>/public/images/Logo.png" height="45px" width="85px">
                </div>
                 <!-- ---------------------responsive logo------------------------------- -->
                <div class="col-1-2">
                    <div class="dropdown">
                        <button class="dropbtn tes" id="pageName">Timeline</button>
                        <div id="myDropdown" class="dropdown-content">
                            <a href="<%=request.getContextPath()%>/donorTimeline" target="mainframe" onclick="timelineSelect()">Timeline</a>
                            <a href="<%=request.getContextPath()%>/emergency_donor" target="mainframe" onclick="emergencySelect()">Emergency</a>
                            <a href="<%=request.getContextPath()%>/campaign_donor" target="mainframe" onclick="campaignSelect()">Campaigns</a>
                            <a href="<%=request.getContextPath()%>/appointment_donor" target="mainframe" onclick="appSelect()">Appointment</a>
                            <a href="<%=request.getContextPath()%>/intructions.jsp" target="mainframe"
                               onclick="instructionSelect()">Instructions</a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-2">
                <div class="d2">
                    <button><i class="fa fa-search" aria-hidden="true"></i></button>
                    <input type="text" name="search" id="search" class="search" placeholder="Search">
                </div>
                
            </div>
            <div class="col-3">
                <div class="col-3-1">
                    <i class="fa fa-bell" aria-hidden="true"></i>
                </div>
                <div class="dropdown">
                    <div class="col-3-2">
                        <% ProfileBean profile = (ProfileBean) request.getAttribute("profile");
                            String base64Encoded=null;
                            if (profile.getImgBytes() != null) {
                                byte[] bytes = profile.getImgBytes();
                                byte[] encodeBase64 = Base64.encodeBase64(bytes);
                                base64Encoded = new String(encodeBase64, "UTF-8");
                            }
                        %>
                        <img src="data:image/jpeg;base64,<%=base64Encoded%>" onerror="this.src='<%=request.getContextPath()%>/public/images/no-profile.jpg'"
                             style="width:50px;height:50px;">
                        <div class="d col-3-3">
                            <a href="#"><%=session.getAttribute("name")%></a>
                        </div>
                    </div>
                    <div class="dropdown-content">
                        <a href="<%=request.getContextPath()%>/donorProfile" target="mainframe" onclick="profileSelect()">Profile</a>
                        <a href="<%=request.getContextPath()%>/logout">Logout</a>
                    </div>
                </div>

                <!-- ---------------------- Mobile responsive dropdown ------------------------------   -->
                <div class="dropdown_responsive">
                    <div class="col-3-2">
                        <% if (profile.getImgBytes() != null) {
                                byte[] bytes = profile.getImgBytes();
                                byte[] encodeBase64 = Base64.encodeBase64(bytes);
                                base64Encoded = new String(encodeBase64, "UTF-8");
                            }
                        %>
                        <img src="data:image/jpeg;base64,<%=base64Encoded%>" onerror="this.src='<%=request.getContextPath()%>/public/images/no-profile.jpg'"
                             style="width:35px;height:35px;">
                        <a href="#"><%=session.getAttribute("name")%></a>
                        <div class="d col-3-3">
                            <i class="fa fa-bars" aria-hidden="true"></i>
                            <a href="#"><%=session.getAttribute("name")%></a>
                        </div>
                    </div>

                    <div class="dropdown-content_responsive">
                        <a href="<%=request.getContextPath()%>/donorTimeline" target="mainframe" onclick="timelineSelect()">Timeline</a>
                        <a href="<%=request.getContextPath()%>/emergency_donor" target="mainframe" onclick="emergencySelect()">Emergency</a>
                        <a href="<%=request.getContextPath()%>/campaign_donor" target="mainframe" onclick="campaignSelect()">Campaigns</a>
                        <a href="<%=request.getContextPath()%>/appointment_donor" target="mainframe" onclick="appSelect()">Appointment</a>
                        <a href="intructions.jsp" target="mainframe" onclick="instructionSelect()">Instructions</a>
                        <a href="<%=request.getContextPath()%>/donorProfile" target="mainframe" onclick="profileSelect()">Profile</a>
                        <a href="<%=request.getContextPath()%>/logout">Logout</a>
                    </div>
                </div>
                 <!-- ----------------------- Mobile responsive dropdown ------------------------------   -->
            </div>
        </nav>

        <nav class="nav_res">
            <div class="inter_nav_res">
                <div class="col">
                    <div class="d2">
                        <div class="inter_nav_res-l">
                            <button>Search</button>
                        </div>
                        <div class="inter_nav_res-r">
                            <input type="text" name="search"  class="search" placeholder="Enter here">
                        </div>
                       
                    </div>
                </div>
            </div>
        </nav>

        <div class="container">
            <iframe name="mainframe" class="mainframe" id="icontent" scrolling="yes" width="100%" height="100%"></iframe>
        </div>

    </div>



    <script>
        function timelineSelect() {
            var x = document.getElementById("pageName");
            x.innerHTML = "Timeline";
        }
        function emergencySelect() {
            var x = document.getElementById("pageName");
            x.innerHTML = "Emergency";
        }
        function campaignSelect() {
            var x = document.getElementById("pageName");
            x.innerHTML = "Campaigns";
        }
        function appSelect() {
            var x = document.getElementById("pageName");
            x.innerHTML = "Appointment";
        }
        function instructionSelect() {
            var x = document.getElementById("pageName");
            x.innerHTML = "Instructions";
        }
        function profileSelect() {
            var x = document.getElementById("pageName");
            x.innerHTML = "Profile";
        }

        /***********************************************/

        window.onscroll = function () { scrollFunction() };

        function scrollFunction() {
            if (document.body.scrollTop > 20 || document.documentElement.scrollTop > 20) {
                document.getElementById("emergency").style.top = "0";
            } else {
                document.getElementById("emergency").style.top = "-50px";
            }
        }

        /**********************************************/

        function loadIframe() {
            var iframe = document.getElementById("icontent");
            iframe.src = "<%=request.getContextPath()%>/donorTimeline"
        };
        window.onload = loadIframe;
    </script>
</body>

</html>