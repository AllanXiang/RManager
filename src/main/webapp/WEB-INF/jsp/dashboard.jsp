<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<title>Admin</title>
		<link rel="stylesheet" href="../css/bootstrap.css">
		<link rel="stylesheet" href="../css/style.css">
		<link rel="stylesheet" href="../css/uniform.default.css">
		<style type="text/css">
#content {
	width: 880px;
	margin: 0 auto;
	padding: 10px;
}

.demo-container {
	box-sizing: border-box;
	width: 850px;
	height: 450px;
	padding: 20px 15px 15px 15px;
	margin: 15px auto 30px auto;
	border: 1px solid #ddd;
	background: #fff;
	background: linear-gradient(#f6f6f6 0, #fff 50px);
	background: -o-linear-gradient(#f6f6f6 0, #fff 50px);
	background: -ms-linear-gradient(#f6f6f6 0, #fff 50px);
	background: -moz-linear-gradient(#f6f6f6 0, #fff 50px);
	background: -webkit-linear-gradient(#f6f6f6 0, #fff 50px);
	box-shadow: 0 3px 10px rgba(0, 0, 0, 0.15);
	-o-box-shadow: 0 3px 10px rgba(0, 0, 0, 0.1);
	-ms-box-shadow: 0 3px 10px rgba(0, 0, 0, 0.1);
	-moz-box-shadow: 0 3px 10px rgba(0, 0, 0, 0.1);
	-webkit-box-shadow: 0 3px 10px rgba(0, 0, 0, 0.1);
}

.demo-placeholder {
	width: 100%;
	height: 100%;
	font-size: 14px;
	line-height: 1.2em;
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
						<li class='active'>
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
										今日查询数
									</h3>
								</div>
								<div class="demo-container">
									<div id="placeholder" class="demo-placeholder"></div>
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
		<script src="../js/jquery.flot.js"></script>
		<script src="../js/custom.js"></script>
		
		<script type="text/javascript">
	$(document).ready(function() {
		triggerAjaxForChart();
	});

	function triggerAjaxForChart() {
		$.ajax( {
			type : "get",
			url : "/dashboard/api",
			dataType : "json",
			success : function(msg) {
				var data_ok = [];
				$.each(msg, function(i, X) {
					var ip = X['ip'];
					var ok = [];

					var stat = X['condition']
					$.each(stat, function(j, num) {
						ok.push( [ j, num['ok'] ]);
					});

					var obj = {
						label : ip,
						data : ok
					};
					data_ok.push(obj);
				});
				TriggerChart(data_ok);
			}
		});
	}

	function TriggerChart(data) {
		var plot = $.plot($("#placeholder"), data, {
			series : {//控制线的填充、点的显示  
				lines : {
					show : true
				},
				points : {
					show : true
				}
			},
			//开启鼠标移动和点击事件  折线图外框颜色 和 外框的宽度  
			grid : {
				hoverable : true,
				clickable : true,
				borderColor : '#000',
				borderWidth : 1
			},

			xaxis : {
				tickDecimals : 0
			}
			
		});

		function showTooltip(x, y, contents) {//浮动块信息 
			$('<div id="tooltip">' + contents + '</div>').css({
                position : 'absolute',
				display : 'none',
				top : y - 15,
				left : x + 15,
				'background-color': '#fff',
				'color': '#000',
				padding : '2px',
				'font-size': '14px',
				opacity : 0.80
            }).appendTo("body").fadeIn(200); 
		}

		var previousPoint = null;
		$("#placeholder").bind("plothover", function(event, pos, item) {
			if (item) {
				if (previousPoint != item.dataIndex) {
					previousPoint = item.dataIndex;
					$("#tooltip").remove();
					var x = item.datapoint[0], //x y 轴位置  
				y = item.datapoint[1];
				showTooltip(item.pageX, item.pageY, y);
			}
			} else {
				$("#tooltip").remove();
				previousPoint = null;
			}
		});

	}
</script>
	</body>
</html>