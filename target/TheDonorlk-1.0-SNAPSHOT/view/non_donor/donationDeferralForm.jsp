<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    if (session.getAttribute("username") == null) {
        response.sendRedirect(request.getContextPath() + "/login.jsp");
    }
    Object role = session.getAttribute("role");
    Object user_id = session.getAttribute("user_id");
    Object bloodbank = session.getAttribute("bloodbank");

    Object id = request.getAttribute("id");
    Object donor_id = request.getAttribute("donor_id");
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
    <script>
        function hideEndDate() {
            var type = document.getElementById("Deferral_Type").value;

            if (type == 'T_Deferral') {
                document.getElementById("End").style.display = "flex";
                return false;
            } else {
                document.getElementById("End").style.display = "none";
                return true;
            }
        }
    </script>
</head>

<body>
<div class="modal-content">
    <div class="modal-header">
        <span class="close-popup" onclick="history.back()">&times;</span>
        <h3>
            Deferral Reason and Details
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

        <c:if test="${user != null}">
        <form action="donationManagement?type=Deferr" method="post" onchange="hideEndDate()"></c:if>
            <c:if test="${user == null}">
            <form action="donationManagement?type=DeferrEdit" method="post" onchange="hideEndDate()"></c:if>

            <div class="fields">
                <input type="hidden" name="id" value="<%= id %>"/>
                <input type="hidden" name="user_id" value="<%= user_id %>"/>
                <input type="hidden" name="donor_id" value="<%= donor_id %>"/>
                <div class="field-single">
                    <span>Deferral Type</span>
                    <select name="Deferral_Type" id="Deferral_Type">
                        <option value="T_Deferral" ${history.type == 'T_Deferral' ? 'selected': ''}>T_Deferral</option>
                        <option value="P_Deferral" ${history.type == 'P_Deferral' ? 'selected': ''}>P_Deferral</option>
                    </select>
                </div>
                <div class="field-single">
                    <span>Deferral Remark</span>
                    <input type="text" name="Deferral_Remark" id="Deferral_Remark" value="<c:out value='${history.deferral_remark}'/>"/>
                </div>
                <div class="field-single">
                    <span>Start Date</span>
                    <input type="date" name="Start_Date" id="Start_Date" value="<c:out value='${history.start_date}'/>">
                </div>
                <div class="field-single" id="End" style="display: <c:out value="${history.type == 'P_Deferral' ? 'none': 'flex'}"/>">
                    <span>End Date</span>
                    <input type="date" name="End_Date" id="End_Date" value="<c:out value='${history.end_date}'/>">
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
