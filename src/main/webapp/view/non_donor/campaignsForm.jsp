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
                Edit Campaign
            </c:if>
            <c:if test="${user == null}">
                Add New Campaign
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
        <form action="campaignUpdate" method="post" onsubmit="return validate();"></c:if>
            <c:if test="${user == null}">
            <form action="campaignInsert" method="post" onsubmit="return validate();"></c:if>
                <div class="fields">
                    <c:if test="${user != null}">
                        <input type="hidden" name="id" value="<c:out value='${user.id}'/>"/>
                    </c:if>
                    <div class="field-single">
                        <span>Campaign Name</span>
                        <input type="text" name="Campaign_Name" id="Campaign_Name" value="<c:out value='${user.name}' />"/>
                    </div>
                    <div class="field-single">
                        <span>Start Time</span>
                        <input type="time" step="any" name="Start_Time" id="Start_Time" value="<c:out value='${user.start_time}' />"/>
                    </div>
                    <div class="field-single">
                        <span>Address Street</span>
                        <input type="text" name="Address_Street" id="Address_Street" value="<c:out value='${user.address_street}' />"/>
                    </div>
                    <div class="field-single">
                        <span>End Time</span>
                        <input type="time" step="any" name="End_Time" id="End_Time" value="<c:out value='${user.end_time}' />"/>
                    </div>
                    <div class="field-single">
                        <span>Address City</span>
                        <input type="text" name="Address_City" id="Address_City" value="<c:out value='${user.address_city}' />"/>
                    </div>
                    <div class="field-single">
                        <span>Date</span>
                        <input type="date" onfocus="this.min=new Date().toISOString().split('T')[0]" step="1" name="Campaign_Date" id="Campaign_Date" value="<c:out value='${user.date}' />">
                    </div>
                    <div class="field-single">
                        <span>BloodBank Code</span>
                        <select name="BloodBank_Code" id="BloodBank_Code" >
                            <c:forEach items="${listBloodBank}" var="bloodbank_code">
                                <c:if test="${bloodbank_code.code == user.bloodbank_code}">
                                    <option value="${bloodbank_code.code}" selected>${bloodbank_code.code}</option>
                                </c:if>
                                <c:if test="${bloodbank_code.code != user.bloodbank_code}">
                                    <option value="${bloodbank_code.code}">${bloodbank_code.code}</option>
                                </c:if>

                            </c:forEach>
                        </select>
                    </div>
                    <%--<c:if test="${user != null}">
                    <div class="field-single" id="status">
                        <span>Status</span>
                        <div class="custom-select" style="width:200px">
                            <select class="box">
                                <option value="open">Upcoming</option>
                                <option value="in progress">In Progress</option>
                                <option value="close">Closed</option>
                            </select>
                        </div>
                    </div>
                    </c:if>--%>
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
