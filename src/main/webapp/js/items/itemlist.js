
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
        , url: '/item/getItemsAll.action'   //资源地址
        , id: 'idTest'   //设定容器唯一ID
        , page: true    //开启分页
        , cols: [[ //设置表头
            {checkbox: true, fixed: 'left'}
            , {field: 'itemId', title: '商品编号', width: 100, sort: true}
            , {field: 'itemName', title: '商品名称', width: 100}
            , {field: 'itemImages', title: '商品图片', width: 200}
            , {field: 'itemTypeId', title: '商品分类', width: 150, sort: true}
            , {field: 'itemScoreType', title: '积分兑换类型', width: 150, sort: true}
            , {field: 'scorePrice', title: '积分兑换价格', width: 100}
            , {field: 'itemPrice', title: '商品成本价格', width: 100}
            , {field: 'itemMarketPrice', title: '商品市场价格', width: 200, sort: true}
            , {field: 'goodsSales', title: '销量', width: 200, sort: true}
            , {field: 'postPrice', title: '运费', width: 200, sort: true}
            , {field: 'keyWord', title: '关键字', width: 200, sort: true}
            , {field: 'makeVender', title: '生产厂商', width: 200, sort: true}
            , {field: 'operate', title: '操作', width: 150, fixed: 'right', align: 'center', toolbar: '#operate_bar'}
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
                var checkStatus = table.checkStatus('idTest'),
                    data = checkStatus.data;
                layer.alert(JSON.stringify(data));
            },
            getCheckLength: function () { //获取选中数目
                var array = new Array();//定义数组
                var checkStatus = table.checkStatus('idTest'),
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
                var checkStatus = table.checkStatus('idTest');

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
                        table.reload('idTest');
                    }
                });
            }
        };


    $('.demoTable .layui-btn').on('click', function () {
        var type = $(this).data('type');
        active[type] ? active[type].call(this) : '';
    });

});