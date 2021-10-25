var cb = document.getElementById('switch_type');
var btn = document.getElementById("test");

var upcoming_more = document.getElementsByClassName("container_upcoming_more");
var progress_more = document.getElementsByClassName("container_progress_more");

btn.onclick = function () {
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
