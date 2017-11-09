layui.use('table', function () {
    var table = layui.table;

    // 方法级渲染表格
    var tableObj = table.render({
        elem: '#layui_table'    //绑定元素
        , url: 'http://localhost:8080/order/selectOrder.action'   //资源地址
        , id: 'idTest'   //设定容器唯一ID
        , height: '500'
        , page: true    //开启分页
        , cols: [[ //设置表头
            {checkbox: true, fixed: 'left'}
            , {field: 'orderId', title: '订单编号', width: 100, sort: true}
            , {field: 'takeGoodsName', title: '收货人', width: 100}
            // , {field: 'shop_name', title: '分店', width: 200}
            , {field: 'orderPaid', title: '订单总额（元）', width: 150, sort: true}
            , {field: 'sendStatus', title: '支付状态', width: 100}
            , {field: 'sendStatus', title: '发货状态', width: 100}
            , {field: 'orderCreateTime', title: '下单时间', width: 200, sort: true}
            , {field: 'operate', title: '操作', width: 150, fixed: 'right', align: 'center', toolbar: '#barDemo'}
        ]]
        , done: function (res, curr, count) {   //数据渲染完的回调
            console.log('订单列表读取完成');
            console.log('res：' + res);     //接口返回信息
            console.log('当前页码：' + curr);    //当前页码
            console.log('数据总量：' + count);     //数据总量
        }
        , initSort: {   //初始排序
            field: 'order_id' //排序字段，对应 cols 设定的各字段名
            , type: 'asc' //排序方式  asc: 升序、desc: 降序、null: 默认排序
        }
        // 每页数据量可选项
        , limits: [10, 20, 30, 50, 100, 200, 500]
        , limit: 10 //每页默认显示的数量
        , skin: 'line' //行边框风格
        , even: true //开启隔行背景
        , size: 'lg'  //设定表格尺寸
    });

    //监听工具条
    table.on('tool(demo)', function (obj) {
        var data = obj.data;
        if (obj.event === 'detail') {        // 查看详情
            var order_items = '' +
                '<div class="detail_info">' +
                '<table class="layui-table" lay-skin="nob" style="color: black">' +
                '<colgroup>' +
                '<col width="150">' +
                '<col width="200">' +
                '</colgroup>' +
                '<tbody>' +
                '<tr><td style="text-align: right;font-weight: bold">订单编号：</td>' + '<td>' + data.order_id + '</td></tr>' +
                '<tr><td style="text-align: right;font-weight: bold">收件人：</td>' + '<td>' + data.take_goods_name + '</td></tr>' +
                '<tr><td style="text-align: right;font-weight: bold">分店：</td>' + '<td>' + data.shop_name + '</td></tr>' +
                '<tr><td style="text-align: right;font-weight: bold">订单总额：</td>' + '<td>' + data.order_sum_price + '</td></tr>' +
                '<tr><td style="text-align: right;font-weight: bold">支付状态：</td>' + '<td>' + data.pay_status + '</td></tr>' +
                '<tr><td style="text-align: right;font-weight: bold">发货状态：</td>' + '<td>' + data.send_status + '</td></tr>' +
                '<tr><td style="text-align: right;font-weight: bold">下单时间：</td>' + '<td>' + data.order_create_time + '</td></tr>' +
                '</tbody>' +
                '</table>' +
                '</div>';
            parent.layer.open({
                type: 1
                , title: ['订单详情', 'font-size:18px;']
                , closeBtn: 1
                , area: ['auto', 'auto']
                , shade: 0.3  //遮罩
                , id: 'del_order_id' //设定一个id，防止重复弹出
                , btn: ['关闭']
                , btn1: function (index, layero) {  //取消按钮的操作
                    parent.layer.close(index);
                }
                , move: false
                , btnAlign: 'c' //按钮居中对齐
                , content: order_items
                , shadeClose: true
            });
        } else if (obj.event === 'del') {   //删除单行操作
            parent.layer.open({     // 弹出确认删除对话框
                type: 1
                , title: ['删除订单提示', 'font-size:18px;']
                , closeBtn: 1
                , area: ['auto', 'auto']       // 对话框：【宽，高】 单位:px
                , shade: 0.3  //遮罩
                , id: 'del_order_id' //设定一个id，防止重复弹出
                , btn: ['删除', '取消']
                , move: false
                , btnAlign: 'c' //按钮居中对齐
                , content: '<h2 style="color: black;text-align: center;margin: 50px">确定要删除此订单吗？</h2>'
                , shadeClose: true
                , btn1: function (index, layero) {      //按钮一：确认批量删除
                    $.ajax({
                        type: "POST",
                        url: "deleteOrderByPrimaryKey.action",
                        data: {'orderId': data.order_id},
                        timeout: 10000, //超时时间：10秒
                        success: function (result) {
                            if (result.match('Unknown')) {
                                parent.layer.msg("删除成功！");
                                obj.del();
                            } else {
                                parent.layer.alert(result.toString());
                            }
                        },
                        error: function (jqXHR) {
                            parent.layer.alert("<div style='font-size:20px;text-align: center;color: red'>" +
                                "删除数据时出现错误,请联系管理员解决问题。<br/><br/>" +
                                "错误提示：" + jqXHR.statusText + "<br/>" +
                                "</div>");
                        },
                        complete: function () {
                            // 不管请求成功或者失败，对话框都会被关闭
                            parent.layer.close(index);
                        }
                    });
                }
                , btn2: function (index, layero) {      //按钮二：取消按钮的操作
                    layer.close(index);
                    layer.msg("已取消删除！");
                }
            });
        }
    });

    // 批量删除订单
    $('#delete_orders_btn').on('click', function () {
        var checkStatus = table.checkStatus('idTest');      // 获取选中行,idTest即为基础参数id对应的值
        var data = checkStatus.data;    // 选中的数据集
        var order_ids = '';     //选中的id集合
        $.each(eval("(" + JSON.stringify(data) + ")"), function (i, n) {    //循环获取每个选中的id
            order_ids += n.order_id + ',';
        });
        console.log('选择的数据集：' + order_ids);
        if (order_ids !== '') {
            parent.layer.open({     // 弹出确认删除对话框
                type: 1
                , title: ['删除订单提示', 'font-size:18px;']
                , closeBtn: 1
                , area: ['auto', 'auto']       // 对话框：【宽，高】 单位:px
                , shade: 0.3  //遮罩
                , id: 'del_orders_id' //设定一个id，防止重复弹出
                , btn: ['删除', '取消']
                , move: false
                , btnAlign: 'c' //按钮居中对齐
                , content: '<h2 style="color: black;text-align: center;margin: 50px">确定要批量删除选定的订单吗？</h2>'
                , shadeClose: true
                , btn1: function (index, layero) {      //按钮一：确认批量删除
                    $.ajax({
                        type: "POST",
                        url: "deleteGroupsByIdArray.action",
                        data: {'arrayString': order_ids.toString()},
                        timeout: 10000, //超时时间：10秒
                        success: function (result) {
                            if (result.match('Unknown')) {
                                // 批量删除本地选中的行
                                var layFilterIndex = 'LAY-table-' + tableObj.config.index;
                                var tableContainer = $('div[lay-filter="' + layFilterIndex + '"]');//找到table filter的索引
                                tableContainer.find('input[name="layTableCheckbox"]:checked').each(function () {//查找选中的checkbox
                                    var tr = $(this).parents('tr');
                                    console.log(tr);
                                    tr.remove();
                                });
                                parent.layer.msg("删除成功！");
                            } else {
                                parent.layer.alert(result.toString());
                            }
                        },
                        error: function (jqXHR) {
                            parent.layer.alert("<div style='font-size:20px;text-align: center;color: red'>" +
                                "删除数据时出现错误,请联系管理员解决问题。<br/><br/>" +
                                "错误提示：" + jqXHR.statusText + "<br/>" +
                                "</div>");
                        },
                        complete: function () {
                            // 不管请求成功或者失败，对话框都会被关闭
                            parent.layer.close(index);
                        }
                    });
                }
                , btn2: function (index, layero) {      //按钮二：取消按钮的操作
                    layer.close(index);
                    layer.msg("已取消删除！");
                }
            })
        } else {
            parent.layer.alert("<h2 style=\"color: red;text-align: center;margin: 30px\">请先选择你要删除的订单！</h2>");
        }
    });
});