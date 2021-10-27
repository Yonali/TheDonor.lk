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
    <title>Profile</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/public/css/Profile.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>

<body>
    <div class="frame">
        <div class="contentbox">
            <div class="donor">    
                <div class="sub_donor">
                    <div class="dn_pp">
                        <img src="<%=request.getContextPath()%>/public/images/postdp.jpg" id="PP" style="width:95px;height:95px;margin-top: 8px; margin-left: 320px;">
                    </div>
                    <div class="dnametl">
                        <a href="#">Jenny Doe</a>                   
                    </div>
                    <div class="dcount">
                        <div class="dnbr"><h1>05</h1> </div>
                        <div class="text">Donations</div>
                    </div>
                </div>          
            </div> 

            <div class="donoroptions">
                <div class="optiondiv">
                    <div class="optiondiv_1">
                        <h6>Interested in Donations</h6>
                    </div>
                    <div class="optiondiv_2">
                        <button class="newbtn" id="newbtn" >Edit</button>
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
                            <img src="<%=request.getContextPath()%>/public/images//postpic.jpg" id="PP1_r" style="width:300px;height:250px;">
                          </div>
                          <!-- --------------------------------responsive------------------------------------- -->
                        <div class="footer">
                            <div class="sub_footer">
                                <div class="like_div">
                                    <button id="likes_box"><i onclick="myFunction(this)" class="fa fa-thumbs-up"></i>25 likes</button>
                                </div>
                                <div class="comment_div">
                                    <button id="comments_box2"> <i onclick="myFunction(this)" class="fa fa-comment-o"
                                        aria-hidden="true"></i>9 Comments</button>
                                </div>
                                <div class="report_div">
                                    <button class="dlt">Delete</button>
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
   
      
         <!-- The Popup Modal1 -->
    <div id="myModal" class="modal">
        <div class="modal-content">
            <div class="modal-header">
                <span class="close">&times;</span>
                <h3>Edit Profile</h3>
            </div>

            <div class="modal-body">
                <!-- The form inside popup modal -->
                <form>
                    <div class="fields">
                        <div class="inter_fields">
                            <div class="A_container">
                                <div class="main_edit_div">
                                    <!-- <span>Upload Your Profile Picture</span> -->
                                    <div class="edit_div1">
                                       
                                        <img src="<%=request.getContextPath()%>/public/images/postdp.jpg" id="PP" style="width:120px;height:120px;">
                                    </div>
                                   
                                     <div class="edit_div2">
                                        <div class="inter_edit_div2">
                                            <h3>Change</h3>
                                            <a href="upload.jsp">
                                                <i class="fa fa-cloud-upload" aria-hidden="true"></i>
                                            </a>
                                            <!-- <button id="change"> <a href="./upload.jsp">Change</a></button>                               -->
                                        </div>
                                     </div>
                                    
                                    <div class="edit_div3">
                                        <textarea name="textarea" class="about_textarea" id="textarea" placeholder="About You..." cols="6" rows="6"></textarea>                            
                                    </div>                 
                                </div>
                            </div>
                            <div class="B_container">
                                <div class="inter_B_container">
                                    <div class="field-single">
                                        <span>Donor NIC</span>
                                        <input type="text" />
                                    </div>
                                    <div class="field-single">
                                        <span>First Name</span>
                                        <input type="text" />
                                    </div>
                                    <div class="field-single">
                                        <span>Last Name</span>
                                        <input type="text" />
                                    </div>
            
                                    <div class="field-single">
                                        <span>DOB</span>
                                        <input type="date" />
                                    </div>
                                    <div class="field-single">
                                        <span>Email</span>
                                        <input type="email" />
                                    </div>
                                    <div class="field-single">
                                        <span>House No</span>
                                        <input type="text" />
                                    </div>
                                    <div class="field-single">
                                        <span>Street</span>
                                        <input type="text" />
                                    </div>
                                    <div class="field-single">
                                        <span>City</span>
                                        <input type="text" />
                                    </div>
                                </div>     
                            </div>
                        </div>
                     
                       
                    </div>
                    <div class="modal-submit-button">
                        <div class="buttons">
                            <button type="submit">Save</button>
                        </div>
                    </div>
                    <div class="Change_pwd">
                        <div class="inter_Change_pwd">
                            <div class="Change_pwd_1">
                                <h3>Change Password</h3>
                            </div>
                            <div class="Change_pwd_2">
                                <div class="field-single">
                                    <span>Current Password</span>
                                    <input type="password" />
                                </div>
                                <div class="field-single">
                                    <span>New Password</span>
                                    <input type="password" />
                                </div>
                                <div class="field-single">
                                    <span>Confirm Password</span>
                                    <input type="password" />
                                </div>                              
                            </div>
                        </div>                        
                    </div>
                    <div class="modal-submit-button">
                        <button type="submit">Save</button>
                    </div>
                    <div class="dlt_act">
                        <div class="inter_dlt_act">
                            <div class="dlt_act_1">
                                <h3>Delete this Account</h3>
                            </div>
                            <div class="dlt_act_2">
                                
                                <span>Once you delete an account, there is no going back. Please be certain.</span>
                            </div>
                        </div>
                    </div>
                    <div class="modal-submit-button-dlt">
                        <button type="submit">Delete</button>
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


         <!-- The Popup Modal2 --------Comment box------- -->
         <div id="myModal2" class="modal2">
            <div class="modal2-content">
                <div class="modal2-header">
                    <span class="close2">&times;</span>
                    <h3>Comments box</h3>
                </div>
    
                <div class="modal2-body">
                    <!-- The form inside popup modal -->
                    <form>
                        <div class="comment_fields">
                            <div class="comment_field-single">
                                <input type="text" placeholder="Old comments here.."/>
                            </div>

                        </div>
                        <div class="add_comment_fields">
                            <div class="comment_field-single">
                                <input type="text" placeholder="Add your comments here.."/>
                            </div>
                        </div>
                        <div class="modal2-submit-button">
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
</body>
</html>