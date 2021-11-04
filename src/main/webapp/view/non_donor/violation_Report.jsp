<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
</head>

<body>
<main>
    <p style="text-align: center;">Development on Progress!<br>All DATA HARDCODED here for Demonstration Purpose</p>
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
                    <button id="editBtn">Remove</button>
                    <button>View</button>
                    <button id="newBtn">Decline</button>
                </div>
            </div>

            <div class="card-body">
                <div class="table-responsive">
                    <table width="100%">
                        <thead>
                        <tr>
                            <td>Donor ID</td>
                            <td>Post ID</td>
                            <td>Reported Date</td>
                            <td>Reason</td>
                            <td>
                                <div class="dropdown">
                                    <button class="dropbtn">Remark</button>
                                    <div id="myDropdown" class="dropdown-content">
                                        <a href="#Decline" class="card-drop-down">Decline</a>
                                        <a href="#Removed" class="card-drop-down">Removed</a>
                                        <a href="#Pending" class="card-drop-down">Pending</a>
                                    </div>
                                </div>
                            </td>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>#D101</td>
                            <td>#P301</td>
                            <td>21/09/2021</td>
                            <td>Reason goes here</td>
                            <td>
                                <span class="status Removed">Removed</span>

                            </td>
                        </tr>
                        <tr>
                            <td>#D102</td>
                            <td>#P302</td>
                            <td>16/09/2021</td>
                            <td>Reason goes here</td>
                            <td>
                                <span class="status Removed">Removed</span>

                            </td>
                        </tr>
                        <tr>
                            <td>#D103</td>
                            <td>#P303</td>
                            <td>21/08/2021</td>
                            <td>Reason goes here</td>
                            <td>
                                <span class="status Decline">Decline</span>

                            </td>
                        </tr>
                        <tr>
                            <td>#D104</td>
                            <td>#P304</td>
                            <td>18/08/2021</td>
                            <td>Reason goes here</td>
                            <td>
                                <span class="status Decline">Decline</span>
                            </td>
                        </tr>
                        <tr>
                            <td>#D105</td>
                            <td>#P305</td>
                            <td>15/08/2021</td>
                            <td>Reason goes here</td>
                            <td>
                                <span class="status Pending">Pending</span>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</main>

<%--<div id="myModal" class="modal">--%>
<%--    <div class="modal-content">--%>
<%--        <div class="modal-header">--%>
<%--            <span class="close-popup">&times;</span>--%>
<%--            <h3>Enter Campaign Details</h3>--%>
<%--        </div>--%>

<%--        <div class="modal-body">--%>
<%--            <!-- The form inside popup modal -->--%>
<%--            <form>--%>
<%--                <div class="fields">--%>
<%--                    <div class="field-single">--%>
<%--                        <span>Campaign Name</span>--%>
<%--                        <input type="text" />--%>
<%--                    </div>--%>
<%--                    <div class="field-single">--%>
<%--                        <span>Start Time</span>--%>
<%--                        <input type="text" />--%>
<%--                    </div>--%>
<%--                    <div class="field-single">--%>
<%--                        <span>Location</span>--%>
<%--                        <input type="text" />--%>
<%--                    </div>--%>
<%--                    <div class="field-single">--%>
<%--                        <span>End Time</span>--%>
<%--                        <input type="text" />--%>
<%--                    </div>--%>
<%--                    <div class="field-single">--%>
<%--                        <span>Date</span>--%>
<%--                        <input type="date" id="donation-date">--%>
<%--                    </div>--%>
<%--                    <div class="field-single">--%>
<%--                        <span>Blood Bank</span>--%>
<%--                        <div class="custom-select" style="width:200px">--%>
<%--                            <select class="box">--%>
<%--                                <option value="GH">General Hospital, Matara</option>--%>
<%--                                <option value="LHS">LHS, Colombo</option>--%>
<%--                                <option value="NHC">Nawaloka Hospitals, Colombo</option>--%>
<%--                                <option value="NK">NBTS, Kalmunai</option>--%>
<%--                                <option value="NM">NBTS, Matale</option>--%>
<%--                            </select>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                    <div class="field-single" id="status">--%>
<%--                        <span>Status</span>--%>
<%--                        <div class="custom-select" style="width:200px">--%>
<%--                            <select class="box">--%>
<%--                                <option value="open">Upcoming</option>--%>
<%--                                <option value="in progress">In Progress</option>--%>
<%--                                <option value="close">Closed</option>--%>
<%--                            </select>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--                <div class="modal-submit-button">--%>
<%--                    <div class="buttons">--%>
<%--                        <button type="submit">Submit</button>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </form>--%>
<%--        </div>--%>

<%--        <div class="modal-footer">--%>
<%--            <img src="images/Logo - White.png" height="100px">--%>
<%--            <p>Many people would not be alive today if it wasn't for the generosity of our donors. <br>Donating--%>
<%--                Blood Makes a Big Difference in the Lives of Others.--%>
<%--            </p>--%>
<%--        </div>--%>
<%--    </div>--%>

<%--    <!-- IMPORTANT -->--%>
<%--    <!-- Javascript file with popup modal function should be called here just after the popup modal -->--%>
<%--    <script src="scripts/popup_modal_dashboard.js"></script>--%>
<%--</div>--%>

</body>

</html>
