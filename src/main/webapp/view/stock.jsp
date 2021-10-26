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
        <h3>Blood Stock</h3>
        <div class="search-wrapper">
          <span class="las la-search"></span>
          <input type="search" placeholder="search here" />
          <span class="las la-calendar-week"></span>
        </div>
        <div class="buttons">
          <!-- <button>Transfuse</button>
          <button class="myBtn_multi">Transfer</button>
          <button class="myBtn_multi">Process</button>
          <button>Discard</button> -->
          <button id="editBtn">Edit</button>
        </div>
      </div>

      <div class="card-header" style="display: block; text-align: center;">
        <div class="buttons">
          <button>Transfuse</button>
          <button class="myBtn_multi">Blood Transfer</button>
          <button class="myBtn_multi">Blood Processing</button>
          <button>Discard</button>
        </div>
      </div>

      <div class="card-body">
        <div class="table-responsive">
          <table width="100%">
            <thead>
            <tr>
              <td>Blood ID</td>
              <td>Blood Product</td>
              <td>Blood Group</td>
              <td>Blood Bank</td>
              <td>Col Date</td>
              <td>Pro Date</td>
              <td>Exp Time</td>
              <td>
                <div class="dropdown">
                  <button class="dropbtn">Status</button>
                  <div id="myDropdown" class="dropdown-content">
                    <a href="#new">New</a>
                    <a href="#consulted">Processed</a>
                    <a href="#completed">NOT Processed</a>
                    <a href="#cancelled">Active</a>
                    <a href="#deferred">Discarded</a>
                  </div>
                </div>
              </td>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td>#B101</td>
              <td>Whole Blood</td>
              <td>A+</td>
              <td>NBTS</td>
              <td>21/09/2021</td>
              <td>22/09/2021</td>
              <td>30/09/2021</td>
              <td>
                <span class="status cancelled">Processed</span>
              </td>
            </tr>
            <tr>
              <td>#B101</td>
              <td>RBC</td>
              <td>A+</td>
              <td>NBTS</td>
              <td>21/09/2021</td>
              <td>22/09/2021</td>
              <td>30/09/2021</td>
              <td>
                <span class="status progress">Active</span>

              </td>
            </tr>
            <tr>
              <td>#B101</td>
              <td>WBC</td>
              <td>A+</td>
              <td>NBTS</td>
              <td>21/09/2021</td>
              <td>22/09/2021</td>
              <td>30/09/2021</td>
              <td>
                <span class="status progress">Active</span>

              </td>
            </tr>
            <tr>
              <td>#B101</td>
              <td>Platelets</td>
              <td>A+</td>
              <td>NBTS</td>
              <td>21/09/2021</td>
              <td>22/09/2021</td>
              <td>30/09/2021</td>
              <td>
                <span class="status progress">Active</span>

              </td>
            </tr>
            <tr>
              <td>#B101</td>
              <td>Plasma</td>
              <td>A+</td>
              <td>NBTS</td>
              <td>21/09/2021</td>
              <td>22/09/2021</td>
              <td>30/09/2021</td>
              <td>
                <span class="status close">Discarded</span>

              </td>
            </tr>
            <tr>
              <td>#B102</td>
              <td>Whole Blood</td>
              <td>A+</td>
              <td>NBTS</td>
              <td>21/09/2021</td>
              <td>22/09/2021</td>
              <td>30/09/2021</td>
              <td>
                <span class="status open">NOT Processed</span>

              </td>
            </tr>
            </tbody>
          </table>
        </div>
      </div>

    </div>

  </div>

  <!-- Multi Popup Modal - Transfer-->
  <div class="modal modal_multi">
    <!-- Modal content -->
    <div class="modal-content">

      <div class="modal-header">
        <span class="close-popup-multi close_multi">&times;</span>
        <h3>Transfer Blood Stock</h3>
      </div>

      <div class="modal-body">
        <!-- The form inside popup modal -->
        <form>
          <div class="fields">
            <div class="field-single">
              <span>Blood ID</span>
              <input type="text" />
            </div>
            <div class="field-single">
              <span>Blood Group</span>
              <div class="custom-select" style="width:200px">
                <select class="box">
                  <option value="A+">A+</option>
                  <option value="A-">A-</option>
                  <option value="B+">B+</option>
                  <option value="B-">B-</option>
                  <option value="AB+">AB+</option>
                  <option value="AB-">AB-</option>
                  <option value="O+">O+</option>
                  <option value="O-">O-</option>
                </select>
              </div>
            </div>
            <div class="field-single" id="product">
              <span>Blood Product</span>
              <div class="custom-select" style="width:200px">
                <select class="box">
                  <option value="RBC">RBC</option>
                  <option value="WBC">WBC</option>
                  <option value="Plasma">Plasma</option>
                  <option value="Platelets">Platelets</option>
                </select>
              </div>
            </div>
            <div class="field-single" id="transfer">
              <span>Transfer To</span>
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
  </div>

  <!-- Multi Popup Modal - Processing-->
  <div class="modal modal_multi">

    <!-- Modal content -->
    <div class="modal-content">
      <div class="modal-header">
        <span class="close-popup-multi close_multi">&times;</span>
        <h3>Blood Processing</h3>
      </div>

      <div class="modal-body">
        <!-- The form inside popup modal -->
        <form>
          <div class="fields">
            <div class="field-single">
              <span>Blood ID</span>
              <input type="text" />
            </div>
            <div class="field-single">
              <span>Blood Group</span>
              <div class="custom-select" style="width:200px">
                <select class="box">
                  <option value="A+">A+</option>
                  <option value="A-">A-</option>
                  <option value="B+">B+</option>
                  <option value="B-">B-</option>
                  <option value="AB+">AB+</option>
                  <option value="AB-">AB-</option>
                  <option value="O+">O+</option>
                  <option value="O-">O-</option>
                </select>
              </div>
            </div>
            <div class="field-single">
              <span>Processed Date</span>
              <input type="date" id="processed-date">
            </div>
            <div></div>
            <div></div><div></div>
            <div></div><div></div>
            <div class="field-single" id="rbc">
              <span>RBC Expiry Date</span>
              <input type="date" id="rbc-date">
            </div>
            <div class="field-single" id="wbc">
              <span>WBC Expiry Date</span>
              <input type="date" id="wbc-date">
            </div>
            <div class="field-single" id="plasma">
              <span>Plasma Expiry Date</span>
              <input type="date" id="plasma-date">
            </div>
            <div class="field-single" id="platelets">
              <span>Platelets Expiry Date</span>
              <input type="date" id="platelets-date">
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
  </div>

</main>


<!-- Edit popup modal -->
<div id="myModal" class="modal">
  <div class="modal-content">
    <div class="modal-header">
      <span class="close-popup">&times;</span>
      <h3>Enter Blood Stock Details</h3>
    </div>

    <div class="modal-body">
      <!-- The form inside popup modal -->
      <form>
        <div class="fields">
          <div class="field-single">
            <span>Blood ID</span>
            <input type="text" />
          </div>
          <div class="field-single">
            <span>Blood Group</span>
            <div class="custom-select" style="width:200px">
              <select class="box">
                <option value="A+">A+</option>
                <option value="A-">A-</option>
                <option value="B+">B+</option>
                <option value="B-">B-</option>
                <option value="AB+">AB+</option>
                <option value="AB-">AB-</option>
                <option value="O+">O+</option>
                <option value="O-">O-</option>
              </select>
            </div>
          </div>
          <div class="field-single" id="product">
            <span>Blood Product</span>
            <div class="custom-select" style="width:200px">
              <select class="box">
                <option value="RBC">RBC</option>
                <option value="WBC">WBC</option>
                <option value="Plasma">Plasma</option>
                <option value="Platelets">Platelets</option>
              </select>
            </div>
          </div>
          <div class="field-single">
            <span>Collection Date</span>
            <input type="date" id="collected-date">
          </div>
          <div class="field-single">
            <span>Processed Date</span>
            <input type="date" id="processed-date">
          </div>
          <div class="field-single" id="expire">
            <span>Expiry Date</span>
            <input type="date" id="expired-date">
          </div>
          <div class="field-single" id="stock-status">
            <span>Status</span>
            <div class="custom-select" style="width:200px">
              <select class="box">
                <option value="consulted">collected</option>
                <option value="completed">processed</option>
                <option value="cancelled">expired</option>
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
  <script src="<%=request.getContextPath()%>/public/scripts/popup_modal_dashboard.js"></script>
</div>

</body>

</html>
