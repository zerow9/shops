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

    <title>查看用户</title>

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
                            <label class="layui-form-label">UUID</label>
                            <div class="layui-input-block">
                                <input type="text" name="userUuid" lay-verify="required" autocomplete="off"
                                       class="layui-input" value="${user.userUuid}" readonly>
                            </div>
                        </div>


                        <div class="layui-form-item">
                            <label class="layui-form-label">用户昵称</label>
                            <div class="layui-input-block">
                                <input type="text" name="userNickname" lay-verify="required" autocomplete="off"
                                       placeholder="请输入昵称" class="layui-input" value="${user.userNickname}" readonly>
                            </div>
                        </div>

                        <div class="layui-form-item">
                            <label class="layui-form-label">真实姓名</label>
                            <div class="layui-input-block">
                                <input type="text" name="userName" lay-verify="required"
                                       placeholder="请输入真实姓名" autocomplete="off" class="layui-input"
                                       value="${user.userName}" readonly>
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <div class="layui-form-item">
                                <label class="layui-form-label">性别</label>
                                <div class="layui-input-block">
                                    <input type="radio" name="userSex" title="男" value="男" disabled="disabled"
                                           <c:if test="${user.userSex== '男'}">checked="checked"</c:if>>
                                    <input type="radio" name="userSex" title="女" value="女" disabled="disabled"
                                           <c:if test="${user.userSex== '女'}">checked="checked"</c:if>>
                                    <input type="radio" name="userSex" title="保密" value="保密" disabled="disabled"
                                           <c:if test="${user.userSex== '保密'}">checked="checked"</c:if>>
                                </div>
                            </div>
                            <div class="layui-form-item">
                                <label class="layui-form-label">健康状况</label>
                                <div class="layui-input-block">
                                    <input type="radio" name="userHealthy" title="健康" value="健康" disabled="disabled"
                                           <c:if test="${user.userHealthy== '健康'}">checked="checked"</c:if>>
                                    <input type="radio" name="userHealthy" title="亚健康" value="亚健康" disabled="disabled"
                                           <c:if test="${user.userHealthy== '亚健康'}">checked="checked"</c:if>>
                                    <input type="radio" name="userHealthy" title="不健康" value="不健康" disabled="disabled"
                                           <c:if test="${user.userHealthy== '不健康'}">checked="checked"</c:if>>
                                    <input type="radio" name="userHealthy" title="保密" value="保密" disabled="disabled"
                                           <c:if test="${user.userHealthy== '保密'}">checked="checked"</c:if>>
                                </div>
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <div class="layui-inline">
                                <label class="layui-form-label">电话号码</label>
                                <div class="layui-input-inline">
                                    <input type="tel" name="userPhone" lay-verify="phone" readonly autocomplete="off"
                                           placeholder="请输入电话号码"
                                           class="layui-input" value="${user.userPhone}">
                                </div>
                            </div>
                            <div class="layui-inline">
                                <label class="layui-form-label">验证邮箱</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="userEmail" autocomplete="off" readonly
                                           class="layui-input" value="${user.userEmail}">
                                </div>
                            </div>
                        </div>

                        <div class="layui-form-item">
                            <div class="layui-inline">
                                <label class="layui-form-label">年龄</label>
                                <div class="layui-input-inline">
                                    <input type="tel" name="userAge" autocomplete="off"
                                           placeholder="请输入年龄" class="layui-input" readonly value="${user.userAge}">
                                </div>
                            </div>
                            <div class="layui-inline">
                                <label class="layui-form-label">注册日期</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="userRegisterDateTime1" readonly autocomplete="off"
                                           class="layui-input" value="${user.dateToString}">
                                </div>
                            </div>
                        </div>

                        <div class="layui-form-item">
                            <div class="layui-inline">
                                <label class="layui-form-label">积分</label>
                                <div class="layui-input-inline">
                                    <input type="tel" name="userScore" autocomplete="off" class="layui-input"
                                           value="${user.userScore}" readonly>
                                </div>
                            </div>
                            <div class="layui-inline">
                                <label class="layui-form-label">登录次数</label>
                                <div class="layui-input-inline">
                                    <input type="tel" name="userPhone" lay-verify="phone" autocomplete="off" readonly
                                           class="layui-input" value="${user.userLandNumber}">
                                </div>
                            </div>
                        </div>

                        <div class="layui-form-item">
                            <label class="layui-form-label">归属组</label>
                            <div class="layui-input-inline">
                                <select name="userGroup" lay-filter="aihao" id="group" readonly>
                                    <c:forEach items="${groups}" var="groupss" varStatus="s">
                                        <option value="${s.index+1}" disabled>${groupss.groupName}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>

                        <div class="layui-form-item">
                            <label class="layui-form-label">地址</label>
                            <div class="layui-input-block">
                                <input type="text" name="userAddress" placeholder="请输入地址" readonly
                                       autocomplete="off" class="layui-input" value="${user.userAddress}">
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
<script  src="../../../js/itemtypes/detailTypes.js"></script>
<script src="../../../js/user/updateUser.js"></script>
<script src="../../../shopmanagement/js/jquery-1.7.2.min.js"></script>

<script >
    $(function(){
        $("#group").find("option[value = '${user.userGroup}']").attr("selected","selected");
    })
</script>
</body>
</html>