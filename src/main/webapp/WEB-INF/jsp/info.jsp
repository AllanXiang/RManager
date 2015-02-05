<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<title>Admin</title>
		<link rel="stylesheet" href="../css/bootstrap.css">
		<link rel="stylesheet" href="../css/style.css">
		<link rel="stylesheet" href="../js/codemirror/codemirror.css">
		<style type="text/css">
			.CodeMirror {
				border: 1px solid #999999;
				width: 90%;
				height: 400px;
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
						<li class='active'>
							<a href="#" class='light toggle-collapsed'>
								<div class="ico"><i class="icon-th-large icon-white"></i></div>
								Search
								<img src="../img/toggle-subnav-down.png" alt="">
							</a>
							<ul class='collapsed-nav'>
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
										基本信息
									</h3>
								</div>
								<div class="box-content">
									<div class="form-horizontal">
										<div class="control-group">
											<label class="control-label">
												公司名
											</label>
											<div class="controls">
												<span class="uneditable-input input-xlarge input-square">${corpinfo.corpname}</span>
											</div>
										</div>
										<div class="control-group">
											<label class="control-label">
												注册号
											</label>
											<div class="controls">
												<span class="uneditable-input input-xlarge input-square">${corpinfo.registerno}</span>
											</div>
										</div>
										<div class="control-group">
											<label for="basictext" class="control-label">
												XML信息
											</label>
											<div class="controls">
												<textarea name="corpinfo_detail" id="basictext"
													class='span9 input-square' rows="6">${corpinfo.detail}</textarea>
											</div>
										</div>
										<div class="form-actions">
											<input type="button" class='btn btn-success' value="整理"
												onclick=autoFormat();>
											<input type="button" id="submit" class='btn btn-primary' value="保存">
											<a href="/info_query" class="btn btn-danger">返回</a>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

			<script src="../js/codemirror/codemirror.js"></script>
			<script src="../js/codemirror/xml.js"></script>
			<script src="../js/codemirror/formatting.js"></script>
			<script src="../js/base/jquery.js"></script>
			<script>
	var editor = CodeMirror.fromTextArea(document.getElementById("basictext"),
			{
				mode : "text/html",
				lineNumbers : true
			});
	function autoFormat() {
		var totalLines = editor.lineCount();
		var totalChars = editor.getTextArea().value.length;
		editor.autoFormatRange( {
			line : 0,
			ch : 0
		}, {
			line : totalLines,
			ch : totalChars
		});
//		console.log(editor.getValue());
	}

	$(document).ready(function() {
		autoFormat();
	});

	$("#submit").click(function(){
		var id = Number(document.URL.split('/').slice(-1));
		var detail =  editor.getValue();
		if(detail == ''){
			alert("输入xml");
			return ;
		}
		var post_data = {
			idcorpinfo: id,
			detail: detail
		};
//		console.log(JSON.stringify(post_data));
		$.ajax({
			contentType: "application/json",
			type: 'PUT',
			dataType: "json",
			url: "/info/api/"+id,
			data: JSON.stringify(post_data),
			success: function(msg){
				if($.trim(msg) == '1'){
					alert("更新成功");
					window.location.href="/info_query";
				}else{
					alert("更新失败 ");
				}
			}
		});
	});
</script>
	</body>
</html>