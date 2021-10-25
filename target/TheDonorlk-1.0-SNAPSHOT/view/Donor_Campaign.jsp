<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="../public/css/appointments_campaign.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

  <script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
  <script src="../public/scripts/cardview_toggle.js"></script>
  <script src="../public/scripts/popup_modal.js"></script>

  <title>Campaigns</title>

</head>

<body>
  <div class="switch-box">
    <div style="text-align: center; align-items: center; justify-content: center; padding: 15px;">
      <span style="color: aliceblue;">Blood Bank</span>
      <div class="custom-select">
        <select class="box">
          <option value="all">All</option>
          <option value="NBTS">NBTS, Narahenpitiya</option>
          <option value="GH">General Hospital, Matara</option>
          <option value="LHS">LHS, Colombo</option>
          <option value="NHC">Nawaloka Hospitals, Colombo</option>
          <option value="NK">North Hospital, Kalmunai</option>
          <option value="NM">Base Hospital, Matale</option>
        </select>
      </div>
    </div>
    <div class="switch-button" id="test">
      <input class="switch-button-checkbox" id="switch_type" type="checkbox" value="progress"></input>
      <label class="switch-button-label" for=""><span class="switch-button-label-span">In Progress</span></label>
    </div>
  </div>

  <script src="../public/scripts/switch.js"></script>

  <!----------------  NEW Card View ----------------->

  <div class="container" id="container_progress">
    <div class="column">
      <div class="post-module">
        <!-- Thumbnail-->
        <div class="thumbnail">
          <div class="date">
            <div class="day">27</div>
            <div class="month">Nov</div>
          </div><img src="../public/images/progress.png" />
        </div>
        <!-- Post Content-->
        <div class="post-content">
          <div class="category completed">In Progress</div>
          <h1 class="title">Date - 27/11/2021 <br>Time - 9AM - 5PM</h1>
          <h2 class="sub_title">University of Colombo Camp <br>@ University Premises</h2>
          <p class="description">Blood Bank - NBTS <br>Blood Bank Contact - 0777123456 <br>Blood Bank Address -
            <br>Blood Bank Email -
          </p>

        </div>
      </div>
    </div>
    <div class="column">
      <div class="post-module">
        <!-- Thumbnail-->
        <div class="thumbnail">
          <div class="date">
            <div class="day">27</div>
            <div class="month">Nov</div>
          </div><img src="../public/images/progress.png" />
        </div>
        <!-- Post Content-->
        <div class="post-content">
          <div class="category completed">In Progress</div>
          <h1 class="title">Date - 27/11/2021 <br>Time - 9AM - 5PM</h1>
          <h2 class="sub_title">Arimac Camp <br>@ Arimac Office</h2>
          <p class="description">Blood Bank - LHS <br>Blood Bank Contact - 0777123456 <br>Blood Bank Address -
            <br>Blood Bank Email -
          </p>
        </div>
      </div>
    </div>
    <div class="column">
      <div class="post-module">
        <!-- Thumbnail-->
        <div class="thumbnail">
          <div class="date">
            <div class="day">27</div>
            <div class="month">Nov</div>
          </div><img src="../public/images/progress.png" />
        </div>
        <!-- Post Content-->
        <div class="post-content">
          <div class="category completed">In Progress</div>
          <h1 class="title">Date - 27/11/2021 <br>Time - 9AM - 5PM</h1>
          <h2 class="sub_title">University of Kelaniya Camp <br>@ UOK Premises</h2>
          <p class="description">Blood Bank - Ragama <br>Blood Bank Contact - 0777123456 <br>Blood Bank Address -
            <br>Blood Bank Email -
          </p>
        </div>
      </div>
    </div>
    <div class="column">
      <div class="post-module">
        <!-- Thumbnail-->
        <div class="thumbnail">
          <div class="date">
            <div class="day">27</div>
            <div class="month">Nov</div>
          </div><img src="../public/images/progress.png" />
        </div>
        <!-- Post Content-->
        <div class="post-content">
          <div class="category completed">In Progress</div>
          <h1 class="title">Date - 27/11/2021 <br>Time - 9AM - 5PM</h1>
          <h2 class="sub_title">Rotaract Cinnamon Gardens Camp <br>@ YMMA Hall</h2>
          <p class="description">Blood Bank - NBTS <br>Blood Bank Contact - 0777123456 <br>Blood Bank Address -
            <br>Blood Bank Email -
          </p>
        </div>
      </div>
    </div>
    <div class="column container_progress_more">
      <div class="post-module">
        <!-- Thumbnail-->
        <div class="thumbnail">
          <div class="date">
            <div class="day">27</div>
            <div class="month">Nov</div>
          </div><img src="../public/images/progress.png" />
        </div>
        <!-- Post Content-->
        <div class="post-content">
          <div class="category completed">In Progress</div>
          <h1 class="title">Date - 27/11/2021 <br>Time - 9AM - 5PM</h1>
          <h2 class="sub_title">Leo Club Camp <br>@ Dence Hall</h2>
          <p class="description">Blood Bank - Ragama <br>Blood Bank Contact - 0777123456 <br>Blood Bank Address -
            <br>Blood Bank Email -
          </p>

        </div>
      </div>
    </div>
    <div class="column container_progress_more">
      <div class="post-module">
        <!-- Thumbnail-->
        <div class="thumbnail">
          <div class="date">
            <div class="day">27</div>
            <div class="month">Nov</div>
          </div><img src="../public/images/progress.png" />
        </div>
        <!-- Post Content-->
        <div class="post-content">
          <div class="category completed">In Progress</div>
          <h1 class="title">Date - 27/11/2021 <br>Time - 9AM - 5PM</h1>
          <h2 class="sub_title">Brandix Camp <br>@ Brandix Facility </h2>
          <p class="description">Blood Bank - AMHK <br>Blood Bank Contact - 0777123456 <br>Blood Bank Address -
            <br>Blood Bank Email -
          </p>
        </div>
      </div>
    </div>
    <div class="column container_progress_more">
      <div class="post-module">
        <!-- Thumbnail-->
        <div class="thumbnail">
          <div class="date">
            <div class="day">15</div>
            <div class="month">Jun</div>
          </div><img src="../public/images/progress.png" />
        </div>
        <!-- Post Content-->
        <div class="post-content">
          <div class="category completed">In Progress</div>
          <h1 class="title">Date - 27/11/2021 <br>Time - 9AM - 5PM</h1>
          <h2 class="sub_title">Help Life Camp <br>@ Independence Squarek</h2>
          <p class="description">Blood Bank - NBTS <br>Blood Bank Contact - 0777123456 <br>Blood Bank Address -
            <br>Blood Bank Email -
          </p>
        </div>
      </div>
    </div>
    <div class="column container_progress_more">
      <div class="post-module">
        <!-- Thumbnail-->
        <div class="thumbnail">
          <div class="date">
            <div class="day">27</div>
            <div class="month">Nov</div>
          </div><img src="../public/images/progress.png" />
        </div>
        <!-- Post Content-->
        <div class="post-content">
          <div class="category completed">In Progress</div>
          <h1 class="title">Date - 27/11/2021 <br>Time - 9AM - 5PM</h1>
          <h2 class="sub_title">Sri Lanka Unite Camp <br>@ Viharamahadevi Park</h2>
          <p class="description">Blood Bank - BHA <br>Blood Bank Contact - 0777123456 <br>Blood Bank Address -
            <br>Blood Bank Email -
          </p>
        </div>
      </div>
    </div>
  </div>

  <button class="newbtn" onclick="progressShowMore()" id="progressShowMoreBtn">Show more</button>


  <div class="container" id="container_upcoming">
    <div class="column">
      <div class="post-module">
        <!-- Thumbnail-->
        <div class="thumbnail">
          <div class="date">
            <div class="day">12</div>
            <div class="month">Dec</div>
          </div><img src="../public/images/upcoming.png" />
        </div>
        <!-- Post Content-->
        <div class="post-content">
          <div class="category open">Upcoming</div>
          <h1 class="title">Date - 12/12/2021 <br>Time - 9AM - 5PM</h1>
          <h2 class="sub_title">University of Colombo Camp <br>@ University Premises</h2>
          <p class="description">Blood Bank - NBTS <br>Blood Bank Contact - 0777123456 <br>Blood Bank Address -
            <br>Blood Bank Email -
          </p>

        </div>
      </div>
    </div>
    <div class="column">
      <div class="post-module">
        <!-- Thumbnail-->
        <div class="thumbnail">
          <div class="date">
            <div class="day">14</div>
            <div class="month">Dec</div>
          </div><img src="../public/images/upcoming.png" />
        </div>
        <!-- Post Content-->
        <div class="post-content">
          <div class="category open">Upcoming</div>
          <h1 class="title">Date - 14/12/2021 <br>Time - 9AM - 5PM</h1>
          <h2 class="sub_title">Arimac Camp <br>@ Arimac Office</h2>
          <p class="description">Blood Bank - LHS <br>Blood Bank Contact - 0777123456 <br>Blood Bank Address -
            <br>Blood Bank Email -
          </p>
        </div>
      </div>
    </div>
    <div class="column">
      <div class="post-module">
        <!-- Thumbnail-->
        <div class="thumbnail">
          <div class="date">
            <div class="day">15</div>
            <div class="month">Dec</div>
          </div><img src="../public/images/upcoming.png" />
        </div>
        <!-- Post Content-->
        <div class="post-content">
          <div class="category open">Upcoming</div>
          <h1 class="title">Date - 15/12/2021 <br>Time - 9AM - 5PM</h1>
          <h2 class="sub_title">University of Kelaniya Camp <br>@ UOK Premises</h2>
          <p class="description">Blood Bank - Ragama <br>Blood Bank Contact - 0777123456 <br>Blood Bank Address -
            <br>Blood Bank Email -
          </p>
        </div>
      </div>
    </div>
    <div class="column">
      <div class="post-module">
        <!-- Thumbnail-->
        <div class="thumbnail">
          <div class="date">
            <div class="day">16</div>
            <div class="month">Dec</div>
          </div><img src="../public/images/upcoming.png" />
        </div>
        <!-- Post Content-->
        <div class="post-content">
          <div class="category open">Upcoming</div>
          <h1 class="title">Date - 16/12/2021 <br>Time - 9AM - 5PM</h1>
          <h2 class="sub_title">Rotaract Cinnamon Gardens Camp <br>@ YMMA Hall</h2>
          <p class="description">Blood Bank - NBTS <br>Blood Bank Contact - 0777123456 <br>Blood Bank Address -
            <br>Blood Bank Email -
          </p>
        </div>
      </div>
    </div>
    <div class="column container_upcoming_more">
      <div class="post-module">
        <!-- Thumbnail-->
        <div class="thumbnail">
          <div class="date">
            <div class="day">17</div>
            <div class="month">Dec</div>
          </div><img src="../public/images/upcoming.png" />
        </div>
        <!-- Post Content-->
        <div class="post-content">
          <div class="category open">Upcoming</div>
          <h1 class="title">Date - 17/12/2021 <br>Time - 9AM - 5PM</h1>
          <h2 class="sub_title">Leo Club Camp <br>@ Dence Hall</h2>
          <p class="description">Blood Bank - Ragama <br>Blood Bank Contact - 0777123456 <br>Blood Bank Address -
            <br>Blood Bank Email -
          </p>

        </div>
      </div>
    </div>
    <div class="column container_upcoming_more">
      <div class="post-module">
        <!-- Thumbnail-->
        <div class="thumbnail">
          <div class="date">
            <div class="day">17</div>
            <div class="month">Dec</div>
          </div><img src="../public/images/upcoming.png" />
        </div>
        <!-- Post Content-->
        <div class="post-content">
          <div class="category open">Upcoming</div>
          <h1 class="title">Date - 17/12/2021 <br>Time - 9AM - 5PM</h1>
          <h2 class="sub_title">Brandix Camp <br>@ Brandix Facility </h2>
          <p class="description">Blood Bank - AMHK <br>Blood Bank Contact - 0777123456 <br>Blood Bank Address -
            <br>Blood Bank Email -
          </p>
        </div>
      </div>
    </div>
    <div class="column container_upcoming_more">
      <div class="post-module">
        <!-- Thumbnail-->
        <div class="thumbnail">
          <div class="date">
            <div class="day">20</div>
            <div class="month">Dec</div>
          </div><img src="../public/images/upcoming.png" />
        </div>
        <!-- Post Content-->
        <div class="post-content">
          <div class="category open">Upcoming</div>
          <h1 class="title">Date - 20/12/2021 <br>Time - 9AM - 5PM</h1>
          <h2 class="sub_title">Help Life Camp <br>@ Independence Squarek</h2>
          <p class="description">Blood Bank - NBTS <br>Blood Bank Contact - 0777123456 <br>Blood Bank Address -
            <br>Blood Bank Email -
          </p>
        </div>
      </div>
    </div>
    <div class="column container_upcoming_more">
      <div class="post-module">
        <!-- Thumbnail-->
        <div class="thumbnail">
          <div class="date">
            <div class="day">21</div>
            <div class="month">Dec</div>
          </div><img src="../public/images/upcoming.png" />
        </div>
        <!-- Post Content-->
        <div class="post-content">
          <div class="category open">Upcoming</div>
          <h1 class="title">Date - 21/12/2021 <br>Time - 9AM - 5PM</h1>
          <h2 class="sub_title">Sri Lanka Unite Camp <br>@ Viharamahadevi Park</h2>
          <p class="description">Blood Bank - BHA <br>Blood Bank Contact - 0777123456 <br>Blood Bank Address -
            <br>Blood Bank Email -
          </p>
        </div>
      </div>
    </div>
  </div>

  <button class="newbtn" onclick="upcomingShowMore()" id="upcomingShowMoreBtn">Show more</button>

</body>

</html>