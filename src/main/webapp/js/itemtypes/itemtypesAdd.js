layui.use(['form'], function () {
    var form = layui.form;
    var $ = layui.$;

    //自定义验证规则
    form.verify({
        typeName: function (value) {
            if (value.length == 0) {
                return '请填写类别名称！';
            }
        },

        typeKeyWord: function (value) {
            if (value.length == 0) {
                return '请填写关键字!';
            }
        },

        typeIntroduce: function (value) {
            if (value.length < 5) {
                return '请补充类别描述！';
            }
        },

    });

    //监听提交
    form.on('submit(demo1)', function (data) {
        var parm = data.field;
        $.ajax({
            url: 'insertItemtypesAdd.action',
            data: parm,
            type: 'POST',
            success: function () {
                parent.layer.closeAll();
            }
        });
        window.parent.location.reload();
        return false;
    });

});