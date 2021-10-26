<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
  <link rel="stylesheet" href="<%=request.getContextPath()%>/public/css/styles.css">
</head>

<body>
<main>
  <div class="recent-grid">
    <div class="card">
      <div class="card-header">
        <h3>Donors</h3>
        <div class="search-wrapper">
          <span class="las la-search"></span>
          <input type="search" placeholder="search here" />
          <!-- <input type="date" id="request-date-search"> -->
        </div>
        <div class="buttons">
          <button id="newBtn">Edit</button>
          <!-- <button>Cancel</button>
                  <button>Create</button> -->
        </div>
      </div>

      <div class="card-body">
        <div class="table-responsive">
          <table width="100%">
            <thead>
            <tr>
              <td>Donor ID</td>
              <td>Donor Name</td>
              <td>Donor NIC</td>
              <td>Blood Group</td>
              <td>Contact Number</td>
              <td>DOB</td>
              <td>Gender</td>
              <td>
                <div class="dropdown">
                  <button class="dropbtn">Status</button>
                  <div id="myDropdown" class="dropdown-content">
                    <a href="#normal">Normal</a>
                    <a href="#Tdeferred">T Deferred</a>
                    <a href="#Pdeferred">P Deferred</a>
                  </div>
                </div>
              </td>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td>#D101</td>
              <td>Jake Clinton</td>
              <td>112344</td>
              <td>O+</td>
              <td>0714342388</td>
              <td>22/08/1988</td>
              <td>Male</td>
              <td>
                <span class="status progress">Normal</span>
              </td>
            </tr>
            <tr>
              <td>#D102</td>
              <td>Anita Rosewell</td>
              <td>112356</td>
              <td>O-</td>
              <td>0714342399</td>
              <td>22/11/1988</td>
              <td>Female</td>
              <td>
                <span class="status open">T deffered</span>

              </td>
            </tr>
            <tr>
              <td>#D103</td>
              <td>Nick Jones</td>
              <td>476536</td>
              <td>B-</td>
              <td>0714342399</td>
              <td>03/01/1995</td>
              <td>Male</td>
              <td>
                <span class="status open">T deffered</span>

              </td>
            </tr>
            <tr>
              <td>#D104</td>
              <td>Timothy Cameron</td>
              <td>234489</td>
              <td>B+</td>
              <td>0714300199</td>
              <td>30/03/1995</td>
              <td>Male</td>
              <td>
                <span class="status close">P deffered</span>
              </td>
            </tr>
            <tr>
              <td>#D105</td>
              <td>Brendon Mack</td>
              <td>476532</td>
              <td>AB+</td>
              <td>0714300195</td>
              <td>28/02/1994</td>
              <td>Male</td>
              <td>
                <span class="status progress">Normal</span>
              </td>
            </tr>
            <tr>
              <td>#D107</td>
              <td>Sara Ellies</td>
              <td>787855</td>
              <td>A+</td>
              <td>0714342195</td>
              <td>28/05/1994</td>
              <td>Female</td>
              <td>
                <span class="status progress">Normal</span>
              </td>
            </tr>
            </tbody>
          </table>
        </div>
      </div>
    </div>
  </div>
</main>

<div id="myModal" class="modal">
  <div class="modal-content">
    <div class="modal-header">
      <span class="close-popup">&times;</span>
      <h3>Enter Donor Details</h3>
    </div>

    <div class="modal-body">
      <!-- The form inside popup modal -->
      <form>
        <div class="fields">
          <div class="field-single">
            <span>First Name</span>
            <input type="text" />
          </div>
          <div class="field-single">
            <span>House Number</span>
            <input type="text" />
          </div>
          <div class="field-single">
            <span>Last Name</span>
            <input type="text" />
          </div>
          <div class="field-single">
            <span>Street</span>
            <input type="text" />
          </div>
          <div class="field-single">
            <span>DOB</span>
            <input type="date" id="dob-date">
          </div>
          <div class="field-single">
            <span>City</span>
            <input type="text" />
          </div>
          <div class="field-single">
            <span>Contact Number</span>
            <input type="text" />
          </div>
          <div class="field-single">
            <span>Blood Bank</span>
            <div class="custom-select" style="width:200px">
              <select class="box">
                <option value="GH">General Hospital, Matara</option>
                <option value="LHS">LHS, Colombo</option>
                <option value="NHC">Nawaloka Hospitals, Colombo</option>
                <option value="NK">NBTS, Kalmunai</option>
                <option value="NM">NBTS, Matale</option>
              </select>
            </div>
          </div>
          <div class="field-single">
            <span>Status</span>
            <div class="custom-select" style="width:200px">
              <select class="box">
                <option value="clear">Normal</option>
                <option value="tdeferred">T Deferred</option>
                <option value="pdeferred">P Deferred</option>
              </select>
            </div>
          </div>
        </div>
        <div class="modal-submit-button">
          <div class="buttons">
            <button type="submit">Submit</button>
          </div>
        </div>
      </form>
    </div>

    <div class="modal-footer">
      <img src="<%=request.getContextPath()%>/public/images/Logo%20-%20White.png" height="100px">
      <p>Many people would not be alive today if it wasn't for the generosity of our donors. <br>Donating
        Blood Makes a Big Difference in the Lives of Others.
      </p>
    </div>
  </div>

  <!-- IMPORTANT -->
  <!-- Javascript file with popup modal function should be called here just after the popup modal -->
  <script src="<%=request.getContextPath()%>/public/scripts/popup_modal_dashboard.js"></script>
</div>

</body>

</html>