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
    <link rel="stylesheet" href="<%=request.getContextPath()%>/public/css/Donor_Instructions.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <title>Instructions</title>
</head>
<body>
<!-- <div class="container"> -->
<!-- <div class="current"> -->

<div class="current_boxes">


    <div id="Interface_1">
        <div class="BB_name">Before The Donation</div>
        <div class="content">
            <!-- <br><br><br><br> -->
            <div class="main_cont_III">

                <div class="row-before">
                    <div class="inter_row-before">
                        <div class="column">
                            <div class="inter_column">
                                <div class="img">
                                    <img src="<%=request.getContextPath()%>/public/images/b1.png" alt="Appointment">
                                </div>

                                <div class="column_des">
                                    <h3>
                                        Schedule An Appointment
                                    </h3><br>
                                    <p>Pick the easiest and the most convenient time </p>
                                </div>
                            </div>
                        </div>

                        <div class="column">
                            <div class="inter_column">
                                <div class="img">
                                    <img src="<%=request.getContextPath()%>/public/images/b2.jpg" alt="food">
                                </div>

                                <div class="column_des">
                                    <h3>
                                        Get Your Nutrients
                                    </h3><br>
                                    <p> Make sure to eat iron rich food like red meat, seafood, beans and dark green leaf vegetables</p>
                                </div>
                            </div>
                        </div>

                        <div class="column">
                            <div class="inter_column">
                                <div class="img">
                                    <img src="<%=request.getContextPath()%>/public/images/b3.jpeg" alt="rest">
                                </div>

                                <div class="column_des">
                                    <h3>
                                        Be Well Hydrated and Rested
                                    </h3><br>
                                    <p> Drink extra liquids and get a sufficient sleep at night before your donation</p>
                                </div>
                            </div>
                        </div>
                    </div>




                </div>
                <div class="extra_details">
                    <div class="inter_extra_details">

                        <div class="TT">
                            <h2>Additional tips before donating:</h2>
                        </div>
                        <div class="tips">
                            <ul>
                                <li>If you are planning to donate platelets, do not take aspirin for 2 days before your appointment.</li>
                                <li>Ask a friend to donate at the same time. You can assist each other and help the entire community at the same time. </li>
                            </ul>
                        </div>
                    </div>



                </div>
            </div>

        </div>
    </div >

    <div  id="Interface_2">
        <div class="BB_name">On The Day Of The Donation</div>
        <div class="content">

            <div class="main_cont_II">
                <div class="row-before">
                    <div class="inter_row-before_middle">
                        <div class="column-sec">
                            <div class="inter_column-sec">
                                <div class="img">
                                    <img src="<%=request.getContextPath()%>/public/images/d1.jpg">
                                </div>

                                <div class="column_des">
                                    <h3>
                                        Photo Identification
                                    </h3><br>
                                    <p>Remember to bring your donor card, NIC, driver's license or two other froms of identification  </p>
                                </div>
                            </div>
                        </div>

                        <div class="column-sec">
                            <div class="inter_column-sec">
                                <div class="img">
                                    <img src="<%=request.getContextPath()%>/public/images/d2.jpg">
                                </div>

                                <div class="column_des">
                                    <h3>
                                        Medication List
                                    </h3><br>
                                    <p>Provide the details of all the medications you intake</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="extra_details">
                    <div class="inter_extra_details">
                        <div class="TT">
                            <h2>Additional tips for the day of the donation:</h2>
                        </div>
                        <div class="tips">
                            <ul>
                                <li>Drink an extra 500ml of water or any other nonalcoholic drink before your appointment  </li>
                                <li>Eat a healthy meal and avoid junk food.</li>
                                <li>Wear a top which can be rolled up above your elbows.</li>
                                <li>Relax yourself when you are donating. You can listen to music or talk with the others.</li>
                            </ul>
                        </div>


                    </div>

                </div>
            </div>


            <!--<button class="backbtn" id="backbtn">Back</button>
            <button class="newbtn2" id="newbtn2">Next</button>-->
        </div>
    </div >

    <div  id="Interface_3">
        <div class="BB_name">After The Donation</div>
        <div class="content">
            <!-- <br><br><br><br> -->
            <div class="main_cont_III">
                <div class="row-before">
                    <div class="inter_row-before">
                        <div class="column-third">
                            <div class="inter_column-third">
                                <div class="img">
                                    <img src="<%=request.getContextPath()%>/public/images/a1.jpg">
                                </div>

                                <div class="column_des">
                                    <h3>
                                        Consume a snack
                                    </h3><br>
                                    <p>Relax for a few minutes and eat some snacks </p>
                                </div>
                            </div>
                        </div>

                        <div class="column-third">
                            <div class="inter_column-third">
                                <div class="img">
                                    <img src="<%=request.getContextPath()%>/public/images/a2.png">
                                </div>

                                <div class="column_des">
                                    <h3>
                                        Share Your Experience
                                    </h3><br>
                                    <p>Talk about your generous deed with others and encourage them to donate as well</p>
                                </div>
                            </div>
                        </div>

                        <div class="column-third">
                            <div class="inter_column-third">
                                <div class="img">
                                    <img src="<%=request.getContextPath()%>/public/images/liq2.jpg">
                                </div>

                                <div class="column_des">
                                    <h3>
                                        Drink Extra Liquids
                                    </h3><br>
                                    <p> Drink an extra 500ml nonalcoholic liquids and avoid alcohol for the next 24 hours</p>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>
                <div class="extra_details">
                    <div class="inter_extra_details">
                        <div class="TT">
                            <h2>Additional tips after the donation:</h2>
                        </div>
                        <div class="tips">
                            <ul>
                                <li>Keep the bandage for the next few hours. Clean the area around bandage with soap and water to avoid a skin rash</li>
                                <li>Do not exhaust yourself for the rest of the day. </li>
                                <li>If the needle site starts to bleed, apply pressure and raise your arm straight up for 5-10 minutes or until the bleeding stops.</li>
                                <li>Call our hotline if you need to any assistance or for any additional information.</li>
                                <li>Eat iron-rich food</li>
                                <li>If you are a frequent blood donor, make sure that you take multivitamins with iron to ensure you continue to replenish your iron stores before your next donation.</li>
                            </ul>
                        </div>

                    </div>
                </div>
            </div>



            <!--<button class="backbtn2" id="backbtn2">Back</button>-->
        </div>
    </div >



    <!-- --------------------back to up------------------------------------------------ -->

    <div >
        <!-- <h4>Top</h4> -->
        <a onclick="topFunction()" id="myBtn" title="Go to top">
            <i class="fa fa-arrow-up" aria-hidden="true"></i>

        </a>
    </div>

    <!-- --------------------back to up------------------------------------------------ -->

</div>


<script src="<%=request.getContextPath()%>/public/scripts/backtotop.js"></script>


</body>
</html>
