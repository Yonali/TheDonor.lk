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
    <link rel="stylesheet"
          href="https://maxst.icons8.com/vue-static/landings/line-awesome/line-awesome/1.3.0/css/line-awesome.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/public/css/styles.css">
</head>

<body>
<main>
    <p style="text-align: center;">Development on Progress!<br>All DATA HARDCODED here for Demonstration Purpose</p>
    <%
        String reg_msg = (String) request.getAttribute("error");
        if (reg_msg == null)
            reg_msg = "";
    %>

    <div id="error_message">
        <%= reg_msg %>
    </div>
    <div class="recent-grid">
            <% if (role.equals("bloodbank") || role.equals("nurse") || role.equals("doctor")) { %>
            <div class="card">
                <form action="<%=request.getContextPath()%>/donationSearch" method="post">
                    <div class="modal-body">
                        <div class="fields">
                            <div class="field-single">
                                <span>Scan Blood ID</span>
                                <input type="text" name="Blood_ID" id="Blood_ID"/>
                            </div>
                            <div class="field-single">
                                <span>Type NIC</span>
                                <input type="text" name="NIC" id="NIC"/>
                            </div>
                        </div>
                    </div>
                    <div class="modal-submit-button" style="padding-top: 0px;">
                        <div class="buttons">
                            <button type="submit" class="bottom-full">Next</button>
                        </div>
                    </div>
                </form>
            </div>
            <% } %>
    </div>

    <div class="recent-grid">
        <div class="card">
            <div class="card-header">
                <h3>Donations</h3>
                <div class="search-wrapper">
                    <span class="las la-search"></span>
                    <input type="search" placeholder="search here"/>
                    <!-- <span class="las la-calendar-week"></span> -->
                    <input type="date" id="donation-date-search">
                </div>
                <div class="buttons">
                    <% if (!role.equals("admin")) { %>
                    <button id="newBtn">Edit</button>
                    <% } %>
                </div>
            </div>

            <div class="card-body">
                <div class="table-responsive">
                    <table width="100%">
                        <thead>
                        <tr>
                            <td>Donor ID</td>
                            <td>Blood Bank</td>
                            <td>Blood ID</td>
                            <td>Donor Name</td>
                            <td>Donor NIC</td>
                            <td>Date</td>
                            <td>Time</td>
                            <td>Remark</td>
                            <td>
                                <div class="dropdown">
                                    <button class="dropbtn">Status</button>
                                    <div id="myDropdown" class="dropdown-content">
                                        <a href="#new" class="card-drop-down">New</a>
                                        <a href="#consulted" class="card-drop-down">Consulted</a>
                                        <a href="#completed" class="card-drop-down">Completed</a>
                                        <a href="#cancelled" class="card-drop-down">Cancelled</a>
                                        <a href="#deferred" class="card-drop-down">Deferred</a>
                                    </div>
                                </div>
                            </td>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>#DC101</td>
                            <td>NBTS</td>
                            <td>#B101</td>
                            <td>Jamie Stark</td>
                            <td>64342388</td>
                            <td>22/09/2021</td>
                            <td>9.00AM</td>
                            <td>Remark goes here</td>
                            <td>
                                <span class="status open">New</span>
                            </td>
                        </tr>
                        <tr>
                            <td>#DC101</td>
                            <td>NBTS</td>
                            <td>#B101</td>
                            <td>Nick Jones</td>
                            <td>64342388</td>
                            <td>22/09/2021</td>
                            <td>9.00AM</td>
                            <td>Remark goes here</td>
                            <td>
                                <span class="status consulted">Consulted</span>
                            </td>
                        </tr>
                        <tr>
                            <td>#DC101</td>
                            <td>NBTS</td>
                            <td>#B101</td>
                            <td>Timothy Cameron</td>
                            <td>64342388</td>
                            <td>22/09/2021</td>
                            <td>9.00AM</td>
                            <td>Remark goes here</td>
                            <td>
                                <span class="status progress">Completed</span>
                            </td>
                        </tr>
                        <tr>
                            <td>#DC101</td>
                            <td>NBTS</td>
                            <td>#B101</td>
                            <td>Jake Clinton</td>
                            <td>64342388</td>
                            <td>22/09/2021</td>
                            <td>9.00AM</td>
                            <td>Remark goes here</td>
                            <td>
                                <span class="status cancelled">Cancelled</span>
                            </td>
                        </tr>
                        <tr>
                            <td>#DC101</td>
                            <td>NBTS</td>
                            <td>#B101</td>
                            <td>Anita Rosewell</td>
                            <td>64342388</td>
                            <td>22/09/2021</td>
                            <td>9.00AM</td>
                            <td>Remark goes here</td>
                            <td>
                                <span class="status close">Deferred</span>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</main>

</body>

</html>