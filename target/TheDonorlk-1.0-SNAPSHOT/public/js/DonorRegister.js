function validate() {
    // var name = document.getElementById("name").value;
    // var subject = document.getElementById("subject").value;
    // var phone = document.getElementById("phone").value;
    // var message = document.getElementById("message").value;
    // var error_message = document.getElementById("error_message");

    var email = document.getElementById("email").value;
    var pwd = document.getElementById("email").value;
    var cnfrm_pwd = document.getElementById("cnfrm_pwd").value;

    if (email.indexOf("@") == -1 || email.length < 6) {
        text = "Please Enter valid Email";
        error_message.innerHTML = text;
        return false;
    }

    if (pwd != cnfrm_pwd) {
        text = "Passwords do not match";
        error_message.innerHTML = text;
        return false;
    }

    alert("Form Submitted Successfully!");
    return true;

    // var text;
    // if (name.length < 5) {
    //     text = "Please Enter valid Name";
    //     error_message.innerHTML = text;
    //     return false;
    // }
    // if (subject.length < 10) {
    //     text = "Please Enter Correct Subject";
    //     error_message.innerHTML = text;
    //     return false;
    // }
    // if (isNaN(phone) || phone.length != 10) {
    //     text = "Please Enter valid Phone Number";
    //     error_message.innerHTML = text;
    //     return false;
    // }

    // if (message.length <= 140) {
    //     text = "Please Enter More Than 140 Characters";
    //     error_message.innerHTML = text;
    //     return false;
    // }

}