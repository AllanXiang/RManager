<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.xzy.util.Global"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<title>Admin</title>
		<meta name="description" content="">

		<meta name="viewport" content="width=device-width">
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
						<li>
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
						<li class='active'>
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
										当日查询情况
									</h3>
								</div>
								<div class="box-content box-nomargin">
									<table
										class='table table-striped dataTable table-bordered dataTable-sorttime dataTable-noheader'>
										<thead>
											<tr>
												<th>
													流水号
												</th>
												<th>
													查询内容
												</th>
												<th>
													开始时间
												</th>
												<th>
													访问IP
												</th>
												<th>
													服务器IP
												</th>
												<th>
													耗时
												</th>
												<th>
													省份
												</th>
												<th>
													结果
												</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${searchlogs}" var="searchlog">
											<tr>
												<td>${searchlog.refid}</td>
												<td>${searchlog.corpname} ${searchlog.registerid}</td>
												<td>${searchlog.starttime}</td>
												<td>${searchlog.userip}</td>
												<td>${searchlog.localip}</td>
												<td>${searchlog.spendtime}</td>
												<td><c:set var="province" value="${searchlog.province}"/>
													<%=Global.provincelist.get(pageContext.getAttribute("province"))%></td>
												<td>
													<c:choose>
														<c:when test="${searchlog.searchcondition == 1}">
															<a href="/info/${searchlog.idcorpinfo}">成功</a>
														</c:when>
														<c:when test="${searchlog.searchcondition == 3}">
															${searchlog.errormessage}
														</c:when>
														<c:otherwise>
															<c:set var="condition" value="${searchlog.searchcondition}"/>
															<%=Global.searchcondition.get(pageContext.getAttribute("condition"))%>
														</c:otherwise>
													</c:choose>
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
	</body>
</html>