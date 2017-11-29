var loading = $('#layui_table');
loading.loading({
    stoppable: false,
    // message: '数据加载中。。。'
    overlay: $("#custom-overlay")
});

layui.use('table', function () {
    var table = layui.table;

    // 方法级渲染表格
    var tableObj = table.render({
        elem: '#layui_table'    //绑定元素
        , url: '/admin/getAdminAll.action'   //资源地址
        , id: 'idTest'   //设定容器唯一ID
        , page: true    //开启分页
        , cols: [[      //设置表头
            {checkbox: true, fixed: 'left'}
            , {field: 'adminId', title: '管理员编号', width: 100, sort: true}
            , {field: 'adminAccount', title: '账号', width: 200}
            , {field: 'adminPhone', title: '电话号码', width: 200}
            , {field: 'adminEmail', title: '邮箱', width: 200}
            , {field: 'adminRegisterTime', title: '注册时间', width: 300, sort: true}
            , {field: 'operate', title: '操作', width: 150, fixed: 'right', align: 'center', toolbar: '#barDemo'}
        ]]
        , done: function (res, curr, count) {   //数据渲染完的回调
            console.log('返回信息：' + res.msg);     //接口返回信息
            console.log('当前页码：' + curr);    //当前页码
            console.log('数据总量：' + count);     //数据总量
            loading.loading('stop');
        }
        // 每页数据量可选项
        , limits: [10, 20, 30, 50, 100, 200, 500]
        , limit: 10 //每页默认显示的数量
        , skin: 'line' //行边框风格
        , even: true //开启隔行背景
        , size: 'lg'  //设定表格尺寸
    });

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
                title: "查看用户",
                shadeClose: true,
                shade: 0.3,
                content: 'seeAdminIdByKey.action?adminId=' + data.adminId, //注意，如果str是object，那么需要字符拼接。
                maxmin: true,
                area: ['80%', '90%']
            });
        } else if (obj.event === 'del') {
            //强势弹窗效果
            swal({
                title: "您确定要删除" + data.adminId + "信息吗",
                text: "删除后将无法恢复，请谨慎操作！",
                type: "warning",
                showCancelButton: true,
                confirmButtonColor: "#DD6B55",
                confirmButtonText: "删除",
                closeOnConfirm: false
            }, function () {
                //通 ajax 加载方法
                $.post('deleteAdminByPrimaryKey.action', {'adminId': data.adminId}, function (index) {
                    swal("删除成功！", "您已经永久删除了这条信息。", "success");
                    window.location.reload();
                });
            })
        } else if (obj.event === 'edit') {
            layer.open({
                type: 2,
                title: "修改管理员",
                shadeClose: true,
                shade: 0.3,
                maxmin: true,
                area: ['80%', '90%'],
                content: 'updateAdmin.action?id=' + data.adminId //注意，如果str是object，那么需要字符拼接。
            });
        }
    });

    var $ = layui.$,
        active = {
            getCheckData: function () { //获取选中数据那就【
                var checkStatus = table.checkStatus('idTest'),
                    data = checkStatus.data;
                layer.alert(JSON.stringify(data));
            },
            getCheckLength: function () { //获取选中数目
                var array = new Array();//定义数组
                var checkStatus = table.checkStatus('idTest'),
                    data = checkStatus.data;
                for (var i = 0; i < data.length; i++) {//遍历数组
                    array[i] = data[i].adminId;
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
                    $.post('deleteAdminsByIdArray.action', {'arrayString': array.toString()}, function (index) {
                        swal("删除成功！", "您已经永久删除了这条信息。", "success");
                        window.location.reload();
                    });
                })
            },
            isAll: function () { //验证是否全选
                table.checkStatus.isAll = true;
                var checkStatus = table.checkStatus('idTest');

                layer.msg(checkStatus.isAll ? '全选' : '未全选')
            },
            addUser: function () {
                layer.open({
                    type: 2,
                    title: "添加管理员",
                    shadeClose: true,
                    shade: 0.3,
                    maxmin: true,
                    area: ['80%', '90%'],
                    content: 'addAdmin.action', //注意，如果str是object，那么需要字符拼接。
                });
            }
        };


    $('.demoTable .layui-btn').on('click', function () {
        var type = $(this).data('type');
        active[type] ? active[type].call(this) : '';
    });

});