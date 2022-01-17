<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.util.*" %>

<%
    if (session.getAttribute("username") == null) {
        response.sendRedirect(request.getContextPath() + "/login.jsp");
    }
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

    <script src="<%=request.getContextPath()%>/public/scripts/validate_username_only.js"></script>
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
</head>

<body>
<div class="modal-content">
    <div class="modal-header">
        <span class="close-popup" onclick="history.back()">&times;</span>
        <h3>
            <c:if test="${user != null}">
                Edit Emergency Requirement
            </c:if>
            <c:if test="${user == null}">
                Add New Emergency Requirement
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
        <form action="emergencyUpdate" method="post" onsubmit="return validate();"></c:if>
            <c:if test="${user == null}">
            <form action="emergencyInsert" method="post" onsubmit="return validate();">
                </c:if>
                <div class="fields">
                    <c:if test="${user != null}">
                        <input type="hidden" name="id" value="<c:out value='${user.id}' />"/>
                    </c:if>
                    <div class="field-single">
                        <span>Blood Group</span>
                        <div class="custom-select" style="width:200px">
                            <select class="box" name="Blood_Group" id="Blood_Group">
                                <c:set var="a_p" value="A+"/>
                                <c:if test="${user.blood_group == a_p}">
                                    <option value="A+" selected>A+</option>
                                </c:if>
                                <c:if test="${user.blood_group != a_p}">
                                    <option value="A+">A+</option>
                                </c:if>
                                <c:set var="a_n" value="A-"/>
                                <c:if test="${user.blood_group == a_n}">
                                    <option value="A-" selected>A-</option>
                                </c:if>
                                <c:if test="${user.blood_group != a_n}">
                                    <option value="A-">A-</option>
                                </c:if>
                                <c:set var="b_p" value="B+"/>
                                <c:if test="${user.blood_group == b_p}">
                                    <option value="B+" selected>B+</option>
                                </c:if>
                                <c:if test="${user.blood_group != b_p}">
                                    <option value="B+">B+</option>
                                </c:if>
                                <c:set var="b_n" value="B-"/>
                                <c:if test="${user.blood_group == b_n}">
                                    <option value="B-" selected>B-</option>
                                </c:if>
                                <c:if test="${user.blood_group != b_n}">
                                    <option value="B-">B-</option>
                                </c:if>
                                <c:set var="ab_p" value="AB+"/>
                                <c:if test="${user.blood_group == ab_p}">
                                    <option value="AB+" selected>AB+</option>
                                </c:if>
                                <c:if test="${user.blood_group != ab_p}">
                                    <option value="AB+">AB+</option>
                                </c:if>
                                <c:set var="ab_n" value="AB-"/>
                                <c:if test="${user.blood_group == ab_n}">
                                    <option value="AB-" selected>AB-</option>
                                </c:if>
                                <c:if test="${user.blood_group != ab_n}">
                                    <option value="AB-">AB-</option>
                                </c:if>
                                <c:set var="o_p" value="O+"/>
                                <c:if test="${user.blood_group == o_p}">
                                    <option value="O+" selected>O+</option>
                                </c:if>
                                <c:if test="${user.blood_group != o_p}">
                                    <option value="O+">O+</option>
                                </c:if>
                                <c:set var="o_n" value="O-"/>
                                <c:if test="${user.blood_group == o_n}">
                                    <option value="O-" selected>O-</option>
                                </c:if>
                                <c:if test="${user.blood_group != o_n}">
                                    <option value="O-">O-</option>
                                </c:if>
                            </select>
                        </div>
                    </div>
<%--                    <c:if test="${user != null}">
                        <div class="field-single">
                            <span>Date</span>
                            <input type="date" name="Date" id="Date" value="<c:out value='${user.date}' />">
                        </div>
                        <div class="field-single">
                            <span>Time</span>
                            <input type="time" step="any" name="Time" id="Time" value="<c:out value='${user.time}' />"/>
                        </div>
                    </c:if>--%>
                    <%--<div class="field-single">
                        <span>BloodBank Code</span>
                        <select name="BloodBank_Code" id="BloodBank_Code">
                            <c:forEach items="${listBloodBank}" var="bloodbank_code">
                                <c:if test="${bloodbank_code.code == user.bloodbank_code}">
                                    <option value="${bloodbank_code.code}" selected>${bloodbank_code.code}</option>
                                </c:if>
                                <c:if test="${bloodbank_code.code != user.bloodbank_code}">
                                    <option value="${bloodbank_code.code}">${bloodbank_code.code}</option>
                                </c:if>

                            </c:forEach>
                        </select>
                    </div>--%>
                    <input type="hidden" name="BloodBank_Code" value="<%= bloodbank %>"/>
                    <c:if test="${user != null}">
                        <div class="field-single" id="status">
                            <span>Status</span>
                            <div class="custom-select" style="width:200px">
                                <select class="box" name="Status">
                                    <c:set var="open" value="Open"/>
                                    <c:if test="${user.status == open}">
                                        <option value="Open" selected>Open</option>
                                    </c:if>
                                    <c:if test="${user.status != open}">
                                        <option value="Open">Open</option>
                                    </c:if>
                                    <c:set var="closed" value="Closed"/>
                                    <c:if test="${user.status == closed}">
                                        <option value="Closed" selected>Closed</option>
                                    </c:if>
                                    <c:if test="${user.status != closed}">
                                        <option value="Closed">Closed</option>
                                    </c:if>
                                </select>
                            </div>
                        </div>
                    </c:if>
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
