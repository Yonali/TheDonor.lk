// Popup Modal script
var modal = document.getElementById("myModal");
var stockmodal = document.getElementById("stockModal");
// var editmodal = document.getElementById("editModal");
var btn = document.getElementById("newBtn");
var editbtn = document.getElementById("editBtn");
var stockbtn = document.getElementById("stockBtn");
var span = document.getElementsByClassName("close-popup")[0];

// var transferbtn = document.getElementById("transferBtn");
// var processbtn = document.getElementById("processBtn");

btn.onclick = function () {
    modal.style.display = "block";
    var status = document.getElementById("status");
    status.style.display = "none";
}
editbtn.onclick = function () {
    modal.style.display = "block";
}

stockbtn.onclick = function () {
    stockmodal.style.display = "block";
    var expire = document.getElementById("expire");
    expire.style.display = "none";
//     var product = document.getElementById("product");
//     product.style.display = "none";
//     var transfer = document.getElementById("transfer");
//     transfer.style.display = "none";
//     var rbc = document.getElementById("rbc");
//     rbc.style.display = "none";
//     var wbc = document.getElementById("wbc");
//     wbc.style.display = "none";
//     var plasma = document.getElementById("plasma");
//     plasma.style.display = "none";
//     var platelets = document.getElementById("platelets");
//     platelets.style.display = "none";
}

span.onclick = function () {
    modal.style.display = "none";
}

window.onclick = function (event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}