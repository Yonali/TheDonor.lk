<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    if (session.getAttribute("username") == null || !session.getAttribute("role").equals("donor")) {
        response.sendRedirect(request.getContextPath() + "/login.jsp");
    }
%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/public/css/appointments_campaign.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
    <script src="<%=request.getContextPath()%>/public/scripts/cardview_toggle.js"></script>

    <title>Appointment</title>
</head>

<body>
    <div class="create-box">
        <div class="current">
            <div class="current_boxes">
                <div class="c">
                    <div class="BB_name">Create New Appointment</div>
                    <button class="newbtn" id="newbtn">New</button>

                </div>
            </div>
        </div>
    </div>

    <!----------------  NEW Card View ----------------->

    <div class="container">
        <div class="column">
            <div class="post-module">
                <!-- Thumbnail-->
                <div class="thumbnail">
                    <div class="date">
                        <div class="day">27</div>
                        <div class="month">Nov</div>
                    </div><img src="<%=request.getContextPath()%>/public/images/open.png" />
                </div>
                <!-- Post Content-->
                <div class="post-content">
                    <div class="category open">Open</div>
                    <h1 class="title">#1562 <br>Date - 27/11/2021 <br>Time - 12 PM</h1>
                    <h2 class="sub_title">National Blood Transfusion Services</h2>
                    <p class="description">Donor - <%=session.getAttribute("name")%> <br>Blood Bank - NBTS <br>Contact - 0777123456 <br>Address -
                    </p>
                    <div class="post-meta"><span class="comments"><i class="fa fa-edit"></i><a href="#" class="editBtn">
                                Edit</a></span></div>
                </div>
            </div>
        </div>
        <div class="column">
            <div class="post-module">
                <!-- Thumbnail-->
                <div class="thumbnail">
                    <div class="date">
                        <div class="day">25</div>
                        <div class="month">Oct</div>
                    </div><img src="<%=request.getContextPath()%>/public/images/accepted.png" />
                </div>
                <!-- Post Content-->
                <div class="post-content">
                    <div class="category accepted">Accepted</div>
                    <h1 class="title">#1421 <br>Date - 25/10/2021 <br>Time - 2.30 PM</h1>
                    <h2 class="sub_title">General Hospital, Colombo</h2>
                    <p class="description">Donor - <%=session.getAttribute("name")%> <br>Blood Bank - GHC <br>Contact - 0707123456 <br>Address -
                    </p>
                    <div class="post-meta"><span class="comments"><i class="fa fa-edit"></i><a href="#" class="editBtn">
                                Edit</a></span></div>
                </div>
            </div>
        </div>
        <div class="column">
            <div class="post-module">
                <!-- Thumbnail-->
                <div class="thumbnail">
                    <div class="date">
                        <div class="day">15</div>
                        <div class="month">Jun</div>
                    </div><img src="<%=request.getContextPath()%>/public/images/rejected.png" />
                </div>
                <!-- Post Content-->
                <div class="post-content">
                    <div class="category rejected">Rejected</div>
                    <h1 class="title">#1102 <br>Date - 15/06/2021 <br>Time - 9.30 PM</h1>
                    <h2 class="sub_title">Teaching Hospital, Kandy</h2>
                    <p class="description">Donor - <%=session.getAttribute("name")%> <br>Blood Bank - THK <br>Contact - 0767123456 <br>Address -
                    </p>
                    <div class="post-meta"><span class="comments"><i class="fa fa-edit"></i><a href="#" class="editBtn">
                                Edit</a></span></div>
                </div>
            </div>
        </div>
        <div class="column">
            <div class="post-module">
                <!-- Thumbnail-->
                <div class="thumbnail">
                    <div class="date">
                        <div class="day">12</div>
                        <div class="month">Jan</div>
                    </div><img src="<%=request.getContextPath()%>/public/images/completed.png" />
                </div>
                <!-- Post Content-->
                <div class="post-content">
                    <div class="category completed">Completed</div>
                    <h1 class="title">#1086 <br>Date - 12/01/2021 <br>Time - 10 PM</h1>
                    <h2 class="sub_title">Lady Ridgeway Hospital, Colombo</h2>
                    <p class="description">Donor - <%=session.getAttribute("name")%> <br>Blood Bank - LRHC <br>Contact - 0117123456 <br>Address -
                    </p>
                    <div class="post-meta"><span class="comments"><i class="fa fa-edit"></i><a href="#" class="editBtn">
                                Edit</a></span></div>
                </div>
            </div>
        </div>
        <div class="column container_more">
            <div class="post-module">
                <!-- Thumbnail-->
                <div class="thumbnail">
                    <div class="date">
                        <div class="day">27</div>
                        <div class="month">Jun</div>
                    </div><img src="<%=request.getContextPath()%>/public/images/completed.png" />
                </div>
                <!-- Post Content-->
                <div class="post-content">
                    <div class="category completed">Completed</div>
                    <h1 class="title">#0562 <br>Date - 27/06/2020 <br>Time - 08.30 PM</h1>
                    <h2 class="sub_title">National Blood Transfusion Services</h2>
                    <p class="description">Donor - <%=session.getAttribute("name")%> <br>Blood Bank - NBTS <br>Contact - 0777123456 <br>Address -
                    </p>
                    <div class="post-meta"><span class="comments"><i class="fa fa-edit"></i><a href="#" class="editBtn">
                                Edit</a></span></div>
                </div>
            </div>
        </div>
        <div class="column container_more">
            <div class="post-module">
                <!-- Thumbnail-->
                <div class="thumbnail">
                    <div class="date">
                        <div class="day">23</div>
                        <div class="month">Feb</div>
                    </div><img src="<%=request.getContextPath()%>/public/images/rejected.png" />
                </div>
                <!-- Post Content-->
                <div class="post-content">
                    <div class="category rejected">Rejected</div>
                    <h1 class="title">#1412 <br>Date - 23/02/2020 <br>Time - 1.30 PM</h1>
                    <h2 class="sub_title">General Hospital, Colombo</h2>
                    <p class="description">Donor - <%=session.getAttribute("name")%> <br>Blood Bank - GHC <br>Contact - 0707123456 <br>Address -
                    </p>
                    <div class="post-meta"><span class="comments"><i class="fa fa-edit"></i><a href="#" class="editBtn">
                                Edit</a></span></div>
                </div>
            </div>
        </div>
        <div class="column container_more">
            <div class="post-module">
                <!-- Thumbnail-->
                <div class="thumbnail">
                    <div class="date">
                        <div class="day">15</div>
                        <div class="month">Jun</div>
                    </div><img src="<%=request.getContextPath()%>/public/images/rejected.png" />
                </div>
                <!-- Post Content-->
                <div class="post-content">
                    <div class="category rejected">Rejected</div>
                    <h1 class="title">#1123 <br>Date - 15/06/2021 <br>Time - 12.30 PM</h1>
                    <h2 class="sub_title">Teaching Hospital, Kandy</h2>
                    <p class="description">Donor - <%=session.getAttribute("name")%> <br>Blood Bank - THK <br>Contact - 0767123456 <br>Address -
                    </p>
                    <div class="post-meta"><span class="comments"><i class="fa fa-edit"></i><a href="#" class="editBtn">
                                Edit</a></span></div>
                </div>
            </div>
        </div>
        <div class="column container_more">
            <div class="post-module">
                <!-- Thumbnail-->
                <div class="thumbnail">
                    <div class="date">
                        <div class="day">12</div>
                        <div class="month">Jan</div>
                    </div><img src="<%=request.getContextPath()%>/public/images/completed.png" />
                </div>
                <!-- Post Content-->
                <div class="post-content">
                    <div class="category completed">Completed</div>
                    <h1 class="title">#0086 <br>Date - 12/01/2021 <br>Time - 11 PM</h1>
                    <h2 class="sub_title">Lady Ridgeway Hospital, Colombo</h2>
                    <p class="description">Donor - <%=session.getAttribute("name")%> <br>Blood Bank - LRHC <br>Contact - 0117123456 <br>Address -
                    </p>
                    <div class="post-meta"><span class="comments"><i class="fa fa-edit"></i><a href="#" class="editBtn">
                                Edit</a></span></div>
                </div>
            </div>
        </div>
    </div>

    <button class="newbtn" onclick="appShowMore()" id="appShowMoreBtn">Show more</button>

    <!------------------------------------------>

    <!-- The Popup Modal -->
    <div id="myModal" class="modal">
        <div class="modal-content">
            <div class="modal-header">
                <span class="close">&times;</span>
                <h3>Enter Appointment Details</h3>
            </div>

            <div class="modal-body">
                <!-- The form inside popup modal -->
                <form>
                    <div class="fields">
                        <div class="field-single">
                            <span>Donor Name</span>
                            <input type="text" />
                        </div>
                        <div class="field-single">
                            <span>Donor NIC</span>
                            <input type="text" />
                        </div>
                        <div class="field-single">
                            <span>Date</span>
                            <input type="date" />
                        </div>
                        <div class="field-single">
                            <span>Time</span>
                            <input type="text" />
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
                        <!-- <div class="field-single">
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
                        </div> -->
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
        <script src="<%=request.getContextPath()%>/public/scripts/popup_modal.js"></script>
    </div>
    </div>

</body>

</html>