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
                    <form class="layui-form" action="" enctype="multipart/form-data" id="uploadForm">

                        <div class="layui-form-item">
                            <label class="layui-form-label">商品ID</label>
                            <div class="layui-input-block">
                                <input type="text" name="itemId" lay-verify="itemId" autocomplete="off"
                                       value="${item.itemId}" class="layui-input" id="itemId" >
                            </div>
                        </div>

                        <div class="layui-form-item">
                            <label class="layui-form-label">商品名称</label>
                            <div class="layui-input-block">
                                <input type="text" name="itemName" lay-verify="itemName" autocomplete="off"
                                       value="${item.itemName}" class="layui-input" >
                            </div>
                        </div>

                        <div class="layui-form-item">
                            <label class="layui-form-label">商品分类</label>
                            <div class="layui-input-block">
                                <select name="itemTypeId" lay-filter="aihao" lay-verify="itemTypeId" id="selectId">
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
                                           value="${item.itemMarketPrice}" class="layui-input" lay-verify="required" >
                                </div>
                            </div>

                            <div class="layui-inline">
                                <label class="layui-form-label">积分价格</label>
                                <div class="layui-input-block">
                                    <input type="text" name="scorePrice" autocomplete="off"
                                           value="${item.scorePrice}" class="layui-input">
                                </div>
                            </div>
                        </div>

                        <div class="layui-form-item">
                            <div class="layui-inline">
                                <label class="layui-form-label">一级分类</label>
                                <div class="layui-input-block">
                                    <input type="text" name="itemTypeOne" autocomplete="off"
                                           value="${item.itemTypeOne}" class="layui-input" lay-verify="itemTypeOne">
                                </div>
                            </div>

                            <div class="layui-inline">
                                <label class="layui-form-label">二级分类</label>
                                <div class="layui-input-block">
                                    <input type="text" name="itemTypeTwo" autocomplete="off"
                                           value="${item.itemTypeTwo}" class="layui-input">
                                </div>
                            </div>

                            <div class="layui-inline">
                                <label class="layui-form-label">三级分类</label>
                                <div class="layui-input-block">
                                    <input type="text" name="itemTypeThree" autocomplete="off"
                                           value="${item.itemTypeThree}" class="layui-input">
                                </div>
                            </div>
                        </div>


                        <div class="layui-form-item">
                            <div class="layui-inline">
                                <label class="layui-form-label">运费</label>
                                <div class="layui-input-block">
                                    <input type="text" name="postPrice" autocomplete="off"
                                           value="${item.postPrice}" class="layui-input">
                                </div>
                            </div>
                            <div class="layui-inline">
                                <label class="layui-form-label">库存数量</label>
                                <div class="layui-input-block">
                                    <input type="text" name="repertoryNumber" autocomplete="off"
                                           value="${item.repertoryNumber}" class="layui-input" lay-verify="required">
                                </div>
                            </div>
                            <div class="layui-inline">
                                <label class="layui-form-label">销售量</label>
                                <div class="layui-input-block">
                                    <input type="text" name="itemSaleNumber" autocomplete="off"
                                           value="${item.itemSaleNumber}" class="layui-input">
                                </div>
                            </div>

                        </div>

                        <div class="layui-form-item">
                            <div class="layui-inline">
                                <label class="layui-form-label">收藏数量</label>
                                <div class="layui-input-block">
                                    <input type="text" name="itemCollectNumber" value="${item.itemCollectNumber}" autocomplete="off"
                                            class="layui-input" readonly>
                                </div>
                            </div>

                            <div class="layui-inline">
                                <label class="layui-form-label">关键词</label>
                                <div class="layui-input-block">
                                    <input type="text" name="keyWord" value="${item.keyWord}" autocomplete="off"
                                            class="layui-input" lay-verify="required" >
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
                                 style="height: 290px;width: 320px; border: 0.1px solid rgb(243,243,244); ">
                                <img src="${item.itemImages}" alt="" height="240px" width="320px" id="itemImg">
                            </div>
                        </div>

                        <div class="layui-form-item">
                            <div class="layui-input-block">
                                <div class="layui-tab layui-tab-brief">
                                    <ul class="layui-tab-title">
                                        <li class="layui-this">上传本地图片</li>
                                        <li>上传网络图片</li>
                                    </ul>
                                    <div class="layui-tab-content">
                                        <div class="layui-tab-item layui-show">
                                            <button type="button" class="layui-btn" id="upload-file-btn">
                                                <i class="layui-icon">&#xe67c;</i>上传图片
                                            </button>
                                        </div>
                                        <div class="layui-tab-item">
                                            <div>
                                                <input type="text" id="netUrlInput" name="netUrl" autocomplete="off"
                                                       placeholder="请输入网络图片地址" class="layui-input"
                                                       style="margin-bottom: 10px">
                                                <button type="button" class="layui-btn" id="upload-net-file-btn">
                                                    <i class="layui-icon">&#xe67c;</i>上传图片
                                                </button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="layui-form-item">
                            <label class="layui-form-label">规格</label>
                            <div class="layui-input-block">
                                <input type="text" name="itemFormat" autocomplete="off"
                                       value="${item.itemFormat}" class="layui-input" lay-verify="itemFormat" >
                            </div>
                        </div>


                        <div class="layui-form-item">
                            <label class="layui-form-label">创建时间</label>
                            <div class="layui-input-block">
                                <input type="text" name="dateToString" value="${item.dateToString}" autocomplete="off"
                                       class="layui-input" readonly>
                            </div>
                        </div>

                        <div class="layui-form-item">
                            <label class="layui-form-label">描述</label>
                            <div class="layui-input-block">
                                <textarea  class="layui-textarea" name="itemIntroduce"
                                          lay-verify="required">${item.itemIntroduce}</textarea>
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
<script src="../../../shopmanagement/js/jquery-1.7.2.min.js"></script>
<script src="../../../js/items/Item.js"></script>
<script>
    $(function(){
        $("#selectId").find("option[value = '${item.itemTypeId}']").attr("selected","selected");
    })
</script>
</body>
