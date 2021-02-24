<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create a new list of shoes</title>
</head>
<body>
<form action ="createNewListServlet" method="post">
List Name: <input type = "text" name ="listName"><br />
Last Updated: <input type = "text" name = "month" placeholder= "mm" size="4"> <input type ="text" name ="day" placeholder="dd"size="4"> <input type ="text" name = "year" placeholder= "yyyy" size= "4">
Shoe Owner Name: <input type = "text" name ="shoeOwnerName"><br />
Available Shoes:<br />
<select name= "allShoesToAdd" multiple size="6">
<c:forEach items="${requestScope.allItems}" var="currentitem">
<option value ="${currentitem.id}">${currentitem.color} ${currentitem.brand} ${currentitem.type}</option>
</c:forEach>
</select>
<br />
<input type = "submit" value= "Create List and Add Shoes">
</form>
<a href ="index.html">Go add new shoes instead.</a>
</body>
</html>