<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>库存详情</title>
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
                    <form class="layui-form" action="">
                        <div class="layui-form-item">
                            <label class="layui-form-label">库存编号</label>
                            <div class="layui-input-block">
                                <input type="text" name="repertoryId" lay-verify="required" autocomplete="off"
                                       placeholder="请输入类别名称" class="layui-input" value="${repertory.repertoryId}"
                                       readonly>
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">商品编号</label>
                            <div class="layui-input-block">
                                <input type="text" name="itemId" lay-verify="required" autocomplete="off"
                                       class="layui-input" value="${repertory.itemId}"
                                >
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">商品市场价格</label>
                            <div class="layui-input-block">
                                <input type="text" name="itemMarketPrice" lay-verify="required" autocomplete="off"
                                       class="layui-input" value="${repertory.itemMarketPrice}"
                                >
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">商品原始价格</label>
                            <div class="layui-input-block">
                                <input type="text" name="itemOriginalPrice" lay-verify="required" autocomplete="off"
                                       class="layui-input" value="${repertory.itemOriginalPrice}"
                                >
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">商店</label>
                            <div class="layui-input-block">
                                <input type="text" name="shopId" lay-verify="required" autocomplete="off"
                                       class="layui-input" value="${repertory.shopId}"
                                >
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">库存量</label>
                            <div class="layui-input-block">
                                <input type="text" name="repertoryNumber" lay-verify="required" autocomplete="off"
                                       class="layui-input" value="${repertory.repertoryNumber}"
                                >
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">入库时间</label>
                            <div class="layui-input-block">
                                <input type="text" lay-verify="required" autocomplete="off"
                                       class="layui-input" name="repertoryPuttime" value="${repertory.puttimeToString}"
                                       readonly>
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">修改时间</label>
                            <div class="layui-input-block">
                                <input type="text" name="updateTime" lay-verify="required" autocomplete="off"
                                       class="layui-input" value="${repertory.updateToString}"
                                >
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">商家编号</label>
                            <div class="layui-input-block">
                                <input type="text" name="venderId" lay-verify="required" autocomplete="off"
                                       class="layui-input" value="${repertory.venderId}"
                                >
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <div class="layui-input-block">
                                <button class="layui-btn" lay-submit="" lay-filter="demo1">立即提交</button>
                                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
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
<script  src="../../../js/repertories/updateRepertory.js"></script>
</body>
