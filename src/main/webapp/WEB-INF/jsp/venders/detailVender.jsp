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

    <title>添加厂商</title>

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
                            <label class="layui-form-label">厂商名称</label>
                            <div class="layui-input-block">
                                <input type="text" name="venderName" lay-verify="required" autocomplete="off"
                                       placeholder="请输入厂商名称" class="layui-input" value="${vender.venderName}">
                            </div>
                        </div>

                        <div class="layui-form-item">
                            <label class="layui-form-label">厂商地址</label>
                            <div class="layui-input-block">
                                <input type="text" name="venderAddress" lay-verify="required" autocomplete="off"
                                       placeholder="请输入厂商地址" class="layui-input" value="${vender.venderAddress}" readonly>
                            </div>
                        </div>

                        <div class="layui-form-item">
                            <div class="layui-inline">
                                <label class="layui-form-label">电话号码</label>
                                <div class="layui-input-inline">
                                    <input type="tel" name="venderPhone" lay-verify="phone" autocomplete="off"
                                           placeholder="请输入电话号码" class="layui-input" value="${vender.venderPhone}" readonly>
                                </div>
                            </div>
                            <div class="layui-inline">
                                <label class="layui-form-label">工商编号</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="icId"  autocomplete="off"
                                           class="layui-input" value="${vender.icId}" readonly>
                                </div>
                            </div>
                        </div>

                        <div class="layui-form-item">
                            <div class="layui-inline">
                                <label class="layui-form-label">邮箱</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="venderEmail" lay-verify="email" autocomplete="off"
                                           class="layui-input" value="${vender.venderEmail}" readonly>
                                </div>
                            </div>
                            <div class="layui-inline">
                                <label class="layui-form-label">邮编</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="venderPost" lay-verify="required" autocomplete="off"
                                           class="layui-input" value="${vender.venderPost}" readonly>
                                </div>
                            </div>
                        </div>

                        <div class="layui-form-item">
                            <label class="layui-form-label">经营范围</label>
                            <div class="layui-input-block">
                                <input type="text" name="businessRange" lay-verify="required" autocomplete="off"
                                       placeholder="请输入经营范围" class="layui-input" value="${vender.businessRange}" readonly>
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
</body>
