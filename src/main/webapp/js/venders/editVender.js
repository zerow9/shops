layui.use(['form', 'layedit', 'laydate'], function () {
    var form = layui.form,
        layer = layui.layer,
        layedit = layui.layedit,
        laydate = layui.laydate;

    //定义JQuery
    var $ = layui.$;

    //日期
    laydate.render({
        elem: '#date2'
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
        itemTypeId: function (value) {
            if (value.length == 0) {
                return "请选择商品名称";
            }
        },
        shopId: function (value) {
            if (value.length == 0) {
                return "请选择商店名称";
            }
        },
        venderId: function (value) {
            if (value.length==0) {
                return '请选择生产商名称'
            }
        }


    });

    //监听提交
    form.on('submit(demo1)', function (data) {
        var parm = data.field;
        $.ajax({
            url: 'updateVenderaction.action',
            data: parm,
            type: "POST",
            async:false,
            cache:false,
            success: function () {
                parent.layer.closeAll();
            }
        });
        window.parent.location.reload();
        return false;
    });

});