<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
                <h3>Doctors</h3>
                <div class="search-wrapper">
                    <span class="las la-search"></span>
                    <input type="search" placeholder="search here"/>
                    <!-- <span class="las la-calendar-week"></span> -->
                </div>
                <div class="buttons">
                    <a href="<%=request.getContextPath()%>/userDoctorShowNewForm">New</a>
                </div>
            </div>

            <div class="card-body">
                <div class="table-responsive">
                    <table width="100%">
                        <thead>
                        <tr>
                            <td>Doctor ID</td>
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
                        <tr>
                            <td>
                                <c:out value="${user.id}" />
                            </td>
                            <td>
                                <c:out value="${user.username}" />
                            </td>
                            <td>
                                <c:out value="${user.nic}" />
                            </td>
                            <td>
                                <c:out value="${user.first_name} ${user.last_name}" />
                            </td>
                            <td>
                                <c:out value="${user.contact}" />
                            </td>
                            <td>
                                <c:out value="${user.section}" />
                            </td>
                            <td>
                                <c:out value="${user.bloodbank_code}" />
                            </td>
                            <td><a href="<%=request.getContextPath()%>/userDoctorShowEditForm?id=<c:out value='${user.id}' />">Edit</a> &nbsp;&nbsp;&nbsp;&nbsp; <a href="userDoctorDelete?id=<c:out value='${user.id}' />">Delete</a></td>
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
