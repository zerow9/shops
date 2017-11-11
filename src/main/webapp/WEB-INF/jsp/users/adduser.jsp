<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                        <div class="layui-form-item">
                            <label class="layui-form-label">用户昵称</label>
                            <div class="layui-input-block">
                                <input type="text" name="userNickname" lay-verify="required" autocomplete="off" placeholder="请输入昵称" class="layui-input">
                            </div>
                        </div>

                        <div class="layui-form-item">
                            <label class="layui-form-label">真实姓名</label>
                            <div class="layui-input-block">
                                <input type="text" name="userName" lay-verify="required" placeholder="请输入真实姓名" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <div class="layui-form-item">
                                <label class="layui-form-label">性别</label>
                                <div class="layui-input-block">
                                    <input type="radio" name="userSex" value="男" title="男" checked="">
                                    <input type="radio" name="userSex" value="女" title="女">
                                    <input type="radio" name="userSex" value="保密" title="保密">
                                </div>
                            </div>
                            <div class="layui-form-item">
                                <label class="layui-form-label">健康状况</label>
                                <div class="layui-input-block">
                                    <input type="radio" name="userHealthy" value="健康" title="健康" checked="">
                                    <input type="radio" name="userHealthy" value="不健康" title="不健康">
                                    <input type="radio" name="userHealthy" value="保密" title="保密">
                                </div>
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <div class="layui-form-item">
                                <label class="layui-form-label">请输入密码</label>
                                <div class="layui-input-inline">
                                    <input type="password" name="userPassword" lay-verify="pass" placeholder="请输入密码" autocomplete="off" class="layui-input">
                                </div>
                                <div class="layui-form-mid layui-word-aux">请填写6到12位密码</div>
                            </div>
                            <div class="layui-form-item">
                                <label class="layui-form-label">请确认密码</label>
                                <div class="layui-input-inline">
                                    <input type="password" name="password" lay-verify="pass" placeholder="请再次输入密码" autocomplete="off" class="layui-input">
                                </div>
                                <div class="layui-form-mid layui-word-aux">请填写6到12位密码</div>
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <div class="layui-inline">
                                <label class="layui-form-label">电话号码</label>
                                <div class="layui-input-inline">
                                    <input type="tel" name="userPhone" lay-verify="phone" autocomplete="off" placeholder="请输入电话号码" class="layui-input">
                                </div>
                            </div>
                            <div class="layui-inline">
                                <label class="layui-form-label">验证邮箱</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="userEmail" lay-verify="email" autocomplete="off" class="layui-input">
                                </div>
                            </div>
                            <div class="layui-inline">
                                <label class="layui-form-label">出生日期</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="userBirthDay" id="date" lay-verify="date" placeholder="yyyy-MM-dd" autocomplete="off" class="layui-input">
                                </div>
                            </div>
                        </div>

                        <div class="layui-form-item">
                            <label class="layui-form-label">积分</label>
                            <div class="layui-input-inline">
                                <input type="text" name="userScore" value="0" autocomplete="off" class="layui-input" readonly="readonly">
                            </div>
                        </div>

                        <%--<div class="layui-form-item">--%>
                            <%--<label class="layui-form-label">归属组</label>--%>
                            <%--<div class="layui-input-block">--%>
                                <%--<select name="userGroup" lay-filter="aihao">--%>
                                    <%--<c:forEach items="${groups}" var="groupss" varStatus="s">--%>
                                        <%--<option value="${s.index+1}">${groupss.groupName}</option>--%>
                                    <%--</c:forEach>--%>
                                <%--</select>--%>
                            <%--</div>--%>
                        <%--</div>--%>

                        <%--<div class="layui-form-item" pane="">--%>
                            <%--<label class="layui-form-label">爱好</label>--%>
                            <%--<div class="layui-input-block">--%>
                                <%--<input type="checkbox" name="like1[write]" lay-skin="primary" title="看报">--%>
                                <%--<input type="checkbox" name="like1[read]" lay-skin="primary" title="阅读">--%>
                                <%--<input type="checkbox" name="like1[game]" lay-skin="primary" title="散步">--%>
                                <%--<input type="checkbox" name="like1[hhh]" lay-skin="primary" title="看电视">--%>
                            <%--</div>--%>
                        <%--</div>--%>

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
                    var index = parent.layer.getFrameIndex(window.name);
                    parent.layer.close(index);
                    //关闭弹出的窗口
                    parent.layer.closeAll();
                    swal({
                        title: "太帅了",
                        text: "添加数据成功！",
                        type: "success"
                    })
                    window.parent.location.reload();
                }
            });
            return false;
        });

    });
</script>
</body>

</html>