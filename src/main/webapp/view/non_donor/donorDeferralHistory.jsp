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
    Object user_id = session.getAttribute("user_id");
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
            <h2 class="card-topic-red">Deferral History</h2>
            <h4 class="card-topic-black"><%= request.getAttribute("donor_name") %><br><%= request.getAttribute("donor_nic") %></h4>

            <div class="card-body">
                <div class="table-responsive">
                    <table width="100%">
                        <thead>
                        <tr>
                            <td>Donation ID</td>
                            <td>Type</td>
                            <td>Start Date</td>
                            <td>End Date</td>
                            <td>Remark</td>
                            <td>Doctor</td>
                            <% if (!role.equals("admin")) { %>
                            <td>Action</td>
                            <% } %>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="history" items="${history}">
                        <tr>
                            <td>
                                <c:out value="${history.donation_id}"/>
                            </td>
                            <td>
                                <c:set var="t_deferral" value="T_Deferral"/>
                                <c:set var="p_deferral" value="P_Deferral"/>

                                <c:if test="${history.type == t_deferral}">
                                    <span class="status open">T_Deferral</span>
                                </c:if>
                                <c:if test="${history.type == p_deferral}">
                                    <span class="status close">P_Deferral</span>
                                </c:if>
                            </td>
                            <td>
                                <c:out value="${history.start_date}" />
                            </td>
                            <td>
                                <c:out value="${history.end_date}"/>
                            </td>
                            <td>
                                <c:out value="${history.deferral_remark}"/>
                            </td>
                            <td>
                                <c:out value="${history.doc_name}"/>
                            </td>
                            <% if (!role.equals("admin")) { %>
                            <c:if test="${history.doc_id == user_id}">
                                <td>
                                    <a href="<%=request.getContextPath()%>/donationShowDeferralEditForm?id=<c:out value='${history.donation_id}'/>&donor_id=<c:out value="${history.donor_id}"/>">Edit</a>
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

</body>

</html>