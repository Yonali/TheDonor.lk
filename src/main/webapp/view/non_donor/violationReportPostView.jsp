<%@ page import="com.example.thedonorlk.Bean.PostBean" %>
<%@ page import="org.apache.commons.codec.binary.Base64" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    if (session.getAttribute("username") == null) {
        response.sendRedirect(request.getContextPath() + "/login.jsp");
    }
    Object user_id = session.getAttribute("user_id");
    PostBean post = (PostBean) request.getAttribute("posts");
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
    <link rel="stylesheet" href="<%=request.getContextPath()%>/public/css/profile.css">
</head>

<body>
<div class="modal-content">
    <div class="modal-header">
        <span class="close-popup" onclick="history.back()">&times;</span>
        <h3>
            Report a Post
        </h3>
    </div>

    <div class="modal-body">
        <%
            String reg_msg = "";
            reg_msg = reg_msg == null ? "" : (String) request.getAttribute("error");
            if (reg_msg != null) {
        %>
        <div id="error_message">
            <%= reg_msg %>
        </div>
        <% } %>

        <div class="post-container">
            <div class="post-row">
                <div class="user-profile">
                    <%  String base64EncodedProfile = null;
                        if (post.getDonor_profile() != null) {
                            byte[] bytes = post.getDonor_profile();
                            byte[] encodeBase64 = Base64.encodeBase64(bytes);
                            base64EncodedProfile = new String(encodeBase64, "UTF-8");
                        }
                    %>
                    <img src="data:image/jpeg;base64,<%=base64EncodedProfile%>"
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
            <%--<div class="post-row">
                <div class="activity-icons">
                    <a href="#"><i class="fa fa-thumbs-up"></i> 120</a>
                    &lt;%&ndash;<a href="#"><img src="<%=request.getContextPath()%>/public/images/comments.png">45</a>&ndash;%&gt;
                </div>
                <div class="post-profile-icon">
                    <% if (post.getDonor_id().equals(String.valueOf(user_id))) { %>
                    <a href="<%=request.getContextPath()%>/postDelete?id=<%=post.getId()%>"><i class="fa fa-trash"></i> Delete</a>
                    <% } else { %>
                    <a href="<%=request.getContextPath()%>/violationShowNewForm?id=<%=post.getId()%>"><i class="fa fa-flag"></i> Report</a>
                    <% } %>
                </div>
            </div>--%>
        </div>

    </div>

    <div class="modal-footer">
        <img src="<%=request.getContextPath()%>/public/images/Logo%20-%20White.png" height="100px">
        <p>Many people would not be alive today if it wasn't for the generosity of our donors. <br>Donating
            Blood Makes a Big Difference in the Lives of Others.
        </p>
    </div>
</div>

</body>
</html>
