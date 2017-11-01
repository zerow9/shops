layui.use('table', function() {
    var table = layui.table;

    //监听表格复选框选择
    table.on('checkbox(demo)', function(obj) {
        console.log(obj)
    });
    //监听工具条
    table.on('tool(demo)', function(obj) {
        var data = obj.data;
        if(obj.event === 'detail') {
            layer.msg('ID：' + data.adminId + ' 的查看操作');
        } else if(obj.event === 'del') {
            console.log("-------------------------"+data);
            //自带的弹窗效果
            /*
            layer.confirm('真的删除行么', function(index) {
                obj.del();
                layer.close(index);
            });
            */

            //强势弹窗效果
            swal({
                title: "您确定要删除'ID：="+data.adminId+"信息吗",
                text: "删除后将无法恢复，请谨慎操作！",
                type: "warning",
                showCancelButton: true,
                confirmButtonColor: "#DD6B55",
                confirmButtonText: "删除",
                closeOnConfirm: false
            }, function() {
                //通 ajax 加载方法
                $({

                });
                swal("删除成功！", "您已经永久删除了这条信息。", "success")
            })

        } else if(obj.event === 'edit') {
            layer.alert('编辑行：<br>' + JSON.stringify(data))
        }
    });

    var $ = layui.$,
        active = {
            getCheckData: function() { //获取选中数据
                var checkStatus = table.checkStatus('adminId'),
                    data = checkStatus.data;
                layer.alert(JSON.stringify(data));
            },
            getCheckLength: function() { //获取选中数目
                var checkStatus = table.checkStatus('adminId'),
                    data = checkStatus.data;
                layer.msg('选中了：' + data.length + ' 个');
            },
            isAll: function() { //验证是否全选
                var checkStatus = table.checkStatus('adminId');
                layer.msg(checkStatus.isAll ? '全选' : '未全选')
            },
            addUser:function(){
                layer.open({
                    type: 2,
                    title:"添加用户",
                    shadeClose: true,
                    btn:['添加用户','取消'],
                    shade: 0.8,
                    maxmin: true,
                    area: ['80%', '90%'],
                    content: 'adduser.html', //注意，如果str是object，那么需要字符拼接。
                    yes:function(){
                        layer.msg("添加成功！");
                        layer.closeAll();
                    },
                    btn1:function(){
                        layer.close();
                    }
                });
            },
            addUser1:function(){
                parent.layer.open({
                    type: 2,
                    title:"添加用户",
                    shadeClose: true,
                    shade: 0.8,
                    area: ['80%', '90%'],
                    content: 'adduser.html', //注意，如果str是object，那么需要字符拼接。
                });
            }

        };

    $('.demoTable .layui-btn').on('click', function() {
        var type = $(this).data('type');
        active[type] ? active[type].call(this) : '';
    });
});