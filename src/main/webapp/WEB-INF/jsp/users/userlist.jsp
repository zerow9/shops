<%--
  Created by IntelliJ IDEA.
  User: TongZhou
  Date: 2017/11/1
  Time: 13:44
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
    <link rel="shortcut icon" href="../../../favicon.ico">
    <link href="../../../shopmanagement/common/font-awesome-4.7.0/css/font-awesome.css" rel="stylesheet">
    <link href="../../../shopmanagement/css/style.min.css?v=4.0.0" rel="stylesheet">
    <link href="../../../shopmanagement/css/plugins/sweetalert/sweetalert.css" rel="stylesheet">
    <link href="../../../common/layui/css/layui.css" rel="stylesheet">
    <link href="../../../css/module/my_layui.css" rel="stylesheet">
    <link href="../../../css/useQuery.css" rel="stylesheet">
    <link href="../../../css/find.css" rel="stylesheet">
</head>

<body>

<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <jsp:include page="../find/userfind.jsp"/>
                <div class="ibox-title">
                    <h5>用户列表</h5>
                    <div class="ibox-tools">
                        <%--最大最小化按钮--%>
                        <a class="collapse-link">
                            <i class="fa fa-chevron-up"></i>
                        </a>
                        <%--自定义操作--%>
                        <a class="dropdown-toggle" data-toggle="dropdown">
                            <i class="fa fa-wrench"></i>
                        </a>
                        <%--关闭按钮--%>
                        <a class="close-link">
                            <i class="fa fa-times"></i>
                        </a>
                    </div>
                </div>

                <div class="ibox-content">
                    <div class="layui-btn-group demoTable">
                        <button class="layui-btn" data-type="getCheckLength">批量删除</button>
                        <button class="layui-btn" data-type="isAll">验证是否全选</button>
                        <button class="layui-btn" data-type="addUser">添加用户</button>
                        <button class="layui-btn" data-type="askQuery">条件筛选</button>
                    </div>
                    <div class="table-responsive">
                        <table class="layui-table"
                               lay-data="{url:'<%=basePath%>admin/getUserJson.action', page:true, id:'userUuid'}"
                               lay-filter="demo">
                            <thead>
                            <tr>
                                <th lay-data="{checkbox:true, fixed: true}"></th>
                                <th lay-data="{field:'userUuid', width:80, sort: true, fixed: true}">ID</th>
                                <th lay-data="{field:'userName', width:80}">用户名</th>
                                <th lay-data="{field:'userSex', width:80, sort: true}">性别</th>
                                <th lay-data="{field:'userAge', width:80}">年龄</th>
                                <th lay-data="{field:'userRegisterDateTime', width:177}">注册日期</th>
                                <th lay-data="{field:'userScore', width:80, sort: true}">积分</th>
                                <th lay-data="{field:'userAddress', width:80}">地址</th>
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
    <a class="layui-btn layui-btn-primary layui-btn-mini" lay-event="detail"><i class="fa fa-eye" aria-hidden="true"
                                                                                title="查看"></i></a>
    <a class="layui-btn layui-btn-mini" lay-event="edit"><i class="fa fa-edit" aria-hidden="true" title="编辑"></i></a>
    <a class="layui-btn layui-btn-danger layui-btn-mini" lay-event="del"><i class="fa fa-trash" aria-hidden="true"
                                                                            title="删除"></i></a>
</script>

<script src="../../../js/extends/jquery/jquery.min.js"></script>
<script src="../../../js/extends/bootstrap/bootstrap.js"></script>
<script src="../../../shopmanagement/js/content.min.js"></script>
<script src="../../../common/layui/layui.js"></script>
<script src="../../../shopmanagement/js/plugins/sweetalert/sweetalert.min.js"></script>
<script src="../../../js/users/userlist.js"></script>
<script src="../../../js/find/findUser.js"></script>
</body>

</html>
