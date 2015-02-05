<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<title>Admin</title>
		<link rel="stylesheet" href="../css/bootstrap.css">
		<link rel="stylesheet" href="../css/style.css">
		<link rel="stylesheet" href="../css/bootstrap-switch.min.css">
		<script type="text/javascript" src="../js/base/jquery.js"></script>
		<script type="text/javascript" src="../js/bootstrap-switch.min.js"></script>
	</head>
	<body>
		<div class="topbar">
			<div class="container-fluid">
				<a href="/dashboard" class='company' target="main">Admin</a>
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
								</div>
								<div class="box-content">
									<div class="form-horizontal">
										<div class="control-group">
											<label class="control-label">IP地址</label>
											<div class="controls">
												<input type="text" name="ip" id="ip" class='input-square'>
											</div>
										</div>
										<div class="control-group">
											<label class="control-label">当前状态</label>
											<div class="controls">
												<input type="checkbox" name="status" id="status"  checked data-size="small">
											</div>
										</div>
										<div class="control-group">
											<label class="control-label">
												支持省份
											</label>
											<div class="controls">
												<label class="checkbox"><input type="checkbox" id="checkAll" />全选</label>
												<div>
													<label class="checkbox inline"><input type="checkbox" name="check">北京</label>
													<label class="checkbox inline"><input type="checkbox" name="check">天津</label>
													<label class="checkbox inline"><input type="checkbox" name="check">河北</label>
													<label class="checkbox inline"><input type="checkbox" name="check">山西</label>
													<label class="checkbox inline"><input type="checkbox" name="check">内蒙古</label>
												</div>
												<div>
													<label class="checkbox inline"><input type="checkbox" name="check">辽宁</label>
													<label class="checkbox inline"><input type="checkbox" name="check">吉林</label>
													<label class="checkbox inline"><input type="checkbox" name="check">黑龙江</label>
												</div>
												<div>
													<label class="checkbox inline"><input type="checkbox" name="check">上海</label>
													<label class="checkbox inline"><input type="checkbox" name="check">江苏</label>
													<label class="checkbox inline"><input type="checkbox" name="check">浙江</label>
													<label class="checkbox inline"><input type="checkbox" name="check">安徽</label>
													<label class="checkbox inline"><input type="checkbox" name="check">福建</label>
													<label class="checkbox inline"><input type="checkbox" name="check">江西</label>
													<label class="checkbox inline"><input type="checkbox" name="check">山东</label>
												</div>
												<div>
													<label class="checkbox inline"><input type="checkbox" name="check">河南</label>
													<label class="checkbox inline"><input type="checkbox" name="check">湖北</label>
													<label class="checkbox inline"><input type="checkbox" name="check">湖南</label>
												</div>
												<div>
													<label class="checkbox inline"><input type="checkbox" name="check">广东</label>
													<label class="checkbox inline"><input type="checkbox" name="check">广西</label>
													<label class="checkbox inline"><input type="checkbox" name="check">海南</label>
												</div>
												<div>
													<label class="checkbox inline"><input type="checkbox" name="check">重庆</label>
													<label class="checkbox inline"><input type="checkbox" name="check">四川</label>
													<label class="checkbox inline"><input type="checkbox" name="check">贵州</label>
													<label class="checkbox inline"><input type="checkbox" name="check">云南</label>
													<label class="checkbox inline"><input type="checkbox" name="check">西藏</label>
												</div>
												<div>
													<label class="checkbox inline"><input type="checkbox" name="check">陕西</label>
													<label class="checkbox inline"><input type="checkbox" name="check">甘肃</label>
													<label class="checkbox inline"><input type="checkbox" name="check">青海</label>
													<label class="checkbox inline"><input type="checkbox" name="check">宁夏</label>
													<label class="checkbox inline"><input type="checkbox" name="check">新疆</label>
												</div>
											</div>
										</div>
										<div class="form-actions">
											<input type="button" id="submit" class='btn btn-primary' value="保存">
											<a href="/server" class="btn btn-danger">返回</a>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<script>
        $('#ip').blur(function(){
        	var ip = $('#ip').val();
	        var val = /([0-9]{1,3}\.{1}){3}[0-9]{1,3}/;
	        var vald = val.exec(ip);
	        if (vald == null) {
	           alert('注意IP有效性');
	           return false;
	        }
	        if (vald != '') {
	            if (vald[0] != ip) {
	               alert('注意IP有效性');
	               return false;
	            }
	        }
        });
        
		$("[name='status']").bootstrapSwitch();
		$("#checkAll").click(function() {  
                if (this.checked) {  
                    $("input[name='check']:checkbox").each(function() { //遍历所有的name为select的 checkbox  
                                $(this).attr("checked", true);  
                            })  
                } else {   //反之 取消全选   
                    $("input[name='check']:checkbox").each(function() { //遍历所有的name为selec的 checkbox  
                                $(this).attr("checked", false);  
                                //alert("f");  
                            })  
                }  
            }); 
            function chbox(){
				var inputs = $("[name='check']");
            	var province = '';
				for(var i = 0; i<inputs.length; i++){
					var obj = inputs[i];
					if(obj.type == 'checkbox'){
						if(obj.checked == true){
							province += '1';
						}else{
							province += '0';
						}
					}
				}
				return province;
			}
            $("#submit").click(function(){
            	var status =  Number($('#status').bootstrapSwitch('state'));
            	var province = chbox();
            	var ip = $('#ip').val();
            	if(ip == ''){
            		alert("输入ip");
            		return ;
            	}
            	var post_data = {
					serverStatus: status,
					serverIp: ip,
					serverProvince: province
            	};
            	$.ajax({
					contentType: "application/json",
					  type: 'POST',
					  dataType: "json",
					  url: "/server/api",
					  data: JSON.stringify(post_data),
					  success: function(msg){
					    	if($.trim(msg) == '1'){
					    		alert("插入成功");
					    		window.location.href="/server";
					    	}else{
					    		alert("插入失败 ");
					    	}
					   }
				});
			});
		</script>
	</body>
</html>