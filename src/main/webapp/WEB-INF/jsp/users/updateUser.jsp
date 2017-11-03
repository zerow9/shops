<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/sql" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>修改用户</title>

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
                        <div class="layui-form-item">
                            <label class="layui-form-label">用户昵称</label>
                            <div class="layui-input-block">
                                <input type="text" name="userNickname" lay-verify="required" autocomplete="off"
                                       placeholder="请输入昵称" class="layui-input" value="${user.userNickname}">
                            </div>
                        </div>

                        <div class="layui-form-item">
                            <label class="layui-form-label">真实姓名</label>
                            <div class="layui-input-block">
                                <input type="text" name="userName" lay-verify="required"
                                       placeholder="请输入真实姓名" autocomplete="off" class="layui-input"
                                       value="${user.userName}">
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <div class="layui-form-item">
                                <label class="layui-form-label">性别</label>
                                <div class="layui-input-block">
                                    <input type="radio" name="userSex" title="男" value="男"
                                           <c:if test="${user.userSex== '男'}">checked="checked"</c:if>>
                                    <input type="radio" name="userSex" title="女" value="女"
                                           <c:if test="${user.userSex== '女'}">checked="checked"</c:if>>
                                    <input type="radio" name="userSex" title="保密" value="保密"
                                           <c:if test="${user.userSex== '保密'}">checked="checked"</c:if>>
                                </div>
                            </div>
                            <div class="layui-form-item">
                                <label class="layui-form-label" >健康状况</label>
                                <div class="layui-input-block">
                                    <input type="radio" name="userHealthy" title="健康" value="健康"
                                           <c:if test="${user.userHealthy== '健康'}">checked="checked"</c:if>>
                                    <input type="radio" name="userHealthy" title="亚健康" value="亚健康"
                                           <c:if test="${user.userHealthy== '亚健康'}">checked="checked"</c:if>>
                                    <input type="radio" name="userHealthy" title="不健康" value="不健康"
                                           <c:if test="${user.userHealthy== '不健康'}">checked="checked"</c:if>>
                                    <input type="radio" name="userHealthy" title="保密" value="保密"
                                           <c:if test="${user.userHealthy== '保密'}">checked="checked"</c:if>>
                                </div>
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <div class="layui-form-item">
                                <label class="layui-form-label">请输入密码</label>
                                <div class="layui-input-inline">
                                    <input type="password" name="userPassword" lay-verify="pass" placeholder="请输入密码"
                                           autocomplete="off" class="layui-input" value="${user.userPassword}">
                                </div>
                                <div class="layui-form-mid layui-word-aux">请填写6到12位密码</div>
                            </div>
                            <div class="layui-form-item">
                                <label class="layui-form-label">请确认密码</label>
                                <div class="layui-input-inline">
                                    <input type="password" name="password" lay-verify="pass" placeholder="请再次输入密码"
                                           autocomplete="off" class="layui-input" value="${user.userPassword}">
                                </div>
                                <div class="layui-form-mid layui-word-aux">请填写6到12位密码</div>
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <div class="layui-inline">
                                <label class="layui-form-label">电话号码</label>
                                <div class="layui-input-inline">
                                    <input type="tel" name="userPhone" lay-verify="phone" autocomplete="off" placeholder="请输入电话号码"
                                           class="layui-input" value="${user.userPhone}">
                                </div>
                            </div>
                            <div class="layui-inline">
                                <label class="layui-form-label">验证邮箱</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="userEmail" lay-verify="email" autocomplete="off"
                                           class="layui-input" value="${user.userEmail}">
                                </div>
                            </div>
                        </div>

                        <div class="layui-form-item">
                            <div class="layui-inline">
                                <label class="layui-form-label">年龄</label>
                                <div class="layui-input-inline">
                                    <input type="tel" name="userAge" lay-verify="phone" autocomplete="off"
                                           placeholder="请输入年龄" class="layui-input" value="${user.userAge}">
                                </div>
                            </div>
                            <div class="layui-inline">
                                <label class="layui-form-label">注册日期</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="userRegisterDateTime" lay-verify="email" readonly autocomplete="off"
                                           class="layui-input" value="${user.dateToString}">
                                </div>
                            </div>
                        </div>

                        <div class="layui-form-item">
                            <div class="layui-inline">
                                <label class="layui-form-label">积分</label>
                                <div class="layui-input-inline">
                                    <input type="tel" name="userScore" lay-verify="phone" autocomplete="off" class="layui-input"
                                           value="${user.userScore}">
                                </div>
                            </div>
                        </div>

                        <div class="layui-form-item">
                            <label class="layui-form-label">归属组</label>
                            <div class="layui-input-block">
                                <select name="userGroup" lay-filter="aihao">
                                    <option value=""></option>
                                    <option value="0" selected="">普通用户组</option>
                                    <option value="1">商家组</option>
                                    <option value="2">管理员组</option>
                                </select>
                            </div>
                        </div>

                        <div class="layui-form-item">
                            <label class="layui-form-label">地址</label>
                            <div class="layui-input-block">
                                <input type="text" name="userAddress" lay-verify="required" placeholder="请输入地址"
                                       autocomplete="off" class="layui-input" value="${user.userAddress}">
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

<script src="../../../shopmanagement/common/layui/layui.all.js" charset="utf-8" type="text/javascript"></script>
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
            $.ajax({
                url: 'insertUser.action',
                data: parm,
                type:'POST',
                success: function () {
                    //关闭弹出的窗口
                    parent.layer.closeAll();
                    swal({
                        title: "太帅了",
                        text: "添加数据成功！",
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

</html>