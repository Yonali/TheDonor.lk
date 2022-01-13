<%@ page import="com.example.thedonorlk.Bean.ProfileBean" %>
<%@ page import="org.apache.commons.codec.binary.Base64" %>
<%@ page import="com.example.thedonorlk.Bean.PostBean" %>
<%@ page import="java.util.List" %>
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
                <%  String base64EncodedPost = null;
                    if (post.getImgBytes() != null) {
                        byte[] bytes = post.getImgBytes();
                        byte[] encodeBase64 = Base64.encodeBase64(bytes);
                        base64EncodedPost = new String(encodeBase64, "UTF-8");
                    }
                %>
                <img src="data:image/jpeg;base64,<%=base64EncodedPost%>" class="post-img"
                     onerror="this.style='display:none;'">
                <div class="post-row">
                    <div class="activity-icons">
                        <%--<a href="#"><i class="fa fa-thumbs-up"></i> 120</a>--%>
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

<!----------------------back to up-------------------------------------------------->
<div>
    <!-- <h4>Top</h4> -->
    <a onclick="topFunction()" id="myBtn" title="Go to top">
        <i class="fa fa-arrow-up" aria-hidden="true"></i>
    </a>
    <script src="<%=request.getContextPath()%>/public/scripts/backtotop.js"></script>
</div>
<!----------------------back to up-------------------------------------------------->

</body>
</html>