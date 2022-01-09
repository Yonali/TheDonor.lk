function loadIframe() {
    // this function will load the Google homepage into the iframe
    var iframe = document.getElementById("icontent");
    iframe.src = "http://localhost:8080/TheDonorlk_war_exploded/view/non_donor/dashboard.jsp" // here goes your url
};

window.onload = loadIframe;

var loadFile = function(event) {
    var image = document.getElementById('output');
    image.src = URL.createObjectURL(event.target.files[0]);
};