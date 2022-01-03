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

    <script src="<%=request.getContextPath()%>/public/scripts/delete_confirmation.js"></script>
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
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
                <h3>Emergency Blood <br>Requirements</h3>
                <div class="search-wrapper">
                    <span class="las la-search"></span>
                    <input type="search" placeholder="search here"/>
                    <input type="date" id="emergency-date-search">
                </div>
                <div class="buttons">
                    <% if (role.equals("bloodbank")) { %>
                    <a href="<%=request.getContextPath()%>/emergencyShowNewForm">New</a>
                    <% } %>
                </div>
            </div>
            <div class="card-body">
                <div class="table-responsive">
                    <table width="100%">
                        <thead>
                        <tr>
                            <td>ID</td>
                            <td>Blood Group</td>
                            <td>Date</td>
                            <td>Time</td>
                            <td>Blood Bank</td>
                            <td>
                                <div class="dropdown">
                                    <button class="dropbtn">Status</button>
                                    <div id="myDropdown" class="dropdown-content">
                                        <a href="#open" class="card-drop-down">Open</a>
                                        <a href="#closed" class="card-drop-down">Closed</a>
                                    </div>
                                </div>
                            </td>
                            <% if (role.equals("bloodbank")) { %>
                            <td>Action</td>
                            <% } %>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="emergency" items="${listEmergency}">
                            <tr>
                                <td>
                                    <c:out value="${emergency.id}"/>
                                </td>
                                <td>
                                    <c:out value="${emergency.blood_group}"/>
                                </td>
                                <td>
                                    <c:out value="${emergency.date}"/>
                                </td>
                                <td>
                                    <c:out value="${emergency.time}"/>
                                </td>
                                <td>
                                    <c:out value="${emergency.bloodbank_code}"/>
                                </td>
                                <td>
                                    <c:set var="open" value="Open"/>
                                    <c:set var="closed" value="Closed"/>

                                    <c:if test="${emergency.status == open}">
                                        <span class="status open">Open</span>
                                    </c:if>
                                    <c:if test="${emergency.status == closed}">
                                        <span class="status close">Closed</span>
                                    </c:if>
                                </td>
                                <%--<% if (role.equals("admin")) { %>
                                <td>
                                    <a href="<%=request.getContextPath()%>/emergencyShowEditForm?id=<c:out value='${emergency.id}' />">Edit</a>
                                    &nbsp;&nbsp;&nbsp;&nbsp; <a onclick="confirmation(event)"
                                                                href="emergencyDelete?id=<c:out value='${emergency.id}' />">Delete</a>
                                </td>
                                <% } %>--%>

                                <% if (role.equals("bloodbank")) { %>
                                <c:if test="${emergency.bloodbank_code == bloodbank}">
                                    <td>
                                        <a href="<%=request.getContextPath()%>/emergencyShowEditForm?id=<c:out value='${emergency.id}' />">Edit</a>
                                        &nbsp;&nbsp;&nbsp;&nbsp; <a onclick="confirmation(event)"
                                                                    href="emergencyDelete?id=<c:out value='${emergency.id}' />">Delete</a>
                                    </td>
                                </c:if>
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

</div>

</body>

</html>