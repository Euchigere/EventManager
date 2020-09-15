// validate password
var password = document.getElementById("password")
    , confirm_password = document.getElementById("confirm-password");

function validatePassword(){
    if(password.value != confirm_password.value) {
        confirm_password.setCustomValidity("Passwords Don't Match");
    } else {
        confirm_password.setCustomValidity('');
    }
}

if (password != null && confirm_password != null) {
    password.onchange = validatePassword;
    confirm_password.onkeyup = validatePassword;
}