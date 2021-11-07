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
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

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
                    <button id="remove">Remove</button>
                    <button id="newBtn">View</button>
                    <button id="decline">Decline</button>
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

<div id="myModal" class="modal">
    <div class="modal-content">
        <div class="modal-header">
            <span class="close-popup">&times;</span>
            <h3>View Report</h3>
        </div>

        <div class="modal-body">
            <!-- The form inside popup modal -->
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
            <div class="posts">
                <div class="singlepost">
                    <div class="Profilename">
                        <img src="<%=request.getContextPath()%>/public/images/postdp.jpg" id="PP" style="width:60px;height:60px;">
                        <a href="#">Jenny Doe</a>
                        <h6 id="postdate">2021/09/10</h6>


                    </div>

                    <div class="caption">
                        <h6>I saved a life today and this is my fifth blood transfusion. </h6>
                    </div>
                    <div class="imgOrV">
                        <img src="<%=request.getContextPath()%>/public/images//postpic.jpg" id="PP1" style="width:400px;height:300px;">
                    </div>
                    <!-- --------------------------------responsive------------------------------------- -->
<%--                    <div class="imgOrV_responsive">--%>
<%--                        <img src="<%=request.getContextPath()%>/public/images//postpic.jpg" id="PP1_r" style="width:250px;height:200px;">--%>
<%--                    </div>--%>
                    <!-- --------------------------------responsive------------------------------------- -->
                    <div class="footer">
                        <div class="sub_footer">
                            <div class="like_div">
                                <button id="likes_box"><i onclick="myFunction(this)" class="fa fa-thumbs-up"></i>25 likes</button>
                                <!-- <button id="mediabtn" class="mediabtn_pht"><i class="fa fa-picture-o" aria-hidden="true"></i>Photo</button> -->
                            </div>
                            <div class="comment_div">
                                <button id="comments_box3"> <i onclick="myFunction(this)" class="fa fa-comment-o"
                                                               aria-hidden="true"></i>9 Comments</button>
                            </div>
<%--                            <div class="report_div">--%>
<%--                                <button class="Report" id="Report">Report</button>--%>
<%--                            </div>--%>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="modal-footer" style="padding: 10px 100px;">
<%--            <img src="<%=request.getContextPath()%>/public/images/Logo - White.png" height="100px">--%>
<%--            <p>Many people would not be alive today if it wasn't for the generosity of our donors. <br>Donating--%>
<%--                Blood Makes a Big Difference in the Lives of Others.--%>
<%--            </p>--%>
        </div>
    </div>

    <!-- IMPORTANT -->
    <!-- Javascript file with popup modal function should be called here just after the popup modal -->
    <script src="<%=request.getContextPath()%>/public/scripts/popup_modal_dashboard.js"></script>
</div>


<!-- -------------------report button popup------------------------------------------------------------------ -->

<%--<div id="myModal4" class="modal4">--%>
<%--    <div class="Inner_m4">--%>
<%--        <div class="modal-content4">--%>
<%--            <div class="modal-header4">--%>
<%--                <span class="close4">&times;</span>--%>
<%--                <h3>Reason to Report</h3>--%>
<%--            </div>--%>

<%--            <div class="modal-body4">--%>
<%--                <!-- The form inside popup modal -->--%>
<%--                <form>--%>
<%--                    <!-- <div class="inner_form"> -->--%>
<%--                    <div class="fields4">--%>
<%--                        <div class="field-single4">--%>
<%--                            <!-- <span>Enter Your Email Address</span> -->--%>
<%--                            <input type="text" placeholder="Enter the reason"/>--%>
<%--                        </div>--%>
<%--                        <div class="field-single4">--%>
<%--                            <span>Do you want to Report?</span>--%>
<%--                        </div>--%>


<%--                    </div>--%>
<%--                    <div class="modal-submit-button4">--%>
<%--                        <div class="buttons">--%>
<%--                            <button type="submit" id="continue">Yes</button>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                    <!-- </div> -->--%>
<%--                </form>--%>
<%--            </div>--%>

<%--            <div class="modal-footer4">--%>

<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>


<%--    <!-- IMPORTANT -->--%>
<%--    <!-- Javascript file with popup modal function should be called here just after the popup modal -->--%>
<%--    <script src="<%=request.getContextPath()%>/public/scripts/popup_modal_dashboard.js"></script>--%>
<%--</div>--%>

<%--<script>--%>
<%--    var btn4 = document.getElementById("new");--%>
<%--    var modal4 = document.getElementById("myModal4");--%>
<%--    var span4 = document.getElementsByClassName("close4")[0];--%>


<%--    if (newbtn != null) {--%>
<%--        btn4.onclick = function () {--%>
<%--            modal4.style.display = "block";--%>
<%--        }--%>
<%--    }--%>
<%--    if (span != null) {--%>
<%--        span4.onclick = function () {--%>
<%--            modal4.style.display = "none";--%>
<%--        }--%>
<%--    }--%>
<%--    window.onclick = function (event) {--%>
<%--        if (event.target == modal4) {--%>
<%--            modal4.style.display = "none";--%>
<%--        }--%>
<%--    }--%>

<%--</script>--%>


</body>

</html>
