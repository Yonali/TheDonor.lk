<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<div class="header">
    <nav>
        <div class="logo"></div>
        <div class="nav-links">
            <ul>
                <li><a href="<%=request.getContextPath()%>">Home</a></li>
                <li><a href="<%=request.getContextPath()%>/view/about_us.jsp">About</a></li>
                <li><a href="<%=request.getContextPath()%>/view/contact_us.jsp">Contact</a></li>
            </ul>
        </div>
    </nav>

    <div class="left-sidebar">
        <div class="logo">
            <img src="<%=request.getContextPath()%>/public/images/Logo - White.png" height="100px">
        </div>
    </div>

    <div class="row">
        <div class="left-col">
            <img src="<%=request.getContextPath()%>/public/images/image.png">
        </div>
        <div class="right-col">
            <h1>Explore <br>being a Donor</h1>
            <p>Join us to put the power to save lives in the palm of your hands.<br>Lets join hands to support blood
                donations and deliver much-needed services to the community.</p>

            <div class="social-media">
                <div class="icon">
                    <h4>Login</h4>
                    <a href="<%=request.getContextPath()%>/view/login.jsp">
                        <img src="<%=request.getContextPath()%>/public/images/login.png">
                    </a>
                </div>
                <div class="icon">
                    <h4>Register</h4>
                    <a href="<%=request.getContextPath()%>/view/DonorRegister.jsp">
                        <img src="<%=request.getContextPath()%>/public/images/register.png">
                    </a>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="service">
    <h3>Our Services</h3>
    <h1 class="centre_heading">The Need for Blood and Platelets is Constant</h1>

    <div class="row-service">
        <div class="column">
            <img src="<%=request.getContextPath()%>/public/images/service-1.jpg" width="325px">
            <div class="coloumn-text">
                <h2>Exclusive Donor Platform</h2>
                <br>
                <p>This is the perfect place for all the blood donors. You can communicate with others and share
                    your knowledge with them.</p>
            </div>

        </div>
        <div class="column">
            <img src="<%=request.getContextPath()%>/public/images/service-1-1.jpg" width="325px">
            <div class="coloumn-text">
                <h2>Blood Donor Management</h2>
                <br>
                <p>Blood Banks can use our services to effectively manage their blood donors.</p>
            </div>
        </div>
        <div class="column">
            <img src="<%=request.getContextPath()%>/public/images/service-3.jpg" width="325px">
            <div class="coloumn-text">
                <h2>Blood Stock Management</h2>
                <br>
                <p>Blood Banks can quicky and effectively manage their blood stocks and get analysis reports to
                    make data driven decisions and initiatives easily.</p>
            </div>
        </div>
    </div>
</div>

<div class="footer">
    <img src="<%=request.getContextPath()%>/public/images/Logo.png" height="100px">
    <p>Many people would not be alive today if it wasn't for the generosity of our donors. <br>Donating Blood Makes
        a Big Difference in the Lives of Others.
        <br><br>But it’s always in high demand. Our lifesaving service is required 365 days a year,
        and our dedicated staff work day and night to process, test and distribute donated blood.
        Every year we need a huge number of new donors to ensure we have the right mix of blood groups to meet
        patient needs now and in the future.
    </p>

    <br><br>
    <a href="#" class="fa fa-facebook"></a>
    <a href="#" class="fa fa-instagram"></a>
    <a href="#" class="fa fa-twitter"></a>


</div>
<hr>
<div class="copyright">
    <p>Copyright © 2021 TheDonor.lk | Project by University of Colombo School of Computing</p>
</div>
</body>
</html>