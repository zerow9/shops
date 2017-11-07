layui.use(['form'], function () {
    var form = layui.form;

    //自定义验证规则
    form.verify({
        typeName: function (value) {
            if (value.length ==0) {
                return '请填写类别名称！';
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

        console.log(parm);
        $.ajax({
            url: 'itemtypesAdd.action',
            data: parm,
            type:'POST',
            success: function () {
                var index = parent.layer.getFrameIndex(window.name);
                parent.layer.close(index);
                $.post('getitemtypeAdd.action?', function (str) {
                    if (str === true)
                        swal("添加成功！","success");
                    window.location.reload();
                });
                //关闭弹出的窗口
                parent.layer.closeAll();
                window.location.reload();
            }
        });
        return false;
    });

});