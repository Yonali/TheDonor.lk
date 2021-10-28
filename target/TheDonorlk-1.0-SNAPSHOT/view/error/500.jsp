<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="eng">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=, initial-scale=1.0">
    <title>Error</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/public/css/landing_page.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <style>

    </style>
</head>

<body>
<div class="header">
    <nav>
        <div class="logo"></div>
        <div class="nav-links">
            <ul>
                <li><a href="<%=request.getContextPath()%>">Home</a></li>
                <li><a href="<%=request.getContextPath()%>/about_us.jsp">About</a></li>
                <li><a href="<%=request.getContextPath()%>/contact_us.jsp">Contact</a></li>
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
            <img src="<%=request.getContextPath()%>/public/images/error.png">
        </div>
        <div class="right-col">
            <h1>500 Error</h1>
            <p>Oops! The server encountered an internal error. <br>Try to refresh this page or feel free to contact us if the problem persists</p>
        </div>
    </div>
</div>

<hr>
<div class="copyright">
    <p>Copyright © 2021 TheDonor.lk | Project by University of Colombo School of Computing</p>
</div>

</body>
</html>