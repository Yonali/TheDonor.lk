<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>TheDonor.lk</title>
    <link rel="stylesheet" href="https://maxst.icons8.com/vue-static/landings/line-awesome/line-awesome/1.3.0/css/line-awesome.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/public/css/styles.css">
</head>

<body>
<main>
    <div class="recent-grid">
        <div class="card">
            <div class="card-header">
                <h3>System Admins</h3>
                <div class="search-wrapper">
                    <span class="las la-search"></span>
                    <input type="search" placeholder="search here" />
                </div>
                <div class="buttons">
                    <a href="<%=request.getContextPath()%>/userAdminShowNewForm">New</a>
                </div>
            </div>

            <div class="card-body">
                <div class="table-responsive">
                    <table width="100%">
                        <thead>
                        <tr>
                            <td>Admin ID</td>
                            <td>Username</td>
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
                                    <c:out value="${user.username}" />
                                </td>
                                <td><a href="<%=request.getContextPath()%>/userAdminShowEditForm?id=<c:out value='${user.id}' />">Edit</a> &nbsp;&nbsp;&nbsp;&nbsp; <a href="userAdminDelete?id=<c:out value='${user.id}' />">Delete</a></td>
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
