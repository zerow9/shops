<%--
  Created by IntelliJ IDEA.
  User: 63465
  Date: 2017/11/2 0002
  Time: 11:03
  To change this template use File | Settings | File Templates.
--%>
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
    <link href="../../../shopmanagement/common/layui/css/layui.css" media="all" rel="stylesheet" >
    <link href="../../../shopmanagement/css/my_layui.css" media="all" rel="stylesheet" >
</head>

<body>

<div class="wrapper wrapper-content animated fadeInRight">

    <div class="row">

        <div class="layui-col-sm12">

            <div class="ibox float-e-margins">

                <blockquote class="layui-elem-quote">
                    <h2>操作提示</h2>
                    在这里，你可以增删改查投诉信息。
                </blockquote>

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

                        <div class="layui-btn-group demoTable">
                            <button class="layui-btn" id="add_group_btn" data-type="add">添加用户组</button>
                        </div>

                        <div class="table-responsive">

                            <table class="layui-table"
                                   lay-data="{url:'getComplaintJson.action', page:true, id:'idTest'}"
                                   lay-filter="complaints_lists_table">
                                <thead>
                                <tr>
                                    <th lay-data="{checkbox:true, fixed: true}"></th>
                                    <th lay-data="{field:'complaintId', width:50, sort: true, fixed: true}">ID</th>
                                    <th lay-data="{field:'accuserId', width:100, sort: true}">投诉人</th>
                                    <th lay-data="{field:'accusedId', width:100, sort: true}">被投诉人</th>
                                    <th lay-data="{field:'complaintTittle', width:200}">投诉标题</th>
                                    <th lay-data="{field:'complaintContent', width:200}">投诉内容</th>
                                    <th lay-data="{field:'dateToString', width:100, sort: true}">投诉时间</th>
                                    <th lay-data="{field:'status', width:100, align:'center', fixed: 'right', toolbar: '#status_bar'}">
                                        是否已处理
                                    </th>
                                    <th lay-data="{fixed: 'right', width:150, align:'center', toolbar: '#operate_bar'}">操作</th>
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

<script type="text/html" id="status_bar">
    <a class="layui-btn layui-btn-primary layui-btn-mini" lay-event="status_status" id="status">是</a>
</script>

<script type="text/html" id="operate_bar">
    <a class="layui-btn layui-btn-primary layui-btn-mini" lay-event="detail"><i class="fa fa-eye" aria-hidden="true" title="查看"></i></a>
    <a class="layui-btn layui-btn-danger layui-btn-mini" lay-event="del"><i class="fa fa-trash" aria-hidden="true" title="删除"></i></a>
</script>

<script src="../../../shopmanagement/js/jquery.min.js"></script>
<script src="../../../shopmanagement/js/bootstrap.min.js"></script>
<script src="../../../shopmanagement/js/content.min.js"></script>
<script src="../../../shopmanagement/common/layui/layui.js"></script>

<script>
    layui.use('table', function () {
        var table = layui.table;
        //监听表格复选框选择
        table.on('checkbox(complaints_lists_table)', function (obj) {
            console.log(obj)
        });
        //监听工具条
        table.on('tool(complaints_lists_table)', function (table_tool) {
            var data = table_tool.data;
            if (table_tool.event === 'detail') {
                var parm = data.complaintId;
                layer.open({
                    type: 2,
                    title:"查看信息",
                    shadeClose: true,
                    shade: 0.3,
                    content: 'seeComplaintIdByKey.action?complaintId='+parm,
                    maxmin: true,
                    area: ['80%', '90%']
                });
            } else if (table_tool.event === 'del') {
                layer.confirm('确定删除投诉吗？', function (index) {
                    var parm = data.complaintId;
                    $.ajax({
                        url: 'deleteComplaintId.action',
                        type:"POST",
                        data:"complaintId="+ parm,
                        success: function () {
                            parent.layer.closeAll();
                            window.location.reload();
                        }
                    });
                    return false;
                });
            } else if (table_tool.event === 'status_status') {
                layer.msg("投诉：" + data.complaints_name + " 已处理。");
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
            },
            add:function () {
                layer.open({
                    type: 2,
                    title:"添加用户",
                    shadeClose: true,
                    shade: 0.8,
                    maxmin: true,
                    area: ['80%', '90%'],
                    content: 'addComplaint.action',
                    btn1:function(){
                        layer.close();
                    }
                });
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
