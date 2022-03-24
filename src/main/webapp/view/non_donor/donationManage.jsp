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
    Object bloodbank = session.getAttribute("bloodbank");
    Object status = request.getAttribute("status");
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
            $('#table_id').DataTable({
                "order": [[0, "desc"]]
            });
        });
    </script>
</head>

<body>
<main>
    <div class="card-2col-right">
        <div class="big_num">
            <h1><c:out value='${donor.donation_count}'/></h1>
        </div>
        <h1>Donations</h1>
    </div>
    <div class="card card-details">
        <p>NIC: <c:out value='${donor.nic}'/></p>
        <div>
            Name: <c:out value='${donor.first_name}'/> <c:out value='${donor.last_name}'/><br>
            Contact: <c:out value='${donor.contact}'/><br>
            Email: <c:out value='${donor.email}'/><br>
            <pre>Age: <c:out value='${donor.age}'/>     Gender: <c:out value='${donor.gender}'/>    Blood Group: <c:out
                    value='${donor.blood_group}'/></pre>
        </div>
    </div>

    <div class="recent-grid">
        <div class="card">

            <% if (status == null) { %>
            <div class="card-header">

                <% if (role.equals("nurse")) { %>

                    <h3>Scan to start new Donation</h3>
                    <div class="field-single">
                        <form action="donationInsert" method="post" onsubmit="return validate();">
                        <span style="padding-left: 15px">Campaign ID</span>
                        <select name="Campaign_ID" id="Campaign_ID" style="width: 50px; height: 40px;">
                            <%--<option value="null"></option>--%>
                            <c:forEach items="${campaign}" var="campaign">
                                <jsp:useBean id="now" class="java.util.Date"/>

                                <c:set var = "start" value = "${campaign.date} ${campaign.start_time}" />
                                <c:set var = "end" value = "${campaign.date} ${campaign.end_time}" />

                                <fmt:parseDate value = "${start}" var = "parsedStartDate" pattern = "yyyy-MM-dd HH:mm:ss" />
                                <fmt:parseDate value = "${end}" var = "parsedEndDate" pattern = "yyy-MM-dd HH:mm:ss" />

                                <c:if test="${(parsedStartDate le now) && (parsedEndDate ge now)}">
                                    <option value="${campaign.id}">${campaign.id}</option>
                                </c:if>

                            </c:forEach>
                                <option value="null">Appointment/Regular</option>
                        </select>
                    </div>
                    <div class="search-wrapper">
                        <span class="las la-search"></span>


                        <input type="search" placeholder="Blood Barcode" name="Blood_Barcode" id="Blood_Barcode"/>
                        <%--<input type="hidden" name="Bloodbank_Code" value="<%= bloodbank %>"/>
                        <input type="hidden" name="User_ID" value="<%= user_id %>"/>
                        <input type="hidden" name="User_Role" value="<%= role %>"/>--%>
                        <input type="hidden" name="Donor_ID" value="<c:out value='${donor.id}'/>"/>
                        <button type="submit">Enter</button>
                        </form>

                    </div>

                <% } %>
            </div>
            <% } else { %>
            <c:choose>
                <c:when test="${status == 'IncorrectBloodID'}">
                    <h2 class="card-topic-red">Invalid Blood ID</h2>
                    <h3 class="card-topic-black">Please try again</h3>
                </c:when>
                <c:when test="${status == 'New_Nurse'}">
                    <h2 class="card-topic-red">Doctor Counsel PENDING</h2>
                    <h3 class="card-topic-black">Please ask donor to counsel the Doctor</h3>
                </c:when>
                <c:when test="${status == 'RecentlyDonated'}">
                    <h2 class="card-topic-red">Donor has recently donated within last 4 months.</h2>
                    <h3 class="card-topic-black">Please ask donor to donate
                        after <%= request.getAttribute("next_date") %>
                    </h3>
                </c:when>
                <c:when test="${status == 'New_Doctor'}">
                    <h3 class="card-topic-red">Counsel the Donor</h3>
                    <div class="card-header card-header-center">
                        <div class="buttons">
                            <a href="donationManagement?type=Accept&id=<%= request.getAttribute("donation_id") %>&user_id=<%= user_id %>">Accept
                                Donor</a>
                            <a href="donationShowDeferralForm?id=<%= request.getAttribute("donation_id") %>&donor_id=<c:out value='${donor.id}'/>">Deferr
                                Donor</a>
                            <a href="donationManagement?type=DoctorCancel&id=<%= request.getAttribute("donation_id") %>&user_id=<%= user_id %>">Cancel
                                Donation</a>
                        </div>
                    </div>
                </c:when>
                <c:when test="${status == 'Counselled'}">
                    <h2 class="card-topic-red">Manage Donation</h2>
                    <div class="card-header card-header-center">
                        <div class="buttons">
                            <a href="donationManagement?type=Complete&id=<%= request.getAttribute("donation_id") %>&user_id=<%= user_id %>&barcode=<%= request.getAttribute("barcode") %>&bank=<%= bloodbank %>">Complete
                                Donation</a>
                            <a href="donationManagement?type=Cancel&id=<%= request.getAttribute("donation_id") %>&user_id=<%= user_id %>">Cancel
                                Donation</a>
                        </div>
                    </div>
                </c:when>
                <c:when test="${status == 'Cancelled'}">
                    <h2 class="card-topic-red">Donation CANCELLED</h2>
                    <h3 class="card-topic-black"><%= request.getAttribute("barcode") %>
                    </h3>
                </c:when>
                <c:when test="${status == 'Completed'}">
                    <h2 class="card-topic-red">Donation COMPLETED</h2>
                    <h3 class="card-topic-black"><%= request.getAttribute("barcode") %>
                    </h3>
                </c:when>
                <c:when test="${status == 'Deferred'}">
                    <h2 class="card-topic-red">Donor DEFERRED</h2>
                    <c:if test="${deferral_history.type == 'T_Deferral'}">
                        <h4 class="card-topic-black"><c:out value='${deferral_history.type}'/> &nbsp; From <c:out
                                value='${deferral_history.start_date}'/> To <c:out
                                value='${deferral_history.end_date}'/></h4>
                    </c:if>
                    <c:if test="${deferral_history.type == 'P_Deferral'}">
                        <h4 class="card-topic-black"><c:out value='${deferral_history.type}'/> &nbsp; From <c:out
                                value='${deferral_history.start_date}'/></h4>
                    </c:if>
                    <h4 class="card-topic-black">Remark: <c:out value='${deferral_history.deferral_remark}'/></h4>
                </c:when>
            </c:choose>
            <% } %>

            <div class="card-body">
                <div class="table-responsive">
                    <table width="100%" id="table_id">
                        <thead>
                        <tr>
                            <td>Donation ID</td>
                            <td>Blood Bank</td>
                            <td>Blood Barcode</td>
                            <td>Donor Name</td>
                            <td>Donor NIC</td>
                            <td>Date</td>
                            <td>Time</td>
                            <td>
                                <div class="dropdown">
                                    <button class="dropbtn">Status</button>
                                    <div id="myDropdown" class="dropdown-content">
                                        <a href="#new" class="card-drop-down">New</a>
                                        <a href="#counselled" class="card-drop-down">Counselled</a>
                                        <a href="#completed" class="card-drop-down">Completed</a>
                                        <a href="#cancelled" class="card-drop-down">Cancelled</a>
                                        <a href="#deferred" class="card-drop-down">Deferred</a>
                                    </div>
                                </div>
                            </td>
                            <% if (role.equals("nurse") || role.equals("doctor")) { %>
                            <td>Actions</td>
                            <% } %>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="donation" items="${listDonation}">
                            <tr>
                                <td><c:out value="${donation.id}"/></td>
                                <td><c:out value="${donation.bloodbank_code}"/></td>
                                <td><c:out value="${donation.blood_id}"/></td>
                                <td><c:out value="${donation.donor_name}"/></td>
                                <td><c:out value="${donation.donor_nic}"/></td>
                                <td><c:out value="${donation.date}"/></td>
                                <td><c:out value="${donation.time}"/></td>
                                <td>
                                    <c:if test="${donation.status == 'New'}">
                                        <span class="status open">New</span>
                                    </c:if>
                                    <c:if test="${donation.status == 'Counselled'}">
                                        <span class="status consulted">Counselled</span>
                                    </c:if>
                                    <c:if test="${donation.status == 'Completed'}">
                                        <span class="status progress">Completed</span>
                                    </c:if>
                                    <c:if test="${donation.status == 'Cancelled'}">
                                        <span class="status cancelled">Cancelled</span>
                                    </c:if>
                                    <c:if test="${donation.status == 'Deferred'}">
                                        <span class="status close">Deferred</span>
                                    </c:if>
                                </td>
                                <% if (role.equals("nurse") || role.equals("doctor")) { %>
                                <td>
                                    <a href="<%=request.getContextPath()%>/donorShowEditForm?id=<c:out value='${donor.id}' />">Edit</a>
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
