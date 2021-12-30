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

const date = new Date();

const renderCalendar = () => {
    date.setDate(1);

    const monthDays = document.querySelector(".days");

    const lastDay = new Date(
        date.getFullYear(),
        date.getMonth() + 1,
        0
    ).getDate();

    const prevLastDay = new Date(
        date.getFullYear(),
        date.getMonth(),
        0
    ).getDate();

    const firstDayIndex = date.getDay();

    const lastDayIndex = new Date(
        date.getFullYear(),
        date.getMonth() + 1,
        0
    ).getDay();

    const nextDays = 7 - lastDayIndex - 1;

    const months = [
        "January",
        "February",
        "March",
        "April",
        "May",
        "June",
        "July",
        "August",
        "September",
        "October",
        "November",
        "December",
    ];

    document.querySelector(".date h1").innerHTML = months[date.getMonth()];

    document.querySelector(".date p").innerHTML = new Date().toDateString();

    let days = "";

    for (let x = firstDayIndex; x > 0; x--) {
        days += `<div class="prev-date">${prevLastDay - x + 1}</div>`;
    }

    for (let i = 1; i <= lastDay; i++) {
        if (
            i === new Date().getDate() &&
            date.getMonth() === new Date().getMonth()
        ) {
            days += `<div class="today">${i}</div>`;
        } else {
            days += `<div>${i}</div>`;
        }
    }

    for (let j = 1; j <= nextDays; j++) {
        days += `<div class="next-date">${j}</div>`;
        monthDays.innerHTML = days;
    }
};

document.querySelector(".prev").addEventListener("click", () => {
    date.setMonth(date.getMonth() - 1);
    renderCalendar();
});

document.querySelector(".next").addEventListener("click", () => {
    date.setMonth(date.getMonth() + 1);
    renderCalendar();
});

renderCalendar();
