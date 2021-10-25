<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=, initial-scale=1.0">
    <title>About Us</title>
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
            <img src="../public/images/about us.png">
        </div>
        <div class="right-col">
            <h1>About Us</h1>
            <p>Many people would not be alive today if it wasn't for the generosity of our donors. <br>Donating Blood
                Makes
                a Big Difference in the Lives of Others.
                <br><br>But it’s always in high demand. Our lifesaving service is required 365 days a year,
                and our dedicated staff work day and night to process, test and distribute donated blood.
                Every year we need a huge number of new donors to ensure we have the right mix of blood groups to meet
                patient needs now and in the future.
            </p>
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
