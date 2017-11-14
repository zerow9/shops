function checkUserName(username) {
    //判断空
    if (username.length == 0) {
        // alert(username);
        document.getElementById("usernameErr1").innerHTML = "<font color='red'>请输入帐号！</font>";
        document.form.username.focus();
        return false;
    }
    //判断长度
    if (username.length < 3 || username.length > 8) {
        document.getElementById("usernameErr1").innerHTML = "<font color='red'>帐号长度为3-8位</font>";
        document.form.username.focus();
        return false;
    }
    document.getElementById("usernameErr1").innerHTML = "";
    return true;
}

function checkPassword(pwd) {
    if (pwd.length == 0) {
        document.getElementById("usernameErr1").innerHTML = "<font color='red'>请输入密码！</font>";
        document.form.password.focus();
        return false;
    }
    if (pwd.length < 3 || pwd.length > 8) {
        document.getElementById("usernameErr1").innerHTML = "<font color='red'>密码长度为3-8位</font>";
        document.form.password.focus();
        return false;
    }
    document.getElementById("usernameErr1").innerHTML = "";
    return true;
}

