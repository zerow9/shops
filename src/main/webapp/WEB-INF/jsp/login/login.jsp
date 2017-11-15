<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">

    <title>登录孝和管理商城后台</title>
    <link href="../../../shopmanagement/css/xhbootstrap.min.css" rel="stylesheet">
    <link href="../../../shopmanagement/css/font-awesome.min.css?v=4.4.0" rel="stylesheet">
    <link href="../../../shopmanagement/css/animate.min.css" rel="stylesheet">
    <link href="../../../shopmanagement/css/style.min.css" rel="stylesheet">
    <link href="../../../shopmanagement/css/login.min.css" rel="stylesheet">
    <!--[if lt IE 8]>
    <meta http-equiv="refresh" content="0;ie.html" />
    <!--验证码修改1-->
    <link href="../../../shopmanagement/css/drag.css" rel="stylesheet" type="text/css"/>
    <![endif]-->
    <script>
        if (window.top !== window.self) {
            window.top.location = window.location;
        }
    </script>
    <!--验证码修改2-->
    <script src="../../../shopmanagement/js/jquery-1.7.2.min.js" type="text/javascript"></script>
    <script src="../../../shopmanagement/js/drag.js" type="text/javascript"></script>
</head>

<body class="signin">
<div class="signinpanel" style="margin-top:6% ">
    <div class="row" style="padding-bottom: 10%;">
        <div class="col-sm-5" style="text-align: center;">
            <form method="post" name="form" action="/login.action" onsubmit="return ">
                <h4 class="no-margins">登录</h4>
                <p class="m-t-md">欢迎访问孝和管理后台</p>
                <div id="errorMassage"></div>
                <input type="text" class="form-control uname" id="username" placeholder="用户名" name="username"
                       onblur="checkUserName(this.value)"/>
                <input type="password" class="form-control pword m-b" id="password" placeholder="密码" name="password"
                       onblur="checkPassword(this.value)"/>
                <div id="drag"></div>
                <div class="h-h-y">
                    <div class="h-h-y-1"><input type="checkbox" name="rememberMe">记住密码</div>
                    <div class="h-h-y-2"><input type="checkbox" name="rememberMe">自动登录</div>
                </div>
                <input type="button" class="btn btn-success btn-block" value="登  录" id="btn" onclick="clickButton()">
            </form>
        </div>
    </div>
    <div class="signup-footer">
        <div class="xh-pull-left">
            &copy; 2017年11月01日 All Rights Reserved. YangCoding
        </div>
    </div>
</div>

<!--验证码js-->
<script type="text/javascript">
    $('#drag').drag();
</script>
<!--输入帐号密码后才能登录-->
<script type="text/javascript">
    function checkUserName(username) {
        //判断空
        if (username.length == 0) {
            // alert(username);
            document.getElementById("errorMassage").innerHTML = "<font color='red'>请输入帐号！</font>";
            document.form.username.focus();
            return false;
        }
        //判断长度
        if (username.length < 3 || username.length > 8) {
            document.getElementById("errorMassage").innerHTML = "<font color='red'>帐号长度为3-8位</font>";
            document.form.username.focus();
            return false;
        }
        document.getElementById("errorMassage").innerHTML = "";
        return true;
    }

    function checkPassword(pwd) {
        if (pwd.length == 0) {
            document.getElementById("errorMassage").innerHTML = "<font color='red'>请输入密码！</font>";
            document.form.password.focus();
            return false;
        }
        if (pwd.length < 3 || pwd.length > 8) {
            document.getElementById("errorMassage").innerHTML = "<font color='red'>密码长度为3-8位</font>";
            document.form.password.focus();
            return false;
        }
        document.getElementById("errorMassage").innerHTML = "";
        return true;
    }

    function clickButton() {
        var input = document.getElementById("btn");
        var username = document.getElementById("username").value;
        var password = document.getElementById("password").value;
        var button = input.attributes["type"].value;
        if (username.length == 0) {
            document.getElementById("errorMassage").innerHTML = "<font color='red'>请输入帐号！</font>";
            document.form.username.focus();
            return false;
        }

        if (password.length == 0) {
            document.getElementById("errorMassage").innerHTML = "<font color='red'>请输入密码！</font>";
            document.form.password.focus();
            return false;
        }
        if (button == 'button')
            document.getElementById("errorMassage").innerHTML = "<font color='red'>请拖动滑块验证！</font>";

    }
</script>

</body>

</html>

</body>
</html>
