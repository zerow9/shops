<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>修改类别信息</title>

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


                        <input type="hidden" name="typeId" value="${itemtypes.typeId}"/>

                        <div class="layui-form-item">
                            <label class="layui-form-label">分类名称</label>
                            <div class="layui-input-block">
                                <input type="text" name="typeName" lay-verify="required" autocomplete="off" placeholder="请输入类别名称"
                                       class="layui-input">
                            </div>
                        </div>


                        <div class="layui-form-item">
                            <label class="layui-form-label">父类</label>
                            <div class="layui-input-block">
                                <select name="fatherTypeId" lay-filter="fatherTypeId">
                                    <option value="" selected=""></option>
                                    <option value="1" >药品</option>
                                    <option value="2">日用品</option>
                                    <option value="3">营养品</option>
                                    <option value="4">保健类</option>
                                    <option value="5">健身器材</option>
                                    <option value="6">食品</option>
                                    <option value="7">衣物</option>
                                </select>
                            </div>
                        </div>

                        <div class="layui-form-item">
                            <label class="layui-form-label">分类等级</label>
                            <div class="layui-input-block">
                                <select name="typeLevel" lay-filter="typeLevel">
                                    <option value="" selected=""></option>
                                    <option value="1" >一级分类</option>
                                    <option value="2">二级分类</option>
                                    <option value="3">三级分类</option>
                                </select>
                            </div>
                        </div>

                        <div class="layui-form-item">
                            <label class="layui-form-label">关键字</label>
                            <div class="layui-input-block">
                                <input type="text" name="typeKeyWord" lay-verify="required" autocomplete="off" placeholder="请输入类别关键字"
                                       class="layui-input">
                            </div>
                        </div>

                        <div class="layui-form-item">
                            <label class="layui-form-label">分类描述</label>
                            <div class="layui-input-block">
                                <input type="text" name="typeIntroduce" lay-verify="required" autocomplete="off" placeholder="请输入类别描述"
                                       class="layui-input">
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
<script  src="../../../js/itemtypes/updateitemTypes.js"></script>
</body>
