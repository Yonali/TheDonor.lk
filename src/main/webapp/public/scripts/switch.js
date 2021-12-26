var cb = document.getElementById('switch_type');

var upcoming_more = document.getElementsByClassName("container_upcoming_more");
var progress_more = document.getElementsByClassName("container_progress_more");

function change_type() {
    if (cb.checked == true) {
        document.getElementById("container_upcoming").style.display = "grid";
        document.getElementById("container_progress").style.display = "none";

        
        for (var i = 0; i < upcoming_more.length; i++) { 
            upcoming_more[i].style.display = "none";
        }
        for (var i = 0; i < progress_more.length; i++) { 
            progress_more[i].style.display = "none";
        }

        document.getElementById("upcomingShowMoreBtn").style.display = "grid";
        document.getElementById("progressShowMoreBtn").style.display = "none";

        document.getElementById("progressShowMoreBtn").innerHTML = "Show more";
        document.getElementById("upcomingShowMoreBtn").innerHTML = "Show more";
    } else {
        document.getElementById("container_upcoming").style.display = "none";
        document.getElementById("container_progress").style.display = "grid";

        // document.getElementById("container_upcoming_more").style.display = "none";
        // document.getElementById("container_progress_more").style.display = "none";
        for (var i = 0; i < upcoming_more.length; i++) { 
            upcoming_more[i].style.display = "none";
        }
        for (var i = 0; i < progress_more.length; i++) { 
            progress_more[i].style.display = "none";
        }

        document.getElementById("upcomingShowMoreBtn").style.display = "none";
        document.getElementById("progressShowMoreBtn").style.display = "grid";
        
        document.getElementById("progressShowMoreBtn").innerHTML = "Show more";
        document.getElementById("upcomingShowMoreBtn").innerHTML = "Show more";
    }
}

var bank_btn = document.getElementById("bank_switch");

bank_btn.onchange = function () {
    var value = bank_btn.options[bank_btn.selectedIndex].value;
    var cards = document.getElementsByClassName(value);
    var all_cards = document.getElementsByClassName("column");

    if (value == "all") {
        for (var i = 0; i < all_cards.length; i++) {
            all_cards[i].style.display = "grid";
        }
        change_type();
    } else {
        console.log(value);
        for (var i = 0; i < all_cards.length; i++) {
            all_cards[i].style.display = "none";
        }
        for (var i = 0; i < cards.length; i++) {
            cards[i].style.display = "grid";
        }

        document.getElementById("upcomingShowMoreBtn").style.display = "none";
        document.getElementById("progressShowMoreBtn").style.display = "none";
    }
}