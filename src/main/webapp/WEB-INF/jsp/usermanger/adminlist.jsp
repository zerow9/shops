<%--
  Created by IntelliJ IDEA.
  User: TongZhou
  Date: 2017/11/1
  Time: 9:47
  To change this template use File | Settings | File Templates.
--%>
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
    <link href="../../../shopmanagement/common/layui/css/layui.css" rel="stylesheet" />
</head>

<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
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
                        <button class="layui-btn" data-type="getCheckData">获取选中行数据</button>
                        <button class="layui-btn" data-type="getCheckLength">获取选中数目</button>
                        <button class="layui-btn" data-type="isAll">验证是否全选</button>
                        <button class="layui-btn" data-type="addUser">添加管理员方法1</button>
                        <button class="layui-btn" data-type="addUser1">添加管理员方法2</button>
                    </div>
                    <div class="table-responsive">
                        <table class="layui-table" lay-data="{width: 900, height:332, url:'<%=basePath%>admin/getAdminAll.action', page:true, id:'adminId'}" lay-filter="demo">
                            <thead>
                            <tr>
                                <th lay-data="{checkbox:true, fixed: true}"></th>
                                <th lay-data="{field:'adminId', width:80, sort: true, fixed: true}">用户编号</th>
                                <th lay-data="{field:'adminAccount', width:80}">账号</th>
                                <th lay-data="{field:'adminPassword', width:80, sort: true}">密码</th>
                                <th lay-data="{field:'adminPhone', width:80}">电话号码</th>
                                <th lay-data="{field:'adminEmail', width:177}">邮箱</th>
                                <th lay-data="{field:'adminRegisterTime', width:80, sort: true}">注册时间</th>
                                <th lay-data="{field:'groupId', width:80}">分配规则组</th>
                                <th lay-data="{fixed: 'right', width:180, align:'center', toolbar: '#barDemo'}">操作</th>
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
    <a class="layui-btn layui-btn-primary layui-btn-mini" lay-event="detail"><i class="fa fa-eye" aria-hidden="true" title="查看"></i></a>
    <a class="layui-btn layui-btn-mini" lay-event="edit"><i class="fa fa-edit" aria-hidden="true" title="编辑"></i></a>
    <a class="layui-btn layui-btn-danger layui-btn-mini" lay-event="del"><i class="fa fa-trash" aria-hidden="true" title="删除"></i></a>
</script>
<script src="../../../shopmanagement/common/layui/layui.js" charset="utf-8" type="text/javascript"></script>
<script src="../../../shopmanagement/js/plugins/sweetalert/sweetalert.min.js"></script>
<script src="../../../js/adminlist.js"></script>

</body>

</html>
