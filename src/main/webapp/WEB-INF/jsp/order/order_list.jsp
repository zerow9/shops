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

    <link href="../../../shopmanagement/common/font-awesome-4.7.0/css/font-awesome.css" rel="stylesheet">
    <link href="../../../shopmanagement/css/style.min.css?v=4.0.0" rel="stylesheet">
    <link href="../../../shopmanagement/css/plugins/sweetalert/sweetalert.css" rel="stylesheet">
    <link href="../../../common/layui/css/layui.css" rel="stylesheet">
    <link rel="stylesheet" href="../../../shopmanagement/css/bootstrap.min.css" media="all">
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

                    <div class="row">

                        <div class="col-md-1">
                            <button class="btn btn-danger" id="delete_orders_btn" type="button">删除订单</button>
                        </div>

                        <form class="form-inline pull-right">

                            <div class="form-group">
                                <label for="exampleInputName2">支付状态</label>
                                <select class="form-control">
                                    <option>未付款</option>
                                    <option>已付款</option>
                                </select>
                            </div>

                            <div class="form-group">
                                <label for="exampleInputName2">发货状态</label>
                                <select class="form-control">
                                    <option>未发货</option>
                                    <option>已发货</option>
                                </select>
                            </div>

                            <%--<div class="form-group">--%>
                            <%--<label for="exampleInputName2">下单时间</label>--%>
                            <%--<input type="text" class="layui-input" id="lay_date1">--%>
                            <%--<input type="text" class="layui-input" id="lay_date2">--%>
                            <%--</div>--%>

                            <div class="form-group">
                                <label for="exampleInputName2">订单总额</label>
                                <input style="width: 80px" type="text" class="form-control" id="exampleInputName1"
                                       placeholder="最小值">
                                ～<input style="width: 80px" type="text" class="form-control" id="exampleInputName2"
                                        placeholder="最大值">
                            </div>

                            <div class="form-group">
                                <select class="form-control">
                                    <option>订单编号</option>
                                    <option>收件人</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-control" id="search_input" placeholder="请输入搜索内容">
                            </div>
                            <button class="btn btn-info" id="search_btn" data-type="reload"
                                    style="margin-right: 1px">搜索
                            </button>
                            <button class="btn btn-primary" id="search_btn_plus" data-type="reload"
                                    style="margin-right: 17px">高级搜索
                            </button>
                        </form>

                    </div>

                    <div class="table-responsive">
                        <table id="layui_table" lay-filter="demo"></table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<%--<div class="detail_info">--%>
<%--<table class="layui-table" lay-data="{基础参数}">--%>
<%--<thead>--%>
<%--<tr>--%>
<%--<th lay-data="{field:'username', width:80}" rowspan="2">联系人</th>--%>
<%--<th lay-data="{field:'amount', width:120}" rowspan="2">金额</th>--%>
<%--<th lay-data="{align:'center'}" colspan="3">地址</th>--%>
<%--</tr>--%>
<%--<tr>--%>
<%--<th lay-data="{field:'province', width:80}">省</th>--%>
<%--<th lay-data="{field:'city', width:120}">市</th>--%>
<%--<th lay-data="{field:'county', width:300}">详细</th>--%>
<%--</tr>--%>
<%--</thead>--%>
<%--</table>--%>
<%--</div>--%>

</body>

<%--工具条模板--%>
<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-primary layui-btn-mini" lay-event="detail">查看</a>
    <a class="layui-btn layui-btn-danger layui-btn-mini" lay-event="del">删除</a>
</script>

<script type="text/html" id="orderPaidTpi">
    {{ d.orderPaid }} 元
</script>

<%--付款状态模板--%>
<script type="text/html" id="payStatusTpi">
    {{#  if(d.sendStatus === 1){ }}
    <span style="color: green">未付款</span>
    {{#  } else if(d.sendStatus === 2) { }}
    <span style="color: red">未付款</span>
    {{#  } else { }}
    未知
    {{#  } }}
</script>

<%--发货状态模板--%>
<script type="text/html" id="sendStatusTpi">
    {{#  if(d.sendStatus === 1){ }}
    <span style="color: green">已发货</span>
    {{#  } else if(d.sendStatus === 2) { }}
    <span style="color: red">未发货</span>
    {{#  } else { }}
    未知
    {{#  } }}
</script>

<script src="../../../js/extends/jquery/jquery.min.js"></script>
<script src="../../../js/extends/jquery/jquery.loading.js"></script>
<script src="../../../js/extends/bootstrap/bootstrap.js"></script>
<script src="../../../shopmanagement/js/content.min.js"></script>
<script src="../../../common/layui/layui.js"></script>
<script src="../../../shopmanagement/js/plugins/sweetalert/sweetalert.min.js"></script>
<script src="../../../js/order/order_list.js"></script>

</html>
