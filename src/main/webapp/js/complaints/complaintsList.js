var loading = $('.table-responsive');
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
        , url: '/complaint/getComplaintJson.action'   //资源地址
        , id: 'idTest'   //设定容器唯一ID
        , page: true    //开启分页
        , cols: [[      //设置表头
            {checkbox: true, fixed: 'left'}
            , {field: 'complaintId', title: 'ID', width: 100, sort: true}
            , {field: 'accuserId', title: '投诉人', width: 100}
            , {field: 'accusedId', title: '被投诉人', width: 150, templet: '#orderPaidTpi', sort: true}
            , {field: 'complaintTittle', title: '投诉标题', width: 150, templet: '#orderPaidTpi', sort: true}
            , {field: 'complaintContent', title: '投诉内容', width: 100, templet: '#payStatusTpi'}
            , {field: 'complaintDate', title: '投诉时间', width: 100, templet: '#sendStatusTpi'}
            , {field: 'status', title: '是否已处理', width: 200, sort: true}
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