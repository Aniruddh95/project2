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
<h3>Add Booking Details</h3>

<form:form action="bdetails.obj" modelAttribute="obj">
<table align="center" border="1px">

<tr>
<th>Hotel ID</th>
<td>${hId}</td>
</tr>

<tr>
<th>Hotel Name</th>
<td>${hName}</td>
</tr>

<tr>
<th>Customer Name</th>
<td><form:input path="customerName"/>
    <form:errors path="customerName"></form:errors>
</td>
</tr>

<tr>
<th>From Date</th>
<td><form:input path="fromDate" placeholder="mm/dd/yyyy"/>
<form:errors path="fromDate"/>
</td>
</tr>

<tr>
<th>To Date</th>
<td><form:input path="toDate" placeholder="mm/dd/yyyy"/>
<form:errors path="toDate"/></td>
</tr>

<tr>
<th>Number of Rooms</th>
<td><form:input path="numberOfRooms"/>
<form:errors path="numberOfRooms"/></td>

</tr>

</table>
<br>
<input type="Submit" value="Book Now" />
</form:form>


</body>
</html>