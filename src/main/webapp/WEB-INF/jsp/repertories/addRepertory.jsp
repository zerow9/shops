<%--
Created by IntelliJ IDEA.
User: TongZhou
Date: 2017/11/6
Time: 14:44
To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>

<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>添加用户</title>

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
                            <div class="layui-inline">
                                <label class="layui-form-label">商品编号</label>
                                <div class="layui-input-block">
                                    <input type="text" name="itemId" autocomplete="off" placeholder="0" class="layui-input" lay-verify="required">
                                </div>
                            </div>
                        </div>

                        <div class="layui-form-item">
                            <div class="layui-inline">
                                <label class="layui-form-label">商品名称</label>
                                <div class="layui-input-block">
                                    <select name="itemTypeId" lay-filter="itemTypeId" lay-verify="itemTypeId">
                                        <option value=""></option>
                                        <option value="3" selected="">商品名称1</option>
                                        <option value="1">商品名称1</option>
                                        <option value="2">商品名称1</option>
                                    </select>
                                </div>
                            </div>

                            <div class="layui-inline">
                                <label class="layui-form-label">商店名称</label>
                                <div class="layui-input-block">
                                    <select name="shopId" lay-filter="shopId" lay-verify="itemTypeId">
                                        <option value=""></option>
                                        <option value="3" selected="">商店1</option>
                                        <option value="1">商店2</option>
                                        <option value="2">商店3</option>
                                    </select>
                                </div>
                            </div>
                        </div>

                        <div class="layui-form-item">
                            <div class="layui-inline">
                                <label class="layui-form-label">市场价格</label>
                                <div class="layui-input-block">
                                    <input type="text" name="itemMarketPrice" autocomplete="off"
                                           placeholder="￥" class="layui-input" lay-verify="required">
                                </div>
                            </div>

                            <div class="layui-inline">
                                <label class="layui-form-label">原始价格</label>
                                <div class="layui-input-block">
                                    <input type="text" name="itemOriginalPrice" autocomplete="off"
                                           placeholder="￥" class="layui-input" lay-verify="required">
                                </div>
                            </div>

                        </div>


                        <div class="layui-form-item">
                            <div class="layui-inline">
                                <label class="layui-form-label">入库时间</label>
                                <div class="layui-input-block">
                                    <input type="text" name="repertoryPuttime" id="date1" lay-verify="date"
                                           placeholder="yyyy-MM-dd HH:mm:ss" autocomplete="off"
                                           placeholder="入库时间" class="layui-input">
                                </div>
                            </div>
                            <div class="layui-inline">
                                <label class="layui-form-label">修改时间</label>
                                <div class="layui-input-block">
                                    <input type="text" name="updateTime" id="date2" lay-verify="date"
                                           placeholder="yyyy-MM-dd HH:mm:ss" autocomplete="off"
                                           placeholder="修改时间" class="layui-input">
                                </div>
                            </div>
                        </div>

                        <div class="layui-form-item">
                            <div class="layui-inline">
                                <label class="layui-form-label">库存数量</label>
                                <div class="layui-input-block">
                                    <input type="text" name="repertoryNumber" autocomplete="off"
                                           placeholder="0" class="layui-input" lay-verify="required">
                                </div>
                            </div>
                        </div>

                        <div class="layui-form-item">
                            <div class="layui-inline">
                                <label class="layui-form-label">生产商名称</label>
                                <div class="layui-input-block">
                                    <select name="venderId" lay-filter="venderId" lay-verify="itemTypeId">
                                        <option value=""></option>
                                        <option value="3" selected="">商店1</option>
                                        <option value="1">商店2</option>
                                        <option value="2">商店3</option>
                                    </select>
                                </div>
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
<script src="../../../js/repertories/addRepertory.js"></script>
</body>
