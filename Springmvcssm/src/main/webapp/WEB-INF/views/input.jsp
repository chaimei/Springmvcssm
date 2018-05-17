<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<s:form action="${pageContext.request.contextPath }/addEmp"
		method="post" modelAttribute="employee">
		<c:if test="${!empty employee.id}" var="flag">
			<s:hidden path="id" />
			<input type="hidden" name="_method" value="PUT" />
		</c:if>
员工姓名：<s:input path="lastName" />
		<br>
员工邮箱：<s:input path="email" />
		<br>
员工性别：<s:radiobuttons path="gender" items="${ genders}" />
		<br>
员工部门：<s:select path="dept.id" items="${depts }"
			itemLabel="departmentName" itemValue="id">
		</s:select>
		<br>
		<c:if test="${flag}">
			<input type="submit" value="修改" />
		</c:if>
		<c:if test="${!flag }">
			<input type="submit" value="添加" />
		</c:if>
	</s:form>
</body>
</html>