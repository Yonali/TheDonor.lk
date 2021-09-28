<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 9/8/2021
  Time: 8:34 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<% if (session.getAttribute("username") == null) {
    response.sendRedirect("./view/login.jsp");
}
%>
<html>
<head>
    <title>Timeline</title>
    <style>
        h1{margin-left: 600px}
    </style>
</head>
<body>
<h1>
    Timeline here
</h1>
</body>
</html>
