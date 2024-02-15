<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix= "c" uri= "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create a new list</title>
</head>
<body>
	<form action="createNewListServlet" method="post">
        List Name: <input type="text" name="listName"><br />
        
        Trip Date: 
        <input type="text" name="month" placeholder="mm" size="2">
        <input type="text" name="day" placeholder="dd" size="2">
        <input type="text" name="year" placeholder="yyyy" size="4"><br />

        Shopper Name: <input type="text" name="shopperName"><br />

        Available Cars:<br />
        <select name="allCarsToAdd" multiple size="6">
            <c:forEach items="${requestScope.allCars}" var="currentCar">
                <option value="${currentCar.id}">${currentCar.make} | ${currentCar.model}</option>
            </c:forEach>
        </select><br />

        <input type="submit" value="Create list and Add Cars">
    </form>
    
    <a href="index.html">Go add new cars instead</a>
</body>
</html>