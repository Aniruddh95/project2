<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body align="center" style="background-color:pink">

<h3>Hotel Details</h3>
<br>
<table border="1px" align="center">
<tr>
<th>ID</th>
<th>Name</th>
<th>Rating</th>
<th>Rate</th>
<th>Available Rooms</th>
</tr>

<c:forEach items="${hotelList}" var="list"  >
<tr>
<td>${list.getId()}</td>
<td><a href="booking.obj?id=${list.getId()}&name=${list.getName()}">${list.getName()}</a></td>
<td>${list.getRating()}</td>
<td>${list.getRate()}</td>
<td>${list.getAvailableRooms()}</td>
</tr>


</c:forEach>


</table>
</body>
</html>