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
    <title>厂商列表</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

    <link href="../../../shopmanagement/common/font-awesome-4.7.0/css/font-awesome.css" rel="stylesheet">
    <link href="../../../shopmanagement/css/style.min.css?v=4.0.0" rel="stylesheet">
    <link href="../../../shopmanagement/css/plugins/sweetalert/sweetalert.css" rel="stylesheet">
    <link href="../../../common/layui/css/layui.css" rel="stylesheet">
    <link href="../../../css/module/my_layui.css" rel="stylesheet">

</head>

<body>

<div class="wrapper wrapper-content animated fadeInRight">

    <div class="row">

        <div class="layui-col-sm12">

            <div class="ibox float-e-margins">

                <blockquote class="layui-elem-quote">
                    <h2>操作提示</h2>
                    在这里，你可以查看信息。
                </blockquote>

                <div class="ibox-title">
                    <h5>日志信息记录</h5>
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

                    <div class="ibox-content">

                        <div class="table-responsive">

                            <table class="layui-table" lay-data="{url:'getLogs.action', page:true, id:'logId'}"
                                   lay-filter="demo">
                                <thead>
                                <tr>
                                    <th lay-data="{field:'logId', width:80, fixed: true}">编号</th>
                                    <th lay-data="{field:'userUuid', width:100}">用户ID</th>
                                    <th lay-data="{field:'logHistoryIp', width:200}">登陆IP</th>
                                    <th lay-data="{field:'logLandTime', width:200}">登陆时间</th>
                                    <th lay-data="{field:'logSpace', width:200}">间隔时间</th>
                                    <th lay-data="{field:'logWeighting', width:200}">加权时间</th>
                                    <th lay-data="{field:'itemStatus', width:200}">商品状态码</th>
                                    <th lay-data="{field:'itemTypeStatus', width:100,}">商品类型</th>
                                    <th lay-data="{field:'logKeyWord', width:100,}">搜索关键词</th>
                                    <th lay-data="{fixed: 'right', width:80, align:'center', toolbar: '#operate_bar'}">
                                        操作
                                    </th>
                                </tr>
                                </thead>
                            </table>

                    </div>

                    </div>
                </div>

            </div>
        </div>
    </div>
</div>

<script type="text/html" id="operate_bar">
    <a class="layui-btn layui-btn-primary layui-btn-mini" lay-event="detail"><i class="fa fa-eye" aria-hidden="true"
                                                                                title="查看"></i></a>
</script>

<script src="../../../js/extends/jquery/jquery.min.js"></script>
<script src="../../../js/extends/bootstrap/bootstrap.js"></script>
<script src="../../../shopmanagement/js/content.min.js"></script>
<script src="../../../common/layui/layui.js"></script>
<script src="../../../shopmanagement/js/plugins/sweetalert/sweetalert.min.js"></script>
<script src="../../../js/logs/listlog.js"></script>

</body>
</html>
