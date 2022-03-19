<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.util.*" %>

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

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.11.5/css/jquery.dataTables.css">
    <script type="text/javascript" charset="utf8"
            src="https://cdn.datatables.net/1.11.5/js/jquery.dataTables.js"></script>
    <script>
        $(document).ready(function () {
            $('#table_id').DataTable();
        });
    </script>
</head>

<body>
<main>
    <%
        String reg_msg = "";
        reg_msg = reg_msg == null ? "" : (String) request.getAttribute("error");
        if (reg_msg != null) {
    %>
    <div id="error_message">
        <%= reg_msg %>
    </div>
    <% } %>

    <div class="recent-grid">
        <div class="card">
            <div class="card-header">
                <h3>Blood Transfer History</h3>
                <%--<div class="search-wrapper">
                    <span class="las la-search"></span>
                    <input type="search" placeholder="search here"/>
                    <input type="date" id="request-date-search">
                </div>--%>
                <div class="buttons">

                </div>
            </div>

            <div class="card-body">
                <div class="table-responsive">
                    <table width="100%" id="table_id">
                        <thead>
                        <tr>
                            <td>ID</td>
                            <td>Blood Barcode</td>
                            <td>From</td>
                            <td>To</td>
                            <td>Blood Group</td>
                            <td>Blood Product</td>
                            <td>Date</td>
                            <td>Time</td>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="transfer" items="${listTransfer}">
                            <tr>
                                <td><c:out value="${transfer.id}"/></td>
                                <td><c:out value="${transfer.blood_barcode}"/></td>
                                <td><c:out value="${transfer.from_bloodbank_code}"/></td>
                                <td><c:out value="${transfer.to_bloodbank_code}"/></td>
                                <td><c:out value="${transfer.blood_group}"/></td>
                                <td><c:out value="${transfer.blood_product}"/></td>
                                <td><c:out value="${transfer.transfer_date}"/></td>
                                <td><c:out value="${transfer.transfer_time}"/></td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</main>

<div id="myModal" class="modal">
    <div class="modal-content">
        <div class="modal-header">
            <span class="close-popup">&times;</span>
            <h3>Enter Blood Transfer Details</h3>
        </div>

        <div class="modal-body">
            <!-- The form inside popup modal -->
            <form>
                <div class="fields">
                    <div class="field-single">
                        <span>Blood ID</span>
                        <input type="text"/>
                    </div>
                    <div class="field-single">
                        <span>Date</span>
                        <input type="date" id="transfer-date">
                    </div>
                    <div class="field-single">
                        <span>Blood Group</span>
                        <div class="custom-select" style="width:200px">
                            <select class="box">
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
                        <span>Time</span>
                        <input type="text"/>
                    </div>
                    <div class="field-single">
                        <span>Blood Product</span>
                        <div class="custom-select" style="width:200px">
                            <select class="box">
                                <option value="RBC">RBC</option>
                                <option value="WBC">WBC</option>
                                <option value="Plasma">Plasma</option>
                                <option value="Platelets">Platelets</option>
                            </select>
                        </div>
                    </div>
                    <div class="field-single">
                        <span>To Blood Bank</span>
                        <div class="custom-select" style="width:200px">
                            <select class="box">
                                <option value="GH">General Hospital, Matara</option>
                                <option value="LHS">LHS, Colombo</option>
                                <option value="NHC">Nawaloka Hospitals, Colombo</option>
                                <option value="NK">NBTS, Kalmunai</option>
                                <option value="NM">NBTS, Matale</option>
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

    <!-- IMPORTANT -->
    <!-- Javascript file with popup modal function should be called here just after the popup modal -->
    <script src="<%=request.getContextPath()%>/public/scripts/popup_modal_dashboard.js"></script>
</div>

</body>

</html>