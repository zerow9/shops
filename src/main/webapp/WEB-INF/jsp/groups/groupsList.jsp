<%--
  Created by IntelliJ IDEA.
  User: 63465
  Date: 2017/11/2 0002
  Time: 10:04
  To change this template use File | Settings | File Templates.
--%>
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
                            <table class="layui-table"
                                   lay-data="{url:'getGroupsJson.action', page:true, id:'group_container_id'}"
                                   lay-filter="group_lists_table">
                                <thead>
                                <tr>
                                    <th lay-data="{checkbox:true, fixed: true}"></th>
                                    <th lay-data="{field:'groupId', width:100, sort: true, fixed: true}">ID</th>
                                    <th lay-data="{field:'groupName', width:200}">用户组名称</th>
                                    <th lay-data="{field:'groupJurisdiction', width:300}">用户组描述</th>
                                    <th lay-data="{field:'isStart', width:200, align:'center', fixed: 'right', toolbar: '#shelve_bar'}">
                                        是否启用
                                    </th>
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
    <a class="layui-btn layui-btn-primary layui-btn-mini" lay-event="shelve_status" id="shelve_status_bar">是</a>
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
<script src="../../../shopmanagement/js/plugins/sweetalert/sweetalert.min.js"></script>
<script>
    layui.use('table', function () {
        var table = layui.table;
        //监听表格复选框选择，输出到控制台
        table.on('checkbox(group_lists_table)', function (obj) {
//            layer.msg('选中了：'+obj.data.groupName);
            console.log(obj)
        });

        //监听工具条
        table.on('tool(group_lists_table)', function (table_tool) {
            var data = table_tool.data;
            if (table_tool.event === 'detail') {
                layer.msg('用户组ID：' + data.group_id + ' 的查看操作');
            } else if (table_tool.event === 'del') {
                //强势弹窗效果
                swal({
                    title: "您确定要删除'ID：=" + data.groupId + "信息吗",
                    text: "删除后将无法恢复，请谨慎操作！",
                    type: "warning",
                    showCancelButton: true,
                    confirmButtonColor: "#DD6B55",
                    confirmButtonText: "删除",
                    closeOnConfirm: false
                }, function () {
                    $.post('deleteGroupsByPrimaryKey.action?', {'groupId': data.groupId}, function (str) {
                        if (str === true)
                            swal("删除成功！", "您已经永久删除了这条信息。", "success");
                        window.location.reload();
                    });
                })
            } else if (table_tool.event === 'edit') {
                layer.alert('编辑行：<br>' + JSON.stringify(data))
            } else if (table_tool.event === 'shelve_status') {
                layer.msg("用户组：" + data.group_name + " 已禁用。");
            }
        });

//        添加用户组
        $("#add_group_btn").on('click', function () {
            parent.layer.open({
                type: 2
                , title: ['添加用户组', 'font-size:18px;']
                , closeBtn: 1
                , area: ['350px', '256px']
                , shade: 0.3  //遮罩
                , id: 'add_group_id' //设定一个id，防止重复弹出
                , btn: ['添加', '取消']
                , btn1: function (index, layero) {  //取消按钮的操作
                    console.log('index:' + index);
                    console.log('\nlayero:' + layero.data);
                }
                , btn2: function (index, layero) {  //取消按钮的操作
                    return true
                }
                , move: false
                , btnAlign: 'c' //按钮居中对齐
                , content: 'admin/addGroups.action'
                , shadeClose: true
                , end: function () {
                    window.location.reload();
                }
            })
        });

//        删除用户组
        $("#del_group_btn").on('click', function () {
            var checkStatus = table.checkStatus('group_container_id')
                , data = checkStatus.data;
            var groupids = '';
            var groupNames = '';
            $.each(eval("(" + JSON.stringify(data) + ")"), function (i, n) {
                groupids += n.groupId + ',';
                groupNames += n.groupName + ',';
            });
            console.log('要删除的用户组id有：' + groupids);
            parent.layer.open({
                type: 1
                , title: ['删除用户组提示', 'font-size:18px;']
                , closeBtn: 1
                , area: ['350px', 'auto']
                , shade: 0.3  //遮罩
                , id: 'del_group_id' //设定一个id，防止重复弹出
                , btn: ['删除', '取消']
                , btn1: function (index, layero) {
                    parent.layer.close(index);
                    $.post('deleteUserByUUidArray.action?', groupids, function (result, status) {
                        console.log('post返回信息：' + '\nresult:' + result + '\nstatus:' + status);
                        if (result === true) {
                            layer.msg("删除成功！");
                            window.location.reload();
                        } else {
                            layer.msg("删除失败！");
                        }
                    });
                }
                , btn2: function (index, layero) {  //取消按钮的操作
                    layer.close(index);
                    layer.msg("已取消删除！");
                }
//                , move: false
                , btnAlign: 'c' //按钮居中对齐
                , content: '<div style="text-align: center;color: black">' +
                '<h3>你确定要删除以下用户组吗？</h3>' +
                '<br/>' + '<p style="font-size: 15px">' + groupNames.replace(/,/g, '<br/>') + '<p>' + '</div>'
                , shadeClose: true
            })
        });
    });
</script>

</body>

</html>
