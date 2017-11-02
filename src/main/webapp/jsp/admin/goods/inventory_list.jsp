<%--
  Created by IntelliJ IDEA.
  User: 63465
  Date: 2017/11/2 0002
  Time: 21:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <link href="../../../common/layui/css/layui.css" rel="stylesheet" >
    <link href="../../../css/module/my_layui.css" rel="stylesheet">

</head>

<body>

<div class="wrapper wrapper-content animated fadeInRight">

    <div class="row">

        <div class="layui-col-sm12">

            <div class="ibox float-e-margins">

                <blockquote class="layui-elem-quote">
                    <h2>操作提示</h2>
                    在这里，你可以增删改查库存。
                </blockquote>

                <div class="ibox-title">
                    <h5>库存列表</h5>
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
                            <button class="layui-btn" data-type="getCheckData">获取选中行数据</button>
                            <button class="layui-btn" data-type="getCheckLength">获取选中数目</button>
                            <button class="layui-btn" data-type="isAll">验证是否全选</button>
                        </div>

                        <div class="table-responsive">

                            <table class="layui-table" lay-data="{url:'/data/goods_lists.json', page:true, id:'idTest'}"
                                   lay-filter="goods_lists_table">
                                <thead>
                                <tr>
                                    <th lay-data="{checkbox:true, fixed: true}"></th>
                                    <th lay-data="{field:'goods_id', width:100, sort: true, fixed: true}">ID</th>
                                    <th lay-data="{field:'goods_name', width:200}">商品名称</th>
                                    <th lay-data="{field:'goods_price', width:100}">商家名称</th>
                                    <th lay-data="{field:'goods_sales', width:100, sort: true}">库存量</th>
                                    <th lay-data="{fixed: 'right', width:200, align:'center', toolbar: '#operate_bar'}">操作</th>
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
    <a class="layui-btn layui-btn-primary layui-btn-mini" lay-event="detail">查看</a>
    <a class="layui-btn layui-btn-mini" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-mini" lay-event="del">删除</a>
</script>


<script src="../../../js/extends/jquery/jquery.min.js"></script>
<script src="../../../js/extends/bootstrap/bootstrap.js"></script>
<script src="../../../shopmanagement/js/content.min.js"></script>
<script src="../../../common/layui/layui.js"></script>

<script>
    layui.use('table', function () {
        var table = layui.table;
        //监听表格复选框选择
        table.on('checkbox(goods_lists_table)', function (obj) {
            console.log(obj)
        });
        //监听工具条
        table.on('tool(goods_lists_table)', function (table_tool) {
            var data = table_tool.data;
            if (table_tool.event === 'detail') {
                layer.msg('ID：' + data.goods_id + ' 的查看操作');
            } else if (table_tool.event === 'del') {
                layer.confirm('真的删除行么', function (index) {
                    table_tool.del();
                    layer.close(index);
                });
            } else if (table_tool.event === 'edit') {
                layer.alert('编辑行：<br>' + JSON.stringify(data))
            } else if (table_tool.event === 'shelve_status') {
                layer.msg("商品：" + data.goods_name + " 已下架。");
            }
        });

//        复选框操作
        var $ = layui.$, active = {
            getCheckData: function () { //获取选中数据
                var checkStatus = table.checkStatus('idTest')
                    , data = checkStatus.data;
                layer.alert(JSON.stringify(data));
            }
            , getCheckLength: function () { //获取选中数目
                var checkStatus = table.checkStatus('idTest')
                    , data = checkStatus.data;
                layer.msg('选中了：' + data.length + ' 个');
            }
            , isAll: function () { //验证是否全选
                var checkStatus = table.checkStatus('idTest');
                layer.msg(checkStatus.isAll ? '全选' : '未全选')
            }
        };

//        测试的顶部功能按钮
        $('.demoTable .layui-btn').on('click', function () {
            var type = $(this).data('type');
            active[type] ? active[type].call(this) : '';
        });
    });
</script>

</body>
</html>
