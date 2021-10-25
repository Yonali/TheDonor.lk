var modal = document.getElementById("myModal");
var newbtn = document.getElementById("newbtn");
var editbtn = document.getElementsByClassName("editBtn");
var span = document.getElementsByClassName("close")[0];

if (newbtn != null) {
    newbtn.onclick = function () {
        modal.style.display = "block";
    }
}
for (var i = 0; i < editbtn.length; i++) {
    if (editbtn[i] != null) {
        editbtn[i].onclick = function () {
            modal.style.display = "block";
        }
    }
}
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

// --------------------comment box---in profile-------------

var btn2 = document.getElementById("comments_box2");
var modal2 = document.getElementById("myModal2");
var span2 = document.getElementsByClassName("close2")[0];

// --------------------added-------------

btn2.onclick = function () {
    modal2.style.display = "block";
}
span2.onclick = function () {
    modal2.style.display = "none";
}
window.onclick = function (event) {
    if (event.target == modal2) {
        modal2.style.display = "none";
    }
}
// --------------------added-------------

// --------------------report popup modal-------------

// var btn4 = document.getElementById("Report");
// var modal4 = document.getElementById("myModal4");
// var span4 = document.getElementsByClassName("close4")[0];



// btn4.onclick = function () {
//     modal4.style.display = "block";
// }
// span4.onclick = function () {
//     modal4.style.display = "none";
// }
// window.onclick = function (event) {
//     if (event.target == modal4) {
//         modal4.style.display = "none";
//     }
// }

// --------------------show more-----------------

function appShowMore() {
    var moreText = document.getElementsByClassName("container_more");
    var btnText = document.getElementById("appShowMoreBtn");

    for (var i = 0; i < moreText.length; i++) {
        if (moreText[i].style.display !== "none") {
            btnText.innerHTML = "Show more";
            moreText[i].style.display = "none";
        } else {
            btnText.innerHTML = "Show less";
            moreText[i].style.display = "grid";
        }
    }
}

function progressShowMore() {
    var moreText = document.getElementsByClassName("container_progress_more");
    var btnText = document.getElementById("progressShowMoreBtn");

    for (var i = 0; i < moreText.length; i++) {
        if (moreText[i].style.display !== "none") {
            btnText.innerHTML = "Show more";
            moreText[i].style.display = "none";
        } else {
            btnText.innerHTML = "Show less";
            moreText[i].style.display = "grid";
        }
    }
}

function upcomingShowMore() {
    var moreText = document.getElementsByClassName("container_upcoming_more");
    var btnText = document.getElementById("upcomingShowMoreBtn");

    for (var i = 0; i < moreText.length; i++) {
        if (moreText[i].style.display !== "none") {
            btnText.innerHTML = "Show more";
            moreText[i].style.display = "none";
        } else {
            btnText.innerHTML = "Show less";
            moreText[i].style.display = "grid";
        }
    }
}