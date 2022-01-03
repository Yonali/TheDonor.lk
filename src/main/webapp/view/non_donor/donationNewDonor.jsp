<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    if (session.getAttribute("username") == null) {
        response.sendRedirect(request.getContextPath() + "/login.jsp");
    }
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

    <script src="<%=request.getContextPath()%>/public/scripts/validate_username_only.js"></script>
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
</head>

<body>
<main>
    <div class="card-2col-right">
        <div class="big_num">
            <h1>0</h1>
        </div>
        <h1>Donations</h1>
    </div>
    <div class="card card-details">
        <p>NIC: <c:out value='${donor_NIC}'/></p>
        <div>
            Name: <br>
            Email: <br>
            <pre>Age:        Gender:        Blood Group:   </pre>
            Remarks:
        </div>
    </div>

    <%
        String dEmail = (String) request.getAttribute("donor_Email");
        String reg_msg = (String) request.getAttribute("error");
        if (reg_msg == null)
            reg_msg = "";
    %>
    <div id="error_message">
        <%= reg_msg %>
    </div>
    <div class="recent-grid">
        <div class="card">
            <div class="card-header center left-right-padding">
                <h3>New Donor</h3>
            </div>

            <div class="card-body center left-right-padding">
                <h3>Enter Donor Email Address</h3>
                <div>
                    <form action="<%=request.getContextPath()%>/donorEmailCheck" method="post">
                        <input type="hidden" name="NIC" value="<c:out value='${donor_NIC}'/>"/>
                        <input type="text" name="Email" id="Email" value="<c:out value='${donor_Email}'/>"
                               style="height: 35px; width: 350px; margin-top: 30px;"/>
                        <% if (dEmail == null) { %>
                        <span class="red-text"><i class="fa fa-times-circle"></i> Please submit to verify email</span>
                        <% } else {%>
                        <span class="green-text"><i class="fa fa-check-circle"></i></i> Verified</span>
                        <% } %>
                        <div class="modal-submit-button" style="padding: 15px;">
                            <div class="buttons">
                                <button type="submit">Submit</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>

            <div class="card-body center left-right-padding">
                <h3>Enter Donor Details</h3>
                <div class="modal-body" style="padding: 40px 0px;">
                    <!-- The form inside popup modal -->
                    <c:if test="${donor != null}">
                    <form action="donorUpdateDonation" method="post" onsubmit="return validate();"></c:if>
                        <c:if test="${donor == null}">
                        <form action="donorInsert" method="post" onsubmit="return validate();">
                            </c:if>
                            <div class="fields">
                                <% if (dEmail != null) { %>
                                <input type="hidden" name="Email" value="<%= dEmail %>"/>
                                <% } %>
                                <div class="field-single">
                                    <span>First Name</span>
                                    <input type="text" name="First_Name" id="First_Name"
                                           value="<c:out value='${donor.fname}'/>"/>
                                </div>
                                <div class="field-single">
                                    <span>Last Name</span>
                                    <input type="text" name="Last_Name" id="Last_Name"
                                           value="<c:out value='${donor.lname}'/>"/>
                                </div>
                                <div class="field-single">
                                    <span>NIC</span>
                                    <input type="text" name="NIC" id="NIC" value="<c:out value='${donor_NIC}'/>"/>
                                </div>
                                <div class="field-single">
                                    <span>Contact Number</span>
                                    <input type="text" name="Contact" id="Contact"
                                           value="<c:out value='${donor.contact}'/>"/>
                                </div>
                                <div class="field-single">
                                    <span>Address Street</span>
                                    <input type="text" name="Address_Street" id="Address_Street"
                                           value="<c:out value='${donor.add_street}'/>"/>
                                </div>
                                <div class="field-single">
                                    <span>Address City</span>
                                    <input type="text" name="Address_City" id="Address_City"
                                           value="<c:out value='${donor.add_city}'/>"/>
                                </div>
                                <div class="field-single">
                                    <span>DOB</span>
                                    <input type="date" name="DOB" id="DOB" value="<c:out value='${donor.dob}'/>">
                                </div>
                                <div class="field-single">
                                    <span>Gender</span>
                                    <select name="Gender" id="Gender">
                                        <option value="Male" ${donor.gender == 'Male' ? 'selected': ''}>Male</option>
                                        <option value="Female" ${donor.gender == 'Female' ? 'selected': ''}>Female
                                        </option>
                                        <option value="Other" ${donor.gender == 'Other' ? 'selected': ''}>Other</option>
                                    </select>
                                </div>
                                <div class="field-single">
                                    <span>Nearby Blood Bank</span>
                                    <select name="BloodBank_Code" id="BloodBank_Code">
                                        <option value="NULL"></option>
                                        <c:forEach items="${listBloodBank}" var="bloodbank_code">
                                            <option value="${bloodbank_code.code}" ${bloodbank_code.code == donor.bloodbank_code ? 'selected': ''}>${bloodbank_code.code}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <div class="modal-submit-button">
                                <div class="buttons">
                                    <button type="submit">Submit</button>
                                </div>
                            </div>
                        </form>
                </div>
            </div>
        </div>
    </div>
</main>
</body>

</html>
