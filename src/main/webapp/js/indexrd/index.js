var formData = null;

layui.use(['form', 'layedit', 'laydate', 'element'], function () {
    var form = layui.form,
        layer = layui.layer,
        layedit = layui.layedit,
        laydate = layui.laydate,
        element = layui.element;

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

    });

    //监听提交
    form.on('submit(demo1)', function (data) {
        if (formData === null)
            formData = $('#uploadForm').serialize().toString();
        console.log(formData);
        $.ajax({
            url: 'updateIndex.action',
            data: formData,
            type: "POST",
            success: function () {
                parent.layer.closeAll();
                swal({
                    title: "太帅了",
                    text: "添加数据成功！",
                    type: "success"
                });
                window.parent.location.reload();
            }
        });
        return false;
    });

});

layui.use('upload', function () {
    var upload = layui.upload;

    //执行实例
    var uploadInst = upload.render({
        elem: '#upload-file-btn' //绑定元素
        , url: '/file/uploadFile.action' //上传接口
        , accept: 'images'    //指定允许上传的文件类型，可选值有：images（图片）、file（所有文件）、video（视频）、audio（音频）
        , auto: true      //是否选完文件后自动上传
        , field: 'uploadFile'       //设定文件域的字段名
        , size: 20480     //设置文件最大可允许上传的大小，单位 KB。不支持ie8/9
        , multiple: false     //	是否允许多文件上传。设置 true即可开启。不支持ie8/9
        , choose: function (res) {  //选择文件后的回调函数。返回一个object参数

        }
        , before: function (res) {  //文件提交上传前的回调。返回一个object参数

        }
        , done: function (res) {    //执行上传请求后的回调。返回三个参数，分别为：res（服务端响应信息）、index（当前文件的索引）、upload（重新上传的方法，一般在文件上传失败后使用）
            // 文件上传成功后，更新数据库文件访问地址
            console.log(res.msg);
            formData = $('#uploadForm').serialize().toString();
            formData += '&itemImages=' + res.data.src;
            if (res.code === 0) {
                $.ajax({
                    url: 'updateItem.action',
                    data: formData,
                    type: "POST",
                    success: function () {
                        layer.msg("图片修改成功！");
                        console.log("更新数据库文件地址成功！");
                        $('#itemImg').attr('src', res.data.src)
                    }
                });
            } else {
                layer.msg("图片修改失败！");
            }
        }
        , error: function () {      //执行上传请求出现异常的回调（一般为网络异常、URL 404等）。返回两个参数，分别为：index（当前文件的索引）、upload（重新上传的方法）

        }
    });
});

// 上传网络图片
$('#upload-net-file-btn').click(function () {
    var netUrl = $('#netUrlInput');
    if (netUrl.val() !== '') {
        $.ajax({
            url: '/file/uploadNetFile.action',
            data: netUrl.attr('name') + '=' + netUrl.val(),
            type: "POST",
            success: function (res) {
                // 文件上传成功后，更新数据库文件访问地址
                console.log(res.msg);
                fileUrl = res.data.src;
                if (res.code === 0) {
                    $('#itemImg').attr('src', res.data.src);
                    parent.layer.msg("网络图片上传成功");
                    // 添加图片地址到form表单
                    formData = $('#uploadForm').serialize().toString();
                    formData += '&itemImages=' + res.data.src;
                } else {
                    layer.msg("图片修改失败！");
                }
            }
        });
    } else {
        parent.layer.msg("请先输入图片URL地址")
    }
});