<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
        <h3>Doctors</h3>
        <div class="search-wrapper">
          <span class="las la-search"></span>
          <input type="search" placeholder="search here" />
          <!-- <span class="las la-calendar-week"></span> -->
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
              <td>Doctor ID</td>
              <td>Username</td>
              <td>Name</td>
              <td>Contact Number</td>
              <td>Email</td>
              <td>Section</td>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td>#DC101</td>
              <td>jamie_stark</td>
              <td>Jamie Stark</td>
              <td>0764342388</td>
              <td>jstark@gmail.com</td>
              <td>Dept A</td>
            </tr>
            <tr>
              <td>#DC102</td>
              <td>susan_helen</td>
              <td>Susan Helen</td>
              <td>0764333378</td>
              <td>helen7@gmail.com</td>
              <td>Dept A</td>
            </tr>
            <tr>
              <td>#DC103</td>
              <td>audrey_b</td>
              <td>Audrey Bourbon</td>
              <td>0764342111</td>
              <td>audrey@gmail.com</td>
              <td>Dept C</td>
            </tr>
            <tr>
              <td>#DC104</td>
              <td>selena_009</td>
              <td>Selena Williams</td>
              <td>0764342399</td>
              <td>selena99@gmail.com</td>
              <td>Dept D</td>
            </tr>
            <tr>
              <td>#DC105</td>
              <td>bob_mart</td>
              <td>Bob Martin</td>
              <td>07788642388</td>
              <td>bmartin@gmail.com</td>
              <td>Dept E</td>
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
      <h3>Enter Doctor Details</h3>
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
            <span>First Name</span>
            <input type="text" />
          </div>
          <div class="field-single">
            <span>Email</span>
            <input type="text" />
          </div>
          <div class="field-single">
            <span>Last Name</span>
            <input type="text" />
          </div>
          <div class="field-single">
            <span>Section</span>
            <input type="text" />
          </div>
          <div class="field-single">
            <span>Address</span>
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
