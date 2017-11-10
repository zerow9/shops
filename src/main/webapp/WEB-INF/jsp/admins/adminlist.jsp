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
    <link rel="shortcut icon" href="../../../shopmanagement/favicon.ico">

    <link href="../../../shopmanagement/common/font-awesome-4.7.0/css/font-awesome.css" rel="stylesheet">
    <link href="../../../shopmanagement/css/style.min.css?v=4.0.0" rel="stylesheet">
    <link href="../../../shopmanagement/css/plugins/sweetalert/sweetalert.css" rel="stylesheet">
    <link href="../../../common/layui/css/layui.css" rel="stylesheet">
    <link href="../../../css/module/my_layui.css" rel="stylesheet">

</head>

<body>
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">

                <blockquote class="layui-elem-quote">
                    <h2>操作提示</h2>
                    在这里，你可以增删改查管理员。
                </blockquote>

                <div class="ibox-title">
                    <h5>管理员列表</h5>
                    <div class="ibox-tools">
                        <a class="collapse-link">
                            <i class="fa fa-chevron-up"></i>
                        </a>
                        <a class="dropdown-toggle" data-toggle="dropdown">
                            <i class="fa fa-wrench"></i>
                        </a>
                        <a class="close-link">
                            <i class="fa fa-times"></i>
                        </a>
                    </div>
                </div>
                <div class="ibox-content">
                    <div class="row">
                        <div class="col-sm-3">
                            <div class="input-group">
                            </div>
                        </div>
                    </div>
                    <div class="layui-btn-group demoTable">
                        <button class="layui-btn" data-type="getCheckLength">批量删除</button>
                        <button class="layui-btn" data-type="isAll">全选</button>
                        <button class="layui-btn" data-type="addUser">添加管理员</button>
                    </div>
                    <div class="table-responsive">
                        <table class="layui-table"
                               lay-data="{ url:'<%=basePath%>admin/getAdminAll.action', page:true, id:'adminId'}"
                               lay-filter="demo">
                            <thead>
                            <tr>
                                <th lay-data="{checkbox:true, fixed: true}"></th>
                                <th lay-data="{field:'adminId', width:100, sort: true, fixed: true}">管理员编号</th>
                                <th lay-data="{field:'adminAccount', width:100}">账号</th>
                                <th lay-data="{field:'adminPhone', width:150}">电话号码</th>
                                <th lay-data="{field:'adminEmail', width:200}">邮箱</th>
                                <th lay-data="{field:'adminRegisterTime', width:300, sort: true}">注册时间</th>
                                <th lay-data="{fixed: 'right', width:200, align:'center', toolbar: '#barDemo'}">操作</th>
                            </tr>
                            </thead>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-primary layui-btn-mini" lay-event="detail"><i class="fa fa-eye" aria-hidden="true"
                                                                                title="查看"></i></a>
    <a class="layui-btn layui-btn-mini" lay-event="edit"><i class="fa fa-edit" aria-hidden="true" title="编辑"></i></a>
    <a class="layui-btn layui-btn-danger layui-btn-mini" lay-event="del"><i class="fa fa-trash" aria-hidden="true"
                                                                            title="删除"></i></a>
</script>

<script src="../../../js/extends/jquery/jquery.min.js"></script>
<script src="../../../js/extends/bootstrap/bootstrap.js"></script>
<script src="../../../shopmanagement/js/content.min.js"></script>
<script src="../../../shopmanagement/common/layui/layui.js"></script>
<script src="../../../shopmanagement/js/plugins/sweetalert/sweetalert.min.js"></script>
<script src="../../../js/admins/adminlist.js"></script>
</body>

</html>
