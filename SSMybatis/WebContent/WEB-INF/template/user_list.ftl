<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${cssPath}/style.css" type="text/css" rel="stylesheet" />
<title>Insert title here</title>
<script type="text/javascript" src="${ctxPath}/js/jquery-1.6.js"></script>
<script type="text/javascript" src="${ctxPath}/js/user.js"></script>
</head>
<body>
 <h2>欢迎<font color="green" size="8px">${user.name}</font>查看用户信息列表:</h2><br>
   <a href="addUser"><font size="5px">增加用户</font></a> <a href="loginOut" style="margin-left: 140px">退出系统</a><br>
   <#--使用framemaker模板语言输出-->
   <table border="2">
      <tr>
        <td>用户ID</td><td>用户名</td><td>密码</td><td>操作</td>
      </tr>
      <#list users as user>
      <tr>
        <td>${user.id}</td><td>${user.name}</td><td>${user.password}</td><td><a href="viewUser?id=${user.id}">查看</a>||<a href="getUpdateUser?id=${user.id}">修改</a>||<a href="javascript:delUser(${user.id});">删除</a></td>
      </tr>
      </#list>
   </table>
 <div class="pagenavigation">
	<#if (pageInfo.currentPage>1)>
		<a href="${ctxPath}/${pageInfo.currentPage - 1} " class="left">上一页</a>
	</#if>
	
	<#assign forbegin=pageInfo.currentPage-5>
	<#assign forend=pageInfo.currentPage+5>
	
	<#list forbegin..forend as i>
		<#if (i>=1) && (i<=pageInfo.totalPage)> 
			<a href="${ctxPath}/${i}" <#if pageInfo.currentPage==i>class="current"</#if>>${i}</a>
		</#if>
	</#list>
	
	<#if (pageInfo.currentPage<pageInfo.totalPage)>
		<a href="${ctxPath}/${pageInfo.currentPage + 1}" class="right">下一页</a>
	</#if>
</div>
当前页：${pageInfo.currentPage}<br>
总记录数：${pageInfo.totalRows}<br>
总页数:${pageInfo.totalPage}<br>
每页大小:${pageInfo.pageSize}
   <br>
   
</body>
</html>