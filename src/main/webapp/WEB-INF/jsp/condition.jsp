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
						<a href="/dashboard"><i class="icon-home icon-white"></i> </a>
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
						<li>
							<a href="/log" class='light'>
								<div class="ico">
									<i class="icon-book icon-white"></i>
								</div> Log </a>
						</li>
						<li class='active'>
							<a href="#" class='light toggle-collapsed'>
								<div class="ico">
									<i class="icon-th-large icon-white"></i>
								</div> Statistics <img src="../img/toggle-subnav-down.png" alt="">
							</a>
							<ul class='collapsed-nav'>
								<li>
									<a href="/statistics"> 月报表 </a>
								</li>
								<li>
									<a href="/condition"> 服务器监控 </a>
								</li>
							</ul>
						</li>
					</ul>
				</div>
				<div class="content">
					<div class="input-append input-prepend" style="float: right">
						<select name="select" id="s_ip" style="width: 130px">
							<c:forEach items="${allip}" var="ip">
							<option value="${ip}">
								${ip}
							</option>
							</c:forEach>
						</select>
						<select name="select" id="s_condition" style="width: 90px">
							<option value="1">
								处理数量
							</option>
							<option value="0">
								异常数量
							</option>
						</select>
						<button id="btncon" type="button" class="btn btn-primary">
							<i class="icon-search icon-white"></i>
						</button>
					</div>
					<div class="row-fluid">
						<div class="span12">
							<div class="box">
								<div class="box-head">
									<h3>
										服务器状态
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
		$("#btncon").click(function(){
			triggerAjaxForChart();
		});
	});

	function triggerAjaxForChart() {
		var status = $("#s_condition").val();
		$.ajax( {
			type : "post",
			url : "/condition/api",
			data : {ip : $("#s_ip").val() },
			dataType : "json",
			success : function(msg) {
				var data = [];
				var ip = msg['ip'];
				var stat = msg['condition']
				$.each(stat, function(j, num) {
					if(status == 1){
						data.push( [ j, num['ok'] ]);
					}else{
						data.push( [ j, num['error'] ]);
					}
				});

				var dataset = [{
					label : ip,
					data : data,
					color: "#5482FF"
				}];
				draw(dataset);
			}
		});
	}
	
	function draw(data){
		var province = ["北京", "天津", "河北", "山西", "内蒙古", 
			"辽宁", "吉林", "黑龙江",
			"上海", "江苏", "浙江", "安徽", "福建", "江西", "山东", 
			"河南", "湖北", "湖南",
			"广东", "广西", "海南",
			"重庆", "四川", "贵州","云南", "西藏",
			"陕西", "甘肃", "青海","宁夏", "新疆"
		];
		var plot = $.plot($("#placeholder"), data, {
			series : {//控制线的填充、点的显示  
				bars : {
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
			yaxis : {
				min :0
			}
		});
		
		
		 var previousPoint = null, previousLabel = null;
		 $.fn.UseTooltip = function () {
            $(this).bind("plothover", function (event, pos, item) {
                if (item) {
                    if ((previousLabel != item.series.label) || (previousPoint != item.dataIndex)) {
                        previousPoint = item.dataIndex;
                        previousLabel = item.series.label;
                        $("#tooltip").remove();
                        var x = item.datapoint[0];
                        var y = item.datapoint[1];
                        var color = item.series.color;
                        showTooltip(item.pageX,
                        item.pageY,
                        color,
                        province[x] +": <strong>" + y + "</strong>");
                    }
                } else {
                    $("#tooltip").remove();
                    previousPoint = null;
                }
            });
        };
 
        function showTooltip(x, y, color, contents) {
            $('<div id="tooltip">' + contents + '</div>').css({
                position: 'absolute',
                display: 'none',
                top: y ,
                left: x + 30,
                border: '2px solid ' + color,
                padding: '3px',
                'font-size': '12px',
                'border-radius': '5px',
                'background-color': '#fff',
                'color': '#000',
                'font-family': 'Verdana, Arial, Helvetica, Tahoma, sans-serif',
                opacity: 0.9
            }).appendTo("body").fadeIn(200);
        }
		$("#placeholder").UseTooltip();
	}

		</script>
	</body>
</html>