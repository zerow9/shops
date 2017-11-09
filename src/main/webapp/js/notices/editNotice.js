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
            url: 'updateNotice',
            data: parm,
            type: "POST",
            async: false,
            cache: false,
            contentType: false,
            processData: false,
            success: function () {

                //关闭弹出的窗口
                parent.layer.closeAll();
                swal({
                    title: "太帅了",
                    text: "添加数据成功！",
                    type: "success"
                })
                window.location.reload();
            }
        });
        return false;
    });

});