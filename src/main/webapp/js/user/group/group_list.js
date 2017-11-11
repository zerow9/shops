layui.use('table', function () {
    var table = layui.table;
    var check_objs;
    //监听表格复选框选择，输出到控制台
    table.on('checkbox(group_lists_table)', function (obj) {
        check_objs = obj;
        console.log(obj)
    });

    //监听工具条
    table.on('tool(group_lists_table)', function (table_tool) {
        var data = table_tool.data;
        if (table_tool.event === 'detail') {
            layer.open({
                type: 2,
                title:"查看用户组",
                shadeClose: true,
                shade: 0.3,
                content: 'detailGroupsIdByKey.action?groupId='+data.groupId, //注意，如果str是object，那么需要字符拼接。
                maxmin: true,
                area: ['400px', '260px']
            });
        }
        else if (table_tool.event === 'del') {
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
        }
        else if (table_tool.event === 'edit') {
            layer.open({
                type: 2,
                title:"修改用户组",
                shadeClose: true,
                shade: 0.3,
                content: 'updateGroups.action?groupId='+data.groupId, //注意，如果str是object，那么需要字符拼接。
                maxmin: true,
                area: ['400px', '260px']
            });
        } else if (table_tool.event === 'shelve_status') {
            layer.msg("用户组：" + data.group_name + " 已禁用。");
        }
    });

//        复选框操作
    var $ = layui.$, active = {
        getCheckData: function () { //获取选中数据
            var checkStatus = table.checkStatus('group_container_id')
                , data = checkStatus.data;
            layer.alert(JSON.stringify(data));
        }
    };

//        测试的顶部功能按钮
    $('.user_group_button .layui-btn').on('click', function () {
        var type = $(this).data('type');
        active[type] ? active[type].call(this) : '';
    });

//        添加用户组
    $("#add_group_btn").on('click', function () {
        layer.open({
            type: 2
            , closeBtn: 1
            , shade: 0.3  //遮罩
            , title: ['添加用户组', 'font-size:18px;']
            , area: ['80%', '60%']
            , id: 'add_group_id' //设定一个id，防止重复弹出
            , move: false
            , btnAlign: 'c' //按钮居中对齐
            , content: 'addGroups.action'
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
        var trs = '';
        $.each(eval("(" + JSON.stringify(data) + ")"), function (i, n) {
            groupids += n.groupId + ',';
            groupNames += n.groupName + ',';
            var tr = "" +
                "<tr>" +
                "<td>" + n.groupId + "</td>" +
                "<td>" + n.groupName + "</td>" +
                "</tr>";
            trs += tr;
        });
        var content_body = '' +
            '<div class="layui-form" id="delete_groups_table" style="color: black;text-align: center">\n' +
            '<h3>你确定要删除以下用户组吗？</h3>' +
            '    <table class="layui-table" style="color: black">\n' +
            '        <colgroup>\n' +
            '            <col width="100">\n' +
            '            <col width="200">\n' +
            '        </colgroup>\n' +
            '        <thead>\n' +
            '        <tr>\n' +
            '            <th>ID</th>\n' +
            '            <th>用户组名称</th>\n' +
            '        </tr>\n' +
            '        </thead>\n' +
            '        <tbody>\n' + trs +
            '        </tbody>\n' +
            '    </table>\n' +
            '</div>';
        console.log('要删除的用户组id有：' + groupids);
        parent.layer.open({
            type: 1
            , title: ['删除用户组提示', 'font-size:18px;']
            , closeBtn: 1
            , area: ['auto', '300px']
            , shade: 0.3  //遮罩
            , id: 'del_group_id' //设定一个id，防止重复弹出
            , btn: ['删除', '取消']
            , btn1: function (index, layero) {
                parent.layer.close(index);
                $.post('deleteGroupsByIdArray.action', {'arrayString': groupids.toString()}, function (result, status) {
                    console.log('post返回信息：' + '\nresult:' + result + '\nstatus:' + status);
                    if (result.match('Unknown')) {
                        parent.layer.msg("删除成功！");
                        window.location.reload();
                    } else {
                        parent.layer.alert(result.toString());
                    }
                });
            }
            , btn2: function (index, layero) {  //取消按钮的操作
                layer.close(index);
                layer.msg("已取消删除！");
            }
            , move: false
            , btnAlign: 'c' //按钮居中对齐
            , content: content_body
            , shadeClose: true
        })
    });

});