<%--
  Created by IntelliJ IDEA.
  User: 63465
  Date: 2017/11/2 0002
  Time: 17:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>layui</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="//res.layui.com/layui/dist/css/layui.css" media="all">
    <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<body>

<fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
    <legend>引用区块 - 默认风格</legend>
</fieldset>

<blockquote class="layui-elem-quote">这个貌似不用多介绍，因为你已经在太多的地方都看到</blockquote>

<fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
    <legend>引用区块 - 一般风格</legend>
</fieldset>

<blockquote class="layui-elem-quote layui-quote-nm">
    猿强，则国强。国强，则猿更强！
    <br>——孟子（好囖。。其实这特喵的是我说的）
</blockquote>

<fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
    <legend>字段集区块</legend>
</fieldset>

<fieldset class="layui-elem-field">
    <legend>爱好</legend>
    <div class="layui-field-box">
        你可以在这里放任何内容，比如表单神马的
    </div>
</fieldset>
<br>
<fieldset class="layui-elem-field layui-field-title">
    <legend>带标题的横线</legend>
</fieldset>

内容区域

<fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
    <legend>分割线</legend>
</fieldset>

默认分割线
<hr>

赤色分割线
<hr class="layui-bg-red">

橙色分割线
<hr class="layui-bg-orange">

墨绿分割线
<hr class="layui-bg-green">

青色分割线
<hr class="layui-bg-cyan">

蓝色分割线
<hr class="layui-bg-blue">

黑色分割线
<hr class="layui-bg-black">

灰色分割线
<hr class="layui-bg-gray">

<fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
    <legend>纯圆角</legend>
</fieldset>

<div class="layui-inline">
    <img src="http://cdn.layui.com/avatar/168.jpg?t=1490352249902" class="layui-circle">
</div>


<script src="//res.layui.com/layui/dist/layui.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
</body>
</html>
