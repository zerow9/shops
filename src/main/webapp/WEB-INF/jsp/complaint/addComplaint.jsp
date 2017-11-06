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

                        <div class="layui-form-item">
                            <label class="layui-form-label">投诉人</label>
                            <div class="layui-input-block">
                                <input type="text" name="accuserId" lay-verify="required" autocomplete="off"
                                       placeholder="请输入投诉人ID" class="layui-input">
                            </div>
                        </div>

                        <div class="layui-form-item">
                            <div class="layui-inline">
                                <label class="layui-form-label">被投诉人</label>
                                <div class="layui-input-inline">
                                    <input type="text" lay-verify="required" placeholder="被投诉人的ID" name="accusedId"
                                           autocomplete="off" class="layui-input">
                                </div>
                            </div>
                            <div class="layui-form-item">
                                <label class="layui-form-label">投诉标题</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="complaintTittle" lay-verify="required" autocomplete="off"
                                           class="layui-input">
                                </div>
                            </div>
                        </div>
                        <div class="layui-inline">
                            <label class="layui-form-label">投诉内容</label>
                            <div class="layui-input-inline">
                                <input type="text" name="complaintContent" lay-verify="required" autocomplete="off"
                                       class="layui-input">
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label"></label>
                            <div class="layui-input-inline">
                            </div>
                        </div>

                        <div class="layui-form-item">
                            <div class="layui-input-block">
                                <button class="layui-btn" lay-submit="" lay-filter="democ">立即提交</button>
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
<script type="application/javascript">
    layui.use(['form'], function () {
        var $ = layui.$;
        var form = layui.form;
        form.on('submit(democ)', function (data) {
            var parm = data.field;
            $.ajax({
                url: 'insertComplaint.action',
                type:'POST',
                data: parm,
                success: function () {
                    parent.layer.closeAll();
                    swal({
                        title: "太帅了",
                        text: "修改数据成功！",
                        type: "success"
                    });
                    window.location.reload();
                }
            });
            return false;
        });
    });
</script>
</body>
