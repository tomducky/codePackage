<%@ page language="java" contentType="text/html;charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/struts-tags" prefix="s" %> 
<html>
	<head><title></title>
	<c:set var="path" value="${pageContext.request.contextPath }"/>
	<link rel="stylesheet" href="${path }/css/general.css"/>
	<link rel="stylesheet" href="${path }/css/jquery-ui-1.8.20.custom.css"/>
	<script type="text/javascript" src="${path }/js/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="${path }/js/jquery-ui-1.8.20.custom.min.js"></script>
	<script type="text/javascript">
	$(function() {
	
	 $("#endDate").datepicker({ dateFormat: 'yy-m-d' });
	 $("#beginDate").datepicker({ dateFormat: 'yy-m-d' });
		$(".ta tr").each(function(i) {
			this.style.backgroundColor = [ '#799AE1', '#D6DFF7' ][i % 2]
		});

		  $(".ta tr").mouseover(function(){//如果鼠标移到class为stripe的表格的tr上时，执行函数
                $(this).addClass("mousehover");}).mouseout(function(){//给这行添加class值为over，并且当鼠标一出该行时执行函数
                $(this).removeClass("mousehover");}); //移除该行的class
	});
	
	
		function showDialogForEdit(id){
			window.showModalDialog('InputerAction!updateInputerDialog?inputer.id='+id,'','dialogWidth=450px;dialogHeight=350px;');
	}
	
	</script>
	</head>
	<center>
	<body>
		
		<table class="ta">	
			<tr bgcolor="#D6DFF7">
			<th colspan="1">操作</th>
				<th>编号</th>
				<th>进货商</th>
			</tr>
			<c:forEach items="${sessionScope.inputerlist }" var="inputer" varStatus="status">
				<tr >
			        <td><img src="${path }/images/edit2.png" alt="编辑" onclick="showDialogForEdit(${inputer.id})"/></td>
					<td>商家_${inputer.id }</td>
					<td>${inputer.name }</td>
				</tr>
			</c:forEach>		
		</table>
		<br/>
		<center>
		
		</center>
	</body>
	</center>
</html>