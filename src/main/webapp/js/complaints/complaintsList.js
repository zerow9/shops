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
                title: "查看信息",
                shadeClose: true,
                shade: 0.3,
                content: 'seeComplaintIdByKey.action?complaintId=' + parm,
                maxmin: true,
                area: ['80%', '90%']
            });
        } else if (table_tool.event === 'del') {
            layer.confirm('确定删除投诉吗？', function (index) {
                var parm = data.complaintId;
                $.ajax({
                    url: 'deleteComplaintId.action',
                    type: "POST",
                    data: "complaintId=" + parm,
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
        add: function () {
            layer.open({
                type: 2,
                title: "添加用户",
                shadeClose: true,
                shade: 0.8,
                maxmin: true,
                area: ['80%', '90%'],
                content: 'addComplaint.action',
                btn1: function () {
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