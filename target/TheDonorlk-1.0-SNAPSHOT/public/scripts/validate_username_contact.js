function validate() {
    var username = document.getElementById("username").value;
    var contact = document.getElementById("contact").value;

    var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
    if (!username.match(mailformat)) {
        swal("Warning!", "Please Enter a valid Email Address!", "warning");
        text = "Please Enter a valid Email Address!";
        error_message.innerHTML = text;
        return false;
    }
    if (isNaN(contact) || contact.length != 10) {
        text = "Please Enter a valid Phone Number";
        error_message.innerHTML = text;
        return false;
    }

    return true;
}