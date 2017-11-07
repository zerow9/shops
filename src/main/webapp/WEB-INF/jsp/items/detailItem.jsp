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
    String dir = request.getSession().getServletContext().getRealPath("shopmanagement");
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
                            <label class="layui-form-label">商品分类</label>
                            <div class="layui-input-block">
                                <select name="itemTypeId" lay-filter="aihao" lay-verify="itemTypeId">
                                    <option value=""></option>
                                    <option value="3" selected="">家电</option>
                                    <option value="1">营养品</option>
                                    <option value="2">生活必需品</option>
                                </select>
                            </div>
                        </div>

                        <div class="layui-form-item">
                            <div class="layui-inline">
                                <label class="layui-form-label">价格</label>
                                <div class="layui-input-block">
                                    <input type="text" name="itemPrice" autocomplete="off"
                                           value="${item.itemPrice}" class="layui-input" lay-verify="required">
                                </div>
                            </div>
                            <div class="layui-inline">
                                <label class="layui-form-label">市场价格</label>
                                <div class="layui-input-block">
                                    <input type="text" name="itemMarketPrice" autocomplete="off"
                                           value="${item.itemMarketPrice}" class="layui-input" lay-verify="required"
                                           readonly>
                                </div>
                            </div>

                            <div class="layui-inline">
                                <label class="layui-form-label">积分价格</label>
                                <div class="layui-input-block">
                                    <input type="text" name="scorePrice" autocomplete="off"
                                           value="${item.scorePrice}" class="layui-input" readonly>
                                </div>
                            </div>
                        </div>

                        <div class="layui-form-item">
                            <div class="layui-inline">
                                <label class="layui-form-label">一级分类</label>
                                <div class="layui-input-block">
                                    <input type="text" name="itemTypeOne" autocomplete="off"
                                           value="${item.itemTypeOne}" class="layui-input" lay-verify="itemTypeOne"
                                           readonly>
                                </div>
                            </div>

                            <div class="layui-inline">
                                <label class="layui-form-label">二级分类</label>
                                <div class="layui-input-block">
                                    <input type="text" name="itemTypeTwo" autocomplete="off"
                                           value="${item.itemTypeTwo}" class="layui-input" readonly>
                                </div>
                            </div>

                            <div class="layui-inline">
                                <label class="layui-form-label">三级分类</label>
                                <div class="layui-input-block">
                                    <input type="text" name="itemTypeThree" autocomplete="off"
                                           value="${item.itemTypeThree}" class="layui-input" readonly>
                                </div>
                            </div>
                        </div>


                        <div class="layui-form-item">
                            <div class="layui-inline">
                                <label class="layui-form-label">运费</label>
                                <div class="layui-input-block">
                                    <input type="text" name="postPrice" autocomplete="off"
                                           value="${item.postPrice}" class="layui-input" readonly>
                                </div>
                            </div>
                            <div class="layui-inline">
                                <label class="layui-form-label">库存数量</label>
                                <div class="layui-input-block">
                                    <input type="text" name="repertoryNumber" autocomplete="off"
                                           value="${item.repertoryNumber}" class="layui-input" lay-verify="required"
                                           readonly>
                                </div>
                            </div>
                            <div class="layui-inline">
                                <label class="layui-form-label">销售量</label>
                                <div class="layui-input-block">
                                    <input type="text" name="itemSaleNumber" autocomplete="off"
                                           value="${item.itemSaleNumber}" class="layui-input" readonly>
                                </div>
                            </div>

                        </div>

                        <div class="layui-form-item">
                            <div class="layui-inline">
                                <label class="layui-form-label">收藏数量</label>
                                <div class="layui-input-block">
                                    <input type="text" name="itemCollectNumber" value="${item.itemCollectNumber}"
                                           autocomplete="off"
                                           class="layui-input" readonly>
                                </div>
                            </div>

                            <div class="layui-inline">
                                <label class="layui-form-label">关键词</label>
                                <div class="layui-input-block">
                                    <input type="text" name="keyWord" value="${item.keyWord}" autocomplete="off"
                                           class="layui-input" lay-verify="required" readonly>
                                </div>
                            </div>

                            <div class="layui-inline">
                                <label class="layui-form-label">生产厂商</label>
                                <div class="layui-input-block">
                                    <input type="text" name="makeVender" value="${item.makeVender}" autocomplete="off"
                                           class="layui-input" lay-verify="required" readonly>
                                </div>
                            </div>

                        </div>

                        <div class="layui-form-item">
                            <label class="layui-form-label">商品图片</label>
                            <div class="layui-input-block"
                                 style="height: 120px;width: 120px; border: 0.1px solid rgb(243,243,244); ">
                                <img src="http://localhost:8080/shopmanagement${item.itemImages}" alt="" height="120px" width="120px">
                            </div>
                        </div>

                        <div class="layui-form-item">
                            <label class="layui-form-label">规格</label>
                            <div class="layui-input-block">
                                <input type="text" name="itemFormat" autocomplete="off"
                                       value="${item.itemFormat}" class="layui-input" lay-verify="itemFormat" readonly>
                            </div>
                        </div>


                        <div class="layui-form-item">
                            <label class="layui-form-label">创建时间</label>
                            <div class="layui-input-block">
                                <input type="text" name="makeDate" value="${item.dateToString}" autocomplete="off"
                                       class="layui-input" readonly>
                            </div>
                        </div>

                        <div class="layui-form-item">
                            <label class="layui-form-label">描述</label>
                            <div class="layui-input-block">
                                <textarea class="layui-textarea" name="itemIntroduce"
                                          lay-verify="required">${item.itemIntroduce}</textarea>
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
<script src="../../../js/items/addItem.js"></script>
</body>
