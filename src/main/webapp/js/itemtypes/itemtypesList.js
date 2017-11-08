layui.use('table', function () {
    var table = layui.table;
    table.on('checkbox(demo)', function (obj) {
        console.log(obj)
    });
    table.on('tool(demo)', function (obj) {
        var data = obj.data;
        if (obj.event === 'detail') {
            layer.open({
                type: 2,
                title: "查看商品",
                shadeClose: true,
                shade: 0.3,
                content: 'detailItemsTypeIdByKey.action?typeId=' + data.typeId,
                maxmin: true,
                area: ['80%', '90%']
            });
        } else if (obj.event === 'del') {
            swal({
                title: "您确定要删除" + data.typeId + "信息吗",
                text: "删除后将无法恢复，请谨慎操作！",
                type: "warning",
                showCancelButton: true,
                confirmButtonColor: "#DD6B55",
                confirmButtonText: "删除",
                closeOnConfirm: false
            }, function () {
                $.post('deleteGroupsByPrimaryKey.action', {'typeId': data.typeId}, function (index) {
                    swal("删除成功！", "您已经永久删除了这条信息。", "success");
                    window.location.reload();
                });
            })
        } else if (obj.event === 'edit') {
            layer.open({
                type: 2,
                title: "修改商品",
                shadeClose: true,
                shade: 0.3,
                maxmin: true,
                area: ['80%', '90%'],
                content: 'editItemType.action?typeId=' + data.typeId
            });
        }
    });
    $('.demoTable .layui-btn').on('click', function () {
        var type = $(this).data('type');
        active[type] ? active[type].call(this) : '';
    });

    active = {
        addItemType: function () {
            layer.open({
                type: 2,
                title: "添加商品",
                shadeClose: true,
                shade: 0.3,
                maxmin: true,
                area: ['80%', '90%'],
                content: 'addItemType.action'
            });
        }
    }
});