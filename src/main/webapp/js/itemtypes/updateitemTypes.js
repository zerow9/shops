layui.use(['form'], function () {
    var form = layui.form;
    //定义JQuery
    var $ = layui.$;

    //自定义验证规则
    form.verify({
        typeName: function (value) {
            if (value.length ==0) {
                return '请填写类别名称！';
            }
        },

        typeLevel: function (value) {
            if (value.length ==0) {
                return '请选择分类级别！';
            }
        },

        typeKeyWord: function (value) {
            if (value.length ==0){
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
            url: 'updateitemTypes.action',
            data: parm,
            success: function () {
                //关闭弹出的窗口
                parent.layer.closeAll();
                swal({
                    title: "太帅了",
                    text: "修改数据成功！",
                    type: "success"
                });
                window.parent.location.reload();
            }
        });
        return false;
    });

});