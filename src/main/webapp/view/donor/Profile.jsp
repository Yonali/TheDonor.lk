
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    if (session.getAttribute("username") == null || !session.getAttribute("role").equals("donor")) {
        response.sendRedirect(request.getContextPath() + "/login.jsp");
    }
    Object user_id = session.getAttribute("user_id");
    List<PostBean> posts = (List<PostBean>) request.getAttribute("posts");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Profile</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/public/css/profile.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <script src="<%=request.getContextPath()%>/public/scripts/scripts.js"></script>
</head>

<body>
<%
    String reg_msg = "";
    reg_msg = reg_msg == null ? "" : (String) request.getAttribute("error");
    if (reg_msg != null) {
%>
<div id="error_message">
    <%= reg_msg %>
</div>
<% } %>

<div class="profile-container">
    <div class="profile-info">
        <!---------------------- Profile -------------------------->
        <div class="info-col">
            <div class="profile-intro">


                <img src="data:image/jpeg;base64,<%=base64Encoded%>"
                     onerror="this.src='<%=request.getContextPath()%>/public/images/no-profile.jpg'"
                     class="pd-image">
                <h2><c:out value='${donor.first_name}'/> <c:out value='${donor.last_name}'/></h2>
                <p class="intro-text"><c:out value='${donor.about}'/></p>
                <br>
                <a href="<%=request.getContextPath()%>/donorShowProfileForm">Edit</a>
                <hr>
                <div>
                    <h1><c:out value='${donor.donation_count}'/></h1>
                    <h3>Donations</h3>
                </div>
            </div>
        </div>
        <!---------------------- Profile -------------------------->

        <div class="post-col">
            <!---------------------- Create Post -------------------------->
            <div class="write-post-container">
                <div class="user-profile">
                    <img src="data:image/jpeg;base64,<%=base64Encoded%>"
                         onerror="this.src='<%=request.getContextPath()%>/public/images/no-profile.jpg'">
                    <div>
                        <p><c:out value='${donor.first_name}'/> <c:out value='${donor.last_name}'/></p>
                        <p></p>
                    </div>
                </div>
                <div class="post-input-container">
                    <!-- <textarea name="" id="" rows="3" placeholder="Add something here"></textarea> -->
                    <form action="postInsert" method="post" id="createPost" enctype="multipart/form-data">
                        <textarea form="createPost" name="caption" rows="3" placeholder="Add something here"></textarea>

                        <input type="file" accept="image/*" name="image" id="file" onchange="loadFile(event)"
                               style="display: none;">
                        <img id="output" width="200"/>

                        <div class="add-post-links">
                            <label for="file" style="cursor: pointer;"><img
                                    src="<%=request.getContextPath()%>/public/images/photo.png">Upload Media</label>
                            &nbsp;&nbsp;&nbsp;&nbsp;
                            <a href="javascript:{}" onclick="document.getElementById('createPost').submit();"><img
                                    src="<%=request.getContextPath()%>/public/images/upload.png">Create Post</a>
                        </div>
                    </form>

                </div>
            </div>
            <!---------------------- Create Post -------------------------->

            <!-- --------------------------- Posts ---------------------------------------------->
            <%for (PostBean post : posts) {%>
            <div class="post-container">
                <div class="post-row">
                    <div class="user-profile">
                        <img src="data:image/jpeg;base64,<%=base64Encoded%>"
                             onerror="this.src='<%=request.getContextPath()%>/public/images/no-profile.jpg'">
                        <div>
                            <p><%=post.getDonor_name()%></p>
                            <span><%=post.getDate()%>, <%=post.getTime()%></span>
                            <p></p>
                        </div>
                    </div>
                </div>
                <p class="post-text">
                    <%=post.getCaption()%>
                </p>

                <img src="data:image/jpeg;base64,<%=base64EncodedPost%>" class="post-img"
                     onerror="this.style='display:none;'">
                <div class="post-row">
                    <div class="activity-icons">
                        <a href="#"><i class="fa fa-thumbs-up"></i> 120</a>
                        <%--<a href="#"><img src="<%=request.getContextPath()%>/public/images/comments.png">45</a>--%>
                    </div>
                    <div class="post-profile-icon">
                        <% if (post.getDonor_id().equals(String.valueOf(user_id))) { %>
                        <a href="<%=request.getContextPath()%>/postDelete?id=<%=post.getId()%>"><i class="fa fa-trash"></i> Delete</a>
                        <% } else { %>
                        <a href="<%=request.getContextPath()%>/violationShowNewForm?id=<%=post.getId()%>"><i class="fa fa-flag"></i> Report</a>
                        <% } %>
                    </div>
                </div>
            </div>
            <%}%>
            <!-- --------------------------- Posts ---------------------------------------------->

            <button type="button" class="load-more-btn">Loadmore</button>
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
<%--    </div>--%>
   
      
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
                                       
                                        <img src="<%=request.getContextPath()%>/public/images/anne-doe.jpg" id="edit_PP" style="width:120px;height:120px;">
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
                                        <textarea name="textarea" class="about_textarea" id="about_textarea" placeholder="About You..." cols="6" rows="6"></textarea>
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