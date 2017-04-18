<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="${ctxPath}/login" method="post">
  用户名:<input type="text" name="name"><br>
  密&nbsp;&nbsp;码:<input type="password" name="password"><br>
  <input type="submit" value="登录" style="margin-left: 50px;">
  <input type="reset" value="重置" style="margin-left: 0px;">
  <input type="button" value="注册" onclick="javascript:location.href='${ctxPath}/user_register'">
</form>
</body>
</html>