<%--
  Created by IntelliJ IDEA.
  User: 63465
  Date: 2017/11/2 0002
  Time: 10:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset="utf-8">
    <title>layui</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="../../../common/layui/css/layui.css" media="all">
</head>

<body>

<form class="layui-form" action="">

    <div class="layui-form-item">
        <label class="layui-form-label">用户组ID</label>
        <div class="layui-input-block">
            <input type="text" name="groupName" lay-verify="group_name" autocomplete="off" value="${groups.groupId}" readonly
                   class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">用户组名称</label>
        <div class="layui-input-block">
            <input type="text" name="groupName" lay-verify="group_name" autocomplete="off" value="${groups.groupName}" readonly
                   class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">用户组描述</label>
        <div class="layui-input-block">
            <input type="text" name="groupJurisdiction" lay-verify="group_description" autocomplete="off"
                   value="${groups.groupJurisdiction}" readonly
                   class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">是否启用</label>
        <div class="layui-input-block">
            <input type="checkbox" checked="" name="group_status" lay-skin="switch"
                   lay-filter="switch" lay-text="启用|禁用">
        </div>
    </div>
</form>

<script src="../../../js/extends/jquery/jquery.min.js"></script>
<script src="../../../common/layui/layui.js" charset="utf-8"></script>
<script>
    layui.use(['form'], function () {
        var form = layui.form
            , layer = layui.layer;
        var $ = layui.$;
        //监听指定开关
        form.on('switch(switch)', function (data) {
            layer.tips((this.checked ? '启用' : '禁用') + "组", data.othis)
        });

    });
</script>

</body>
</html>
