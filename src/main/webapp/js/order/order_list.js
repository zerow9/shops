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
            var order_items = '' +
                '<div style="padding: 30px;">' +
                '<dl class="dl-horizontal">' +
                '<dt>订单编号：</dt>' + '<dd>' + data.order_id + '</dd>' +
                '<dt>收件人：</dt>' + '<dd>' + data.take_goods_name + '</dd>' +
                '<dt>分店：</dt>' + '<dd>' + data.shop_name + '</dd>' +
                '<dt>订单总额：</dt>' + '<dd>' + data.order_sum_price + '</dd>' +
                '<dt>支付状态：</dt>' + '<dd>' + data.pay_status + '</dd>' +
                '<dt>发货状态：</dt>' + '<dd>' + data.send_status + '</dd>' +
                '<dt>下单时间：</dt>' + '<dd>' + data.order_create_time + '</dd>' +
                '</dl>' +
                '</div>';
            parent.layer.open({
                type: 1
                , title: ['订单详情', 'font-size:18px;']
                , closeBtn: 1
                , area: ['400px', '310px']
                , shade: 0.3  //遮罩
                , id: 'del_group_id' //设定一个id，防止重复弹出
                , btn: ['关闭']
                , btn1: function (index, layero) {  //取消按钮的操作
                    parent.layer.close(index);
                }
                , move: false
                , btnAlign: 'c' //按钮居中对齐
                , content: order_items
                , shadeClose: true
            });
        } else if (obj.event === 'del') {
            parent.layer.confirm('真的删除行么', function (index) {
                obj.del();
                layer.close(index);
            });
        }
    });

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
        }
    };

    $('.demoTable .layui-btn').on('click', function () {
        var type = $(this).data('type');
        active[type] ? active[type].call(this) : '';
    });
});