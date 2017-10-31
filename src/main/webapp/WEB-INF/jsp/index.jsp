<%@page import="org.apache.shiro.SecurityUtils"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<title></title>
<link rel="stylesheet"
	href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script
	src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style type="text/css">
@media only screen and (min-width:768px) {
	#slider_sub {
		width: 150px;
		position: absolute;
		z-index: 1;
	}
}
</style>
</head>

<body>
	<nav class="navbar navbar-default navbar-static-top">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#slider_sub"
				aria-expanded="false" aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a href="#" class="navbar-brand">网站后台管理</a>
		</div>
		<ul class="nav navbar-nav navbar-right" style="margin-right: 25px;">
			<li><a href="#"><span class="badge" style="background: #1B6D85;">欢迎  <%=SecurityUtils.getSubject().getPrincipal()%></span></a> 
			</li>
			<li><a href="logout.action"><span
					class="glyphicon glyphicon-off">注销</span> </a>
			</li>
		</ul>
		<ul class="nav "
			style="margin-top: 40px; width: auto; margin-left: 150px;margin-right: 150px;">
			<li>
				<div class="input-groups">
					<input class="form-control" type="text" /> <span
						class="input-groups-btn">
						<button type="button" class="btn btn-danger">
							<span class="glyphicon glyphicon-search"></span>
						</button> </span>
				</div>
			</li>
		</ul>

		<div class="navbar-default navbar-collapse" id="slider_sub">
			<ul class="nav">
				<li><a href="#sub1" data-toggle="collapse">系统功能<span
						class="glyphicon glyphicon-chevron-right pull-right"></span> </a>
					<ul id="sub1" class="nav collapse">
						<li><a href="#"><span
								class="glyphicon glyphicon-info-sign" />&nbsp;系统信息</a>
						</li>
						<li><a href="#"><span class="glyphicon glyphicon-user" />&nbsp;管理员信息</a>
						</li>
						<li><a href="#"><span
								class="glyphicon glyphicon-list-alt" />&nbsp;日志管理</a>
						</li>
					</ul>
				</li>

				<li><a href="#sub2" data-toggle="collapse">栏目功能<span
						class="glyphicon glyphicon-chevron-right pull-right"></span> </a>
					<ul id="sub2" class="nav collapse">
						<li><a href="#"><span
								class="glyphicon glyphicon-info-sign" />&nbsp;系统信息</a>
						</li>
						<li><a href="#"><span class="glyphicon glyphicon-user" />&nbsp;管理员信息</a>
						</li>
						<li><a href="#"><span
								class="glyphicon glyphicon-list-alt" />&nbsp;日志管理</a>
						</li>
					</ul>
				</li>
				<li><a href="#sub3" data-toggle="collapse">产品功能<span
						class="glyphicon glyphicon-chevron-right pull-right"></span> </a>
					<ul id="sub3" class="nav collapse">
						<li><a href="#"><span
								class="glyphicon glyphicon-info-sign" />&nbsp;系统信息</a>
						</li>
						<li><a href="#"><span class="glyphicon glyphicon-user" />&nbsp;管理员信息</a>
						</li>
						<li><a href="#"><span
								class="glyphicon glyphicon-list-alt" />&nbsp;日志管理</a>
						</li>
					</ul>
				</li>
				<li><a href="#sub4" data-toggle="collapse">新闻功能<span
						class="glyphicon glyphicon-chevron-right pull-right"></span> </a>
					<ul id="sub4" class="nav collapse">
						<li><a href="#"><span
								class="glyphicon glyphicon-info-sign" />&nbsp;系统信息</a>
						</li>
						<li><a href="#"><span class="glyphicon glyphicon-user" />&nbsp;管理员信息</a>
						</li>
						<li><a href="#"><span
								class="glyphicon glyphicon-list-alt" />&nbsp;日志管理</a>
						</li>
					</ul>
				</li>
				<li><a href="#sub5" data-toggle="collapse">新闻功能<span
						class="glyphicon glyphicon-chevron-right pull-right"></span> </a>
					<ul id="sub5" class="nav collapse">
						<li><a href="#"><span
								class="glyphicon glyphicon-info-sign" />&nbsp;系统信息</a>
						</li>
						<li><a href="#"><span class="glyphicon glyphicon-user" />&nbsp;管理员信息</a>
						</li>
						<li><a href="#"><span
								class="glyphicon glyphicon-list-alt" />&nbsp;日志管理</a>
						</li>
					</ul>
				</li>
				<li><a href="#sub6" data-toggle="collapse">新闻功能<span
						class="glyphicon glyphicon-chevron-right pull-right"></span> </a>
					<ul id="sub6" class="nav collapse">
						<li><a href="#"><span
								class="glyphicon glyphicon-info-sign" />&nbsp;系统信息</a>
						</li>
						<li><a href="#"><span class="glyphicon glyphicon-user" />&nbsp;管理员信息</a>
						</li>
						<li><a href="#"><span
								class="glyphicon glyphicon-list-alt" />&nbsp;日志管理</a>
						</li>
					</ul>
				</li>
				<li><a href="#sub7" data-toggle="collapse">新闻功能<span
						class="glyphicon glyphicon-chevron-right pull-right"></span> </a>
					<ul id="sub7" class="nav collapse">
						<li><a href="#"><span
								class="glyphicon glyphicon-info-sign" />&nbsp;系统信息</a>
						</li>
						<li><a href="#"><span class="glyphicon glyphicon-user" />&nbsp;管理员信息</a>
						</li>
						<li><a href="#"><span
								class="glyphicon glyphicon-list-alt" />&nbsp;日志管理</a>
						</li>
					</ul>
				</li>
				<li><a href="#sub8" data-toggle="collapse">新闻功能<span
						class="glyphicon glyphicon-chevron-right pull-right"></span> </a>
					<ul id="sub8" class="nav collapse">
						<li><a href="#"><span
								class="glyphicon glyphicon-info-sign" />&nbsp;系统信息</a>
						</li>
						<li><a href="#"><span class="glyphicon glyphicon-user" />&nbsp;管理员信息</a>
						</li>
						<li><a href="#"><span
								class="glyphicon glyphicon-list-alt" />&nbsp;日志管理</a>
						</li>
					</ul>
				</li>
				<li><a href="#sub9" data-toggle="collapse">新闻功能<span
						class="glyphicon glyphicon-chevron-right pull-right"></span> </a>
					<ul id="sub9" class="nav collapse">
						<li><a href="#"><span
								class="glyphicon glyphicon-info-sign" />&nbsp;系统信息</a>
						</li>
						<li><a href="#"><span class="glyphicon glyphicon-user" />&nbsp;管理员信息</a>
						</li>
						<li><a href="#"><span
								class="glyphicon glyphicon-list-alt" />&nbsp;日志管理</a>
						</li>
					</ul>
				</li>
				<li><a href="#sub10" data-toggle="collapse">新闻功能<span
						class="glyphicon glyphicon-chevron-right pull-right"></span> </a>
					<ul id="sub10" class="nav collapse">
						<li><a href="#"><span
								class="glyphicon glyphicon-info-sign" />&nbsp;系统信息</a>
						</li>
						<li><a href="#"><span class="glyphicon glyphicon-user" />&nbsp;管理员信息</a>
						</li>
						<li><a href="#"><span
								class="glyphicon glyphicon-list-alt" />&nbsp;日志管理</a>
						</li>
					</ul>
				</li>
				<li><a href="#sub11" data-toggle="collapse">新闻功能<span
						class="glyphicon glyphicon-chevron-right pull-right"></span> </a>
					<ul id="sub11" class="nav collapse">
						<li><a href="#"><span
								class="glyphicon glyphicon-info-sign" />&nbsp;系统信息</a>
						</li>
						<li><a href="#"><span class="glyphicon glyphicon-user" />&nbsp;管理员信息</a>
						</li>
						<li><a href="#"><span
								class="glyphicon glyphicon-list-alt" />&nbsp;日志管理</a>
						</li>
					</ul>
				</li>
				<li><a href="#sub12" data-toggle="collapse">新闻功能<span
						class="glyphicon glyphicon-chevron-right pull-right"></span> </a>
					<ul id="sub12" class="nav collapse">
						<li><a href="#"><span
								class="glyphicon glyphicon-info-sign" />&nbsp;系统信息</a>
						</li>
						<li><a href="#"><span class="glyphicon glyphicon-user" />&nbsp;管理员信息</a>
						</li>
						<li><a href="#"><span
								class="glyphicon glyphicon-list-alt" />&nbsp;日志管理</a>
						</li>
					</ul>
				</li>
				<li><a href="#sub13" data-toggle="collapse">新闻功能<span
						class="glyphicon glyphicon-chevron-right pull-right"></span> </a>
					<ul id="sub13" class="nav collapse">
						<li><a href="#"><span
								class="glyphicon glyphicon-info-sign" />&nbsp;系统信息</a>
						</li>
						<li><a href="#"><span class="glyphicon glyphicon-user" />&nbsp;管理员信息</a>
						</li>
						<li><a href="#"><span
								class="glyphicon glyphicon-list-alt" />&nbsp;日志管理</a>
						</li>
					</ul>
				</li>
			</ul>
		</div>
	</nav>
	<div style="margin-left: 150px;margin-top: -20px;">
		<ol class="breadcrumb">
			<li><a href="#">订单查询</a>
			</li>
			<li><a href="#">管理首页</a>
			</li>
			<li><a href="#">管理首页</a>
			</li>
			<li><a href="#">管理首页</a>
			</li>
		</ol>
		<div class="row">
			<div class="col-md-6">
				<div class="panel panel-default">
					<div class="panel panel-heading">最新订单</div>
					<div class="panel-body table-responsive">
						<table class="table table-striped table-hover table-bordered">
							<thead>
								<tr>
									<th>ID</th>
									<th>订单号</th>
									<th>订单日期</th>
									<th>总价</th>
									<th>状态</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>1</td>
									<td>543534</td>
									<td>2017-09-12</td>
									<td>123</td>
									<td>有</td>
								</tr>
								<tr>
									<td>2</td>
									<td>533334</td>
									<td>2017-09-12</td>
									<td>123</td>
									<td>有</td>
								</tr>
								<tr>
									<td>3</td>
									<td>546654</td>
									<td>2017-09-12</td>
									<td>123</td>
									<td>有</td>
								</tr>
								<tr>
									<td>4</td>
									<td>543587</td>
									<td>2017-09-12</td>
									<td>123</td>
									<td>有</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
			<div class="col-md-6">
				<div class="panel panel-default">
					<div class="panel panel-heading">最新订单</div>
					<div class="panel-body table-responsive">
						<table class="table table-striped table-hover table-bordered">
							<thead>
								<tr>
									<th>ID</th>
									<th>订单号</th>
									<th>订单日期</th>
									<th>总价</th>
									<th>状态</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>1</td>
									<td>543534</td>
									<td>2017-09-12</td>
									<td>123</td>
									<td>有</td>
								</tr>
								<tr>
									<td>2</td>
									<td>533334</td>
									<td>2017-09-12</td>
									<td>123</td>
									<td>有</td>
								</tr>
								<tr>
									<td>3</td>
									<td>546654</td>
									<td>2017-09-12</td>
									<td>123</td>
									<td>有</td>
								</tr>
								<tr>
									<td>4</td>
									<td>543587</td>
									<td>2017-09-12</td>
									<td>123</td>
									<td>有</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
		<div class="col-sm-12" style="margin-left: -15px;">
			<div class="panel panel-default">
				<div class="panel panel-heading">最新订单</div>
				<div class="panel-body table-responsive">
					<table class="table table-striped table-hover table-bordered">
						<thead>
							<tr>
								<th>ID</th>
								<th>订单号</th>
								<th>订单日期</th>
								<th>总价</th>
								<th>状态</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>1</td>
								<td>543534</td>
								<td>2017-09-12</td>
								<td>123</td>
								<td>有</td>
							</tr>
							<tr>
								<td>2</td>
								<td>533334</td>
								<td>2017-09-12</td>
								<td>123</td>
								<td>有</td>
							</tr>
							<tr>
								<td>3</td>
								<td>546654</td>
								<td>2017-09-12</td>
								<td>123</td>
								<td>有</td>
							</tr>
							<tr>
								<td>4</td>
								<td>543587</td>
								<td>2017-09-12</td>
								<td>123</td>
								<td>有</td>
							</tr>
						</tbody>
					</table>
					<nav aria-label="Page navigation" class="pull-right">
						<ul class="pagination">
							<li><a href="#" aria-label="Previous"> <span
									aria-hidden="true">上一页</span> </a>
							</li>
							<li><a href="#">1</a>
							</li>
							<li><a href="#">2</a>
							</li>
							<li><a href="#">3</a>
							</li>
							<li><a href="#">4</a>
							</li>
							<li><a href="#">5</a>
							</li>
							<li><a href="#">6</a>
							</li>
							<li><a href="#">.....</a>
							</li>
							<li><a href="#">最后一页</a>
							</li>
							<li><a href="#" aria-label="Next"> <span
									aria-hidden="true">下一页</span> </a>
							</li>
						</ul>
					</nav>
				</div>
			</div>
		</div>
	</div>
</body>
</html>