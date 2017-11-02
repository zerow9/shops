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
    <link rel="stylesheet" href="../../../common/layui/css/layui.css" media="all">
</head>

<body>

<div style="margin-bottom: 5px;">

    <!-- 示例-970 -->
    <ins class="adsbygoogle" style="display:inline-block;width:970px;height:90px"
         data-ad-client="ca-pub-6111334333458862" data-ad-slot="3820120620"></ins>

</div>

<div class="layui-btn-complaints demoTable">
</div>

<table class="layui-table"
       lay-data="{url:'/data/user_complaints_list.json', page:true, id:'idTest'}"
       lay-filter="complaints_lists_table">
    <thead>
    <tr>
        <th lay-data="{checkbox:true, fixed: true}"></th>
        <th lay-data="{field:'complaints_id', width:50, sort: true, fixed: true}">ID</th>
        <th lay-data="{field:'complaints_user_id', width:100, sort: true}">投诉人</th>
        <th lay-data="{field:'be_complaints_user_id', width:100, sort: true}">被投诉人</th>
        <th lay-data="{field:'complaints_title', width:200}">投诉标题</th>
        <th lay-data="{field:'complaints_content', width:200}">投诉内容</th>
        <th lay-data="{field:'complaints_time', width:100, sort: true}">投诉时间</th>
        <th lay-data="{field:'complaints_status', width:100, align:'center', fixed: 'right', toolbar: '#status_bar'}">
            是否已处理
        </th>
        <th lay-data="{fixed: 'right', width:150, align:'center', toolbar: '#operate_bar'}">操作</th>
    </tr>
    </thead>
</table>

<script type="text/html" id="status_bar">
    <a class="layui-btn layui-btn-primary layui-btn-mini" lay-event="status_status" id="status_status_bar">是</a>
</script>

<script type="text/html" id="operate_bar">
    <a class="layui-btn layui-btn-primary layui-btn-mini" lay-event="detail">查看</a>
    <a class="layui-btn layui-btn-danger layui-btn-mini" lay-event="del">删除</a>
</script>


<script src="../../../common/layui/layui.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
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
                layer.msg('投诉ID：' + data.complaints_id + ' 的查看操作');
            } else if (table_tool.event === 'del') {
                layer.confirm('确定删除投诉吗？', function (index) {
                    table_tool.del();
                    layer.close(index);
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
