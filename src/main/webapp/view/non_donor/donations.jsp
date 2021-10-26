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
    <form>
      <div class="card">
        <div class="modal-body">

          <div class="fields">
            <div class="field-single">
              <span>Scan Blood ID</span>
              <input type="text" />
            </div>
            <div class="field-single">
              <span>Type NIC</span>
              <input type="text" />
            </div>
          </div>
        </div>
        <div class="modal-submit-button" style="padding-top: 0px;">
          <div class="buttons">
            <button type="submit" class="bottom-full">Next</button>
          </div>
        </div>
      </div>
    </form>
  </div>
  
  <div class="recent-grid">
    <div class="card">
      <div class="card-header">
        <h3>Donations</h3>
        <div class="search-wrapper">
          <span class="las la-search"></span>
          <input type="search" placeholder="search here" />
          <!-- <span class="las la-calendar-week"></span> -->
          <input type="date" id="donation-date-search">
        </div>
        <div class="buttons">
          <button id="newBtn">Edit</button>
        </div>
      </div>

      <div class="card-body">
        <div class="table-responsive">
          <table width="100%">
            <thead>
            <tr>
              <td>Donor ID</td>
              <td>Blood ID</td>
              <td>Donor Name</td>
              <td>Donor NIC</td>
              <td>Date</td>
              <td>Time</td>
              <td>Remark</td>
              <td>
                <div class="dropdown">
                  <button class="dropbtn">Status</button>
                  <div id="myDropdown" class="dropdown-content">
                    <a href="#new">New</a>
                    <a href="#consulted">Consulted</a>
                    <a href="#completed">Completed</a>
                    <a href="#cancelled">Cancelled</a>
                    <a href="#deferred">Deferred</a>
                  </div>
                </div>
              </td>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td>#DC101</td>
              <td>#B101</td>
              <td>Jamie Stark</td>
              <td>64342388</td>
              <td>22/09/2021</td>
              <td>9.00AM</td>
              <td>Remark goes here</td>
              <td>
                <span class="status open">New</span>
              </td>
            </tr>
            <tr>
              <td>#DC101</td>
              <td>#B101</td>
              <td>Nick Jones</td>
              <td>64342388</td>
              <td>22/09/2021</td>
              <td>9.00AM</td>
              <td>Remark goes here</td>
              <td>
                <span class="status consulted">Consulted</span>
              </td>
            </tr>
            <tr>
              <td>#DC101</td>
              <td>#B101</td>
              <td>Timothy Cameron</td>
              <td>64342388</td>
              <td>22/09/2021</td>
              <td>9.00AM</td>
              <td>Remark goes here</td>
              <td>
                <span class="status progress">Completed</span>
              </td>
            </tr>
            <tr>
              <td>#DC101</td>
              <td>#B101</td>
              <td>Jake Clinton</td>
              <td>64342388</td>
              <td>22/09/2021</td>
              <td>9.00AM</td>
              <td>Remark goes here</td>
              <td>
                <span class="status cancelled">Cancelled</span>
              </td>
            </tr>
            <tr>
              <td>#DC101</td>
              <td>#B101</td>
              <td>Anita Rosewell</td>
              <td>64342388</td>
              <td>22/09/2021</td>
              <td>9.00AM</td>
              <td>Remark goes here</td>
              <td>
                <span class="status close">Deferred</span>
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
      <h3>Edit Donations Details</h3>
    </div>

    <div class="modal-body">
      <!-- The form inside popup modal -->
      <form>
        <div class="fields">
          <div class="field-single">
            <span>Donor ID</span>
            <input type="text" />
          </div>
          <div class="field-single">
            <span>Date</span>
            <input type="date" id="donation-date">
          </div>
          <div class="field-single">
            <span>Blood ID</span>
            <input type="text" />
          </div>
          <div class="field-single">
            <span>Time</span>
            <input type="text" />
          </div>
          <div class="field-single">
            <span>Donor Name</span>
            <input type="text" />
          </div>
          <div class="field-single">
            <span>Remark</span>
            <input type="text" />
          </div>
          <div class="field-single">
            <span>Donor NIC</span>
            <input type="text" />
          </div>
          <div class="field-single">
            <span>Status</span>
            <!-- <input type="text" /> -->
            <div class="custom-select" style="width:200px">
              <select class="box">
                <option value="new">New</option>
                <option value="consulted">Consulted</option>
                <option value="completed">Completed</option>
                <option value="cancelled">Cancelled</option>
                <option value="deferred">Deferred</option>
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