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
                <%--<div class="search-wrapper">
                    <span class="las la-search"></span>
                    <input type="search" placeholder="search here"/>
                    <!-- <input type="date" id="request-date-search"> -->
                </div>--%>
                <div class="buttons">

                </div>
            </div>

            <div class="card-body">
                <div class="table-responsive">
                    <table width="100%" id="table_id">
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
                            <td>Status</td>
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
                                <c:if test="${donor.status == 'Normal'}">
                                    <span class="status progress">Normal</span>
                                </c:if>
                                <c:if test="${donor.status == 'T_Deferred'}">
                                    <span class="status open">T_Deferred</span>
                                </c:if>
                                <c:if test="${donor.status == 'P_Deferred'}">
                                    <span class="status close">P_Deferred</span>
                                </c:if>
                                <c:if test="${donor.status == 'Not_Verified'}">
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