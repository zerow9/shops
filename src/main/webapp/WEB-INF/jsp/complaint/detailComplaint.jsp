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

    <title>查看用户</title>

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
                            <label class="layui-form-label">ID</label>
                            <div class="layui-input-block">
                                <input type="text" name="adminAccount" lay-verify="required" autocomplete="off"
                                       placeholder="请输入账号" class="layui-input" value="${complaint.complaintId}" readonly>
                            </div>
                        </div>

                        <div class="layui-form-item">
                            <label class="layui-form-label">投诉人</label>
                            <div class="layui-input-block">
                                <input type="text" name="adminAccount" lay-verify="required" autocomplete="off"
                                       placeholder="请输入账号" class="layui-input" value="${complaint.accuserId}" readonly>
                            </div>
                        </div>

                        <div class="layui-form-item">
                            <div class="layui-inline">
                                <label class="layui-form-label">被投诉人</label>
                                <div class="layui-input-inline">
                                    <input type="tel" name="adminPhone" lay-verify="phone" autocomplete="off" readonly
                                           class="layui-input" value="${complaint.accusedId}">
                                </div>
                            </div>
                            <div class="layui-inline">
                                <label class="layui-form-label">投诉标题</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="adminEmail" lay-verify="email" autocomplete="off"
                                           class="layui-input" value="${complaint.complaintTittle}" readonly>
                                </div>
                            </div>
                        </div>
                        <div class="layui-inline">
                            <label class="layui-form-label">投诉内容</label>
                            <div class="layui-input-inline">
                                <input type="text" name="adminEmail" lay-verify="email" autocomplete="off"
                                       class="layui-input" value="${complaint.complaintContent}" readonly>
                            </div>
                        </div>
                </div>

                        <div class="layui-form-item">
                            <label class="layui-form-label">投诉时间</label>
                            <div class="layui-input-block">
                                <input type="text" name="adminRegisterTime1"  autocomplete="off"
                                       class="layui-input" value="${complaint.dateToString}" readonly>
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
<script src="../../../js/admins/updateadmin.js"></script>
</body>
