<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body align="center" style="background-color:pink">
<h3>Booking Details</h3><br>
<h4>Hello ${bookingDetails.getCustomerName()} following are your booking details.</h4>
<table border="1px" align="center">

<tr>
<th>Booking Id</th>
<td>${bookingDetails.getId()}</td>
</tr>

<tr>
<th>Hotel Name</th>
<td>${hotelDetails.getName() }</td>
</tr>

<tr>
<th>No of Rooms</th>
<td>${bookingDetails.getNumberOfRooms()}</td>
</tr>

<tr>
<th>Amount</th>
<td>${hotelDetails.getRate()}</td>
</tr>


</table>
</body>
</html>