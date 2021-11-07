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
    <title>Timeline</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/public/css/home.css">

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>

<body>
    <div class="frame">
        <div class="contentbox">
            <div class="emergency">
<%--                <div class="E" title="Go to top">--%>

<%--                    <div class="BG">A+</div>--%>
<%--                    <div class="BB">NBTS<h6>2021/03/11</h6>--%>
<%--                    </div>--%>
<%--                </div>--%>
                <div class="E" title="Emergency Blood Requirement">
                    <div class="BG">A+</div>
                    <div class="BB">NBTS<h6>2021/03/11</h6>
                    </div>
                </div>
                <div class="E" title="Emergency Blood Requirement">
                    <div class="BG">AB+</div>
                    <div class="BB">National Blood Centre<h6>2021/11/11</h6>
                    </div>
                </div>
                <div class="E" title="Emergency Blood Requirement">
                    <div class="BG">A-</div>
                    <div class="BB">NHSL Blood Bank<h6>2021/01/01</h6>
                    </div>
                </div>
                <div class="E" title="Emergency Blood Requirement">
                    <div class="BG">AB+</div>
                    <div class="BB">Blood bank Matara<h6>2021/05/19</h6>
                    </div>
                </div>
                <div class="E" title="Emergency Blood Requirement">
                    <div class="BG">AB+</div>
                    <div class="BB">National Blood Centre<h6>2021/03/21</h6>
                    </div>
                </div>
                <div class="E" title="Emergency Blood Requirement">
                    <div class="BG">AB+</div>
                    <div class="BB">National Blood Centre<h6>2021/03/21</h6>
                    </div>
                </div>
                <div class="E" title="Emergency Blood Requirement">
                    <div class="BG">AB+</div>
                    <div class="BB">National Blood Centre<h6>2021/03/21</h6>
                    </div>
                </div>
                <div class="E" title="Emergency Blood Requirement">
                    <div class="BG">B+</div>
                    <div class="BB">National Blood Centre<h6>2021/03/21</h6>
                    </div>
                </div>


            </div>
            <div class="postcontainer">
                <div class="sharepost">
                    <i class="fa fa-pencil-square-o" aria-hidden="true"> </i>
                    <textarea name="textarea" class="textarea" id="textarea" placeholder="write something..." cols="100" rows="3"></textarea>
                     <!-- --------------------------------responsive------------------------------------- -->
                    <textarea name="textarea" class="textarea_responsive" id="textarea" placeholder="write something..." cols="25" rows="3"></textarea>
                     <!-- --------------------------------responsive------------------------------------- -->
                </div>
   
                <div class="media">
                    <div class="media_all">
                        <div  class="Upload_pht">
                            <h3>Photo</h3>
                            <a href="upload_pht.jsp">
                                <i class="fa fa-picture-o" aria-hidden="true"></i>                              
                            </a>
                        </div>
                        <div class="Upload_vedio">
                            <h3>Video</h3>
                            <a href="upload_video.jsp">
                                <i class="fa fa-video-camera" aria-hidden="true"></i>
                            </a>
                        </div>
                        <div class="SB">
                            <button id="sharebtn" ><i class="fa fa-share" aria-hidden="true"></i>
                                Share</button>
                        </div>
              
                    </div>                 
                </div>
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
                         <div class="imgOrV_responsive">
                            <img src="<%=request.getContextPath()%>/public/images//postpic.jpg" id="PP1_r" style="width:250px;height:200px;">
                          </div>
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
                                <div class="report_div">
                                    <button class="Report" id="Report">Report</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
        </div>
           <!-- --------------------back to up------------------------------------------------ -->
   
    <div >
        <!-- <h4>Top</h4> -->
        <a onclick="topFunction()" id="myBtn" title="Go to top">
            <i class="fa fa-arrow-up" aria-hidden="true"></i>

        </a>
        <script src="<%=request.getContextPath()%>/public/scripts/backtotop.js"></script>
    </div>
    
    <!-- --------------------back to up------------------------------------------------ -->    
    </div>



    <!-- The Popup Modal2 --------Comment box------- -->
    <div id="myModal3" class="modal3">
        <div class="modal3-content">
            <div class="modal3-header">
                <span class="close3">&times;</span>
                <h3>Comments box</h3>
            </div>

            <div class="modal3-body">
                <!-- The form inside popup modal -->
                <form>
                    <div class="comment_fields">
                        <div class="comment_field-single">
                            <input type="text" placeholder="Old comments here.." />
                        </div>

                    </div>
                    <div class="add_comment_fields">
                        <div class="comment_field-single">
                            <input type="text" placeholder="Add your comments here.." />
                        </div>
                    </div>
                    <div class="modal3-submit-button">
                        <div class="buttons">
                            <button type="submit"><i class="fa fa-paper-plane" aria-hidden="true"></i></button>
                        </div>
                    </div>
                </form>
            </div>

            <div class="comment_modal-footer">
                <img src="<%=request.getContextPath()%>/public/images/Logo%20-%20White.png" height="100px">

            </div>
        </div>

        <!-- IMPORTANT -->
        <!-- Javascript file with popup modal function should be called here just after the popup modal -->
        <script src="<%=request.getContextPath()%>/public/scripts/popup_modal.js"></script>
    </div>

    <script>

        var btn3 = document.getElementById("comments_box3");
        var modal3 = document.getElementById("myModal3");
        var span3 = document.getElementsByClassName("close3")[0];

        btn3.onclick = function () {
            modal3.style.display = "block";
        }
        span3.onclick = function () {
            modal3.style.display = "none";
        }
        window.onclick = function (event) {
            if (event.target == modal3) {
                modal3.style.display = "none";
            }
        }




    </script>


<!-- -------------------report button popup------------------------------------------------------------------ -->

<div id="myModal4" class="modal4">
    <div class="Inner_m4">
        <div class="modal-content4">
            <div class="modal-header4">
                <span class="close4">&times;</span>
                <h3>Reason to Report</h3>
            </div>

            <div class="modal-body4">
                <!-- The form inside popup modal -->
                <form>
                   <!-- <div class="inner_form"> -->
                    <div class="fields4">
                        <div class="field-single4">
                            <!-- <span>Enter Your Email Address</span> -->
                            <input type="text" placeholder="Enter the reason"/>
                        </div>
                        <div class="field-single4">
                            <span>Do you want to Report?</span>
                        </div>
                        

                    </div>
                    <div class="modal-submit-button4">
                        <div class="buttons">
                            <button type="submit" id="continue">Yes</button>
                        </div>
                    </div>
                  <!-- </div> -->
                </form>
            </div>

            <div class="modal-footer4">

            </div>
        </div>
    </div>


    <!-- IMPORTANT -->
    <!-- Javascript file with popup modal function should be called here just after the popup modal -->
    <script src="<%=request.getContextPath()%>/public/scripts/popup_modal.js"></script>
</div>
<script>
        var btn4 = document.getElementById("Report");
        var modal4 = document.getElementById("myModal4");
        var span4 = document.getElementsByClassName("close4")[0];



        btn4.onclick = function () {
            modal4.style.display = "block";
        }
        span4.onclick = function () {
            modal4.style.display = "none";
        }
        window.onclick = function (event) {
            if (event.target == modal4) {
                modal4.style.display = "none";
            }
        }

</script>
</body>

</html>