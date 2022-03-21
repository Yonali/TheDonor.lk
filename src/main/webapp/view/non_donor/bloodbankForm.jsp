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

    <script src="<%=request.getContextPath()%>/public/scripts/validate_email_contact.js"></script>
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
</head>

<body>
<div class="modal-content">
    <div class="modal-header">
        <span class="close-popup" onclick="history.back()">&times;</span>
        <h3>
            <c:if test="${user != null}">
                Edit BloodBank User
            </c:if>
            <c:if test="${user == null}">
                Add New BloodBank User
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
            <form action="userBloodBankUpdate" method="post" onsubmit="return validate();"></c:if>
        <c:if test="${user == null}">
            <form action="userBloodBankInsert" method="post" onsubmit="return validate();">
        </c:if>
                <div class="fields">
                    <c:if test="${user != null}">
                        <input type="hidden" name="id" value="<c:out value='${user.id}' />" />
                    </c:if>
                    <div class="field-single">
                        <span>Username (BloodBank Code)</span>
                        <input type="text" name="username" id="username" value="<c:out value='${user.code}' />"/>
                    </div>
                    <div class="field-single">
                        <span>Name</span>
                        <input type="text" name="name" id="name" value="<c:out value='${user.name}' />"/>
                    </div>
                    <div class="field-single">
                        <span>Blood Group</span>
                        <input type="text" name="bg" id="bg" value="<c:out value='${user.bg}' />"/>
                    </div>
                    <div class="field-single">
                        <span>Email</span>
                        <input type="text" name="email" id="email" value="<c:out value='${user.email}' />"/>
                    </div>
                    <div class="field-single">
                        <span>Contact Number</span>
                        <input type="text" name="contact" id="contact" value="<c:out value='${user.contact}' />"/>
                    </div>
                    <div class="field-single">
                        <span>Address Street</span>
                        <input type="text" name="add_street" id="add_street" value="<c:out value='${user.add_street}' />"/>
                    </div>
                    <div class="field-single">
                        <span>Address City</span>
                        <input type="text" name="add_city" id="add_city" value="<c:out value='${user.add_city}' />"/>
                    </div>
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
