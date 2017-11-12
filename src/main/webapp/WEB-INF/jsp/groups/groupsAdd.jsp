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
        <label class="layui-form-label">用户组名称</label>
        <div class="layui-input-block">
            <input type="text" name="groupName" lay-verify="group_name" autocomplete="off" placeholder="请输入用户组名称"
                   class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">用户组描述</label>
        <div class="layui-input-block">
            <input type="text" name="groupJurisdiction" lay-verify="group_description" autocomplete="off"
                   placeholder="请输入用户组描述"
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

    <div class="layui-form-item">
        <label class="layui-form-label">权限选择</label>
        <div class="layui-input-block">
            <input type="checkbox" name="add" title="添加">
            <input type="checkbox" name="select" title="查看">
            <input type="checkbox" name="delete" title="删除">
            <input type="checkbox" name="update" title="修改">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">角色</label>
        <div class="layui-input-block">
            <select name="role" lay-filter="aihao">
                <option value=""></option>
                <option value="user">用户组</option>
                <option value="admin" >管理员组</option>
                <option value="service">客观组</option>
            </select>
        </div>
    </div>


    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit="" lay-filter="demo1">添加</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
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

        //监听提交
        form.on('submit(demo1)', function (data) {
            var parm = data.field;

            console.log(parm);
            $.ajax({
                url: 'insertGroups.action',
                data: parm,
                type: 'POST',
                success: function () {
                    var index = parent.layer.getFrameIndex(window.name);
                    parent.layer.close(index);
                    //关闭弹出的窗口
                    parent.layer.msg("添加成功！");
//                    window.location.reload();
                }
            });
            return false;
        });

    });
</script>

</body>
</html>
