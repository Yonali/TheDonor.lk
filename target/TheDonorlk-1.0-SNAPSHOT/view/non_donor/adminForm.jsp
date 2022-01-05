<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    if (session.getAttribute("username") == null) {
        response.sendRedirect(request.getContextPath() + "/login.jsp");
    }
%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>TheDonor.lk</title>
    <link rel="stylesheet"
          href="https://maxst.icons8.com/vue-static/landings/line-awesome/line-awesome/1.3.0/css/line-awesome.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/public/css/styles.css">

    <script src="<%=request.getContextPath()%>/public/scripts/validate_username_only.js"></script>
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
</head>

<body>
<div class="modal-content">
    <div class="modal-header">
        <span class="close-popup" onclick="history.back()">&times;</span>
        <h3>
            <c:if test="${user != null}">
                Edit Admin User
            </c:if>
            <c:if test="${user == null}">
                Add New Admin User
            </c:if>
        </h3>
    </div>

    <div class="modal-body">
        <%
            String reg_msg = "";
            reg_msg = reg_msg == null ? "": (String) request.getAttribute("error");
            if (reg_msg != null) {
        %>
        <div id="error_message">
            <%= reg_msg %>
        </div>
        <% } %>

        <c:if test="${user != null}">
            <form action="userAdminUpdate" method="post" onsubmit="return validate();"></c:if>
        <c:if test="${user == null}">
            <form action="userAdminInsert" method="post" onsubmit="return validate();">
        </c:if>
                <div class="fields">
                    <c:if test="${user != null}">
                        <input type="hidden" name="id" value="<c:out value='${user.id}' />" />
                    </c:if>
                    <div class="field-single">
                        <span>Username</span>
                        <input type="text" name="username" id="username" value="<c:out value='${user.username}' />"/>
                    </div>
                    <br>
                    <p>(Username should be a valid email address)</p>
                </div>
                <div class="modal-submit-button">
                    <div class="buttons">
                        <button type="submit">Submit</button>
                    </div>
                </div>
            </form>
    </div>

    <div class="modal-footer">
        <img src="<%=request.getContextPath()%>/public/images/Logo%20-%20White.png" height="100px">
        <p>Many people would not be alive today if it wasn't for the generosity of our donors. <br>Donating
            Blood Makes a Big Difference in the Lives of Others.
        </p>
    </div>
</div>

</body>

</html>
