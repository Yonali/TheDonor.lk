<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=, initial-scale=1.0">
    <title>Contact Us</title>
    <link rel="stylesheet" href="../public/css/landing_page.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

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
            <img src="../public/images/Logo - White.png" height="100px">
        </div>
    </div>

    <div class="row">
        <div class="left-col">
            <img src="../public/images/contact us.png">
        </div>
        <div class="right-col">
            <h1>Contact Us</h1>
            <div>
                <i class="fa fa-mobile"></i>
                +94 76 76 42072
            </div>
            <div>
                <i class="fa fa-envelope"></i>
                info@thedonor.lk
            </div>
            <div>
                <i class="fa fa-street-view"></i>
                No 115, Baseline Road, Narahenpitiya
            </div>
        </div>
    </div>
</div>

<!-- --------------------back to up------------------------------------------------ -->
<div>
    <!-- <h4>Top</h4> -->
    <a onclick="topFunction()" id="myBtn" title="Go to top">
        <i class="fa fa-arrow-up" aria-hidden="true"></i>
    </a>
    <script src="../public/scripts/backtotop.js"></script>
</div>
<!-- --------------------back to up------------------------------------------------ -->


<hr>
<div class="copyright">
    <p>Copyright © 2021 TheDonor.lk | Project by University of Colombo School of Computing</p>
</div>


</body>
</html>
