<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>TheDonor.lk</title>
  <link rel="stylesheet" href="https://maxst.icons8.com/vue-static/landings/line-awesome/line-awesome/1.3.0/css/line-awesome.min.css">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/public/css/styles.css">

  <script src="<%=request.getContextPath()%>/public/scripts/scripts.js"></script>

</head>

<body>
<!-- <input type="checkbox" id="nav-toggle"> -->

<div class="sidebar">
  <div class="logo">
    <img src="<%=request.getContextPath()%>/public/images/Logo - White.png" height="100px">
  </div>

  <div class="sidebar-menu">
    <ul>
      <li>
        <a href="<%=request.getContextPath()%>/view/dashboard.jsp" target="iframe"><span class="las la-tachometer-alt"></span>
          <span>Dashboard</span></a>
      </li>
      <li>
        <a href="<%=request.getContextPath()%>/view/campaigns.jsp" target="iframe"><span class="las la-users"></span>
          <span>Campaigns</span></a>
      </li>
      <li>
        <a href="<%=request.getContextPath()%>/view/donations.jsp" target="iframe"><span class="las la-tint"></span>
          <span>Donations</span></a>
      </li>
      <li>
        <a href="<%=request.getContextPath()%>/view/appointments.jsp" target="iframe"><span class="las la-clipboard-list"></span>
          <span>Appointments</span></a>
      </li>
      <li>
        <a href="<%=request.getContextPath()%>/view/emergency.jsp" target="iframe"><span class="las la-ambulance"></span>
          <span>Emergency Requirements</span></a>
      </li>
      <li>
        <a href="#"><span class="las la-percentage"></span>
          <span>Blood Stock Management</span></a>
        <ul class="stock-show">
          <li><a href="<%=request.getContextPath()%>/view/stock.jsp" target="iframe"><span class="las la-angle-right"></span><span>Blood
                                    Stock</span></a></li>
          <li><a href="<%=request.getContextPath()%>/view/request_sent.jsp" target="iframe"><span class="las la-angle-right"></span><span>
                                    Request Sent</span></a></li>
          <li><a href="<%=request.getContextPath()%>/view/request_received.jsp" target="iframe"><span class="las la-angle-right"></span><span>
                                        Request Received</span></a></li>
          <li><a href="<%=request.getContextPath()%>/view/transfer.jsp" target="iframe"><span class="las la-angle-right"></span><span>
                                    Transfer History</span></a></li>
        </ul>
      </li>
      <li>
        <a href="<%=request.getContextPath()%>/view/donors.jsp" target="iframe"><span class="las la-user-tag"></span>
          <span>Donors</span></a>
      </li>
      <li>
        <a href="#"><span class="las la-user-circle"></span>
          <span>System Users</span></a>
        <ul class="user-show">
          <li><a href="<%=request.getContextPath()%>/userBloodBank" target="iframe"><span class="las la-angle-right"></span><span>Blood
                                    Banks</span></a></li>
          <li><a href="<%=request.getContextPath()%>/view/doctors.jsp" target="iframe"><span
                  class="las la-angle-right"></span><span>Doctors</span></a></li>
          <li><a href="<%=request.getContextPath()%>/view/nurses.jsp" target="iframe"><span
                  class="las la-angle-right"></span><span>Nurses</span></a></li>
          <li><a href="<%=request.getContextPath()%>/userAdmin" target="iframe"><span class="las la-angle-right"></span><span>System
                                    Admins</span></a></li>
        </ul>
      </li>
      <!-- <li>
          <a href=""><span class="las la-cog"></span>
              <span>Settings</span></a>
      </li>
      <li>
          <a href=""><span class="las la-sign-out-alt"></span>
              <span>Logout</span></a>
      </li> -->
    </ul>
  </div>
</div>

<div class="main-content">
  <header>
    <h2>
      <label for="">
        <span class="las la-bars"></span>
      </label>
      NBTS Narahenpita
    </h2>
    <div class="dropdown">
      <div class="user-wrapper">
        <img src="<%=request.getContextPath()%>/public/images/anne-doe.jpg" width="40px" height="40px" alt="">
        <div>
          <h4>Anne Doe</h4>
          <small>Admin</small>
        </div>
      </div>
      <div class="dropdown-content">
        <a href="#">Settings</a>
        <a href="#">Logout</a>
      </div>
    </div>

  </header>

  <div class="content">
    <iframe id="icontent" target="_self" name="iframe"
            scrolling="yes" style="width:100%;height:99vh;border:none;"></iframe>
  </div>
</div>
</body>

</html>