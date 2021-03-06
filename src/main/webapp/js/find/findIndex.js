layui.use(['laydate', 'form', 'table'], function () {
    var form = layui.form;
    var laydate = layui.laydate;
    var table = layui.table;
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
        var date = JSON.stringify(data.field);
        var str=date.toString().replace('{','').replace('}','').replace(/"/g,'').replace(/,/g,'&').replace(/:/g,'=');
        table.reload('itemId', {
            url: 'findIndex.action?'+str,
            where: {

            }
        });
        return false;
    });

    form.on('submit(find1)', function (data) {
        // var date = JSON.stringify(data.field);
        // var str=date.toString().replace('{','').replace('}','').replace(/"/g,'').replace(/,/g,'&').replace(/:/g,'=');
        table.reload('itemId', {
            url: '/index/updateReconstructorIndex.action',
            where: {

            }
        });
        return false;
    });

    form.on('submit(find2)', function (data) {
        // var date = JSON.stringify(data.field);
        // var str=date.toString().replace('{','').replace('}','').replace(/"/g,'').replace(/,/g,'&').replace(/:/g,'=');
        table.reload('itemId', {
            url: '/index/deleteIndexAll.action',
            where: {

            }
        });
        return false;
    });


});
