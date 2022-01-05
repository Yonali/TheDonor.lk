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
        <h3>Edit Blood Stock</h3>
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

        <form action="bloodStockEdit" method="post" onsubmit="return validate();">
            <div class="fields">
                <input type="hidden" name="id" value="<c:out value='${id}'/>"/>
                <%--<input type="hidden" name="Blood_Barcode" value="<c:out value='${bloodBarcode}'/>"/>
                <input type="hidden" name="Collected_Date" value="<c:out value='${colDate}'/>"/>
                <input type="hidden" name="Bloodbank_Code" value="<%= bloodbank %>"/>--%>

                <div class="field-single" id="wbc">
                    <span>Collected Date</span>
                    <input type="date" name="Collected_Date" id="Collected_Date" value="<c:out value='${stock.collected_date}'/>">
                </div>
                <div class="field-single">
                    <span>Processed Date</span>
                    <input type="date" name="Processed_Date" id="Processed_Date" value="<c:out value='${stock.processed_date}'/>">
                </div>
                <div class="field-single" id="rbc">
                    <span>Expiry Date</span>
                    <input type="date" name="Expiry_Date" id="Expiry_Date" value="<c:out value='${stock.expiry_date}'/>">
                </div>
                <div class="field-single">
                    <span>Status</span>
                    <select name="Status" id="Status">
                        <option value="Active" ${stock.status == 'Active' ? 'selected': ''}>Active</option>
                        <option value="Discarded" ${stock.status == 'Discarded' ? 'selected': ''}>Discarded</option>
                        <option value="Transfused" ${stock.status == 'Transfused' ? 'selected': ''}>Transfused</option>
                        <option value="NOT_Processed" ${stock.status == 'NOT_Processed' ? 'selected': ''}>NOT_Processed</option>
                        <option value="Processed" ${stock.status == 'Processed' ? 'selected': ''}>Processed</option>
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
