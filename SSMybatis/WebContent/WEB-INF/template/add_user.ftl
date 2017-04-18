<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${ctxPath}/js/jquery-1.6.js"></script>
<script type="text/javascript" src="${ctxPath}/js/index.js"></script>
</head>
<body>
<h1>
增加用户
</h1>
<form action="AddUser" method="post">
    用户名:<input type="text" name="name" id="name"><span id="content"></span><br>
    密&nbsp;&nbsp;码:<input type="password" name="password"><br>
     <input type="submit" value="增加" style="margin-left: 50px;">
     <input type="reset" value="重置" style="margin-left: 0px;">
     <input type="button" value="返回" style="margin-left: 0px;" onClick="javascript:window.back();">
</form>
</body>
</html>