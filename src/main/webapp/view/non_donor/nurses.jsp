<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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

    <script src="<%=request.getContextPath()%>/public/scripts/action_confirmation.js"></script>
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.11.5/css/jquery.dataTables.css">
    <script type="text/javascript" charset="utf8"
            src="https://cdn.datatables.net/1.11.5/js/jquery.dataTables.js"></script>
    <script>
        $(document).ready(function () {
            $('#table_id').DataTable({
                "order": [[0, "desc"]]
            });
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
                <h3>Nurses</h3>
                <%--<div class="search-wrapper">
                    <span class="las la-search"></span>
                    <input type="search" placeholder="search here"/>
                    <!-- <span class="las la-calendar-week"></span> -->
                </div>--%>
                <div class="buttons">
                    <a href="<%=request.getContextPath()%>/userNurseShowNewForm">New</a>
                </div>
            </div>
            <div class="card-body">
                <div class="table-responsive">
                    <table width="100%" id="table_id">
                        <thead>
                        <tr>
                            <td>Nurse ID</td>
                            <td>Username</td>
                            <td>NIC</td>
                            <td>Name</td>
                            <td>Contact Number</td>
                            <td>Section</td>
                            <td>BloodBank</td>
                            <td>Actions</td>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="user" items="${listUser}">
                            <c:if test="${user.bloodbank_code == bloodbank || role == 'admin'}">
                                <tr>
                                    <td>
                                        <c:out value="${user.id}"/>
                                    </td>
                                    <td>
                                        <c:out value="${user.username}"/>
                                    </td>
                                    <td>
                                        <c:out value="${user.nic}"/>
                                    </td>
                                    <td>
                                        <c:out value="${user.first_name} ${user.last_name}"/>
                                    </td>
                                    <td>
                                        <c:out value="${user.contact}"/>
                                    </td>
                                    <td>
                                        <c:out value="${user.section}"/>
                                    </td>
                                    <td>
                                        <c:out value="${user.bloodbank_code}"/>
                                    </td>

                                    <% if (role.equals("admin")) { %>
                                    <td>
                                        <a href="<%=request.getContextPath()%>/userNurseShowEditForm?id=<c:out value='${user.id}' />">Edit</a>
                                        &nbsp;&nbsp;&nbsp;&nbsp;
                                        <a onclick="confirmation(event)"
                                           href="userNurseDelete?id=<c:out value='${user.id}' />">Delete</a></td>
                                    <% } %>

                                    <% if (role.equals("bloodbank")) { %>
                                    <td>
                                        <c:if test="${user.bloodbank_code == bloodbank}">
                                            <a href="<%=request.getContextPath()%>/userNurseShowEditForm?id=<c:out value='${user.id}' />">Edit</a> &nbsp;&nbsp;&nbsp;&nbsp;
                                            <a onclick="confirmation(event)"
                                               href="userNurseDelete?id=<c:out value='${user.id}' />">Delete</a>
                                        </c:if>
                                    </td>
                                    <% } %>
                                </tr>
                            </c:if>
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
