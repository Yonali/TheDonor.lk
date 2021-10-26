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
    <div class="recent-grid">
        <div class="card">
            <div class="card-header">
                <h3>Blood Request - Sent</h3>
                <div class="search-wrapper">
                    <span class="las la-search"></span>
                    <input type="search" placeholder="search here" />
                    <input type="date" id="request-date-search">
                </div>
                <div class="buttons">
                    <button id="editBtn">Edit</button>
                    <button>Cancel</button>
                    <button id="newBtn">New</button>
                </div>
            </div>

            <div class="card-body">
                <div class="table-responsive">
                    <table width="100%">
                        <thead>
                        <tr>
                            <td>Blood ID</td>
                            <td>Blood Bank</td>
                            <td>Blood Group</td>
                            <td>Blood Product</td>
                            <td>Count</td>
                            <td>Remark</td>
                            <td>Date</td>
                            <td>Time</td>
                            <td>
                                <div class="dropdown">
                                    <button class="dropbtn">Status</button>
                                    <div id="myDropdown" class="dropdown-content">
                                        <a href="#requested">New</a>
                                        <a href="#accepted">Accepted</a>
                                        <a href="#declined">Declined</a>
                                        <a href="#cancelled">Cancelled</a>
                                    </div>
                                </div>
                            </td>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>#B101</td>
                            <td>Nawaloka Hospitals, Colombo</td>
                            <td>A+</td>
                            <td>WBC</td>
                            <td>25</td>
                            <td>Remark goes here</td>
                            <td>22/09/2021</td>
                            <td>9.00AM</td>
                            <td>
                                <span class="status open">New</span>
                            </td>
                        </tr>
                        <tr>
                            <td>#B102</td>
                            <td>Asiri Hospitals, Colombo</td>
                            <td>A-</td>
                            <td>RBC</td>
                            <td>25</td>
                            <td>Remark goes here</td>
                            <td>22/09/2021</td>
                            <td>10.00AM</td>
                            <td>
                                <span class="status progress">Accepted</span>
                            </td>
                        </tr>
                        <tr>
                            <td>#B103</td>
                            <td>Blood Bank, Chillaw</td>
                            <td>B+</td>
                            <td>Platelets</td>
                            <td>50</td>
                            <td>Remark goes here</td>
                            <td>21/09/2021</td>
                            <td>9.00AM</td>
                            <td>
                                <span class="status close">Declined</span>
                            </td>
                        </tr>
                        <tr>
                            <td>#B104</td>
                            <td>Nawaloka Hospitals, Colombo</td>
                            <td>A+</td>
                            <td>WBC</td>
                            <td>25</td>
                            <td>Remark goes here</td>
                            <td>20/09/2021</td>
                            <td>9.00AM</td>
                            <td>
                                <span class="status close">Cancelled</span>
                            </td>
                        </tr>
                        <tr>
                            <td>#B105</td>
                            <td>LHS, Colombo</td>
                            <td>O+</td>
                            <td>Plasma</td>
                            <td>10</td>
                            <td>Remark goes here</td>
                            <td>19/09/2021</td>
                            <td>9.00AM</td>
                            <td>
                                <span class="status open">New</span>
                            </td>
                        </tr>
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
            <h3>Enter Blood Request Details</h3>
        </div>

        <div class="modal-body">
            <!-- The form inside popup modal -->
            <form>
                <div class="fields">
                    <div class="field-single">
                        <span>Blood ID</span>
                        <input type="text" />
                    </div>
                    <div class="field-single">
                        <span>Date</span>
                        <input type="date" id="donation-date">
                    </div>
                    <div class="field-single">
                        <span>Blood Group</span>
                        <div class="custom-select" style="width:200px">
                            <select class="box">
                                <option value="A+">A+</option>
                                <option value="A-">A-</option>
                                <option value="B+">B+</option>
                                <option value="B-">B-</option>
                                <option value="AB+">AB+</option>
                                <option value="AB-">AB-</option>
                                <option value="O+">O+</option>
                                <option value="O-">O-</option>
                            </select>
                        </div>
                    </div>
                    <div class="field-single">
                        <span>Time</span>
                        <input type="text" />
                    </div>
                    <div class="field-single">
                        <span>Blood Product</span>
                        <div class="custom-select" style="width:200px">
                            <select class="box">
                                <option value="RBC">RBC</option>
                                <option value="WBC">WBC</option>
                                <option value="Plasma">Plasma</option>
                                <option value="Platelets">Platelets</option>
                            </select>
                        </div>
                    </div>
                    <div class="field-single">
                        <span>Count</span>
                        <input type="text" />
                    </div>
                    <div class="field-single">
                        <span>Send Request To</span>
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
                    <div class="field-single">
                        <span>Remark</span>
                        <input type="text" />
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