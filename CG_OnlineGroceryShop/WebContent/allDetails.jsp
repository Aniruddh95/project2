<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.cg.bean.*" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color:pink" align="center">
<h2>Online Grocery Shop</h2>
<c:choose>
<c:when test="${details.size()>0 }">
<h3>Available Items</h3>
<table border="1 px" style="background-color:aqua" align="center">
<tr>
<th>ID</th>
<th>Name</th>
<th>Price</th>
<th>Category</th>
<th>Quantity</th>
<th>Unit</th>
<th>Description</th>
</tr>
<c:forEach items="${details}" var="detail">
<tr>
<td>${detail.getId()} </td>
<td>${detail.getName()} </td>


<td>${detail.getPrice()} </td>


<td>${detail.getCategory()} </td>


<td>${detail.getQuantity()} </td>


<td>${detail.getUnit()} </td>

<td>${detail.getDescription()} </td>
</tr>

</c:forEach>


</table>
<br>
</c:when>
<c:otherwise>
<h3>No Data Found</h3>

</c:otherwise>
</c:choose>
<a href="index.jsp" >Go Home</a>

</body>
</html>