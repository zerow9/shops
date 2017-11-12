layui.use(['laydate', 'form'], function () {
    var form = layui.form;
    var laydate = layui.laydate;
    var $ = layui.$;
    laydate.render({
        elem: '#time'
        , format: 'yyyy-MM-dd'
    });
    laydate.render({
        elem: '#other'
        , format: 'yyyy-MM-dd'
    });

    form.on('submit(find)', function (data) {
        var date = data.field;
        $.ajax({
            url: 'findUser.action',
            data: date,
            type: "POST",
            success: function () {
                parent.layer.closeAll();
                window.parent.location.reload();
            }
        });
        return false;
    })
});
