<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

</head>

<body>

<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">

                <blockquote class="layui-elem-quote">
                    <h2>操作提示</h2>
                    在这里，你可以增删改查商品分类。
                </blockquote>

                <!--商品分类标题-->
                <div class="ibox-title">
                    <h5>商品分类管理</h5>
                    <div class="ibox-tools">
                        <a class="collapse-link">
                            <i class="fa fa-chevron-up"></i>
                        </a>
                        <a class="dropdown-toggle" data-toggle="dropdown" href="table_data_tables.html#">
                            <i class="fa fa-wrench"></i>
                        </a>
                        <ul class="dropdown-menu dropdown-user">
                            <li><a href="#">编辑</a></li>
                        </ul>
                        <a class="close-link">
                            <i class="fa fa-times"></i>
                        </a>
                    </div>
                </div>
                <!--商品分类标题-->

                <div class="ibox-content">

                    <div class="layui-btn-group demoTable">
                        <button class="layui-btn">添加分类</button>
                    </div>

                    <div class="table-responsive">

                        <table class="layui-table" lay-data="{url:'/data/type_lists.json', page:true, id:'idTest'}"
                               lay-filter="type_lists_table">
                            <thead>
                            <tr>
                                <th lay-data="{checkbox:true, fixed: true}"></th>
                                <th lay-data="{field:'type_id', width:100, sort: true, fixed: true}">ID</th>
                                <th lay-data="{field:'type_name', width:200}">分类名称</th>
                                <th lay-data="{field:'type_grade', width:100}">分类级别</th>
                                <th lay-data="{field:'type_parent', width:100}">父级分类</th>
                                <th lay-data="{field:'type_description', width:100}">分类描述</th>
                                <th lay-data="{fixed: 'right', width:200, align:'center', toolbar: '#operate_bar'}">操作
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
        table.on('checkbox(type_lists_table)', function (obj) {
            console.log(obj)
        });

        //监听工具条
        table.on('tool(type_lists_table)', function (table_tool) {
            var data = table_tool.data;
            if (table_tool.event === 'detail') {
                layer.msg('用户组ID：' + data.group_id + ' 的查看操作');
            } else if (table_tool.event === 'del') {
                layer.confirm('确定删除用户组吗？', function (index) {
                    table_tool.del();
                    layer.close(index);
                });
            } else if (table_tool.event === 'edit') {
                layer.alert('编辑行：<br>' + JSON.stringify(data))
            } else if (table_tool.event === 'shelve_status') {
                layer.msg("用户组：" + data.group_name + " 已禁用。");
            }
        });

//        复选框操作
        var $ = layui.$, active = {
            getCheckData: function () { //获取选中数据
                var checkStatus = table.checkStatus('type_lists_table')
                    , data = checkStatus.data;
                layer.alert(JSON.stringify(data));
            }
        };

//        测试的顶部功能按钮
        $('.user_group_button .layui-btn').on('click', function () {
            var type = $(this).data('type');
            active[type] ? active[type].call(this) : '';
        });

//        添加用户组
        $("#add_group_btn").on('click', function () {
            parent.layer.open({
                type: 2
                , title: ['添加用户组', 'font-size:18px;']
                , closeBtn: 1
                , area: ['500px', '400px']
                , shade: 0.3  //遮罩
                , id: 'add_group_id' //设定一个id，防止重复弹出
                , btn: ['添加', '取消']
                , btn1: function (index, layero) {  //添加按钮的操作
                    return false
                }
                , btn2: function (index, layero) {  //取消按钮的操作
                    return true
                }
                , move: false
                , btnAlign: 'c' //按钮居中对齐
                , content: '/jsp/admin/user/user_group_add.jsp'
            })
        });

    });
</script>

</body>

</html>