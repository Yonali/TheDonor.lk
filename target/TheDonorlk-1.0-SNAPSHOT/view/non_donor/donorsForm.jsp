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
            <c:if test="${donor != null}">
                Edit Donor
            </c:if>
            <c:if test="${donor == null}">
                Add New Donor
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

        <c:if test="${donor != null}">
        <form action="donorUpdate" method="post" onsubmit="return validate();"></c:if>
            <c:if test="${donor == null}">
            <form action="donorInsert" method="post" onsubmit="return validate();">
                </c:if>
                <div class="fields">
                    <c:if test="${donor != null}">
                        <input type="hidden" name="id" value="<c:out value='${donor.id}' />"/>
                    </c:if>
                    <div class="field-single">
                        <span>First Name</span>
                        <input type="text" name="First_Name" id="First_Name" value="<c:out value='${donor.fname}'/>"/>
                    </div>
                    <div class="field-single">
                        <span>Last Name</span>
                        <input type="text" name="Last_Name" id="Last_Name" value="<c:out value='${donor.lname}'/>"/>
                    </div>
                    <div class="field-single">
                        <span>Donor NIC</span>
                        <input type="text" name="NIC" id="NIC" value="<c:out value='${donor.nic}'/>"/>
                    </div>
                    <div class="field-single">
                        <span>Blood Group</span>
                            <select name="Blood_Group" id="Blood_Group">
                                <option value="NULL"></option>
                                <option value="A+" ${donor.blood_group == 'A+' ? 'selected': ''}>A+</option>
                                <option value="A-" ${donor.blood_group == 'A-' ? 'selected': ''}>A-</option>
                                <option value="B+" ${donor.blood_group == 'B+' ? 'selected': ''}>B+</option>
                                <option value="B-" ${donor.blood_group == 'B-' ? 'selected': ''}>B-</option>
                                <option value="AB+" ${donor.blood_group == 'AB+' ? 'selected': ''}>AB+</option>
                                <option value="AB-" ${donor.blood_group == 'AB-' ? 'selected': ''}>AB-</option>
                                <option value="O+" ${donor.blood_group == 'O+' ? 'selected': ''}>O+</option>
                                <option value="O-" ${donor.blood_group == 'O-' ? 'selected': ''}>O-</option>
                            </select>
                    </div>
                    <div class="field-single">
                        <span>Contact</span>
                        <input type="text" name="Contact" id="Contact" value="<c:out value='${donor.contact}'/>"/>
                    </div>
                    <div class="field-single">
                        <span>Date</span>
                        <input type="date" name="DOB" id="DOB" value="<c:out value='${donor.dob}'/>">
                    </div>
                    <div class="field-single">
                        <span>Gender</span>
                            <select name="Gender" id="Gender">
                                <option value="Male" ${donor.gender == 'Male' ? 'selected': ''}>Male</option>
                                <option value="Female" ${donor.gender == 'Female' ? 'selected': ''}>Female</option>
                                <option value="Other" ${donor.gender == 'Other' ? 'selected': ''}>Other</option>
                            </select>
                    </div>
                    <div class="field-single">
                        <span>BloodBank Code</span>
                        <select name="BloodBank_Code" id="BloodBank_Code">
                            <option value="NULL"></option>
                            <c:forEach items="${listBloodBank}" var="bloodbank_code">
                                <option value="${bloodbank_code.code}" ${bloodbank_code.code == donor.bloodbank_code ? 'selected': ''}>${bloodbank_code.code}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="field-single">
                        <span>Status</span>
                            <select name="Status" id="Status">
                                <option value="Normal" ${donor.status == 'Normal' ? 'selected': ''}>Normal</option>
                                <option value="T_Deferred" ${donor.status == 'T_Deferred' ? 'selected': ''}>T_Deferred</option>
                                <option value="P_Deferred" ${donor.status == 'P_Deferred' ? 'selected': ''}>P_Deferred</option>
                                <option value="Not_Verified" ${donor.status == 'Not_Verified' ? 'selected': ''}>Not_Verified</option>
                            </select>
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
