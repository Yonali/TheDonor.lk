<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <title>TheDonor.lk</title>
  <link rel="stylesheet" href="https://maxst.icons8.com/vue-static/landings/line-awesome/line-awesome/1.3.0/css/line-awesome.min.css">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/public/css/styles.css">
  <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/3.5.1/chart.min.js"
          integrity="sha512-Wt1bJGtlnMtGP0dqNFH1xlkLBNpEodaiQ8ZN5JLA5wpc1sUlk/O5uuOMNgvzddzkpvZ9GLyYNa8w2s7rqiTk5Q=="
          crossorigin="anonymous" referrerpolicy="no-referrer"></script>
</head>

<body>
<main>
  <p style="text-align: center;">Development on Progress!<br>All DATA HARDCODED here for Demonstration Purpose</p>
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
                  label: 'Blood Stock',
                  data: [60, 45, 30, 60, 25, 75, 45, 15],
                  backgroundColor: [
                    'rgb(85, 20, 20)',
                    'rgb(85, 20, 20)',
                    'rgb(85, 20, 20)',
                    'rgb(85, 20, 20)',
                    'rgb(85, 20, 20)',
                    'rgb(85, 20, 20)',
                    'rgb(85, 20, 20)',
                    'rgb(85, 20, 20)'
                  ],
                  borderWidth: 1
                }]
              },
              options: {
                scales: {
                  y: {
                    beginAtZero: true
                  }
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
      <h1>598</h1>
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
            <h1>05</h1>
            <span>New Donors</span>
          </div>
        </div>
        <div class="card-single">
          <div class="big_num">
            <h1>02</h1>
            <span>Campaigns</span>
          </div>
        </div>
        <div class="card-single">
          <div class="big_num">
            <h1>25</h1>
            <span>Appointments</span>
          </div>
        </div>
        <div class="card-single">
          <div class="big_num">
            <h1>167</h1>
            <span>Donations</span>
          </div>
        </div>
      </div>
    </div>
  </div>
</main>
</body>

</html>
