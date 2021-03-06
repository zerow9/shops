<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>添加索引</title>

    <link rel="shortcut icon" href="../../../shopmanagement/favicon.ico">
    <link href="../../../shopmanagement/common/font-awesome-4.7.0/css/font-awesome.css" rel="stylesheet">
    <link href="../../../shopmanagement/css/style.min.css?v=4.0.0" rel="stylesheet">
    <link href="../../../shopmanagement/css/plugins/sweetalert/sweetalert.css" rel="stylesheet">
    <link href="../../../shopmanagement/common/layui/css/layui.css" rel="stylesheet"/>
    <base target="_blank">

</head>

<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">

                <div class="ibox-content">
                    <form class="layui-form" action="" enctype="multipart/form-data">

                        <div class="layui-form-item">
                            <label class="layui-form-label">商品ID</label>
                            <div class="layui-input-block">
                                <input type="text" name="itemName" lay-verify="itemName" autocomplete="off"
                                       value="${item.itemId}" class="layui-input" readonly>
                            </div>
                        </div>

                        <div class="layui-form-item">
                            <label class="layui-form-label">商品名称</label>
                            <div class="layui-input-block">
                                <input type="text" name="itemName" lay-verify="itemName" autocomplete="off"
                                       value="${item.itemName}" class="layui-input" readonly>
                            </div>
                        </div>

                        <div class="layui-form-item">
                            <div class="layui-inline">
                                <label class="layui-form-label">市场价格</label>
                                <div class="layui-input-block">
                                    <input type="text" name="itemMarketPrice" autocomplete="off"
                                           value="${item.itemMarketPrice}" class="layui-input" lay-verify="required"
                                           readonly>
                                </div>
                            </div>
                        </div>


                        <div class="layui-form-item">
                            <label class="layui-form-label">商品图片</label>
                            <div class="layui-input-block"
                                 style="height: 120px;width: 120px; border: 0.1px solid rgb(243,243,244); ">
                                <img src="${item.itemImages}" alt="" height="120px" width="120px">
                            </div>
                        </div>

                        <div class="layui-form-item">
                            <label class="layui-form-label">创建时间</label>
                            <div class="layui-input-block">
                                <input type="text" name="makeDate" value="${item.dateToString}" autocomplete="off"
                                       class="layui-input" readonly>
                            </div>
                        </div>


                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="../../../shopmanagement/common/layui/layui.js" charset="utf-8" type="text/javascript"></script>
<script src="../../../shopmanagement/js/plugins/sweetalert/sweetalert.min.js"></script>
<script src="../../../shopmanagement/js/jquery-1.7.2.min.js"></script>
<script src="../../../js/items/addItem.js"></script>
<script>
    $(function(){
        $("#selectId1").find("option[value = '${item.itemTypeId}']").attr("selected","selected");
    })
</script>
</body>
