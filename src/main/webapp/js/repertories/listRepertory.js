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
                content: 'detailRepertory.action?repertoryId=' + data.repertoryId,
                maxmin: true,
                area: ['80%', '90%']
            });
        } else if (obj.event === 'del') {
            swal({
                title: "您确定要删除" + data.repertoryId + "信息吗",
                text: "删除后将无法恢复，请谨慎操作！",
                type: "warning",
                showCancelButton: true,
                confirmButtonColor: "#DD6B55",
                confirmButtonText: "删除",
                closeOnConfirm: false
            }, function () {
                $.post('deleteRepertoryIdByPrimaryKey.action', {'repertoryId': data.repertoryId}, function (index) {
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
                content: 'editRepertory.action?repertoryId=' + data.repertoryId
            });
        }
    });

    $('.demoTable .layui-btn').on('click', function () {
        var type = $(this).data('type');
        active[type] ? active[type].call(this) : '';
    });

    active = {
        getCheckData: function () { //获取选中数据那就【
            var checkStatus = table.checkStatus('repertoryId'),
                data = checkStatus.data;
            layer.alert(JSON.stringify(data));
        },
        getCheckLength: function () { //获取选中数目
            var array = new Array();//定义数组
            var checkStatus = table.checkStatus('repertoryId'),
                data = checkStatus.data;
            for (var i = 0; i < data.length; i++) {//遍历数组
                array[i] = data[i].itemId;
            }

            //判断数据是否选中
            if(data.length===0){
                layer.msg("数据没有选中！");
                return;
            }
            //强势弹窗效果
            swal({
                title: "您确定要删除这" + array.length + "信息吗",
                text: "删除后将无法恢复，请谨慎操作！",
                type: "warning",
                showCancelButton: true,
                confirmButtonColor: "#DD6B55",
                confirmButtonText: "删除",
                closeOnConfirm: false
            }, function () {
                //通 ajax 加载方法
                $.post('deleteRepertoryByIdArray.action', {'arrayString': array.toString()}, function (index) {
                    swal("删除成功！", "您已经永久删除了这条信息。", "success");
                    window.location.reload();
                });
            })
        },
        isAll: function () { //验证是否全选
            table.checkStatus.isAll=true;
            var checkStatus = table.checkStatus('repertoryId');

            layer.msg(checkStatus.isAll ? '全选' : '未全选')
        },
        addRepertory: function () {
            layer.open({
                type: 2,
                title: "添加商品",
                shadeClose: true,
                shade: 0.3,
                maxmin: true,
                area: ['80%', '90%'],
                content: 'addRepertory.action'
            });
        }
    }
});