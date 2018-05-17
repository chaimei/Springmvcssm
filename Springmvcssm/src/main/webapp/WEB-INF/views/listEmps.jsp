<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="scripts/jquery-1.7.2.min.js"></script>
<script type="text/javascript">
$(function(){
	$(".del").click(function(){
		var href=$(this).attr("href");
		$("form").attr("action",href).submit();
		return false;
	});
});

function delEmp(id){
	if(!window.confirm("确定要删除吗？")){
		return false;
	}
	window.location.href="${pageContext.request.contextPath }/delete/"+id;
}
</script>

</head>
<body>
	<h1 align="center">员工信息列表</h1>
<form action="editEmp" method="post">
	<table border="1px" align="center" width="70%" cellspacing="0px">
		<tr>
			<th>员工编号</th>
			<th>员工姓名</th>
			<th>员工邮箱</th>
			<th>性別</th>
			<th>部门名称</th>
			<th>其他操作</th>
		</tr>
		<c:forEach items="${emps}" var="emp">
		<tr align="center">
			<td>${emp.id }
			<input type="hidden" name="id" value="${emp.id }"/>
			</td>
			<td>${emp.lastName }</td>
			<td>${emp.email }</td>
			<td>${emp.gender==0?"女":"男" }</td>
			<td>${emp.dept.departmentName}</td>
			<td>
				<a href="edit/${emp.id }">修改</a> 
				&nbsp;&nbsp;
				 <a href="#" onclick="delEmp(${emp.id })">删除</a>  
				<%--<a class="del" href="delEmp/${emp.id }" >删除</a>--%>
			</td>
		</tr>
		</c:forEach>
	</table>
	<br>
	</form>
	<a href="toAddEmp">添加员工</a>
</body>
</html>