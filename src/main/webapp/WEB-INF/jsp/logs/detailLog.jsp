<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/sql" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>查看日志</title>

    <link rel="shortcut icon" href="../../../shopmanagement/favicon.ico">
    <link href="../../../shopmanagement/css/style.min.css?v=4.0.0" rel="stylesheet">
    <link href="../../../shopmanagement/common/layui/css/layui.css" rel="stylesheet"/>
    <base target="_blank">

</head>

<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">

                <div class="ibox-content">
                    <fieldset class="layui-elem-field layui-field-title">
                        <legend> 日志查看 </legend>
                    </fieldset>
                    <table class="layui-table" lay-even="" lay-skin="row">
                        <colgroup>
                            <col width="50%">
                            <col>
                        </colgroup>
                        <tbody>
                        <tr>
                            <td style="text-align: center;">编号</td>
                            <td>${log.logId}</td>
                        </tr>
                        <tr>
                            <td style="text-align: center;">用户ID</td>
                            <td>${log.userUuid}</td>
                        </tr>
                        <tr>
                            <td style="text-align: center;">登陆ip</td>
                            <td>${log.logHistoryIp}</td>
                        </tr>
                        <tr>
                            <td style="text-align: center;">间隔时间</td>
                            <td>${log.logSpaceToString}</td>
                        </tr>
                        <tr>
                            <td style="text-align: center;">加权时间</td>
                            <td>${log.logWeighting}</td>
                        </tr>
                        <tr>
                            <td style="text-align: center;">商品状态码</td>
                            <td>${log.itemStatus}</td>
                        </tr>
                        <tr>
                            <td style="text-align: center;">商品类型</td>
                            <td>${log.itemTypeStatus}</td>
                        </tr>
                        <tr>
                            <td style="text-align: center;">搜索关键词</td>
                            <td>${log.logKeyWord}</td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>

</body>

</html>