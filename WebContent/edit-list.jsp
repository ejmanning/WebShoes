<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit an Existing List</title>
</head>
<body>
	<form action = "editListDetailsServlet" method= "post">
	<input type = "hidden" name ="id" value="${listToEdit.id}">
	List Name: <input type = "text" name ="listName" value="${listToEdit.listName}"><br />
	
	Last Updated: <input type ="text" name ="month" placeholder="mm" size="4" value="${month}"> <input type ="text" name ="day" placeholder="dd" size="4" value="${date}"> <input type ="text" name="year" placeholder="yyyy" size="4" value="${year}">
	
	Shoe Owner Name: <input type ="text" name ="shoeOwnerName" value="${listToEdit.shoeOwner.ownerName}"><br />
	
	Available Shoes:<br />
	
	<select name="allItemsToAdd"multiple size="6">
	<c:forEach items="${requestScope.allItems}" var="currentitem">
		<option value ="${currentitem.id}">${currentitem.brand} ${currentitem.color} ${currentitem.type}</option>
	</c:forEach>
	</select>
<br />
<input type = "submit" value="Edit List and Add Shoes">
</form>
<a href = "index.html">Go add new items instead</a>
</body>
</html>