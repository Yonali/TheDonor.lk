<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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

    <script src="<%=request.getContextPath()%>/public/scripts/delete_confirmation.js"></script>
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
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
                <h3>Campaigns</h3>
                <div class="search-wrapper">
                    <span class="las la-search"></span>
                    <input type="search" placeholder="search here"/>
                    <input type="date" id="campaign-date-search">
                </div>
                <div class="buttons">
                    <% if (role.equals("bloodbank") || role.equals("admin")) { %>
                    <a href="<%=request.getContextPath()%>/userAdminShowNewForm">New</a>
                    <% } %>
                </div>
            </div>

            <div class="card-body">
                <div class="table-responsive">
                    <table width="100%">
                        <thead>
                        <tr>
                            <td>Campaign ID</td>
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
                                        <a href="#open">Upcoming</a>
                                        <a href="#progress">In Progress</a>
                                        <a href="#close">Closed</a>
                                    </div>
                                </div>
                            </td>
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
                                    <a href="<%=request.getContextPath()%>/campaignShowEditForm?id=<c:out value='${campaign.id}' />">Edit</a>
                                    &nbsp;&nbsp;&nbsp;&nbsp; <a onclick="confirmation(event)"
                                                                href="campaignAdminDelete?id=<c:out value='${campaign.id}' />">Delete</a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</main>

<div id="myModal" class="modal">
    <div class="modal-content">
        <div class="modal-header">
            <span class="close-popup">&times;</span>
            <h3>Enter Campaign Details</h3>
        </div>

        <div class="modal-body">
            <!-- The form inside popup modal -->
            <form>
                <div class="fields">
                    <div class="field-single">
                        <span>Campaign Name</span>
                        <input type="text"/>
                    </div>
                    <div class="field-single">
                        <span>Start Time</span>
                        <input type="text"/>
                    </div>
                    <div class="field-single">
                        <span>Location</span>
                        <input type="text"/>
                    </div>
                    <div class="field-single">
                        <span>End Time</span>
                        <input type="text"/>
                    </div>
                    <div class="field-single">
                        <span>Date</span>
                        <input type="date" id="donation-date">
                    </div>
                    <div class="field-single">
                        <span>Blood Bank</span>
                        <div class="custom-select" style="width:200px">
                            <select class="box">
                                <option value="GH">General Hospital, Matara</option>
                                <option value="LHS">LHS, Colombo</option>
                                <option value="NHC">Nawaloka Hospitals, Colombo</option>
                                <option value="NK">NBTS, Kalmunai</option>
                                <option value="NM">NBTS, Matale</option>
                            </select>
                        </div>
                    </div>
                    <div class="field-single" id="status">
                        <span>Status</span>
                        <div class="custom-select" style="width:200px">
                            <select class="box">
                                <option value="open">Upcoming</option>
                                <option value="in progress">In Progress</option>
                                <option value="close">Closed</option>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="modal-submit-button">
                    <div class="buttons">
                        <button type="submit">Submit</button>
                    </div>
                </div>
            </form>
        </div>

        <div class="modal-footer">
            <img src="images/Logo - White.png" height="100px">
            <p>Many people would not be alive today if it wasn't for the generosity of our donors. <br>Donating
                Blood Makes a Big Difference in the Lives of Others.
            </p>
        </div>
    </div>

    <!-- IMPORTANT -->
    <!-- Javascript file with popup modal function should be called here just after the popup modal -->
    <script src="<%=request.getContextPath()%>/public/scripts/popup_modal_dashboard.js"></script>
</div>

</body>

</html>