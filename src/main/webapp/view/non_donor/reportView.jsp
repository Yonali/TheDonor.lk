<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.util.*" %>
<%@ page import="com.example.thedonorlk.Bean.DonorBean" %>

<%
    if (session.getAttribute("username") == null) {
        response.sendRedirect(request.getContextPath() + "/login.jsp");
    }
    Object role = session.getAttribute("role");
    Object bloodbank = session.getAttribute("bloodbank");

    List<DonorBean> sendToDonorList = (List<DonorBean>) request.getAttribute("SendToDonorList");
%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>TheDonor.lk</title>
    <link rel="stylesheet"
          href="https://maxst.icons8.com/vue-static/landings/line-awesome/line-awesome/1.3.0/css/line-awesome.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/public/css/styles.css">

    <script src="<%=request.getContextPath()%>/public/scripts/action_confirmation.js"></script>
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.11.5/css/jquery.dataTables.css">
    <script type="text/javascript" charset="utf8"
            src="https://cdn.datatables.net/1.11.5/js/jquery.dataTables.js"></script>


    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/1.3.4/jspdf.min.js"></script>
    <%--<script type="text/javascript" src="<%=request.getContextPath()%>/public/scripts/save-pdf.js"></script>--%>
    <script>
        function Popup(divID) {
            var mywindow = window.open('', 'new div', '');
            mywindow.document.write('<html><head><title></title>');
            mywindow.document.write('<link rel="stylesheet" href="<%=request.getContextPath()%>/public/css/styles.css" type="text/css"/>');
            mywindow.document.write('</head><body >');
            mywindow.document.write(document.getElementById(divID).innerHTML);
            mywindow.document.write('</body></html>');
            mywindow.document.close();
            //mywindow.focus();
            //setTimeout(function(){mywindow.print();},1000);
            //mywindow.close();

            setTimeout(function () { mywindow.print(); }, 100);
            window.onfocus = function () { setTimeout(function () { mywindow.close(); }, 100); }

            return true;
        }
    </script>
</head>

<body>
<main>
    <%
        String reg_msg = "";
        reg_msg = reg_msg == null ? "" : (String) request.getAttribute("error");
        if (reg_msg != null) {
    %>
    <div id="error_message">
        <%= reg_msg %>
    </div>
    <% } %>

    <div class="recent-grid">
        <div class="card" id="reportCard">
            <div class="card-header" style="justify-content: space-around">
                <div style="text-align: center"><h2><%= bloodbank %>
                </h2>
                    <h3>Detailed Report from <span style="color: #750605"><%= request.getAttribute("from")%></span> to <span style="color: #750605"><%= request.getAttribute("to")%></span></h3></div>
                <%--<div class="search-wrapper">
                    <span class="las la-search"></span>
                    <input type="search" placeholder="search here"/>
                    <input type="date" id="campaign-date-search">
                </div>--%>
            </div>

            <div class="card-body">
                <div class="table-responsive">
                    <table width="100%" id="table_one">
                        <thead>
                        <tr>
                            <td>Blood Stock Flow</td>
                            <td>Type A</td>
                            <td>Type B</td>
                            <td>Type AB</td>
                            <td>Type O</td>
                            <td>Total</td>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>Blood Stock at the beginning</td>
                        </tr>
                        <tr>
                            <td>Blood collected from campaigns</td>
                        </tr>
                        <tr>
                            <td>Blood collected through appointments</td>
                        </tr>
                        <tr>
                            <td>Blood Transfused</td>
                        </tr>
                        <tr>
                            <td>Blood Transferred</td>
                        </tr>
                        <tr style="font-weight: bold;">
                            <td>Remaining Blood Stock</td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>

            <div class="card-body">
                <div class="table-responsive">
                    <table width="100%" id="table_two">
                        <thead>
                        <tr>
                            <td>Blood Donation Campaign</td>
                            <td>Campaign Date</td>
                            <td>Location</td>
                            <td>Type A</td>
                            <td>Type B</td>
                            <td>Type AB</td>
                            <td>Type O</td>
                            <td>Total</td>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>Campaign 1</td>
                        </tr>
                        <tr>
                            <td>Campaign 2</td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>

            <div class="card">
                <div class="card-header-center">
                    <h3>This Month</h3>
                </div>

                <div class="card-body">
                    <div class="cards">
                        <div class="card-single">
                            <div class="big_num">
                                <h1><c:out value="${count.new_donors}"/></h1>
                                <span>New Donors</span>
                            </div>
                        </div>
                        <div class="card-single">
                            <div class="big_num">
                                <h1><c:out value="${count.campaigns}"/></h1>
                                <span>Campaigns</span>
                            </div>
                        </div>
                        <div class="card-single">
                            <div class="big_num">
                                <h1><c:out value="${count.appointment}"/></h1>
                                <span>Appointments</span>
                            </div>
                        </div>
                        <div class="card-single">
                            <div class="big_num">
                                <h1><c:out value="${count.donation}"/></h1>
                                <span>Donations</span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    </div>

    <div class="modal-submit-button" style="padding-top: 20px;">
        <div class="buttons">
            <button class="bottom-full" id="export" onclick="Popup('reportCard')">Export PDF</button>
        </div>
    </div>
</main>

</div>
</body>
</html>