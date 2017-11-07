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
        itemTypeId: function (value) {
            if (value.length == 0) {
                return '请输入商品名称'
            }
        },
        itemFormat: function (value) {
            if (value.length == 0) {
                return '请输入商品规格'
            }
        },
        itemTypeOne: function (value) {
            if (value.length == 0) {
                return '请选择商品分类'
            }
        }

    });


    //监听提交
    form.on('submit(demo1)', function (data) {
        var formData = new FormData($("#uploadForm")[0]);
        $.ajax({
            url: 'updateItem.action',
            data: formData,
            type: "POST",
            async: false,
            cache: false,
            contentType: false,
            processData: false,
            success: function () {
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