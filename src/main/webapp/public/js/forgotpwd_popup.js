var modal = document.getElementById("myModal");
var newbtn = document.getElementById("fp");
// var editbtn = document.getElementById("editBtn");
var span = document.getElementsByClassName("close-popup")[0];
// var status_input = document.getElementById("status");

if (newbtn != null) {
    newbtn.onclick = function () {
        modal.style.display = "block";
        status_input.style.display = "none";
    }
}
// if (editbtn != null) {
//     editbtn.onclick = function () {
//         modal.style.display = "block";
//         status_input.style.display = "flex";
//     }
// }
span.onclick = function () {
    modal.style.display = "none";
}
window.onclick = function (event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}


// -------------------------------------------------------
var modal2 = document.getElementById("new_password");
var newbtn2 = document.getElementById("continue");
change
if (newbtn2 != null) {
    newbtn2.onclick = function () {
        modal2.style.display = "block";
        status_input.style.display = "none";
    }
}
// if (editbtn != null) {
//     editbtn.onclick = function () {
//         modal.style.display = "block";
//         status_input.style.display = "flex";
//     }
// }
span.onclick = function () {
    modal2.style.display = "block";
}
window.onclick = function (event) {
    if (event.target == modal2) {
        modal2.style.display = "none";
    }
}



