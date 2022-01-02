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
%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>TheDonor.lk</title>
    <link rel="stylesheet"
          href="https://maxst.icons8.com/vue-static/landings/line-awesome/line-awesome/1.3.0/css/line-awesome.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/public/css/styles.css">

</head>

<body>
<main>
    <%
        String reg_msg = (String) request.getAttribute("error");
        if (reg_msg == null)
            reg_msg = "";
    %>
    <div id="error_message">
        <%= reg_msg %>
    </div>
    <div class="recent-grid">
        <div class="card">
            <div class="card-header">
                <h3>Donors</h3>
                <div class="search-wrapper">
                    <span class="las la-search"></span>
                    <input type="search" placeholder="search here"/>
                    <!-- <input type="date" id="request-date-search"> -->
                </div>
                <div class="buttons">

                </div>
            </div>

            <div class="card-body">
                <div class="table-responsive">
                    <table width="100%">
                        <thead>
                        <tr>
                            <td>Donor ID</td>
                            <td>Nearby</td>
                            <td>Donor Name</td>
                            <td>Donor NIC</td>
                            <td>Blood Group</td>
                            <td>Contact Number</td>
                            <td>DOB</td>
                            <td>Gender</td>
                            <td>
                                <div class="dropdown">
                                    <button class="dropbtn">Status</button>
                                    <div id="myDropdown" class="dropdown-content">
                                        <a href="#normal" class="card-drop-down">Normal</a>
                                        <a href="#Tdeferred" class="card-drop-down">T_Deferred</a>
                                        <a href="#Pdeferred" class="card-drop-down">P_Deferred</a>
                                    </div>
                                </div>
                            </td>
                            <% if (!role.equals("admin")) { %>
                            <td>Action</td>
                            <% } %>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="donor" items="${listDonor}">
                        <tr>
                            <td>
                                <c:out value="${donor.id}"/>
                            </td>
                            <td>
                                <c:out value="${donor.bloodbank_code}"/>
                            </td>
                            <td>
                                <c:out value="${donor.fname}"/> <c:out value="${donor.lname}"/>
                            </td>
                            <td>
                                <c:out value="${donor.nic}"/>
                            </td>
                            <td>
                                <c:out value="${donor.blood_group}"/>
                            </td>
                            <td>
                                <c:out value="${donor.contact}"/>
                            </td>
                            <td>
                                <c:out value="${donor.dob}"/>
                            </td>
                            <td>
                                <c:out value="${donor.gender}"/>
                            </td>
                            <td>
                                <c:set var="normal" value="Normal"/>
                                <c:set var="t_deferred" value="T_Deferred"/>
                                <c:set var="p_deferred" value="P_Deferred"/>
                                <c:set var="not_verified" value="Not_Verified"/>

                                <c:if test="${donor.status == normal}">
                                    <span class="status progress">Normal</span>
                                </c:if>
                                <c:if test="${donor.status == t_deferred}">
                                    <span class="status open">T_Deferred</span>
                                </c:if>
                                <c:if test="${donor.status == p_deferred}">
                                    <span class="status close">P_Deferred</span>
                                </c:if>
                                <c:if test="${donor.status == not_verified}">
                                    <span class="status cancelled">Not_Verified</span>
                                </c:if>
                            </td>
                            <% if (!role.equals("admin")) { %>
                                <td>
                                    <a href="<%=request.getContextPath()%>/donorShowEditForm?id=<c:out value='${donor.id}' />">Edit</a>
                                </td>
                            <% } %>
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
            <h3>Enter Donor Details</h3>
        </div>

        <div class="modal-body">
            <!-- The form inside popup modal -->
            <form>
                <div class="fields">
                    <% if (role.equals("nurse")) { %>
                    <div class="field-single">
                        <span>First Name</span>
                        <input type="text"/>
                    </div>
                    <div class="field-single">
                        <span>House Number</span>
                        <input type="text"/>
                    </div>
                    <div class="field-single">
                        <span>Last Name</span>
                        <input type="text"/>
                    </div>
                    <div class="field-single">
                        <span>Street</span>
                        <input type="text"/>
                    </div>
                    <div class="field-single">
                        <span>DOB</span>
                        <input type="date" id="dob-date">
                    </div>
                    <div class="field-single">
                        <span>City</span>
                        <input type="text"/>
                    </div>
                    <div class="field-single">
                        <span>Contact Number</span>
                        <input type="text"/>
                    </div>
                    <div class="field-single">
                        <span>Blood Bank</span>
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
                    <% } %>

                    <div class="field-single">
                        <span>Status</span>
                        <div class="custom-select" style="width:200px">
                            <select class="box">
                                <option value="clear">Normal</option>
                                <option value="tdeferred">T Deferred</option>
                                <option value="pdeferred">P Deferred</option>
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