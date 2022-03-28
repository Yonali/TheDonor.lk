<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
        <h3>New Request</h3>
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

            <form action="requestInsert" method="post" onsubmit="return validate();">
                <div class="fields">
                    <input type="hidden" name="From_BloodBank_Code" value="<%= bloodbank %>"/>
                    <div class="field-single">
                        <span>BloodBank Code</span>
                        <select name="BloodBank_Code" id="BloodBank_Code" >
                            <c:forEach items="${listBloodBank}" var="bloodbank_code">
                                <%--<c:if test="${bloodbank_code.code == user.bloodbank_code}">
                                    <option value="${bloodbank_code.code}" selected>${bloodbank_code.code}</option>
                                </c:if>--%>
                                <c:if test="${bloodbank_code.code != bloodbank}">
                                    <option value="${bloodbank_code.code}">${bloodbank_code.code}</option>
                                </c:if>

                            </c:forEach>
                        </select>
                    </div>
                    <div class="field-single">
                        <span>Blood Group</span>
                        <select name="Blood_Group" id="Blood_Group">
                            <option value="A+">A+</option>
                            <option value="A-">A-</option>
                            <option value="B+">B+</option>
                            <option value="B-">B-</option>
                            <option value="AB+">AB+</option>
                            <option value="AB-">AB-</option>
                            <option value="O+">O+</option>
                            <option value="O-">O-</option>
                        </select>
                    </div>
                    <div class="field-single">
                        <span>Blood Product</span>
                        <select name="Blood_Product" id="Blood_Product">
                            <option value="RBC">RBC</option>
                            <option value="WBC">WBC</option>
                            <option value="Platelets">Platelets</option>
                            <option value="Plasma">Plasma</option>
                        </select>
                    </div>
                    <div class="field-single">
                        <span>Required Count</span>
                        <input type="text" name="Required_Count" id="Required_Count"/>
                    </div>
                    <div class="field-single">
                        <span>Remark</span>
                        <input type="text" name="Remark" id="Remark"/>
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
