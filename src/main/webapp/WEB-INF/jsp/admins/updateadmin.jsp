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
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>添加用户</title>

    <link rel="shortcut icon" href="../../../shopmanagement/favicon.ico">
    <link href="../../../shopmanagement/common/font-awesome-4.7.0/css/font-awesome.css" rel="stylesheet">
    <link href="../../../shopmanagement/css/style.min.css?v=4.0.0" rel="stylesheet">
    <link href="../../../shopmanagement/css/plugins/sweetalert/sweetalert.css" rel="stylesheet">
    <link href="../../../shopmanagement/common/layui/css/layui.css" rel="stylesheet"/>
    <base target="_blank">

</head>

<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">

                <div class="ibox-content">
                    <form class="layui-form" action="">


                        <input type="hidden" name="adminId" value="${admin.adminId}"/>

                        <div class="layui-form-item">
                            <label class="layui-form-label">账号</label>
                            <div class="layui-input-block">
                                <input type="text" name="adminAccount" lay-verify="required" autocomplete="off"
                                       placeholder="请输入账号" class="layui-input" value="${admin.adminAccount}">
                            </div>
                        </div>

                        <div class="layui-form-item">
                            <div class="layui-form-item">
                                <label class="layui-form-label">请输入密码</label>
                                <div class="layui-input-inline">
                                    <input type="password" name="adminPassword" lay-verify="pass" placeholder="请输入密码"
                                           value="${admin.adminPassword}" autocomplete="off"
                                           class="layui-input password">
                                </div>
                            </div>
                            <div class="layui-form-item">
                                <label class="layui-form-label">请确认密码</label>
                                <div class="layui-input-inline">
                                    <input type="password" name="password" lay-verify="chackpass" placeholder="请再次输入密码"
                                           autocomplete="off" class="layui-input" value="${admin.adminPassword}">
                                </div>
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <div class="layui-inline">
                                <label class="layui-form-label">电话号码</label>
                                <div class="layui-input-inline">
                                    <input type="tel" name="adminPhone" lay-verify="phone" autocomplete="off"
                                           placeholder="请输入电话号码" class="layui-input" value="${admin.adminPhone}">
                                </div>
                            </div>
                            <div class="layui-inline">
                                <label class="layui-form-label">验证邮箱</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="adminEmail" lay-verify="email" autocomplete="off"
                                           class="layui-input" value="${admin.adminEmail}">
                                </div>
                            </div>
                        </div>

                        <div class="layui-form-item">
                            <label class="layui-form-label">归属组</label>
                            <div class="layui-input-inline">
                                <select name="groupId" lay-filter="aihao">
                                    <option value=""></option>
                                    <option value="3" selected="">普通用户组</option>
                                    <option value="1">商家组</option>
                                    <option value="2">管理员组</option>
                                </select>
                            </div>
                        </div>

                        <div class="layui-form-item">
                            <label class="layui-form-label">注册时间</label>
                            <div class="layui-input-block">
                                <input type="text" name="adminRegisterTime1"  autocomplete="off"
                                       class="layui-input" value="${admin.dateToString}" readonly>
                            </div>
                        </div>


                        <div class="layui-form-item">
                            <div class="layui-input-block">
                                <button class="layui-btn" lay-submit="" lay-filter="demo1">立即提交</button>
                                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                            </div>
                        </div>

                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="../../../shopmanagement/common/layui/layui.js" charset="utf-8" type="text/javascript"></script>
<script src="../../../shopmanagement/js/plugins/sweetalert/sweetalert.min.js"></script>
<script>
    layui.use(['form', 'layedit', 'laydate'], function () {
        var form = layui.form,
            layer = layui.layer,
            layedit = layui.layedit,
            laydate = layui.laydate;

        //定义JQuery
        var $ = layui.$;

        //日期
        laydate.render({
            elem: '#date'
        });
        laydate.render({
            elem: '#date1'
        });

        //自定义验证规则
        form.verify({
            title: function (value) {
                if (value.length < 5) {
                    return '标题至少得5个字符啊';
                }
            },
            pass: [/(.+){6,12}$/, '密码必须6到12位'],
            content: function (value) {
                layedit.sync(editIndex);
            },
            chackpass:function (value) {
                //验证密码
                var passdata=$(".password").val();
                if(value!=passdata){
                    return "密码输入不一致，请重新输入！"
                }


            }
        });


        //监听提交
        form.on('submit(demo1)', function (data) {
            var parm = data.field;

//            alert(parm);
            $.ajax({
                url: 'updateAdminByPrimaryKey.action',
                data: parm,
                success: function () {
                    //关闭弹出的窗口
                    parent.layer.closeAll();
                    swal({
                        title: "太帅了",
                        text: "修改数据成功！",
                        type: "success"
                    });
                    window.parent.location.reload();
                }
            });
            return false;
        });

    });
</script>
</body>
