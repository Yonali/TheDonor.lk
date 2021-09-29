<%--
  Created by IntelliJ IDEA.
  User: Yonali
  Date: 9/6/2021
  Time: 12:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=, initial-scale=1.0">
    <title>Register</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/public/css/DonorRegister.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="./datepicker.css" />
    <script src="./datepicker.js"></script>
    <script src="<%=request.getContextPath()%>/public/js/DonorRegister.js"></script>
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
                String reg_msg = (String)request.getAttribute("error");
                if(reg_msg == null)
                    reg_msg = "";
            %>
            <div id="error_message">
                <%= reg_msg %>
            </div>

            <!-- onsubmit="return validate();" -->
            <form action="<%=request.getContextPath()%>/register" class="form-section" method="post" onsubmit="return validate();">
                <div id="register_form" class="input-fields">
                    <div class="inputf1">
                        <i class="fa fa-user"></i>
                        <input type="text" name="fname" id="fname" class="input" placeholder="First Name" required />
                    </div>
                    <div class="inputf1">
                        <i class="fa fa-user"></i>
                        <input type="text" name="lname" id="uname" class="input" placeholder="Last Name" required />
                    </div>

                    <div class="inputf1">
                        <i class="fa fa-envelope"></i>
                        <input type="text" name="email" id="email" class="input" placeholder="Email" required />
                    </div>

                    <div class="inputf1">
                        <i class="fa fa-phone"></i>
                        <input type="text" name="contact" id="contact" class="input" placeholder="Contact Number" required />
                    </div>

                    <div class="inputf1">
                        <input type="date" name="dob" id="dob" class="input" required />
                        <label>Date of Birth</label>
                    </div>

                    <div class="inputf1">
                        <i class="fa fa-intersex"></i>
                        <select name="gender" style="margin-left: 5px;">
                            <option value="male">Male</option>
                            <option value="female">Female</option>
                            <option value="other">other</option>
                        </select>
                        <label style="margin-left: 15px;">Select your Gender</label>
                    </div>

                    <div class="inputf1">
                        <i class="fa fa-lock"></i>
                        <input type="password" name="pwd" id="pwd" class="input" placeholder="Password" required />
                    </div>

                    <div class="inputf1">
                        <i class="fa fa-lock"></i>
                        <input type="password" name="cnfrm_pwd" id="cnfrm_pwd" class="input" placeholder="Confirm Password" required />
                    </div>
                </div>

                <div>
                    <input type="submit" value="Sign up" id="Signup">
                </div>
            </form>

            <h4>or</h4>

            <div class="SocialM">
                <button class="SocialMediea" id="LoginF"><i class="fa fa-facebook-f"></i>Sign up with Facebook</button>
                <button class="SocialMediea" id="LoginG"><i class="fa fa-google"></i>Sign up with Google</button>
            </div>
        </div>

    </div>
</div>
</body>
</html>

