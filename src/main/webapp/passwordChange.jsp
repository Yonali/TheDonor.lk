
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String email = (String) request.getAttribute("email");
%>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=, initial-scale=1.0">
    <title>Forgot Password</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/public/css/login.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <style>
        .input-fields {
            margin-bottom: 160px;
        }
    </style>
</head>

<body>
    <div class="maincontainer">

        <div class="subcontainer">
            <div class="inter_lcontainer">
                <img src="<%=request.getContextPath()%>/public/images/ml1.png" height="580px" width="500px" id="ml1">
            </div>

            <div class="inter_rcontainer">
                <div class="logo">
                    <img src="<%=request.getContextPath()%>/public/images/Logo.png" height="100px">
                </div>

                <%
                    String login_msg = (String)request.getAttribute("error");
                    if(login_msg == null)
                        login_msg = "";
                %>
                <div class="error_message">
                    <%= login_msg %>
                </div>

                <form action="<%=request.getContextPath()%>/passwordUpdateForgot" class="form-section" method="post">
                    <div id="login_form" class="input-fields">
                        <div class="bottom">
                            <p>Email: <%= email %></p>
                            <br>
                            <p>Please enter the OTP received and the new password below</p>
                        </div>
                        <br>

                        <input type="hidden" name="email" value="<%= email %>"/>
                        <div class="inputf1">
                            <i class="fa fa-key"></i>
                            <input type="text" name="otp" id="otp" class="uname"  placeholder="OTP" required/>
                        </div>
                        <div class="inputf1">
                            <i class="fa fa-lock"></i>
                            <input type="password" name="pwd" id="pwd" class="uname" placeholder="Password" required/>
                        </div>
                        <div class="inputf1">
                            <i class="fa fa-lock"></i>
                            <input type="password" name="cnfrm_pwd" id="cnfrm_pwd" class="uname"
                                   placeholder="Confirm Password" required/>
                        </div>
                    </div>

                    <div>
                        <input type="submit" value="Change" id="Login">
                    </div>
                </form>

            </div>
        </div>
    </div>
</body>
</html>
