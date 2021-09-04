
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=, initial-scale=1.0">
    <title>Login</title>
    <link rel="stylesheet" href="../public/css/mainlogin.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">



</head>
<body>
<div class="maincontainer">


    <div class="subcontainer">
        <div class="inter_lcontainer">
            <img src="../public/images/ml1.jpg" height="600px" width="500px" id="ml1">


        </div>
        <div class="inter_rcontainer">
            <div class="logo">
                <img src="../public/images/dlk.PNG" height="80px" width="310px">
            </div>

            <form action="" class="form-section">
                <div id="login_form" class="input-fields">
                    <div class="inputf1">
                        <i class="fa fa-user"></i>
                        <input type="text" name="uname" id="uname" class="uname"  placeholder="Username" required/>
                    </div>

                    <div class="inputf1">
                        <i class="fa fa-lock" ></i>
                        <input type="password" name="pwd" id="pwd" class="pwd" placeholder="Password" required/>
                    </div>
                </div>

                <div class="remember">
                    <input type="checkbox" class="chech-box"><span>Remember me</span>
                    <a href="#" class="a">Forgot Password?</a>
                </div>

                <div >
                    <input type="button" value="Login" id="Login">
                </div>
            </form>

            <h6>or</h6>

            <div class="SocialM">
                <button class="SocialMediea" id="LoginF"><i class="fa fa-facebook-f"></i>Login with Facebook</button>
                <button class="SocialMediea" id="LoginG"><i class="fa fa-google"></i> Login with Google</button>
            </div>

            <div class="bottom">
                <p>Don't have an account?
                    <a href="DonorRegister.html">Sign up</a>
            </div>

        </div>







    </div>




</div>


</body>
</html>
