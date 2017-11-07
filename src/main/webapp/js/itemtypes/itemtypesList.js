layui.use('table', function() {
    var table = layui.table;

    //监听表格复选框选择
    table.on('checkbox(type_lists_table)', function(obj) {
        console.log(obj)
    });
    //监听工具条
    table.on('tool(type_lists_table)', function(obj) {
        var data = obj.data;
        if(obj.event === 'detail') {
            layer.open({
                type: 2,
                title:"查看分类",
                shadeClose: true,
                shade: 0.3,
                content: 'seeItemTypeById.action'+data.typeId(), //注意，如果str是object，那么需要字符拼接。
                maxmin: true,
                area: ['80%', '90%']
            });

        } else if(obj.event === 'del') {

            //强势弹窗效果
            swal({
                title: "您确定要删除'ID：="+data.typeId()+"信息吗",
                text: "删除后将无法恢复，请谨慎操作！",
                type: "warning",
                showCancelButton: true,
                confirmButtonColor: "#DD6B55",
                confirmButtonText: "删除",
                closeOnConfirm: false
            }, function() {
                $.post('deleteItemTypeById.action', {'typeId':data.typeId()}, function(str){
                    if(str===true)
                        swal("删除成功！", "您已经永久删除了这条信息。", "success");
                    window.location.reload();
                });

            })

        } else if(obj.event === 'edit') {
            // layer.alert('编辑行：<br>' + JSON.stringify(data))
            layer.open({
                type: 2,
                title:"修改商品分类",
                shadeClose: true,
                shade: 0.3,
                content: 'updateItemTypeById.action='+data.typeId(), //注意，如果str是object，那么需要字符拼接。
                maxmin: true,
                area: ['80%', '90%']
            });

        }

    });

    var $ = layui.$,
        active = {
            getCheckData: function() { //获取选中数据
                var checkStatus = table.checkStatus('typeId'),
                    data = checkStatus.data;
                JSON.stringify(data);
            },
            getCheckLength: function() { //获取选中数目

                var array = new Array();//定义数组
                var checkStatus = table.checkStatus('typeId'),
                    data = checkStatus.data;
                for (var i = 0; i < data.length; i++) {//遍历数组
                    array[i] = data[i].userUuid;
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
                    $.post('deleteItemTypeByIdArray.action', {'arrayString': array.toString()}, function (index) {
                        swal("删除成功！", "您已经永久删除了这条信息。", "success");
                        window.location.reload();
                    });
                })
            },
            isAll: function() { //验证是否全选
                var checkStatus = table.checkStatus('idTest');
                layer.msg(checkStatus.isAll ? '全选' : '未全选')
            },

            addUser:function(){
                layer.open({
                    type: 2,
                    title:"添加分类",
                    shadeClose: true,
                    shade: 0.8,
                    maxmin: true,
                    area: ['80%', '90%'],
                    content: 'addItemType.action',
                    btn1:function(){
                        layer.close();
                    }
                });
            }
        };

    $('.demoTable .layui-btn').on('click', function() {
        var type = $(this).data('type');
        active[type] ? active[type].call(this) : '';
    });
});