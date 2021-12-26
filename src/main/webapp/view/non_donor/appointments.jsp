<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet"
          href="https://maxst.icons8.com/vue-static/landings/line-awesome/line-awesome/1.3.0/css/line-awesome.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/public/css/styles.css">
<%--    <script src="<%=request.getContextPath()%>/public/scripts/calender.js"></script>--%>


</head>

<body>
<main>
<%--    <p style="text-align: center;">Development on Progress!<br>All DATA HARDCODED here for Demonstration Purpose</p>--%>

    <%----------------------------calendar----------------------------------------%>
    <div class="container">
        <div class="calendar">
            <div class="month">
                <i class="fa fa-angle-left prev"></i>
                <div class="date">
                    <h1></h1>
                    <p></p>
                </div>

                <i class="fa fa-angle-right next"></i>
            </div>
            <div class="weekdays">
                <div>Sun</div>
                <div>Mon</div>
                <div>Tue</div>
                <div>Wed</div>
                <div>Thu</div>
                <div>Fri</div>
                <div>Sat</div>
            </div>
            <div class="days"></div>
        </div>
    </div>
    <%---------------------------------------------------------------------------------%>

    <div class="recent-grid">
        <div class="card">
            <div class="card-header">
                <h3>Appointments</h3>
                <diiiiiiiv class="search-wrapper">
                    <span class="las la-search"></span>
                    <input type="search" placeholder="search here"/>
                    <input type="date" id="appointment-date-search">
                </diiiiiiiv>
                <div class="buttons">
                    <% if (role.equals("bloodbank")) { %>
                    <button>Accept</button>
                    <button>Decline</button>
                    <% } %>
                </div>
            </div>
            <div class="card-body">
                <div class="table-responsive">
                    <table width="100%">
                        <thead>
                        <tr>
                            <td>Appt. ID</td>
                            <td>Blood Bank</td>
                            <td>Donor Name</td>
                            <td>Donor NIC</td>
                            <td>Date</td>
                            <td>Time</td>
                            <td>
                                <div class="dropdown">
                                    <button class="dropbtn">Status</button>
                                    <div id="myDropdown" class="dropdown-content">
                                        <a href="#accepted" class="card-drop-down">New</a>
                                        <a href="#accepted" class="card-drop-down">Accepted</a>
                                        <a href="#declined" class="card-drop-down">Declined</a>
                                    </div>
                                </div>
                            </td>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>#D101</td>
                            <td>NBTS</td>
                            <td>Jake Clinton</td>
                            <td>112344</td>
                            <td>21/09/2021</td>
                            <td>9.00AM</td>
                            <td>
                                <span class="status open">New</span>
                            </td>
                        </tr>
                        <tr>
                            <td>#D102</td>
                            <td>NBTS</td>
                            <td>Anita Rosewell</td>
                            <td>112356</td>
                            <td>21/09/2021</td>
                            <td>10.00AM</td>
                            <td>
                                <span class="status close">Declined</span>

                            </td>
                        </tr>
                        <tr>
                            <td>#D104</td>
                            <td>NBTS</td>
                            <td>Timothy Cameron</td>
                            <td>234489</td>
                            <td>21/09/2021</td>
                            <td>3.00PM</td>
                            <td>
                                <span class="status progress">Accepted</span>
                            </td>
                        </tr>
                        <tr>
                            <td>#D105</td>
                            <td>NBTS</td>
                            <td>Brendon Mack</td>
                            <td>476532</td>
                            <td>22/09/2021</td>
                            <td>9.00AM</td>
                            <td>
                                <span class="status progress">Accepted</span>
                            </td>
                        </tr>
                        <tr>
                            <td>#D107</td>
                            <td>NBTS</td>
                            <td>Sara Ellies</td>
                            <td>787855</td>
                            <td>23/09/2021</td>
                            <td>9.00AM</td>
                            <td>
                                <span class="status progress">Accepted</span>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</main>




<!-- The Popup Modal -->
<div id="myModal" class="modal">
    <div class="modal-content">
        <div class="modal-header">
            <span class="close-popup">&times;</span>
            <h3>Enter Appointment Details</h3>
        </div>

        <div class="modal-body">
            <!-- The form inside popup modal -->
            <form>
                <div class="fields">
                    <div class="field-single">
                        <span>Donor Name</span>
                        <input type="text"/>
                    </div>
                    <div class="field-single">
                        <span>Date</span>
                        <input type="date" id="appointment-date">
                    </div>
                    <div class="field-single">
                        <span>Donor NIC</span>
                        <input type="text"/>
                    </div>
                    <div class="field-single">
                        <span>Time</span>
                        <input type="text"/>
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
            <img src="<%=request.getContextPath()%>/public/images/Logo%20-%20White.png" height="100px">
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
