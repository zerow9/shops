layui.use('table', function () {
    var table = layui.table;

    //监听表格复选框选择
    table.on('checkbox(demo)', function (obj) {
        console.log(obj)
    });
    //监听工具条
    table.on('tool(demo)', function (obj) {
        var data = obj.data;
        if (obj.event === 'detail') {
            layer.open({
                type: 2,
                title: "查看商品",
                shadeClose: true,
                shade: 0.3,
                content: 'detailItemsIdByKey.action?itemId=' + data.itemId, //注意，如果str是object，那么需要字符拼接。
                maxmin: true,
                area: ['80%', '90%']
            });
        } else if (obj.event === 'del') {
            //强势弹窗效果
            swal({
                title: "您确定要删除" + data.itemId + "信息吗",
                text: "删除后将无法恢复，请谨慎操作！",
                type: "warning",
                showCancelButton: true,
                confirmButtonColor: "#DD6B55",
                confirmButtonText: "删除",
                closeOnConfirm: false
            }, function () {
                //通 ajax 加载方法
                $.post('deleteItemByPrimaryKey.action', {'itemId': data.itemId}, function (index) {
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
                content: 'editItem.action?itemId=' + data.itemId, //注意，如果str是object，那么需要字符拼接。
                end: function () {
                    table.reload('itemId');
                }
            });
        }
    });

    var $ = layui.$,
        active = {
            getCheckData: function () { //获取选中数据那就【
                var checkStatus = table.checkStatus('adminId'),
                    data = checkStatus.data;
                layer.alert(JSON.stringify(data));
            },
            getCheckLength: function () { //获取选中数目
                var array = new Array();//定义数组
                var checkStatus = table.checkStatus('itemId'),
                    data = checkStatus.data;
                for (var i = 0; i < data.length; i++) {//遍历数组
                    array[i] = data[i].itemId;
                }

                //判断数据是否选中
                if (data.length === 0) {
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
                    $.post('deleteItemByIdArray.action', {'arrayString': array.toString()}, function (index) {
                        swal("删除成功！", "您已经永久删除了这条信息。", "success");
                        window.location.reload();
                    });
                })
            },
            isAll: function () { //验证是否全选
                table.checkStatus.isAll = true;
                var checkStatus = table.checkStatus('itemId');

                layer.msg(checkStatus.isAll ? '全选' : '未全选')
            },
            addItem: function () {
                layer.open({
                    type: 2,
                    title: "添加商品",
                    shadeClose: true,
                    shade: 0.3,
                    maxmin: true,
                    area: ['80%', '90%'],
                    content: 'addItem.action', //注意，如果str是object，那么需要字符拼接。
                    end: function () {
                        table.reload('itemId');
                    }
                });
            }
        };


    $('.demoTable .layui-btn').on('click', function () {
        var type = $(this).data('type');
        active[type] ? active[type].call(this) : '';
    });

});