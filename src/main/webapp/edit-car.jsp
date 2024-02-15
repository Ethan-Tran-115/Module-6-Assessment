<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Car</title>
</head>
<body>
	<form action="editCarServlet" method="post">
        Make: <input type="text" name="make" value="${carToEdit.make}"><br>
        Model: <input type="text" name="model" value="${carToEdit.model}"><br>
        Year: <input type="text" name="year" value="${carToEdit.year}"><br>
        <input type="hidden" name="id" value="${carToEdit.id}">
        <input type="submit" value="Save Edited Car">
    </form>
</body>
</html>