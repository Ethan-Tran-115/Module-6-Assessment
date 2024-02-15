<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method = "post" action = "navigationServlet">
	<table>
	<c:forEach items="${requestScope.allCars}" var="currentcar">
	<tr>
		<td><input type="radio" name="id" value="${currentcar.id}" ></td>
		<td>${currentcar.make}</td>
		<td>${currentcar.model}</td>
		<td>${currentcar.year}</td>
		</tr>
	</c:forEach>
	</table>
	<input type = "submit" value = "edit" name="doThisToCar">
	<input type = "submit" value = "delete" name="doThisToCar">
	<input type="submit" value = "add" name = "doThisToCar">
	</form>
</body>
</html>