<%@ page import="java.util.List" %>
<%@ page import="com.example.thedonorlk.Bean.DashboardBean" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    if (session.getAttribute("username") == null) {
        response.sendRedirect(request.getContextPath() + "/login.jsp");
    }

    List<Integer> RBC_stock = (List<Integer>) request.getAttribute("RBC_stock");
    List<Integer> WBC_stock = (List<Integer>) request.getAttribute("WBC_stock");
    List<Integer> Platelets_stock = (List<Integer>) request.getAttribute("Platelets_stock");
    List<Integer> Plasma_stock = (List<Integer>) request.getAttribute("Plasma_stock");

%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>TheDonor.lk</title>
    <link rel="stylesheet"
          href="https://maxst.icons8.com/vue-static/landings/line-awesome/line-awesome/1.3.0/css/line-awesome.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/public/css/styles.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/3.5.1/chart.min.js"
            integrity="sha512-Wt1bJGtlnMtGP0dqNFH1xlkLBNpEodaiQ8ZN5JLA5wpc1sUlk/O5uuOMNgvzddzkpvZ9GLyYNa8w2s7rqiTk5Q=="
            crossorigin="anonymous" referrerpolicy="no-referrer"></script>
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
        <div class="card">
            <div class="card-header-center">
                <h3>Dashboard</h3>
            </div>

            <div class="card-body">
                <div class="chart">
                    <canvas id="myChart" width="400" height="200"></canvas>
                    <script>
                        var ctx = document.getElementById('myChart');
                        var myChart = new Chart(ctx, {
                            type: 'bar',
                            data: {
                                labels: ['A+', 'A-', 'B+', 'B-', 'AB+', 'AB-', 'O+', 'O-'],
                                datasets: [{
                                        label: 'RBC',
                                        data: [<c:out value="${RBC_stock[0]}"/>, <c:out value="${RBC_stock[1]}"/>, <c:out value="${RBC_stock[2]}"/>,
                                            <c:out value="${RBC_stock[3]}"/>, <c:out value="${RBC_stock[4]}"/>, <c:out value="${RBC_stock[5]}"/>,
                                            <c:out value="${RBC_stock[6]}"/>, <c:out value="${RBC_stock[7]}"/>],
                                        backgroundColor: '#dc3545'
                                    }, {
                                        label: 'WBC',
                                    data: [<c:out value="${WBC_stock[0]}"/>, <c:out value="${WBC_stock[1]}"/>, <c:out value="${WBC_stock[2]}"/>,
                                        <c:out value="${WBC_stock[3]}"/>, <c:out value="${WBC_stock[4]}"/>, <c:out value="${WBC_stock[5]}"/>,
                                        <c:out value="${WBC_stock[6]}"/>, <c:out value="${WBC_stock[7]}"/>],
                                        backgroundColor: '#0d6efd'
                                    }, {
                                        label: 'Platelets',
                                    data: [<c:out value="${Platelets_stock[0]}"/>, <c:out value="${Platelets_stock[1]}"/>, <c:out value="${Platelets_stock[2]}"/>,
                                        <c:out value="${Platelets_stock[3]}"/>, <c:out value="${Platelets_stock[4]}"/>, <c:out value="${Platelets_stock[5]}"/>,
                                        <c:out value="${Platelets_stock[6]}"/>, <c:out value="${Platelets_stock[7]}"/>],
                                        backgroundColor: '#fd7e14'
                                    }, {
                                        label: 'Plasma',
                                    data: [<c:out value="${Plasma_stock[0]}"/>, <c:out value="${Plasma_stock[1]}"/>, <c:out value="${Plasma_stock[2]}"/>,
                                        <c:out value="${Plasma_stock[3]}"/>, <c:out value="${Plasma_stock[4]}"/>, <c:out value="${Plasma_stock[5]}"/>,
                                        <c:out value="${Plasma_stock[6]}"/>, <c:out value="${Plasma_stock[7]}"/>],
                                        backgroundColor: '#198754'
                                    }]
                            },
                            options: {
                                responsive: true,
                                legend: {
                                    position: 'right' // place legend on the right side of chart
                                },
                                scales: {
                                    x: [{
                                        stacked: true // this should be set to make the bars stacked
                                    }],
                                    y: [{
                                        stacked: true, // this also..
                                        beginAtZero: true
                                    }]
                                }
                            }
                        });
                    </script>
                </div>
            </div>
        </div>
    </div>

    <div class="card-2col-centered">
        <h1>Total Donors Registered</h1>
        <div class="big_num">
            <h1><c:out value="${count.total_donors}"/></h1>
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
</main>
</body>

</html>
