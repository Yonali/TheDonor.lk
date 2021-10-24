<%--
  Created by IntelliJ IDEA.
  User: Akthar
  Date: 9/6/2021
  Time: 12:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<html>--%>
<%--<head>--%>
<%--    <meta charset="UTF-8">--%>
<%--    <meta http-equiv="X-UA-Compatible" content="IE=edge">--%>
<%--    <meta name="viewport" content="width=, initial-scale=1.0">--%>
<%--    <title>Login</title>--%>
<%--    <link rel="stylesheet" href="<%=request.getContextPath()%>/public/css/login.css">--%>
<%--    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">--%>
<%--</head>--%>

<%--<body>--%>
<%--    <div class="maincontainer">--%>

<%--        <div class="subcontainer">--%>
<%--            <div class="inter_lcontainer">--%>
<%--                <img src="<%=request.getContextPath()%>/public/images/ml1.png" height="580px" width="500px" id="ml1">--%>
<%--            </div>--%>

<%--            <div class="inter_rcontainer">--%>
<%--                <div class="logo">--%>
<%--                    <img src="<%=request.getContextPath()%>/public/images/Logo.png" height="100px">--%>
<%--                </div>--%>

<%--                <%--%>
<%--                    String login_msg = (String)request.getAttribute("error");--%>
<%--                    if(login_msg == null)--%>
<%--                        login_msg = "";--%>
<%--                %>--%>
<%--                <div class="error_message">--%>
<%--                    <%= login_msg %>--%>
<%--                </div>--%>

<%--                <form action="<%=request.getContextPath()%>/login" class="form-section" method="post">--%>
<%--                    <div id="login_form" class="input-fields">--%>

<%--                        <div class="inputf1">--%>
<%--                            <i class="fa fa-user"></i>--%>
<%--                            <input type="text" name="username" id="uname" class="uname"  placeholder="Username" required/>--%>
<%--                        </div>--%>

<%--                        <div class="inputf1">--%>
<%--                            <i class="fa fa-lock" ></i>--%>
<%--                            <input type="password" name="password" id="pwd" class="pwd" placeholder="Password" required/>--%>
<%--                        </div>--%>
<%--                    </div>--%>

<%--                    <div class="remember">--%>
<%--                        <input type="checkbox" class="chech-box"><span>Remember me</span>--%>
<%--                        <a href="#" class="a">Forgot Password?</a>--%>
<%--                    </div>--%>

<%--                    <div >--%>
<%--                        <input type="submit" value="Login" id="Login">--%>
<%--                    </div>--%>
<%--                </form>--%>

<%--                <!-- <h4>or</h4>--%>

<%--                <div class="SocialM">--%>
<%--                    <button class="SocialMediea" id="LoginF"><i class="fa fa-facebook-f"></i>Login with Facebook</button>--%>
<%--                    <button class="SocialMediea" id="LoginG"><i class="fa fa-google"></i> Login with Google</button>--%>
<%--                </div> -->--%>

<%--                <div class="bottom">--%>
<%--                    <p>Don't have an account?--%>
<%--                        <a href="DonorRegister.jsp">Sign up</a>--%>
<%--                </div>--%>

<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</body>--%>
<%--</html>--%>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=, initial-scale=1.0">
    <title>Login</title>
    <link rel="stylesheet" href="../public/css/login.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>

<body>
<div class="maincontainer">

    <div class="subcontainer">
        <div class="inter_lcontainer">
            <img src="../public/images/ml1.png" height="580px" width="500px" id="ml1">
        </div>

        <div class="inter_rcontainer">
            <div class="logo">
                <img src="../public/images/Logo.png" height="100px">
            </div>

            <%
                String login_msg = (String)request.getAttribute("error");
                if(login_msg == null)
                    login_msg = "";
            %>
            <div class="error_message">
                <%= login_msg %>
            </div>

            <form action="<%=request.getContextPath()%>/login" class="form-section" method="post">
                <div id="login_form" class="input-fields">

                    <div class="inputf1">
                        <i class="fa fa-user"></i>
                        <input type="text" name="username" id="uname" class="uname"  placeholder="Username" required/>
                    </div>

                    <div class="inputf1">
                        <i class="fa fa-lock" aria-hidden="true"></i>
                        <input type="password" name="password" id="pwd" class="pwd" placeholder="Password" required/>
                    </div>
                </div>

                <div class="remember">
                    <input type="checkbox" class="chech-box"><span>Remember me</span>
                    <a href="#" class="a" id="fp">Forgot Password?</a>
                </div>

                <div >
                    <input type="submit" value="Login" id="Login">
                </div>
            </form>

            <!-- <h4>or</h4>

           <div class="SocialM">
               <button class="SocialMediea" id="LoginF"><i class="fa fa-facebook-f"></i>Login with Facebook</button>
               <button class="SocialMediea" id="LoginG"><i class="fa fa-google"></i> Login with Google</button>
           </div>-->

            <div class="bottom">
                <p>Don't have an account?
                    <a href="DonorRegister.jsp">Sign up</a>
            </div>

        </div>
    </div>
</div>





<div id="myModal" class="modal">
    <div class="Inner_m">
        <div class="modal-content">
            <div class="modal-header">
                <span class="close-popup">&times;</span>
                <h3>Forgot your password?</h3>
            </div>

            <div class="modal-body">
                <!-- The form inside popup modal -->
                <form>
<%--                    <div class="inner_form">--%>
                    <div class="fields">
                        <div class="field-single">
                            <span>Enter Your Email Address</span>

                            <!-- <input type="text" /> -->
                        </div>
                        <div class="field-single">
                            <!-- <span>Enter Your Email Address</span> -->
                            <input type="text" placeholder="Enter email address"/>
                        </div>

                    </div>
                    <div class="modal-submit-button">
                        <div class="buttons">
                            <button type="submit" id="continue">Continue</button>
                        </div>
                    </div>
<%--                    </div>--%>
                </form>
            </div>

            <div class="modal-footer">

            </div>
        </div>
    </div>


    <!-- IMPORTANT -->
    <!-- Javascript file with popup modal function should be called here just after the popup modal -->
    <script src="../public/js/forgotpwd_popup.js"></script>
</div>










<!-- --------------------New password-------------------------------------------------------- -->



<div id="new_password" class="modal">
    <div class="Inner_m">
        <div class="modal-content">
            <div class="modal-header">
                <span class="close-popup">&times;</span>
                <h3>New Password</h3>
            </div>

            <div class="modal-body">
                <!-- The form inside popup modal -->
                <form>
                    <div class="fields">
                        <div class="field-single">
                            <span>Please create a new password</span>
                            <!-- <input type="text" /> -->
                        </div>
                        <div class="field-single">
                            <!-- <span>Enter Your Email Address</span> -->
                            <input type="password" placeholder="Create new password"/>
                        </div>
                        <div class="field-single">
                            <!-- <span>Enter Your Email Address</span> -->
                            <input type="password" placeholder="Confirm new password"/>
                        </div>

                    </div>

                    <div class="modal-submit-button">
                        <div class="buttons">
                            <button type="submit" id="change" >Change</button>
                        </div>
                    </div>
                </form>
            </div>

            <div class="modal-footer">

            </div>
        </div>
    </div>


    <!-- IMPORTANT -->
    <!-- Javascript file with popup modal function should be called here just after the popup modal -->
    <script src="../public/js/forgotpwd_popup.js"></script>
</div>






</body>
</html>