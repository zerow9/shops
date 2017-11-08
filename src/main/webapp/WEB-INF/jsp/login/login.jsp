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
        if(window.top!==window.self){window.top.location=window.location};
    </script>
    <!--验证码修改2-->
    <script src="../../../shopmanagement/js/jquery-1.7.2.min.js" type="text/javascript"></script>
    <script src="../../../shopmanagement/js/drag.js" type="text/javascript"></script>
</head>

<body class="signin">
<div class="signinpanel" style="margin-top:6% ">
    <div class="row" style="padding-bottom: 10%;" >
        <div class="col-sm-5" style="text-align: center;" >
            <form method="post" action="/login.action">
                <h4 class="no-margins">登录</h4>
                <p class="m-t-md">欢迎访问孝和管理后台</p>
                <input type="text" class="form-control uname" placeholder="用户名" name="username"/>
                <input type="password" class="form-control pword m-b" placeholder="密码" name="password"/>
                <div id="drag"></div>
                <div  class="h-h-y">
                <div class="h-h-y-1"><input type="checkbox" name="rememberMe" >记住密码</div>
                <div class="h-h-y-2"><input type="checkbox" name="rememberMe" >自动登录</div>
                </div>
                <button class="btn btn-success btn-block">登录</button>
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
</body>

</html>

</body>
</html>
