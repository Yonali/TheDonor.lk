<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                <h3>Campaigns</h3>
                <div class="search-wrapper">
                    <span class="las la-search"></span>
                    <input type="search" placeholder="search here" />
                    <input type="date" id="campaign-date-search">
                </div>
                <div class="buttons">
                    <button id="editBtn">Edit</button>
                    <button>Cancel</button>
                    <button id="newBtn">Create</button>
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
                        <tr>
                            <td>#C101</td>
                            <td>Campaign 01</td>
                            <td>Viharamahadevi Park, Colombo</td>
                            <td>21/09/2021</td>
                            <td>9.00AM</td>
                            <td>2.00PM</td>
                            <td>
                                <span class="status open">Upcoming</span>

                            </td>
                        </tr>
                        <tr>
                            <td>#C102</td>
                            <td>Campaign 02</td>
                            <td>Red Cross Society, Colombo</td>
                            <td>16/09/2021</td>
                            <td>9.00AM</td>
                            <td>2.00PM</td>
                            <td>
                                <span class="status progress">In Progress</span>

                            </td>
                        </tr>
                        <tr>
                            <td>#C103</td>
                            <td>Campaign 03</td>
                            <td>Central Park, Kandy</td>
                            <td>21/08/2021</td>
                            <td>9.00AM</td>
                            <td>2.00PM</td>
                            <td>
                                <span class="status close">Closed</span>

                            </td>
                        </tr>
                        <tr>
                            <td>#C104</td>
                            <td>Campaign 04</td>
                            <td>Navy Hospital, Welisara</td>
                            <td>18/08/2021</td>
                            <td>9.00AM</td>
                            <td>2.00PM</td>
                            <td>
                                <span class="status close">Closed</span>
                            </td>
                        </tr>
                        <tr>
                            <td>#C105</td>
                            <td>Campaign 05</td>
                            <td>HCC, Kalmunai</td>
                            <td>15/08/2021</td>
                            <td>9.00AM</td>
                            <td>2.00PM</td>
                            <td>
                                <span class="status close">Closed</span>
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
            <h3>Enter Campaign Details</h3>
        </div>

        <div class="modal-body">
            <!-- The form inside popup modal -->
            <form>
                <div class="fields">
                    <div class="field-single">
                        <span>Campaign Name</span>
                        <input type="text" />
                    </div>
                    <div class="field-single">
                        <span>Start Time</span>
                        <input type="text" />
                    </div>
                    <div class="field-single">
                        <span>Location</span>
                        <input type="text" />
                    </div>
                    <div class="field-single">
                        <span>End Time</span>
                        <input type="text" />
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
    <script src="scripts/popup_modal.js"></script>
</div>

</body>

</html>