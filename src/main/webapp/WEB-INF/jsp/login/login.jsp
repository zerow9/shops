<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>

<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">

    <title>登录孝和管理商城后台</title>
    <link href="../../../shopmanagement/css/xhbootstrap.min.css" rel="stylesheet">
    <link href="../../../shopmanagement/css/font-awesome.min.css?v=4.4.0" rel="stylesheet">
    <link href="../../../shopmanagement/css/animate.min.css" rel="stylesheet">
    <link href="../../../shopmanagement/css/style.min.css" rel="stylesheet">
    <link href="../../../shopmanagement/css/login.min.css" rel="stylesheet">
</head>

<body class="signin">
<div class="signinpanel">
    <div class="row" style="margin: auto;">
        <div class="col-sm-5" style="text-align: center;">
            <form method="post" action="/login.action">
                <h4 class="no-margins">登录：</h4>
                <p class="m-t-md">欢迎访问孝和管理后台</p>
                <input type="text" class="form-control uname" placeholder="用户名" name="username"/>
                <input type="password" class="form-control pword m-b" placeholder="密码" name="password"/>
                <span style="float:right; width:45%;"><img src="../../../shopmanagement/img/code.jpg"
                                                           height="34"/></span>
                <input type="text" class="form-control pword m-b" placeholder="验证码" style="width:50%; "/>
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
</body>

</html>
