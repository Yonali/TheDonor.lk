<%@ page import="com.example.thedonorlk.Database.UserBloodBankDAO" %>
<%@ page import="com.example.thedonorlk.Bean.UserBloodBankBean" %>
<%@ page import="java.util.List" %>
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
    <style>
        .modal-content {
            top: 10px;
        }
        @-webkit-keyframes slideIn {
            from {
                top: -300px;
                opacity: 0;
            }

            to {
                top: 10px;
                opacity: 1;
            }
        }
        @keyframes slideIn {
            from {
                top: -300px;
                opacity: 0;
            }

            to {
                top: 10px;
                opacity: 1;
            }
        }
    </style>
</head>

<body>
<div class="modal-content">
    <div class="modal-header">
        <span class="close-popup" onclick="history.back()">&times;</span>
        <h3>
            <c:if test="${appointment != null}">
                Edit Appointment
            </c:if>
            <c:if test="${appointment == null}">
                Create New Appointment
            </c:if>
        </h3>
    </div>

    <div class="modal-body">
        <%
            String reg_msg = (String) request.getAttribute("error");
            if (reg_msg == null)
                reg_msg = "";
        %>
        <div id="error_message">
            <%= reg_msg %>
        </div>

        <!-- The form inside popup modal -->
        <c:if test="${appointment != null}">
        <form action="appointmentUpdate" method="post" onsubmit="return validate();"></c:if>
            <c:if test="${appointment == null}">
            <form action="appointmentInsert" method="post" onsubmit="return validate();">
                </c:if>
                <div class="fields">
                    <c:if test="${appointment != null}">
                        <input type="hidden" name="id" value="<c:out value='${appointment.id}' />"/>
                    </c:if>
                    <input type="hidden" name="Donor_ID" value="<%= session.getAttribute("id") %>"/>
                    <div class="field-single">
                        <span>Date</span>
                        <input type="date" name="Appointment_Date" id="Appointment_Date"
                               value="<c:out value='${appointment.appointment_date}' />"/>
                    </div>
                    <div class="field-single">
                        <span>Start Time</span>
                        <input type="time" step="any" name="Appointment_Time" id="Appointment_Time"
                               value="<c:out value='${appointment.appointment_time}' />"/>
                    </div>
                    <div class="field-single">
                        <span>Blood Bank</span>
                        <div class="custom-select" style="width:200px">
                            <select class="box" name="BloodBank_Code" id="BloodBank_Code" >
                                <c:forEach items="${listBloodBank}" var="bloodbank_code">
                                    <c:if test="${bloodbank_code.code == appointment.bloodbank_code}">
                                        <option value="${bloodbank_code.code}" selected>${bloodbank_code.code}</option>
                                    </c:if>
                                    <c:if test="${bloodbank_code.code != appointment.bloodbank_code}">
                                        <option value="${bloodbank_code.code}">${bloodbank_code.code}</option>
                                    </c:if>

                                </c:forEach>
                            </select>
                        </div>
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