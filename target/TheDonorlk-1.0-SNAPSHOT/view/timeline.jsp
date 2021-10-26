<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 9/8/2021
  Time: 8:34 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Timeline</title>
    <style>
        h1{margin-left: 600px}
    </style>

    <script src="https://apis.google.com/js/platform.js" async defer></script>

    <meta name="google-signin-scope" content="profile email">
    <meta name="google-signin-client_id"
          content="417323600803-ri5po2d23sqlch1qpsjbnir71qsf9q5k.apps.googleusercontent.com">
</head>
<body>
<h1>
    Timeline here
</h1>
<button onclick="myFunction()">Sign Out</button>
<script>
    function myFunction() {
        gapi.auth2.getAuthInstance().disconnect();
        location.reload();
    }
</script>
</body>
</html>
