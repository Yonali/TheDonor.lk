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
        <h3>Blood Processing</h3>
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

        <form action="bloodProcessing" method="post" onsubmit="return validate();">
            <div class="fields">
                <input type="hidden" name="id" value="<c:out value='${id}'/>"/>
<%--                <input type="hidden" name="Blood_Barcode" value="<c:out value='${bloodBarcode}'/>"/>
                <input type="hidden" name="Collected_Date" value="<c:out value='${colDate}'/>"/>--%>
                <input type="hidden" name="Bloodbank_Code" value="<%= bloodbank %>"/>
                <div class="field-single">
                    <span>Blood Group</span>
                    <div class="custom-select" style="width:200px">
                        <select class="box" name="Blood_Group" id="Blood_Group">
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
                </div>
                <div class="field-single">
                    <span>Processed Date</span>
                    <input type="date" name="Processed_Date" id="Processed_Date">
                    <script>
                        document.getElementById('Processed_Date').valueAsDate = new Date();
                    </script>
                </div>
                <div></div>
                <div></div>
                <div></div>
                <div></div>
                <div class="field-single" id="rbc">
                    <span>RBC Expiry Date</span>
                    <input type="date" onfocus="this.min=new Date().toISOString().split('T')[0]" step="1" name="RBC_Expiry_Date" id="RBC_Expiry_Date">
                </div>
                <div class="field-single" id="wbc">
                    <span>WBC Expiry Date</span>
                    <input type="date" onfocus="this.min=new Date().toISOString().split('T')[0]" step="1" name="WBC_Expiry_Date" id="WBC_Expiry_Date">
                </div>
                <div class="field-single" id="plasma">
                    <span>Plasma Expiry Date</span>
                    <input type="date" onfocus="this.min=new Date().toISOString().split('T')[0]" step="1" name="Plasma_Expiry_Date" id="Plasma_Expiry_Date">
                </div>
                <div class="field-single" id="platelets">
                    <span>Platelets Expiry Date</span>
                    <input type="date" onfocus="this.min=new Date().toISOString().split('T')[0]" step="1" name="Platelets_Expiry_Date" id="Platelets_Expiry_Date">
                </div>
                <script>
                    document.getElementById('RBC_Expiry_Date').valueAsDate = new Date(new Date().setDate(new Date().getDate() + 35));
                    document.getElementById('WBC_Expiry_Date').valueAsDate = new Date(new Date().setDate(new Date().getDate() + 3));
                    document.getElementById('Plasma_Expiry_Date').valueAsDate = new Date(new Date().setDate(new Date().getDate() + 365));
                    document.getElementById('Platelets_Expiry_Date').valueAsDate = new Date(new Date().setDate(new Date().getDate() + 7));
                </script>
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
