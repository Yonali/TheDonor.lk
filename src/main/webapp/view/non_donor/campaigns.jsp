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
                <h3>Campaigns</h3>
                <div class="search-wrapper">
                    <span class="las la-search"></span>
                    <input type="search" placeholder="search here"/>
                    <input type="date" id="campaign-date-search">
                </div>
                <div class="buttons">
                    <% if (role.equals("bloodbank")) { %>
                    <a href="<%=request.getContextPath()%>/campaignShowNewForm">New</a>
                    <% } %>
                </div>
            </div>

            <div class="card-body">
                <div class="table-responsive">
                    <table width="100%">
                        <thead>
                        <tr>
                            <td>ID</td>
                            <td>Campaign Name</td>
                            <td>Location</td>
                            <td>Date</td>
                            <td>Start Time</td>
                            <td>End Time</td>
                            <td>Blood Bank</td>
                            <td>
                                <div class="dropdown">
                                    <button class="dropbtn">Status</button>
                                    <div id="myDropdown" class="dropdown-content">
                                        <a href="#open" class="card-drop-down">Upcoming</a>
                                        <a href="#progress" class="card-drop-down">In Progress</a>
                                        <a href="#close" class="card-drop-down">Closed</a>
                                    </div>
                                </div>
                            </td>
                            <% if (role.equals("bloodbank")) { %>
                            <td>Actions</td>
                            <% } %>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="campaign" items="${listCampaign}">
                            <tr>
                                <td>
                                    <c:out value="${campaign.id}"/>
                                </td>
                                <td>
                                    <c:out value="${campaign.name}"/>
                                </td>
                                <td>
                                    <c:out value="${campaign.address_street}, ${campaign.address_city}"/>
                                </td>
                                <td>
                                    <c:out value="${campaign.date}"/>
                                </td>
                                <td>
                                    <c:out value="${campaign.start_time}"/>
                                </td>
                                <td>
                                    <c:out value="${campaign.end_time}"/>
                                </td>
                                <td>
                                    <c:out value="${campaign.bloodbank_code}"/>
                                </td>
                                <td>


                                    <jsp:useBean id="now" class="java.util.Date"/>

                                    <c:set var = "start" value = "${campaign.date} ${campaign.start_time}" />
                                    <c:set var = "end" value = "${campaign.date} ${campaign.end_time}" />

                                    <fmt:parseDate value = "${start}" var = "parsedStartDate" pattern = "yyyy-MM-dd HH:mm:ss" />
                                    <fmt:parseDate value = "${end}" var = "parsedEndDate" pattern = "yyy-MM-dd HH:mm:ss" />

                                    <c:if test="${(parsedStartDate le now) && (parsedEndDate ge now)}">
                                        <span class="status progress">InProgress</span>
                                    </c:if>
                                    <c:if test="${(parsedStartDate le now) && (parsedEndDate le now)}">
                                        <span class="status close">Closed</span>
                                    </c:if>
                                    <c:if test="${(parsedStartDate ge now) && (parsedEndDate ge now)}">
                                        <span class="status open">Upcoming</span>
                                    </c:if>
                                </td>

                                <%--<% if (role.equals("admin")) { %>
                                <td>
                                    <a href="<%=request.getContextPath()%>/campaignShowEditForm?id=<c:out value='${campaign.id}' />">Edit</a>
                                    &nbsp;&nbsp;&nbsp;&nbsp; <a onclick="confirmation(event)"
                                                                href="campaignDelete?id=<c:out value='${campaign.id}' />">Delete</a>
                                </td>
                                <% } %>--%>

                                <% if (role.equals("bloodbank")) { %>
                                <c:if test="${campaign.bloodbank_code == bloodbank}">
                                <td>
                                    <a href="<%=request.getContextPath()%>/campaignShowEditForm?id=<c:out value='${campaign.id}' />">Edit</a>
                                    &nbsp;&nbsp;&nbsp;&nbsp; <a onclick="confirmation(event)"
                                                                href="campaignDelete?id=<c:out value='${campaign.id}' />">Delete</a>
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