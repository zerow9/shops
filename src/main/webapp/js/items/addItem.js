layui.use(['form', 'layedit', 'laydate'], function () {
    var form = layui.form,
        layer = layui.layer,
        layedit = layui.layedit,
        laydate = layui.laydate;

    //定义JQuery
    var $ = layui.$;

    //日期
    laydate.render({
        elem: '#date'
    });
    laydate.render({
        elem: '#date1'
    });

    //自定义验证规则
    form.verify({
        title: function (value) {
            if (value.length < 5) {
                return '标题至少得5个字符啊';
            }
        },
        content: function (value) {
            layedit.sync(editIndex);
        },
        itemName: function (value) {
            if (value.length == 0) {
                return '请输入商品名称';
            }
        },
        itemTypeId: function () {
            if (value.length == 0) {
                return '请输入商品名称'
            }
        }

    });


    //监听提交
    form.on('submit(demo1)', function (data) {
        var parm = data.field;
        $.ajax({
            url: 'insertItem.action',
            data: parm,
            success: function () {

                //关闭弹出的窗口
                parent.layer.closeAll();
                swal({
                    title: "太帅了",
                    text: "添加数据成功！",
                    type: "success"
                })
                window.parent.location.reload();
            }
        });
        return false;
    });

});