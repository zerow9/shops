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
            layer.msg('ID：' + data.typeId + ' 的查看操作');
        } else if (table_tool.event === 'del') {
            //强势弹窗效果
            swal({
                title: "您确定要删除'ID：=" + data.typeId + "信息吗",
                text: "删除后将无法恢复，请谨慎操作！",
                type: "warning",
                showCancelButton: true,
                confirmButtonColor: "#DD6B55",
                confirmButtonText: "删除",
                closeOnConfirm: false
            }, function () {
                $.post('deleteGroupsByPrimaryKey.action?', {'typeId': data.typeId}, function (str) {
                    if (str === true)
                        swal("删除成功！", "您已经永久删除了这条信息。", "success");
                    window.location.reload();
                });

            })
        } else if (table_tool.event === 'edit') {
            layer.alert('编辑行：<br>' + JSON.stringify(data))
        }
    });

//        复选框操作
    var $ = layui.$active = {
        getCheckData: function () { //获取选中数据
            var checkStatus = table.checkStatus('type_container_id')
                , data = checkStatus.data;
            layer.alert(JSON.stringify(data));
        }
    };

//        添加用类别
    $("#add_type_btn").on('click', function () {
        layer.open({
            type: 2
            , closeBtn: 1
            , shade: 0.3  //遮罩
            , title: ['添加类别', 'font-size:18px;']
            , area: ['400px', '260px']
            , id: 'add_type_id' //设定一个id，防止重复弹出
            , move: false
            , btnAlign: 'c' //按钮居中对齐
            , content: 'getItemTypes.action'
            , shadeClose: true
            , end: function () {
                window.location.reload();
            }
        })
    });

});