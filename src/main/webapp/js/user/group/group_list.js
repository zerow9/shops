
var loading = $('.table-responsive');
loading.loading({
    stoppable: false,
    // message: '数据加载中。。。'
    overlay: $("#custom-overlay")
});

layui.use('table', function () {
    var table = layui.table;
    var check_objs;

    // 方法级渲染表格
    var tableObj = table.render({
        elem: '#layui_table'    //绑定元素
        , url: '/admin/getGroupsJson.action'   //资源地址
        , id: 'idTest'   //设定容器唯一ID
        // , height: '500'
        , page: true    //开启分页
        , cols: [[ //设置表头
            {checkbox: true, fixed: 'left'}
            , {field: 'groupId', title: '用户组编号', width: 200, sort: true}
            , {field: 'groupName', title: '用户组名称', width: 200}
            , {field: 'groupJurisdiction', title: '用户组描述', width: 450, templet: '#orderPaidTpi', sort: true}
            , {field: 'isStart', title: '是否启用', width: 150, templet: '#shelve_bar', sort: true}
            , {field: 'operate', title: '操作', width: 150, fixed: 'right', align: 'center', toolbar: '#operate_bar'}
        ]]
        , done: function (res, curr, count) {   //数据渲染完的回调
            console.log('返回信息：' + res.msg);     //接口返回信息
            console.log('当前页码：' + curr);    //当前页码
            console.log('数据总量：' + count);     //数据总量
            loading.loading('stop');
        }
        , initSort: {   //初始排序
            field: 'orderId' //排序字段，对应 cols 设定的各字段名
            , type: 'asc' //排序方式  asc: 升序、desc: 降序、null: 默认排序
        }
        // 每页数据量可选项
        , limits: [10, 20, 30, 50, 100, 200, 500]
        , limit: 10 //每页默认显示的数量
        , skin: 'line' //行边框风格
        , even: true //开启隔行背景
        , size: 'lg'  //设定表格尺寸
    });

    //监听表格复选框选择，输出到控制台
    table.on('checkbox(demo)', function (obj) {
        check_objs = obj;
        console.log(obj)
    });

    //监听工具条
    table.on('tool(demo)', function (table_tool) {
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
            var checkStatus = table.checkStatus('idTest')
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
        var checkStatus = table.checkStatus('idTest')
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