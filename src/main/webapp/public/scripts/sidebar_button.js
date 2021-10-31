var newbtn = document.getElementById("sidebar_btn");
var sidebar = document.getElementById("sidebar");
var main_content = document.getElementById("main-content");
var header = document.getElementById("header");

newbtn.onclick = function () {
    if (sidebar.style.display == "none") {
        main_content.style.marginLeft = "20%";
        sidebar.style.display = "block";
        header.style.left = "20%";
        header.style.width = "80%";
    } else {
        main_content.style.marginLeft = "0%";
        sidebar.style.display = "none";
        header.style.left = "0%";
        header.style.width = "100%";
    }
}