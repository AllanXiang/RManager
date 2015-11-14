<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<title>Admin</title>
		<link rel="stylesheet" href="../css/bootstrap.css">
		<link rel="stylesheet" href="../css/style.css">
		<link rel="stylesheet" href="../css/uniform.default.css">
		<link rel="stylesheet" href="../js/tableTools/css/TableTools.css">
		<style type="text/css">
.table th,.table td {
	text-align: center;
}
</style>
	</head>
	<body>
		<div class="topbar">
			<div class="container-fluid">
				<a href="/dashboard" class='company'>Admin</a>
				<ul class='mini'>
					<li>
						<a href="#"> <img src="../img/icons/fugue/gear.png" alt="">
							Settings </a>
					</li>
					<li>
						<a href="/logout"> <img
								src="../img/icons/fugue/control-power.png" alt=""> Logout
						</a>
					</li>
				</ul>
			</div>
		</div>
		<div class="breadcrumbs">
			<div class="container-fluid">
				<ul class="bread pull-left">
					<li>
						<a href="/dashboard"><i class="icon-home icon-white"></i>
						</a>
					</li>
					<li>
						<a href="/dashboard"> Dashboard </a>
					</li>
				</ul>

			</div>
		</div>
		<div class="main">
			<div class="container-fluid">
				<div class="navi">
					<ul class='main-nav'>
						<li>
							<a href="/dashboard" class='light'>
								<div class="ico">
									<i class="icon-home icon-white"></i>
								</div> Dashboard </a>
						</li>
						<li class='active'>
							<a href="/server" class='light'>
								<div class="ico">
									<i class="icon-list icon-white"></i>
								</div> Server </a>
						</li>
						<li>
							<a href="#" class='light toggle-collapsed'>
								<div class="ico"><i class="icon-th-large icon-white"></i></div>
								Search
								<img src="../img/toggle-subnav-down.png" alt="">
							</a>
							<ul class='collapsed-nav closed'>
								<li>
									<a href="/info_query">
										搜索公司
									</a>
								</li>
								<li>
									<a href="/online">
										在线查询
									</a>
								</li>
							</ul>
						</li>
						<li>
							<a href="/log" class='light'>
								<div class="ico">
									<i class="icon-book icon-white"></i>
								</div> Log </a>
						</li>
						<li>
							<a href="#" class='light toggle-collapsed'>
								<div class="ico"><i class="icon-th-large icon-white"></i></div>
								Statistics
								<img src="../img/toggle-subnav-down.png" alt="">
							</a>
							<ul class='collapsed-nav closed'>
								<li>
									<a href="/statistics">
										月报表
									</a>
								</li>
								<li>
									<a href="/condition">
										服务器监控
									</a>
								</li>
							</ul>
						</li>
					</ul>
				</div>
				<div class="content">
					<div class="row-fluid">
						<div class="span12">
							<div class="box">
								<div class="box-head">
									<h3>
										服务器信息
									</h3>
									<div class="actions">
									<a href="server/addserver" class="btn btn-primary">添加服务器</a>
									</div>
								</div>
								<div class="box-content box-nomargin">
									<table class='table table-striped dataTable table-bordered'>
										<thead>
											<tr>
												<th>
													服务器IP
												</th>
												<th>
													启动时间
												</th>
												<th>
													当前状态
												</th>
												<th>
													操作
												</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${servers}" var="server">
											<tr>
												<td>${server.serverIp}</td>
												<td>${server.serverStime}</td>
												<td><c:choose>
														<c:when test="${server.serverStatus == 0}">
															<input type="button" class='btn btn-danger' value="暂停">
														</c:when>
														<c:otherwise>
															<input type="button" class='btn btn-success' value="运行">
														</c:otherwise>
													</c:choose>
												</td>
												<td><a href="/server/${server.serverId}" title="配置"
														class="btn btn-mini tip theme-login"> <img
															src="../img/icons/essen/16/config.png" alt=""> </a>
													<a onclick="return delServer(${server.serverId}, '${server.serverIp}')" title="删除"
													   class="btn btn-mini tip theme-login"> <img
															src="../img/icons/essen/16/busy.png" alt=""> </a>
												</td>
											</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<script src="../js/base/jquery.js"></script>
		<script src="../js/base/bootstrap.min.js"></script>
		<script src="../js/jquery.uniform.min.js"></script>
		<script src="../js/jquery.dataTables.min.js"></script>
		<script src="../js/jquery.dataTables.bootstrap.js"></script>
		<script src="../js/tableTools/js/TableTools.min.js"></script>
		<script src="../js/custom.js"></script>
		<script>
		function delServer(id, ip) {
			if(confirm('确定要执行此操作吗?')) {
				var status = -3;
				var del_data = {
					serverId: id,
					serverIp: ip,
					serverStatus: status
				};
				$.ajax({
					contentType: "application/json",
					type: 'PUT',
					dataType: "json",
					url: "/server/api/" + id,
					data: JSON.stringify(del_data),
					success: function (msg) {
						if ($.trim(msg) == '1') {
							alert("删除成功");
							window.location.href = "/server";
						} else if ($.trim(msg) == '0') {
							alert("删除失败 ");
						} else {
							alert("当前服务器正在运行 无法删除");
						}
					}
				});
				return true;
			}
			return false;
		};
		</script>
	</body>
</html>