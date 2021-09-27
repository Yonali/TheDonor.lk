function ValidateEmail(inputText)
{
    var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
    if(inputText.value.match(mailformat))
    {
        alert("Valid email address!");
        // document.form2.email.focus();
        return true;
    }
    else
    {
        alert("You have entered an invalid email address!");
        // document.form2.email.focus();
        return true;
    }
}

// SELECTING ALL TEXT ELEMENTS
var fname = document.forms['form2']['fname'];
var lname = document.forms['form2']['lname'];
var email = document.forms['form2']['email'];
var pwd = document.forms['form2']['password'];
var cpwd = document.forms['form2']['cpwd'];
// SELECTING ALL ERROR DISPLAY ELEMENTS
// var first_name_error = document.getElementById('first_name_error');
// var last_name_error = document.getElementById('last_name_error');
// var email_error = document.getElementById('email_error');
// var pwd_error = document.getElementById('pwd_error');
var error = document.getElementById('pwd_error');
// SETTING ALL EVENT LISTENERS
fname.addEventListener('blur', fnameVerify, true);
lname.addEventListener('blur', lnameVerify, true);
email.addEventListener('blur', emailVerify, true);
pwd.addEventListener('blur', pwdVerify, true);
// validation function
function Validate() {
    // validate fname
    if (fname.value == "") {
        fname.style.border = "1px solid red";
        document.getElementById('fname_div').style.color = "red";
        error.textContent = "First name is required";
        fname.focus();
        return false;
    }
    // validate lrname
    if (lname.value == "") {
        lname.style.border = "1px solid red";
        document.getElementById('lname_div').style.color = "red";
        error.textContent = "Last name is required";
        lname.focus();
        return false;
    }

    // validate email
    if (email.value == "") {
        email.style.border = "1px solid red";
        document.getElementById('email_div').style.color = "red";
        error.textContent = "Email is required";
        email.focus();
        return false;
    }
    // validate password
    if (pwd.value == "") {
        pwd.style.border = "1px solid red";
        document.getElementById('pwd_div').style.color = "red";
        cpwd.style.border = "1px solid red";
        error.textContent = "Password is required";
        pwd.focus();
        return false;
    }
    // check if the two passwords match
    if (pwd.value != cpwd.value) {
        pwd.style.border = "1px solid red";
        document.getElementById('cpwd_div').style.color = "red";
        cpwd.style.border = "1px solid red";
        error.innerHTML = "The two passwords do not match";
        return false;
    }
    // validate password length
    if (pwd.value.length < 8) {
        pwd.style.border = "1px solid red";
        document.getElementById('pwd_div').style.color = "red";
        error.textContent = "Username must be at least 8 characters";
        pwd.focus();
        return false;
    }
}
// event handler functions
function fnameVerify() {
    if (fname.value != "") {
        //  fname.style.border = "1px solid #5e6e66";
        document.getElementById('fname_div').style.color = "#5e6e66";
        error.innerHTML = "";
        return true;
    }
}
function lnameVerify() {
    if (lname.value != "") {
        //  lname.style.border = "1px solid #5e6e66";
        document.getElementById('lname_div').style.color = "#5e6e66";
        error.innerHTML = "";
        return true;
    }
}
function emailVerify() {
    if (email.value != "") {
        // email.style.border = "1px solid #5e6e66";
        document.getElementById('email_div').style.color = "#5e6e66";
        error.innerHTML = "";
        return true;
    }
}
function pwdVerify() {
    if (pwd.value != "") {
        // pwd.style.border = "1px solid #5e6e66";
        document.getElementById('cpwd_div').style.color = "#5e6e66";
        document.getElementById('pwd_div').style.color = "#5e6e66";
        error.innerHTML = "";
        return true;
    }
    if (pwd.value === cpwd.value) {
        // pwd.style.border = "1px solid #5e6e66";
        document.getElementById('cpwd_div').style.color = "#5e6e66";
        error.innerHTML = "";
        return true;
    }
}
