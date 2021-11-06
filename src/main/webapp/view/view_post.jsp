<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 11/6/2021
  Time: 11:19 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    if (session.getAttribute("username") == null ) {
        response.sendRedirect(request.getContextPath() + "/login.jsp");
    }
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/public/css/home.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <title>Reported Post</title>
</head>
<body>

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

</body>
</html>
