<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="Pragma" content="no-cache">
		<meta http-equiv="Cache-Control" content="no-cache">
		<meta http-equiv="Expires" content="0">
		<link rel="stylesheet" href="css/bootstrap.css">
		<script src="js/base/jquery.js"></script>
		<script src="js/base/bootstrap.min.js"></script>
		<title>检查登录</title>
	</head>
	<body>

		<!-- 模态框（Modal） -->
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h4 class="modal-title" id="myModalLabel">
							登录失败
						</h4>
					</div>
					<div class="modal-body">
						用户不存在或密码错误
					</div>
					<div class="modal-footer">
						<a href="index.jsp" class="btn btn-danger" data-dismiss="myModal">返回</a>
					</div>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal-dialog -->
		</div>
		<!-- /.modal -->


		<script>
	$(function() {
		$('#myModal').modal( {
			keyboard : false
		})
	});
</script>
	</body>
</html>