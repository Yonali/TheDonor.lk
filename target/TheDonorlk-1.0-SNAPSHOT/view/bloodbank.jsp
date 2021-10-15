<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>TheDonor.lk</title>
  <link rel="stylesheet" href="https://maxst.icons8.com/vue-static/landings/line-awesome/line-awesome/1.3.0/css/line-awesome.min.css">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/public/css/styles.css">
  <script src="<%=request.getContextPath()%>/public/css/scripts.js"></script>
</head>

<body>
<main>
  <div class="recent-grid">
    <div class="card">
      <div class="card-header">
        <h3>Blood Banks</h3>
        <div class="search-wrapper">
          <span class="las la-search"></span>
          <input type="search" placeholder="search here" />
        </div>
        <div class="buttons">
          <button id="editBtn">Edit</button>
          <button>Delete</button>
          <button id="newBtn">New</button>
        </div>
      </div>

      <div class="card-body">
        <div class="table-responsive">
          <table width="100%">
            <thead>
            <tr>
              <td>Blood Bank ID</td>
              <td>Username</td>
              <td>Name</td>
              <td>Contact Number</td>
              <td>Address</td>
              <td>Email</td>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td>#BB101</td>
              <td>GH</td>
              <td>General Hospital, Matara</td>
              <td>0714342388</td>
              <td>33, Matara</td>
              <td>jstark@gmail.com</td>
            </tr>
            <tr>
              <td>#BB102</td>
              <td>NHC</td>
              <td>Nawaloka Hospitals, Colombo</td>
              <td>0764333378</td>
              <td>55, Colombo</td>
              <td>helen7@gmail.com</td>
            </tr>
            <tr>
              <td>#BB103</td>
              <td>LHS</td>
              <td>LHS, Colombo</td>
              <td>0764342111</td>
              <td>31/C, Colombo</td>
              <td>audrey@gmail.com</td>
            </tr>
            <tr>
              <td>#BB104</td>
              <td>NM</td>
              <td>NBTS, Matale</td>
              <td>0764342399</td>
              <td>11, Matale</td>
              <td>selena99@gmail.com</td>
            </tr>
            <tr>
              <td>#BB105</td>
              <td>NK</td>
              <td>NBTS, Kalmunai</td>
              <td>07788642388</td>
              <td>177, Kalmunai</td>
              <td>bmartin@gmail.com</td>
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
      <h3>Enter Blood Bank Details</h3>
    </div>

    <div class="modal-body">
      <!-- The form inside popup modal -->
      <form>
        <div class="fields">
          <div class="field-single">
            <span>Username</span>
            <input type="text" />
          </div>
          <div class="field-single">
            <span>Contact Number</span>
            <input type="text" />
          </div>
          <div class="field-single">
            <span>Name</span>
            <input type="text" />
          </div>
          <div class="field-single">
            <span>Email</span>
            <input type="text" />
          </div>
          <div class="field-single">
            <span>Address</span>
            <input type="text" />
          </div>
          <!-- <div class="field-single">
              <span>Blood Bank</span>
              <input type="text" />
          </div> -->
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
