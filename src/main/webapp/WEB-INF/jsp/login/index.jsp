<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="org.apache.shiro.SecurityUtils" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <title>孝和商城管理系统后台</title>
    <link rel="shortcut icon" href="../../../shopmanagement/favicon.ico">
    <link rel="stylesheet" href="../../../shopmanagement/common/layui/css/layui.css">
    <link href="../../../shopmanagement/css/bootstrap.min.css?v=3.3.5" rel="stylesheet">
    <link href="../../../shopmanagement/css/font-awesome.min.css?v=4.4.0" rel="stylesheet">
    <link href="../../../shopmanagement/css/animate.min.css" rel="stylesheet">
    <link href="../../../shopmanagement/css/style.min.css?v=4.0.0" rel="stylesheet">
</head>

<body class="fixed-sidebar full-height-layout gray-bg" style="overflow:hidden">
<div id="wrapper">
    <!--左侧导航开始-->
    <nav class="navbar-default navbar-static-side" role="navigation">
        <div class="nav-close"><i class="fa fa-times-circle"></i>
        </div>
        <%
            String user = SecurityUtils.getSubject().getPrincipal().toString();
            boolean b = user.equalsIgnoreCase("root");
        %>
        <div class="sidebar-collapse" style="background-color:#0C0C0C ">
            <ul class="nav" id="side-menu">

                <!--当前登录用户展示-->
                <li class="nav-header">
                    <div class="dropdown profile-element">
                        <span><img alt="image" class="img-circle" src="../../../shopmanagement/img/admin.jpg"/></span>
                        <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                                <span class="clear">
                               <span class="block m-t-xs"><strong class="font-bold">欢迎<%=user%>登陆</strong></span>
                                <span class="text-muted text-xs block">超级管理员<b class="caret"></b></span>
                                </span>
                        </a>
                        <ul class="dropdown-menu animated fadeInRight m-t-xs">
                            <li><a class="J_menuItem" href="form_avatar.html">修改头像</a>
                            </li>
                            <li><a class="J_menuItem" href="profile.html">个人资料</a>
                            </li>
                            <li><a class="J_menuItem" href="contacts.html">联系我们</a>
                            </li>
                            <li><a class="J_menuItem" href="mailbox.html">信箱</a>
                            </li>
                            <li class="divider"></li>
                            <li><a href="/logout.action">安全退出</a>
                            </li>
                        </ul>
                    </div>
                    <div class="logo-element">孝和商城</div>
                </li>

                <!--首页-->
                <li>
                    <a class="J_menuItem" href="../../../jsp/admin/home.jsp">
                        <i class="fa fa-home"></i>
                        <span class="nav-label">首页</span>
                    </a>
                </li>

                <c:if test="<%=b%>">
                    <li>
                        <a href="javascript:;">
                            <i class="fa fa-user"></i>
                            <span class="nav-label">管理员管理</span>
                            <span class="fa arrow"></span>
                        </a>
                        <ul class="nav nav-second-level">
                            <li><a class="J_menuItem" href="/admin/selectAdminAll.action">管理员列表</a>
                            </li>
                        </ul>
                    </li>
                </c:if>

                <!--用户管理-->
                <li>
                    <a href="#">
                        <i class="fa fa-user"></i>
                        <span class="nav-label">用户管理</span>
                        <span class="fa arrow"></span>
                    </a>
                    <ul class="nav nav-second-level">
                        <li><a class="J_menuItem" href="/admin/selectUserAll.action">用户列表</a>
                        </li>
                        <li><a class="J_menuItem" href="admin/selectGroupsAll.action">用户组列表</a>
                        </li>
                        <li><a class="J_menuItem" href="complaint/selectComplaintAll.action">投诉管理</a>
                        </li>
                    </ul>
                </li>

                <!--商品管理-->
                <li>
                    <a href="#">
                        <i class="fa fa-shopping-cart"></i>
                        <span class="nav-label">商品管理</span>
                        <span class="fa arrow"></span>
                    </a>
                    <ul class="nav nav-second-level">
                        <li><a class="J_menuItem" href="/item/forwardItemList.action">商品列表</a>
                        </li>
                        <li><a class="J_menuItem" href="/itemType/forwardItemTypeList.action">商品分类</a>
                        </li>
                        <li><a class="J_menuItem" href="/repertories/forwardRepertories.action">库存管理</a></li>
                        <li><a class="J_menuItem" href="/venders/forwardVenders.action">厂商管理</a></li>
                        <li><a class="J_menuItem" href="/shop/forwordShop.action">商店管理</a></li>
                    </ul>
                </li>

                <li>
                    <a href="#">
                        <i class="fa fa-first-order"></i>
                        <span class="nav-label">订单管理</span>
                        <span class="fa arrow"></span>
                    </a>
                    <ul class="nav nav-second-level">
                        <li><a class="J_menuItem" href="/order/orderList.action">订单列表</a>
                        </li>
                    </ul>
                </li>

                <!--内容管理-->
                <li>
                    <a href="#">
                        <i class="fa fa-book"></i>
                        <span class="nav-label">内容管理</span>
                        <span class="fa arrow"></span>
                    </a>
                    <ul class="nav nav-second-level">
                        <li><a class="J_menuItem" href="#">广告</a>
                        </li>
                        <li><a class="J_menuItem" href="/notices/noticesList.action">公告管理</a>
                        </li>
                    </ul>
                </li>

                <!--营销管理-->
                <li>
                    <a href="#">
                        <i class="fa fa-database"></i>
                        <span class="nav-label">营销管理</span>
                        <span class="fa arrow"></span>
                    </a>
                    <ul class="nav nav-second-level">
                        <li><a class="J_menuItem" href="#">推荐管理</a>
                        </li>
                    </ul>
                </li>

                <!--系统管理-->
                <li>
                    <a href="#">
                        <i class="fa fa-wrench"></i>
                        <span class="nav-label">系统管理</span>
                        <span class="fa arrow"></span>
                    </a>
                    <ul class="nav nav-second-level">
                        <li><a class="J_menuItem" href="log/forwordLog.action">日志管理</a>
                        </li>
                        <li><a class="J_menuItem" href="/index/index.action">索引管理</a>
                        </li>
                        </li>
                    </ul>
                </li>

            </ul>
        </div>
    </nav>
    <!--左侧导航结束-->

    <!--右侧部分开始-->
    <div id="page-wrapper" class="gray-bg dashbard-1">
        <div class="row border-bottom">
            <nav class="navbar navbar-static-top" role="navigation" style="margin-bottom: 0">
                <div class="navbar-header"><a class="navbar-minimalize minimalize-styl-2 btn btn-primary " href="#"><i
                        class="fa fa-bars"></i> </a>
                </div>
                <ul class="nav navbar-top-links navbar-right">
                    <li class="dropdown">
                        <a class="dropdown-toggle count-info" data-toggle="dropdown" href="#">
                            <i class="fa fa-envelope"></i> <span class="label label-warning">1</span>
                        </a>
                        <ul class="dropdown-menu dropdown-messages">

                            <li>
                                <div class="dropdown-messages-box">
                                    <a href="profile.html" class="pull-left">
                                        <img alt="image" class="img-circle" src="../../../shopmanagement/img/a0.jpg">
                                    </a>
                                    <div class="media-body ">
                                        <small class="pull-right text-navy">刚刚</small>
                                        <strong>孝和系统</strong> hello ，i am coming！
                                        <br>
                                        <small class="text-muted">今天</small>
                                    </div>
                                </div>
                            </li>
                            <li class="divider"></li>
                            <li>
                                <div class="text-center link-block">
                                    <a class="J_menuItem" href="mailbox.html">
                                        <i class="fa fa-envelope"></i> <strong> 查看所有消息</strong>
                                    </a>
                                </div>
                            </li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a class="dropdown-toggle count-info" data-toggle="dropdown" href="#">
                            <i class="fa fa-bell"></i> <span class="label label-primary">1</span>
                        </a>
                        <ul class="dropdown-menu dropdown-alerts">
                            <li>
                                <a href="mailbox.html">
                                    <div>
                                        <i class="fa fa-envelope fa-fw"></i> 您有1条未读消息
                                        <span class="pull-right text-muted small">4分钟前</span>
                                    </div>
                                </a>
                            </li>
                            <li class="divider"></li>
                            <li>
                                <div class="text-center link-block">
                                    <a class="J_menuItem" href="notifications.html">
                                        <strong>查看所有 </strong>
                                        <i class="fa fa-angle-right"></i>
                                    </a>
                                </div>
                            </li>
                        </ul>
                    </li>
                    <li class="dropdown hidden-xs">
                        <a class="right-sidebar-toggle" aria-expanded="false">
                            <i class="fa fa-tasks"></i> 主题
                        </a>
                    </li>
                </ul>
            </nav>
        </div>
        <div class="row content-tabs">
            <nav class="page-tabs J_menuTabs">
                <div class="page-tabs-content">
                    <a href="javascript:;" class="active J_menuTab" data-id="../../../jsp/admin/home.jsp">首页</a>
                </div>
            </nav>
            <a href="/logout.action" class="roll-nav roll-right J_tabExit"><i
                    class="fa fa fa-sign-out"></i> 退出</a>
        </div>
        <div class="row J_mainContent" id="content-main">
            <iframe class="J_iframe" name="iframe0" width="100%" height="100%"
                    src="../../../jsp/admin/home.jsp" frameborder="0"
                    data-id="../../../jsp/admin/home.jsp" seamless></iframe>
        </div>
        <div class="footer">
            <div class="pull-right">&copy; 2017-2020 <a href="javascript:;" target="_blank">Yang Coding</a>
            </div>
        </div>
    </div>
    <!--右侧部分结束-->


    <!--右侧边栏开始-->
    <div id="right-sidebar">
        <div class="sidebar-container">

            <ul class="nav nav-tabs navs">

                <li class="active">
                    <a data-toggle="tab" href="#tab-1">
                        <i class="fa fa-gear"></i> 主题
                    </a>
                </li>

            </ul>

            <div class="tab-content">
                <div id="tab-1" class="tab-pane active">
                    <div class="sidebar-title">
                        <h3><i class="fa fa-comments-o"></i> 主题设置</h3>
                        <small><i class="fa fa-tim"></i> 你可以从这里选择和预览主题的布局和样式，这些设置会被保存在本地，下次打开的时候会直接应用这些设置。</small>
                    </div>
                    <div class="skin-setttings">
                        <div class="title">主题设置</div>
                        <div class="setings-item">
                            <span>收起左侧菜单</span>
                            <div class="switch">
                                <div class="onoffswitch">
                                    <input type="checkbox" name="collapsemenu" class="onoffswitch-checkbox"
                                           id="collapsemenu">
                                    <label class="onoffswitch-label" for="collapsemenu">
                                        <span class="onoffswitch-inner"></span>
                                        <span class="onoffswitch-switch"></span>
                                    </label>
                                </div>
                            </div>
                        </div>
                        <div class="setings-item">
                            <span>固定顶部</span>

                            <div class="switch">
                                <div class="onoffswitch">
                                    <input type="checkbox" name="fixednavbar" class="onoffswitch-checkbox"
                                           id="fixednavbar">
                                    <label class="onoffswitch-label" for="fixednavbar">
                                        <span class="onoffswitch-inner"></span>
                                        <span class="onoffswitch-switch"></span>
                                    </label>
                                </div>
                            </div>
                        </div>
                        <div class="setings-item">
                                <span>
                        固定宽度
                    </span>
                            <div class="switch">
                                <div class="onoffswitch">
                                    <input type="checkbox" name="boxedlayout" class="onoffswitch-checkbox"
                                           id="boxedlayout">
                                    <label class="onoffswitch-label" for="boxedlayout">
                                        <span class="onoffswitch-inner"></span>
                                        <span class="onoffswitch-switch"></span>
                                    </label>
                                </div>
                            </div>
                        </div>
                        <div class="title">皮肤选择</div>
                        <div class="setings-item default-skin nb">
                                <span class="skin-name ">
                         <a href="#" class="s-skin-0">
                             默认皮肤
                         </a>
                    </span>
                        </div>
                        <div class="setings-item blue-skin nb">
                                <span class="skin-name ">
                        <a href="#" class="s-skin-1">
                            蓝色主题
                        </a>
                    </span>
                        </div>
                        <div class="setings-item yellow-skin nb">
                                <span class="skin-name ">
                        <a href="#" class="s-skin-3">
                            黄色/紫色主题
                        </a>
                    </span>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    </div>
    <!--右侧边栏结束-->

</div>
<script src="../../../shopmanagement/js/jquery.min.js?v=2.1.4"></script>
<script src="../../../shopmanagement/js/bootstrap.min.js?v=3.3.5"></script>
<script src="../../../shopmanagement/js/plugins/metisMenu/jquery.metisMenu.js"></script>
<script src="../../../shopmanagement/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
<script src="../../../shopmanagement/common/layui/layui.all.js"></script>
<script src="../../../shopmanagement/js/hplus.min.js?v=4.0.0"></script>
<script type="text/javascript" src="../../../shopmanagement/js/contabs.min.js"></script>
<script src="../../../shopmanagement/js/plugins/pace/pace.min.js"></script>
<script>
    function closeWin() {
        alert(1);
    }
</script>
</body>

</html>