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
    <link href="../../../shopmanagement/css/bootstrap.min.css" rel="stylesheet">
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

                        <form class="form-inline pull-right" id="search_form">
                            <div class="form-group">
                                <label for="s_pay_status">支付状态</label>
                                <select name="payStatus" class="form-control" id="s_pay_status">
                                    <option></option>
                                    <option>未付款</option>
                                    <option>已付款</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <label for="s_send_status">发货状态</label>
                                <select name="sendStatus" class="form-control" id="s_send_status">
                                    <option></option>
                                    <option>未发货</option>
                                    <option>已发货</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <label for="s_sum_price_min">订单总额</label>
                                <input style="width: 80px" type="number" name="orderSumPriceMin" class="form-control"
                                       id="s_sum_price_min"
                                       placeholder="最小值">
                                ～<input style="width: 80px" type="number" name="orderSumPriceMax" class="form-control"
                                        id="s_sum_price_max"
                                        placeholder="最大值">
                            </div>
                            <div class="form-group">
                                <select class="form-control" name="searchContentType" id="s_text_type">
                                    <option>订单编号</option>
                                    <option>收件人</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <input name="searchContent" type="search" class="form-control" id="s_text_type_input"
                                       placeholder="请输入搜索内容">
                            </div>
                            <button type="button" class="btn btn-info" id="search_btn" data-type="reload">搜索</button>
                            <button type="reset" class="btn btn-info">重置</button>
                            <button type="button" class="btn btn-primary" id="search_btn_plus" data-type="reload"
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

<div id="custom-overlay" style="margin-top:70px;margin-left: 40%">
    <i class="fa fa-spinner fa-pulse fa-5x "></i>
</div>

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
    <span style="color: green">已付款</span>
    {{#  } else if(d.sendStatus === 0) { }}
    <span style="color: red">未付款</span>
    {{#  } else { }}
    未知
    {{#  } }}
</script>

<%--发货状态模板--%>
<script type="text/html" id="sendStatusTpi">
    {{#  if(d.sendStatus === 1){ }}
    <span style="color: green">已发货</span>
    {{#  } else if(d.sendStatus === 0) { }}
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
