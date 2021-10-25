<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Profile Photo Change</title>
    <link rel="stylesheet" href="../public/css/upload.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
  <div class="main">
    <div class="drag-area">
    
      <div class="icon"><i class="fa fa-cloud-upload" aria-hidden="true"></i></div>
      <header>Drag & Drop to Upload File</header>
      <span>OR</span>
      <button>Browse File</button>
      <input type="file" hidden>
    </div>
    <div class="c">
      <button id="save"><a >Done</a></button>
      <!-- <button id="save"><a href="./upload.jsp">Save</a></button> -->
    </div>
  </div>
  <script src="../public/scripts/upload.js"></script>
<!-- <script>
var modal = document.getElementById("./upload.jsp");
var span = document.getElementsByClassName("save")[0];

if (span != null) {
  span.onclick = function () {
      modal.style.display = "none";
  }
}
window.onclick = function (event) {
  if (event.target == modal) {
      modal.style.display = "none";
  }
}

</script> -->
</body>
</html>