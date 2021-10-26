<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    if (session.getAttribute("username") == null) {
        response.sendRedirect(request.getContextPath() + "/login.jsp");
    }
%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>TheDonor.lk</title>
    <link rel="stylesheet"
          href="https://maxst.icons8.com/vue-static/landings/line-awesome/line-awesome/1.3.0/css/line-awesome.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/public/css/styles.css">
    <%--  <script src="<%=request.getContextPath()%>/public/css/scripts.js"></script>--%>
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
                <h3>Blood Banks</h3>
                <div class="search-wrapper">
                    <span class="las la-search"></span>
                    <input type="search" placeholder="search here"/>
                </div>
                <div class="buttons">
                    <a href="<%=request.getContextPath()%>/userBloodBankShowNewForm">New</a>
                </div>
            </div>

            <div class="card-body">
                <div class="table-responsive">
                    <table width="100%">
                        <thead>
                        <tr>
                            <td>BloodBank ID</td>
                            <td>Username/<br>BloodBank Code</td>
                            <%--              <td>Username</td>--%>
                            <td>Name</td>
                            <td>Email</td>
                            <td>Contact</td>
                            <td>Address</td>
                            <td>Actions</td>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="user" items="${listUser}">
                            <tr>
                                <td>
                                    <c:out value="${user.id}" />
                                </td>
                                <td>
                                    <c:out value="${user.code}" />
                                </td>
                                <td>
                                    <c:out value="${user.name}" />
                                </td>
                                <td>
                                    <c:out value="${user.email}" />
                                </td>
                                <td>
                                    <c:out value="${user.contact}" />
                                </td>
                                <td>
                                    <c:out value="${user.add_street}, ${user.add_city}" />
                                </td>
                                <td><a href="<%=request.getContextPath()%>/userBloodBankShowEditForm?id=<c:out value='${user.id}' />">Edit</a> &nbsp;&nbsp;&nbsp;&nbsp; <a href="userBloodBankDelete?id=<c:out value='${user.id}' />">Delete</a></td>
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
