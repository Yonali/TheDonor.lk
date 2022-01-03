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
        String reg_msg = "";
        reg_msg = reg_msg == null ? "": (String) request.getAttribute("error");
        if (reg_msg != null) {
    %>
    <div id="error_message">
        <%= reg_msg %>
    </div>
    <% } %>

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
                                    <a href="<%=request.getContextPath()%>/donorShowDeferralHistory?id=<c:out value='${donor.id}' />">Deferral History</a>
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

</body>
</html>