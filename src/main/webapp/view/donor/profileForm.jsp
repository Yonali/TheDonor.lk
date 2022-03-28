<%@ page import="org.apache.commons.codec.binary.Base64" %>
<%@ page import="com.example.thedonorlk.Bean.ProfileBean" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    if (session.getAttribute("username") == null) {
        response.sendRedirect(request.getContextPath() + "/login.jsp");
    }
    Object bloodbank = session.getAttribute("bloodbank");
    Object role = session.getAttribute("role");
    Object id = session.getAttribute("user_id");
    Object username = session.getAttribute("username");
%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>TheDonor.lk</title>
    <link rel="stylesheet"
          href="https://maxst.icons8.com/vue-static/landings/line-awesome/line-awesome/1.3.0/css/line-awesome.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/public/css/styles.css">

    <script src="<%=request.getContextPath()%>/public/scripts/validate_username_only.js"></script>
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

    <link rel="stylesheet" href="<%=request.getContextPath()%>/public/css/styles.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/public/css/styles2.css">

    <script src="<%=request.getContextPath()%>/public/scripts/scripts.js"></script>
</head>

<body>
<div class="modal-content"  style="top: 0px">
    <div class="modal-header">
        <span class="close-popup" onclick="history.back()">&times;</span>
        <h3>Edit Profile</h3>
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

        <div class="modal-body">
            <div class="fields">
                <div class="inter_fields">
                    <div class="main1">
                        <div class="left1">
                            <form action="profileUpdate" method="post" enctype="multipart/form-data">
                                <div class="A_container">
                                    <div class="main_edit_div">
                                        <div class="edit_div1">
                                            <% ProfileBean profile = (ProfileBean) request.getAttribute("profile");
                                                String base64Encoded=null;
                                                if (profile.getImgBytes() != null) {
                                                    byte[] bytes = profile.getImgBytes();
                                                    byte[] encodeBase64 = Base64.encodeBase64(bytes);
                                                    base64Encoded = new String(encodeBase64, "UTF-8");
                                                }
                                            %>
                                            <img src="data:image/jpeg;base64,<%=base64Encoded%>" onerror="this.src='<%=request.getContextPath()%>/public/images/no-profile.jpg'"
                                                 id="output" style="width:120px;height:120px;">
                                        </div>

                                        <input type="hidden" name="id" value="<%= id %>"/>
                                        <input type="hidden" name="role" value="Donor"/>
                                        <div class="edit_div1">
                                            <input type="file" accept="image/*" name="image" id="file" onchange="loadFile(event)" <%--style="display: none;"--%>>
                                            <%--<p><label for="file" style="cursor: pointer;">Upload Image</label></p>--%>
                                        </div>
                                        <div class="modal-submit-button" style="padding-top: 0px">
                                            <div class="buttons">
                                                <button type="submit">Change</button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </form>
                        </div>

                        <div class="right1">
                            <form action="donorProfileUpdate" method="post" id="profileForm">
                                <input type="hidden" name="id" value="<%= id %>"/>
                                <input type="hidden" name="role" value="<%= role %>"/>
                                <div class="B_container">
                                    <div class="inter_B_container">
                                        <div class="field-single">
                                            <span>First Name</span>
                                            <input type="text" name="First_Name" value="<c:out value='${donor.first_name}'/>"/>
                                        </div>
                                        <div class="field-single">
                                            <span>Last Name</span>
                                            <input type="text" name="Last_Name" value="<c:out value='${donor.last_name}'/>"/>
                                        </div>

                                        <div class="field-single">
                                            <span>Contact</span>
                                            <input type="text" name="Contact" value="<c:out value='${donor.contact}'/>"/>
                                        </div>
                                        <div class="field-single">
                                            <span>Address Street</span>
                                            <input type="text" name="Add_Street" value="<c:out value='${donor.add_street}'/>"/>
                                        </div>
                                        <div class="field-single">
                                            <span>Address City</span>
                                            <input type="text" name="Add_City" value="<c:out value='${donor.add_city}'/>"/>
                                        </div>
                                        <div class="field-single">
                                            <span>About you</span>
                                            <%--<input type="text" name="About" value="<c:out value='${donor.about}'/>"/>--%>
                                            <textarea name="About" form="profileForm" style="width: 50%; height: 50px;"><c:out value='${donor.about}'/></textarea>
                                        </div>
                                    </div>
                                </div>
                                <div class="modal-submit-button">
                                    <div class="buttons">
                                        <button type="submit">Save</button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>

            <form action="passwordUpdate" method="post">
                <div class="Change_pwd">
                    <div class="inter_Change_pwd">
                        <div class="main2">
                            <div class="left2">
                                <div class="Change_pwd_1">
                                    <h3>Change Password</h3>
                                </div>
                            </div>
                            <input type="hidden" name="id" value="<%= id %>"/>
                            <input type="hidden" name="username" value="<%= username %>"/>
                            <input type="hidden" name="role" value="Donor"/>
                            <div class="right2">
                                <div class="Change_pwd_2">
                                    <div class="field-single">
                                        <span>Current Password</span>
                                        <input type="password" name="Cur_Password"/>
                                    </div>
                                    <div class="field-single">
                                        <span>New Password</span>
                                        <input type="password" name="New_Password"/>
                                    </div>
                                    <div class="field-single">
                                        <span>Confirm Password</span>
                                        <input type="password" name="Cnfrm_Password"/>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="modal-submit-button">
                    <button type="submit">Save</button>
                </div>
            </form>

            <form>
                <div class="dlt_act">
                    <div class="inter_dlt_act">
                        <div class="main3">
                            <div class="left3">
                                <div class="dlt_act_1">
                                    <h3>Delete this Account</h3>
                                </div>
                            </div>
                            <div class="right3">
                                <div class="dlt_act_2">
                                    <span>Once you delete an account, there is no going back. Please be certain.</span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="modal-submit-button-dlt">
                    <button type="submit">Delete</button>
                </div>
            </form>
        </div>

        <div class="modal-footer" style="margin-left: -50px; margin-right: -50px; margin-bottom: -50px ">
            <img src="<%=request.getContextPath()%>/public/images/Logo%20-%20White.png" height="100px">
            <p>Many people would not be alive today if it wasn't for the generosity of our donors. <br>Donating
                Blood Makes a Big Difference in the Lives of Others.
            </p>
        </div>
    </div>
</div>

</body>
</html>
