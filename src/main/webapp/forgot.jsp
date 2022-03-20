
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=, initial-scale=1.0">
    <title>Forgot Password</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/public/css/login.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
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

                <form action="<%=request.getContextPath()%>/login" class="form-section" method="post">
                    <div id="login_form" class="input-fields">
                        <div class="bottom">
                            <p>Please enter your registered email address below</p>
                        </div>
                        <br>

                        <div class="inputf1">
                            <i class="fa fa-envelope"></i>
                            <input type="text" name="email" id="email" class="uname"  placeholder="Email" required/>
                        </div>
                    </div>

                    <div >
                        <input type="submit" value="Submit" id="Login">
                    </div>
                </form>

            </div>
        </div>
    </div>
</body>
</html>
