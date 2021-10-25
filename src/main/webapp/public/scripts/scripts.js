function loadIframe() {
    // this function will load the Google homepage into the iframe
    var iframe = document.getElementById("icontent");
    iframe.src = "http://localhost:8080/TheDonorlk_war_exploded/view/dashboard.jsp" // here goes your url
    };
    window.onload = loadIframe;

