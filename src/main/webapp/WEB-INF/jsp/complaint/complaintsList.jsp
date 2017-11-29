<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>投诉列表</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link href="../../../shopmanagement/common/font-awesome-4.7.0/css/font-awesome.css" rel="stylesheet">
    <link href="../../../shopmanagement/css/style.min.css?v=4.0.0" rel="stylesheet">
    <link href="../../../shopmanagement/css/plugins/sweetalert/sweetalert.css" rel="stylesheet">
    <link href="../../../common/layui/css/layui.css" rel="stylesheet">
    <link href="../../../css/extends/jquery/jquery.loading.css" rel="stylesheet">
    <link href="../../../css/module/my_layui.css" rel="stylesheet">
    <link href="../../../css/complaintsQuery.css" rel="stylesheet">
</head>

<body>

<div class="wrapper wrapper-content animated fadeInRight">

    <div class="row">
        <div class="layui-col-sm12">
            <div class="ibox float-e-margins">
                <jsp:include page="../find/findComplaints.jsp"/>
                <div class="ibox-title">
                    <h5>投诉列表</h5>
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
                            <table id="layui_table" lay-filter="complaints_lists_table">
                            </table>
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

<script type="text/html" id="status_bar">
    <a class="layui-btn layui-btn-primary layui-btn-mini" lay-event="status_status" id="status">是</a>
</script>

<script type="text/html" id="operate_bar">
    <a class="layui-btn layui-btn-primary layui-btn-mini" lay-event="detail"><i class="fa fa-eye" aria-hidden="true"
                                                                                title="查看"></i></a>
    <a class="layui-btn layui-btn-danger layui-btn-mini" lay-event="del"><i class="fa fa-trash" aria-hidden="true"
                                                                            title="删除"></i></a>
</script>

<script src="../../../js/extends/jquery/jquery.min.js"></script>
<script src="../../../js/extends/jquery/jquery.loading.js"></script>
<script src="../../../js/extends/bootstrap/bootstrap.js"></script>
<script src="../../../shopmanagement/js/content.min.js"></script>
<script src="../../../common/layui/layui.js"></script>
<script src="../../../shopmanagement/js/plugins/sweetalert/sweetalert.min.js"></script>
<script src="../../../js/complaints/complaintsList.js"></script>
<script src="../../../js/find/findComplaint.js"></script>
</body>
</html>
