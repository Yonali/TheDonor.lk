var modal = document.getElementById("myModal");
var newbtn = document.getElementById("newBtn");
var editbtn = document.getElementById("editBtn");
var span = document.getElementsByClassName("close-popup")[0];
var status_input = document.getElementById("status");

if (newbtn != null) {
    newbtn.onclick = function () {
        modal.style.display = "block";
        status_input.style.display = "none";
    }
}
if (editbtn != null) {
    editbtn.onclick = function () {
        modal.style.display = "block";
        status_input.style.display = "flex";
    }
}
span.onclick = function () {
    modal.style.display = "none";
}
window.onclick = function (event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}

/************************* */

var modalparent = document.getElementsByClassName("modal_multi");
var modal_btn_multi = document.getElementsByClassName("myBtn_multi");
var span_close_multi = document.getElementsByClassName("close_multi");

function setDataIndex() {

    for (i = 0; i < modal_btn_multi.length; i++) {
        modal_btn_multi[i].setAttribute('data-index', i);
        modalparent[i].setAttribute('data-index', i);
        span_close_multi[i].setAttribute('data-index', i);
    }
}

for (i = 0; i < modal_btn_multi.length; i++) {
    modal_btn_multi[i].onclick = function () {
        var ElementIndex = this.getAttribute('data-index');
        modalparent[ElementIndex].style.display = "block";
    };

    // When the user clicks on <span> (x), close the modal
    span_close_multi[i].onclick = function () {
        var ElementIndex = this.getAttribute('data-index');
        modalparent[ElementIndex].style.display = "none";
    };

}

window.onload = function () {

    setDataIndex();
};

window.onclick = function (event) {
    if (event.target === modalparent[event.target.getAttribute('data-index')]) {
        modalparent[event.target.getAttribute('data-index')].style.display = "none";
    }

    // // OLD CODE
    // if (event.target === modal) {
    //     modal.style.display = "none";
    // }
};


// var stockmodal_edit = document.getElementById("editModal");
// var editBtn = document.getElementById("editBtn");
// var span = document.getElementsByClassName("close-popup")[0];

// if (editBtn != null) {
//     editBtn.onclick = function () {
//         stockmodal_edit.style.display = "block";
//     }
// }
// span.onclick = function () {
//     stockmodal_edit.style.display = "none";
// }
// window.onclick = function (event) {
//     if (event.target == stockmodal_edit) {
//         stockmodal_edit.style.display = "none";
//     }
// }

// var stockmodal_transfer = document.getElementById("transferModal");
// var transferBtn = document.getElementById("transferBtn");
// var span_stockmodal_transfer = document.getElementsByClassName("close-popup")[0];

// if (transferBtn != null) {
//     transferBtn.onclick = function () {
//         stockmodal_transfer.style.display = "block";
//     }
// }
// // span_stockmodal_transfer.onclick = function () {
// //     stockmodal_transfer.style.display = "none";
// // }
// window.onclick = function (event) {
//     if (event.target == stockmodal_transfer) {
//         stockmodal_transfer.style.display = "none";
//     }
// }