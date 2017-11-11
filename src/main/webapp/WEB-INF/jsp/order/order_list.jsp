<%--
  Created by IntelliJ IDEA.
  User: 63465
  Date: 2017/11/6 0006
  Time: 16:00
  To change this template use File | Settings | File Templates.
--%>
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
    <title>layui</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

    <link rel="stylesheet" href="../../../shopmanagement/css/bootstrap.min.css" media="all">
    <link href="../../../shopmanagement/common/font-awesome-4.7.0/css/font-awesome.css" rel="stylesheet">
    <link href="../../../shopmanagement/css/style.min.css?v=4.0.0" rel="stylesheet">
    <link href="../../../shopmanagement/css/plugins/sweetalert/sweetalert.css" rel="stylesheet">
    <link href="../../../common/layui/css/layui.css" rel="stylesheet">
    <link href="../../../css/extends/jquery/jquery.loading.css" rel="stylesheet">
    <link href="../../../css/module/my_layui.css" rel="stylesheet">
</head>

<body>

<div class="row">
    <div class="layui-col-sm12">
        <div class="ibox float-e-margins">

            <div class="ibox-title">
                <h5>订单列表</h5>
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

                    <div class="layui-btn-group demoTable">
                        <button id="delete_orders_btn" class="layui-btn">删除订单</button>
                    </div>

                    <div class="table-responsive">
                        <table id="layui_table" lay-filter="demo">
                            <%--<thead>--%>
                            <%--<tr>--%>
                            <%--<th lay-data="{checkbox:true, fixed: true}"></th>--%>
                            <%--<th lay-data="{field:'order_id', width:100, sort: true, fixed: true}">订单编号</th>--%>
                            <%--<th lay-data="{field:'take_goods_name', width:100}">收货人</th>--%>
                            <%--<th lay-data="{field:'shop_name', width:200}">分店</th>--%>
                            <%--<th lay-data="{field:'order_sum_price', width:100, sort: true}">订单总额</th>--%>
                            <%--<th lay-data="{field:'pay_status', width:100}">支付状态</th>--%>
                            <%--<th lay-data="{field:'send_status', width:100}">发货状态</th>--%>
                            <%--<th lay-data="{field:'order_create_time', width:200, sort: true}">下单时间</th>--%>
                            <%--<th lay-data="{fixed: 'right', width:160, align:'center', toolbar: '#barDemo'}"></th>--%>
                            <%--</tr>--%>
                            <%--</thead>--%>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

</div>

<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-primary layui-btn-mini" lay-event="detail">查看</a>
    <a class="layui-btn layui-btn-danger layui-btn-mini" lay-event="del">删除</a>
</script>

<script src="../../../js/extends/jquery/jquery.min.js"></script>
<script src="../../../js/extends/jquery/jquery.loading.js"></script>
<script src="../../../js/extends/bootstrap/bootstrap.js"></script>
<script src="../../../shopmanagement/js/content.min.js"></script>
<script src="../../../common/layui/layui.js"></script>
<script src="../../../shopmanagement/js/plugins/sweetalert/sweetalert.min.js"></script>
<script src="../../../js/order/order_list.js"></script>

</body>
</html>
