<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    if (session.getAttribute("username") == null) {
        response.sendRedirect(request.getContextPath() + "/login.jsp");
    }

    Object role = session.getAttribute("role");
    Object bloodbank = session.getAttribute("bloodbank");
%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>TheDonor.lk</title>
    <link rel="stylesheet"
          href="https://maxst.icons8.com/vue-static/landings/line-awesome/line-awesome/1.3.0/css/line-awesome.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/public/css/styles.css">

    <script src="<%=request.getContextPath()%>/public/scripts/validate_username_contact.js"></script>
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
</head>

<body>
<div class="modal-content">
    <div class="modal-header">
        <span class="close-popup" onclick="history.back()">&times;</span>
        <h3>
            <c:if test="${user != null}">
                Edit Doctor User
            </c:if>
            <c:if test="${user == null}">
                Add New Doctor User
            </c:if>
        </h3>
    </div>

    <div class="modal-body">
        <%
            String reg_msg = "";
            reg_msg = reg_msg == null ? "" : (String) request.getAttribute("error");
            if (reg_msg != null) {
        %>
        <div id="error_message">
            <%= reg_msg %>
        </div>
        <% } %>

        <c:if test="${user != null}">
        <form action="userDoctorUpdate" method="post" onsubmit="return validate();">
            </c:if>
            <c:if test="${user == null}">
            <form action="userDoctorInsert" method="post" onsubmit="return validate();">
                </c:if>
                <div class="fields">
                    <c:if test="${user != null}">
                        <input type="hidden" name="id" value="<c:out value='${user.id}' />"/>
                    </c:if>
                    <div class="field-single">
                        <span>Username (Valid Email address)</span>
                        <input type="text" name="username" id="username" value="<c:out value='${user.username}' />"/>
                    </div>
                    <div class="field-single">
                        <span>NIC</span>
                        <input type="text" name="nic" id="nic" value="<c:out value='${user.nic}' />"/>
                    </div>
                    <div class="field-single">
                        <span>First Name</span>
                        <input type="text" name="first_name" id="first_name"
                               value="<c:out value='${user.first_name}' />"/>
                    </div>
                    <div class="field-single">
                        <span>Last Name</span>
                        <input type="text" name="last_name" id="last_name" value="<c:out value='${user.last_name}' />"/>
                    </div>
                    <div class="field-single">
                        <span>Contact Number</span>
                        <input type="text" name="contact" id="contact" value="<c:out value='${user.contact}' />"/>
                    </div>
                    <div class="field-single">
                        <span>Section</span>
                        <input type="text" name="section" id="section" value="<c:out value='${user.section}' />"/>
                    </div>
                    <div class="field-single">
                        <span>BloodBank Code</span>
                        <select name="bloodbank_code" id="bloodbank_code">
                            <% if (role.equals("admin")) { %>
                            <c:forEach items="${listBloodBank}" var="bloodbank_code">
                                <c:if test="${bloodbank_code.code == user.bloodbank_code}">
                                    <option value="${bloodbank_code.code}" selected>${bloodbank_code.code}</option>
                                </c:if>
                                <c:if test="${bloodbank_code.code != user.bloodbank_code}">
                                    <option value="${bloodbank_code.code}">${bloodbank_code.code}</option>
                                </c:if>
                            </c:forEach>
                            <% } else { %>
                            <option value="<%= bloodbank %>" selected><%= bloodbank %></option>
                            <% } %>
                        </select>
                        <%--                        <input type="text" name="bloodbank_code" id="bloodbank_code" value="<c:out value='${user.bloodbank_code}' />"/>--%>
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
