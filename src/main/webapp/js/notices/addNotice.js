layui.use(['form', 'layedit', 'laydate'], function () {
    var form = layui.form,
        layer = layui.layer,
        layedit = layui.layedit,
        laydate = layui.laydate;

    //定义JQuery
    var $ = layui.$;

    laydate.render({
        elem: '#date'
        ,format: 'yyyy年MM月dd日'
        ,value:new Date()
        ,closeStop: '#date'
    });


    //监听提交
    form.on('submit(demo1)', function (data) {
        var parm = data.field;
        console.log(parm)
        $.ajax({
            url: 'insertNotice.action',
            data: parm,
            type: "POST",
            success: function () {
                parent.layer.closeAll();
            }
        });
        window.parent.location.reload();
        return false;
    });

});