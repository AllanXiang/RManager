<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Admin</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1">

<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/login.css">
</head>

<body class='login_body'>
	<div class="wrap">
		<h2>Admin</h2>
		<h4>Welcome to the login page</h4>
		<form id="form1" name="form1" action="/login" method="post">
		<div class="login">
			<div class="email">
				<label for="user">Username</label><div class="email-input"><div class="control-group"><div class="input-prepend"><span class="add-on"><i class="icon-envelope"></i></span><input type="text" id="user" name="user" class="{required:true}"></div></div></div>
			</div>
			<div class="pw">
				<label for="pw">Password</label><div class="pw-input"><div class="control-group"><div class="input-prepend"><span class="add-on"><i class="icon-lock"></i></span><input type="password" id="pw" name="pw" class='{required:true}'></div></div></div>
			</div>
		</div>
		<div class="submit">
			<a href="#">Lost password?</a>
			<button class="btn btn-red5" type="submit">Login</button>
		</div>
		</form>
	</div>
</body>
</html>