function validate() {
    var email = document.getElementById("email").value;
    var pwd = document.getElementById("pwd").value;
    var cnfrm_pwd = document.getElementById("cnfrm_pwd").value;
    var contact = document.getElementById("contact").value;

    // var mailformat = /^[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$/;
    var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
    if (!email.match(mailformat)) {
        swal("Warning!", "Please Enter a valid Email Address!", "warning");
        text = "Please Enter a valid Email Address!";
        error_message.innerHTML = text;
        return false;
    }
    if (isNaN(contact) || contact.length != 10) {
        swal("Warning!", "Please Enter a valid Phone Number!", "warning");
        text = "Please Enter a valid Phone Number";
        error_message.innerHTML = text;
        return false;
    }

    if (pwd.length < 8) {
        swal("Warning!", "Password should be Minimum 8 Characters long", "warning");
        text = "Password should be Minimum 8 Characters long";
        error_message.innerHTML = text;
        return false;
    }
    if (pwd != cnfrm_pwd) {
        swal("Warning!", "Passwords Do Not Match, Please Try Again", "warning");
        text = "Passwords Do Not Match, Please Try Again";
        error_message.innerHTML = text;
        return false;
    }

    return true;
}