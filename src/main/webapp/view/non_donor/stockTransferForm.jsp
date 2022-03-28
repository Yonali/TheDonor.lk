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
        <h3>Blood Stock Transfer</h3>
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

        <form action="bloodTransfering" method="post" onsubmit="return validate();">
            <div class="fields">
                <input type="hidden" name="id" value="<c:out value='${id}'/>"/>
                <%--<input type="hidden" name="Blood_Barcode" value="<c:out value='${bloodBarcode}'/>"/>
                <input type="hidden" name="Collected_Date" value="<c:out value='${colDate}'/>"/>--%>
                <input type="hidden" name="From_Bloodbank_Code" value="<%= bloodbank %>"/>
                <div class="field-single">
                    <span>Transfer To</span>
                    <select name="To_Bloodbank_Code" id="To_Bloodbank_Code" >
                        <c:forEach items="${listBloodBank}" var="bloodbank_code">
                            <c:if test="${bloodbank_code.code != bloodbank}">
                                <option value="${bloodbank_code.code}">${bloodbank_code.code}</option>
                            </c:if>
                        </c:forEach>
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
