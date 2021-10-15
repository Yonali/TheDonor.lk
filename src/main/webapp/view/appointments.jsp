<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <title>TheDonor.lk</title>
  <link rel="stylesheet" href="https://maxst.icons8.com/vue-static/landings/line-awesome/line-awesome/1.3.0/css/line-awesome.min.css">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/public/css/styles.css">
</head>

<body>
<main>
  <div class="recent-grid">
    <div class="card">
      <div class="card-header">
        <h3>Appointments</h3>
        <div class="search-wrapper">
          <span class="las la-search"></span>
          <input type="search" placeholder="search here" />
          <input type="date" id="appointment-date-search">
        </div>
        <div class="buttons">
          <button>Accept</button>
          <button>Decline</button>
          <button id="newBtn">Create</button>
        </div>
      </div>
      <div class="card-body">
        <div class="table-responsive">
          <table width="100%">
            <thead>
            <tr>
              <td>Appt. ID</td>
              <td>Donor Name</td>
              <td>Donor NIC</td>
              <td>Date</td>
              <td>Time</td>
              <td>
                <div class="dropdown">
                  <button class="dropbtn">Status</button>
                  <div id="myDropdown" class="dropdown-content">
                    <a href="#accepted">New</a>
                    <a href="#accepted">Accepted</a>
                    <a href="#declined">Declined</a>
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
              <td>21/09/2021</td>
              <td>9.00AM</td>
              <td>
                <span class="status open">New</span>
              </td>
            </tr>
            <tr>
              <td>#D102</td>
              <td>Anita Rosewell</td>
              <td>112356</td>
              <td>21/09/2021</td>
              <td>10.00AM</td>
              <td>
                <span class="status close">Declined</span>

              </td>
            </tr>
            <tr>
              <td>#D104</td>
              <td>Timothy Cameron</td>
              <td>234489</td>
              <td>21/09/2021</td>
              <td>3.00PM</td>
              <td>
                <span class="status progress">Accepted</span>
              </td>
            </tr>
            <tr>
              <td>#D105</td>
              <td>Brendon Mack</td>
              <td>476532</td>
              <td>22/09/2021</td>
              <td>9.00AM</td>
              <td>
                <span class="status progress">Accepted</span>
              </td>
            </tr>
            <tr>
              <td>#D107</td>
              <td>Sara Ellies</td>
              <td>787855</td>
              <td>23/09/2021</td>
              <td>9.00AM</td>
              <td>
                <span class="status progress">Accepted</span>
              </td>
            </tr>
            </tbody>
          </table>
        </div>
      </div>
    </div>
  </div>
</main>

<!-- The Popup Modal -->
<div id="myModal" class="modal">
  <div class="modal-content">
    <div class="modal-header">
      <span class="close-popup">&times;</span>
      <h3>Enter Appointment Details</h3>
    </div>

    <div class="modal-body">
      <!-- The form inside popup modal -->
      <form>
        <div class="fields">
          <div class="field-single">
            <span>Donor Name</span>
            <input type="text" />
          </div>
          <div class="field-single">
            <span>Date</span>
            <input type="date" id="appointment-date">
          </div>
          <div class="field-single">
            <span>Donor NIC</span>
            <input type="text" />
          </div>
          <div class="field-single">
            <span>Time</span>
            <input type="text" />
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
      <img src="<%=request.getContextPath()%>/public/images/Logo - White.png" height="100px">
      <p>Many people would not be alive today if it wasn't for the generosity of our donors. <br>Donating
        Blood Makes a Big Difference in the Lives of Others.
      </p>
    </div>
  </div>

  <!-- IMPORTANT -->
  <!-- Javascript file with popup modal function should be called here just after the popup modal -->
  <script src="<%=request.getContextPath()%>/public/scripts/popup_modal.js"></script>
</div>

</body>

</html>
