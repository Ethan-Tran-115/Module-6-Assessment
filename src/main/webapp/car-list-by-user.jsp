<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Car Lists</title>
</head>
<body>
	<form method="post" action="listnavigationServlet"> 
        <table>
            <c:forEach items="${requestScope.allLists}" var="currentList">
                <tr>
                    <td><input type="radio" name="id" value="${currentList.id}"></td>
                    <td><h2>${currentList.listName}</h2></td>
                </tr>
                <tr>
                    <td colspan="3">Trip Date: ${currentList.tripDate}</td>
                </tr>
                <tr>
                    <td colspan="3">Shopper: ${currentList.shopper.shopperName}</td>
                </tr>
                <c:forEach var="car" items="${currentList.listOfCars}">
                    <tr>
                        <td></td>
                        <td colspan="3">${car.make}, ${car.model}</td>
                    </tr>
                </c:forEach>
            </c:forEach>
        </table>
        <input type="submit" value="edit" name="doThisToList">
        <input type="submit" value="delete" name="doThisToList">
        <input type="submit" value="add" name="doThisToList">
    </form>
    <a href="addCarsForListServlet">Create a new list</a><br />
    <a href="index.html">Insert a new car</a>
</body>
</html>