layui.use('table', function () {
    var table = layui.table;

    table.on('tool(demo)', function (obj) {
        var data = obj.data;
        if (obj.event === 'detail') {
            layer.open({
                type: 2,
                title:"查看日志",
                shadeClose: true,
                shade: 0.3,
                content: 'seeVenderIdByKey.action?venderId='+data.venderId, //注意，如果str是object，那么需要字符拼接。
                maxmin: true,
                area: ['80%', '90%']
            });
        }
    });

});