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
    <title>商品列表</title>
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
                    在这里，你可以增删改查商品。
                </blockquote>

                <div class="ibox-title">
                    <h5>商品列表</h5>
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
                            <button class="layui-btn" data-type="getCheckLength">批量删除</button>
                            <button class="layui-btn" data-type="isAll">全选</button>
                            <button class="layui-btn" data-type="addItem">添加商品</button>
                        </div>

                        <div class="table-responsive">

                            <table class="layui-table" lay-data="{url:'<%=basePath%>item/getItemsAll.action', page:true, id:'itemId'}"
                                   lay-filter="demo">
                                <thead>
                                <tr>
                                    <th lay-data="{checkbox:true, fixed: true}"></th>
                                    <th lay-data="{field:'itemId', width:100, fixed: true}">ID</th>
                                    <th lay-data="{field:'itemName', width:200}">商品名称</th>
                                    <th lay-data="{field:'itemImages', width:200}">商品图片</th>
                                    <th lay-data="{field:'itemTypeId', width:200}">商品类型</th>
                                    <th lay-data="{field:'itemScoreType', width:200}">积分兑换类型</th>
                                    <th lay-data="{field:'scorePrice', width:200}">积分兑换价格</th>
                                    <th lay-data="{field:'itemPrice', width:100, sort: true}">价格</th>
                                    <th lay-data="{field:'goodsSales', width:100, sort: true}">销量</th>
                                    <th lay-data="{field:'postPrice', width:200}">运费</th>
                                    <th lay-data="{field:'keyWord', width:200}">关键字</th>
                                    <th lay-data="{field:'makeVender', width:200}">生产厂商</th>
                                    <th lay-data="{fixed: 'right', width:200, align:'center', toolbar: '#operate_bar'}">
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

<script type="text/html" id="shelve_bar">
    <a class="layui-btn layui-btn-primary layui-btn-mini" lay-event="shelve_status" id="shelve_status_bar">已上架</a>
</script>

<script type="text/html" id="operate_bar">
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
<script src="../../../js/items/itemlist.js"></script>

</body>
</html>
