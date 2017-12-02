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
                    在这里，你可以增删改查商品分类具体信息。
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
                        <button class="layui-btn" data-type="addItemType">添加分类</button>
                    </div>

                    <div class="table-responsive">

                        <table class="layui-table" lay-data="{url:'getitemTypes.action', page:true, id:'type'}"
                               lay-filter="demo">
                            <thead>
                            <tr>
                                <th lay-data="{checkbox:true, fixed: true}"></th>
                                <th lay-data="{field:'typeId', width:100, sort: true, fixed: true}">ID</th>
                                <th lay-data="{field:'typeName', width:200}">分类名称</th>
                                <th lay-data="{field:'parentItemTypeName', width:100}">父类别</th>
                                <th lay-data="{field:'typeLevel', width:100 ,templet: '#shelve_bar'}">分类等级</th>
                                <th lay-data="{field:'typeKeyWord', width:100}">关键字</th>
                                <th lay-data="{field:'typeIntroduce', width:100}">分类描述</th>
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
    <a class="layui-btn layui-btn-primary layui-btn-mini" lay-event="detail"><i class="fa fa-eye" aria-hidden="true" title="查看"></i></a>
    <a class="layui-btn layui-btn-mini" lay-event="edit"><i class="fa fa-edit" aria-hidden="true" title="编辑"></i></a>
    <a class="layui-btn layui-btn-danger layui-btn-mini" lay-event="del"><i class="fa fa-trash" aria-hidden="true" title="删除"></i></a>
</script>

<script type="text/html" id="shelve_bar">
    {{# if(d.typeLevel==0){}}
        <span>顶级分类</span>
    {{# }else if(d.typeLevel==1){}}
        <span>一级分类</span>
    {{# }else if(d.typeLevel==2){}}
        <span>二级分类</span>
    {{# }else{}}
        <span>三级分类</span>
    {{# }}}
</script>

<script src="../../../js/extends/jquery/jquery.min.js"></script>
<script src="../../../js/extends/bootstrap/bootstrap.js"></script>
<script src="../../../shopmanagement/js/content.min.js"></script>
<script src="../../../common/layui/layui.js"></script>
<script src="../../../shopmanagement/js/plugins/sweetalert/sweetalert.min.js"></script>
<script src="../../../js/itemtypes/itemtypesList.js"></script>
</body>
</html>