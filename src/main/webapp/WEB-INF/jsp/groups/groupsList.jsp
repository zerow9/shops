<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset="utf-8">
    <title>用户组列表</title>
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

<div class="wrapper wrapper-content animated fadeInRight">

    <div class="row">

        <div class="layui-col-sm12">

            <div class="ibox float-e-margins">

                <blockquote class="layui-elem-quote">
                    <h2>操作提示</h2>
                    在这里，你可以增删改查用户组，并给用户组配置权限。
                </blockquote>
                <div class="ibox-title">
                    <h5>用户组列表</h5>
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

                        <div class="layui-btn-group user_group_button">
                            <button class="layui-btn" id="add_group_btn">添加用户组</button>
                            <button class="layui-btn" id="del_group_btn">删除用户组</button>
                        </div>

                        <div class="table-responsive">
                            <table id="layui_table" lay-filter="demo"></table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<div id="custom-overlay" style="margin-top:70px;margin-left: 40%">
    <i class="fa fa-spinner fa-pulse fa-5x "></i>
</div>

<script type="text/html" id="operate_bar">
    <a class="layui-btn layui-btn-primary layui-btn-mini" lay-event="detail"><i class="fa fa-eye" aria-hidden="true"
                                                                                title="查看"></i></a>
    <a class="layui-btn layui-btn-mini" lay-event="edit"><i class="fa fa-edit" aria-hidden="true" title="编辑"></i></a>
    <shiro:hasPermission name="root">
    <a class="layui-btn layui-btn-danger layui-btn-mini" lay-event="del"><i class="fa fa-trash" aria-hidden="true"
                                                                            title="删除"></i></a>
    </shiro:hasPermission>
</script>
<script type="text/html" id="shelve_bar">
    {{# if(d.isStart==1){}}
    <a class="layui-btn layui-btn-primary layui-btn-mini" >是</a>
    {{# }else{}}
    <a class="layui-btn layui-btn-primary layui-btn-mini" >否 </a>
    {{# }}}
</script>
<script src="../../../js/extends/jquery/jquery.min.js"></script>
<script src="../../../js/extends/jquery/jquery.loading.js"></script>
<script src="../../../js/extends/bootstrap/bootstrap.js"></script>
<script src="../../../shopmanagement/js/content.min.js"></script>
<script src="../../../common/layui/layui.js"></script>
<script src="../../../shopmanagement/js/plugins/sweetalert/sweetalert.min.js"></script>
<script src="../../../js/user/group/group_list.js"></script>

</body>

</html>
