<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/public/css/styles.css">

    <script src="<%=request.getContextPath()%>/public/scripts/action_confirmation.js"></script>
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
                <h3>Violation Report</h3>
                <div class="search-wrapper">
                    <span class="las la-search"></span>
                    <input type="search" placeholder="search here" />
                    <input type="date" id="campaign-date-search">
                </div>
                <div class="buttons">

                </div>
            </div>

            <div class="card-body">
                <div class="table-responsive">
                    <table width="100%">
                        <thead>
                        <tr>
                            <td>ID</td>
                            <td>Post ID</td>
                            <td>Donor ID</td>
                            <td>Reported Date</td>
                            <td>Reason</td>
                            <td>
                                <div class="dropdown">
                                    <button class="dropbtn">Status</button>
                                    <div id="myDropdown" class="dropdown-content">
                                        <a href="#Decline" class="card-drop-down">Decline</a>
                                        <a href="#Removed" class="card-drop-down">Removed</a>
                                        <a href="#Pending" class="card-drop-down">Pending</a>
                                    </div>
                                </div>
                            </td>
                            <% if (role.equals("admin")) { %>
                            <td>Action</td>
                            <% } %>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="violation" items="${listViolations}">
                            <tr>
                                <td>
                                    <c:out value="${violation.id}"/>
                                </td>
                                <td>
                                    <c:out value="${violation.post_id}"/>
                                </td>
                                <td>
                                    <c:out value="${violation.donor_id}"/>
                                </td>
                                <td>
                                    <c:out value="${violation.date}"/>
                                </td>
                                <td>
                                    <c:out value="${violation.time}"/>
                                </td>
                                <td>
                                    <c:out value="${violation.reason}"/>
                                </td>
                                <td>
                                    <c:if test="${violation.status == 'Pending'}">
                                        <span class="status cancelled">Pending</span>
                                    </c:if>
                                    <c:if test="${violation.status == 'Declined'}">
                                        <span class="status Decline">Declined</span>
                                    </c:if>
                                    <c:if test="${violation.status == 'Removed'}">
                                        <span class="status Removed">Removed</span>
                                    </c:if>
                                </td>
                                <% if (role.equals("admin")) { %>
                                <td>
                                    <c:if test="${violation.status != 'Removed'}">
                                    <a href="<%=request.getContextPath()%>/violationPostView?id=<c:out value='${violation.post_id}'/>">View</a>

                                    <c:if test="${violation.status != 'Declined'}">
                                    <a href="<%=request.getContextPath()%>/violationManagement?id=<c:out value='${violation.id}'/>&type=Decline">Decline</a>
                                    </c:if>
                                    <a onclick="confirmation(event)"
                                       href="<%=request.getContextPath()%>/violationManagement?id=<c:out value='${violation.id}'/>&type=Remove&post_id=<c:out value='${violation.post_id}'/>">Remove</a>
                                    </c:if>
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
