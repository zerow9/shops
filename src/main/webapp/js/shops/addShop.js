layui.use(['form', 'layedit', 'laydate'], function () {
    var form = layui.form,
        layer = layui.layer,
        layedit = layui.layedit,
        laydate = layui.laydate;

    //定义JQuery
    var $ = layui.$;

    //监听提交
    form.on('submit(demo1)', function (data) {
        var parm = data.field;
        $.ajax({
            url: 'insertShop.action',
            data: parm,
            type: "POST",
            cache: false,
            async: false,
            success: function (data1) {
                parent.layer.closeAll();
            }
        });
        window.parent.location.reload();
        return false;
    });

});