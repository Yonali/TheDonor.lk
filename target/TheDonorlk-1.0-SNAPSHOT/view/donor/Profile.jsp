<%@ page import="com.example.thedonorlk.Bean.ProfileBean" %>
<%@ page import="org.apache.commons.codec.binary.Base64" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    if (session.getAttribute("username") == null || !session.getAttribute("role").equals("donor")) {
        response.sendRedirect(request.getContextPath() + "/login.jsp");
    }
    Object user_id = session.getAttribute("user_id");
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

<div class="frame">
    <div class="contentbox">
        <div class="donor">
            <div class="sub_donor">
                <div class="dn_pp">
                    <% ProfileBean profile = (ProfileBean) request.getAttribute("profile");
                        String base64Encoded = null;
                        if (profile.getImgBytes() != null) {
                            byte[] bytes = profile.getImgBytes();
                            byte[] encodeBase64 = Base64.encodeBase64(bytes);
                            base64Encoded = new String(encodeBase64, "UTF-8");
                        }
                    %>
                    <img src="data:image/jpeg;base64,<%=base64Encoded%>"
                         onerror="this.src='<%=request.getContextPath()%>/public/images/no-profile.jpg'"
                         style="width:95px;height:95px;margin-top: 8px; margin-left: 320px;">
                    <%--
                                            <img src="<%=request.getContextPath()%>/public/images/anne-doe.jpg" id="PP" style="width:95px;height:95px;margin-top: 8px; margin-left: 320px;">
                    --%>
                </div>
                <div class="dnametl">
                    <h2><c:out value='${donor.first_name}'/> <c:out value='${donor.last_name}'/></h2>
                </div>
                <div class="dcount">
                    <div class="dnbr"><h1><c:out value='${donor.donation_count}'/></h1></div>
                    <div class="text"><h3>Donations</h3></div>
                </div>
            </div>
        </div>

        <div class="donoroptions">
            <div class="optiondiv">
                <div class="optiondiv_1">
                    <p><c:out value='${donor.about}'/></p>
                </div>
                <div></div>
                <div class="optiondiv_2">
                    <%--<button class="newbtn" id="newbtn">Edit</button>--%>
                    <a href="<%=request.getContextPath()%>/donorShowProfileForm?id=<%= user_id %>">
                        <button class="newbtn" id="newbtn">Edit</button>
                    </a>
                </div>
            </div>
        </div>


        <div class="postcontainer">
            <div class="sharepost">
                <i class="fa fa-pencil-square-o" aria-hidden="true"> </i>
                <textarea name="textarea" class="textarea" id="textarea" placeholder="write something..." cols="100"
                          rows="3"></textarea>
                <!-- --------------------------------responsive------------------------------------- -->
                <textarea name="textarea" class="textarea_responsive" id="textarea_responsive"
                          placeholder="write something..." cols="25" rows="3"></textarea>
                <!-- --------------------------------responsive------------------------------------- -->
                <img id="output" width="200"/>
            </div>
            <div class="media">
                <div class="media_all">
                    <div class="Upload_pht">
                        <input type="file"  accept="image/*" name="image" id="file"  onchange="loadFile(event)" style="display: none;">
                        <label for="file" style="cursor: pointer;"><h4>  Upload Media here  </h4></label>

                    </div>
                    <div></div>
                    <div class="SB">
                        <button id="sharebtn"><i class="fa fa-share" aria-hidden="true"></i>
                            Share
                        </button>
                    </div>

                </div>
            </div>

            <div class="posts">
                <div class="singlepost">
                    <div class="Profilename">
                        <img src="<%=request.getContextPath()%>/public/images/anne-doe.jpg" id="PP"
                             style="width:60px;height:60px;">
                        <a href="#"><%=session.getAttribute("name")%>
                        </a>
                        <h6 id="postdate">2021/09/10</h6>
                    </div>

                    <div class="caption">
                        <h6>Save lives. Donate Blood. </h6>
                    </div>
                    <div class="imgOrV">
                        <img src="<%=request.getContextPath()%>/public/images/postpic.jpg" id="PP1"
                             style="width:400px;height:300px;">
                    </div>
                    <!-- --------------------------------responsive------------------------------------- -->
                    <div class="imgOrV_responsive">
                        <img src="<%=request.getContextPath()%>/public/images/postpic.jpg" id="PP1_r"
                             style="width:300px;height:250px;">
                    </div>
                    <!-- --------------------------------responsive------------------------------------- -->
                    <div class="footer">
                        <div class="sub_footer">
                            <div class="like_div">
                                <button id="likes_box"><i onclick="myFunction(this)" class="fa fa-thumbs-up"></i>25
                                    likes
                                </button>
                            </div>
                            <div class="comment_div">
                                <button id="comments_box2"><i onclick="myFunction(this)" class="fa fa-comment-o"
                                                              aria-hidden="true"></i>9 Comments
                                </button>
                            </div>
                            <div class="report_div">
                                <button class="dlt">Delete</button>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="singlepost">
                    <div class="Profilename">
                        <img src="<%=request.getContextPath()%>/public/images/anne-doe.jpg" id="PP"
                             style="width:60px;height:60px;">
                        <a href="#"><%=session.getAttribute("name")%>
                        </a>
                        <h6 id="postdate">2021/09/10</h6>
                    </div>

                    <div class="caption">
                        <h6>Save lives. Donate Blood. </h6>
                    </div>
                    <div class="imgOrV">
                        <img src="<%=request.getContextPath()%>/public/images/postpic.jpg" id="PP1"
                             style="width:400px;height:300px;">
                    </div>
                    <!-- --------------------------------responsive------------------------------------- -->
                    <div class="imgOrV_responsive">
                        <img src="<%=request.getContextPath()%>/public/images/postpic.jpg" id="PP1_r"
                             style="width:300px;height:250px;">
                    </div>
                    <!-- --------------------------------responsive------------------------------------- -->
                    <div class="footer">
                        <div class="sub_footer">
                            <div class="like_div">
                                <button id="likes_box"><i onclick="myFunction(this)" class="fa fa-thumbs-up"></i>25
                                    likes
                                </button>
                            </div>
                            <div class="comment_div">
                                <button id="comments_box2"><i onclick="myFunction(this)" class="fa fa-comment-o"
                                                              aria-hidden="true"></i>9 Comments
                                </button>
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
</div>

<!----------------------back to up-------------------------------------------------->
<div>
    <!-- <h4>Top</h4> -->
    <a onclick="topFunction()" id="myBtn" title="Go to top">
        <i class="fa fa-arrow-up" aria-hidden="true"></i>
    </a>
    <script src="<%=request.getContextPath()%>/public/scripts/backtotop.js"></script>
</div>
<!----------------------back to up-------------------------------------------------->

</div>
</body>
</html>