<%--
  Created by IntelliJ IDEA.
  User: Yonali
  Date: 9/6/2021
  Time: 12:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=, initial-scale=1.0">
    <title>Register</title>
    <link rel="stylesheet" href="../public/css/DonorRegister.css">
<%--    <link rel="script" href="../public/js/DonorRegister.js">--%>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="./datepicker.css" />

    <script src="../public/js/DonorRegister.js"></script>



</head>
<body onload='document.form2.email.focus()'>

<div class="maincontainer">

    <!-- <div class="container"> -->
    <div class="subcontainer">
        <div class="inter_lcontainer">
            <img src="../public/images/ml1.png" height="580px" width="500px" id="ml1">
        </div>

        <div class="inter_rcontainer">
            <div class="logo">
                <img src="../public/images/dlk.PNG" height="80px" width="300px">
            </div>

            <%
                String reg_msg = (String)request.getAttribute("error");
                if(reg_msg == null)
                    reg_msg = "";
            %>
            <div class="error">
                <p><%= reg_msg %></p>
            </div>


            <form name="form2" action="/register" class="form-section" method="post" onsubmit="return Validation()">

                <div id="register_form" class="input-fields">
                    <div class="inputf1" id="fname_div">
                        <i class="fa fa-user"></i>
                        <input type="text" name="fname" id="fname" class="input" placeholder="First Name" required/>
                        <!-- <div class="first_name_error"></div> -->
                    </div>
                    <div class="inputf1" id="lname_div">
                        <i class="fa fa-user"></i>
                        <input type="text" name="lname" id="lname" class="input" placeholder="Last Name" required/>
                        <!-- <div class="last_name_error"></div> -->
                    </div>

                    <div class="inputf1" id="email_div">
                        <i class="fa fa-envelope"></i>
                        <input type="email" name="email" id="email" class="input" placeholder="Email" required/>
                        <!-- <div class="email_error"></div> -->
                    </div>

                    <div class="cal" id="dob_div">
                        <div class="inputf1">
                            <input type="date" name="dob" id="dob" class="inputd"  required/>
                        </div>
                    </div>

                    <div class="inputf1" id="pwd_div">
                        <i class="fa fa-lock" ></i>
                        <input type="password" name="pwd" id="pwd" class="input" placeholder="Password" required/>
                    </div>

                    <div class="inputf1" id="cpwd_div">
                        <i class="fa fa-lock" ></i>
                        <input type="password" name="cpwd" id="cpwd"  class="input" placeholder="Confirm Password" required/>
                        <!-- <div class="pwd_error"></div> -->
                    </div>
                </div>

                <div >
                    <!-- <input type="submit" value="Sign up" id="Signup" onclick="ValidateEmail(document.form2.email)"> -->
                    <input type="submit" value="Sign up" id="Signup" onclick="ValidateEmail(document.form2.email)">
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

