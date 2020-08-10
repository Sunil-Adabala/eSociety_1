<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.Calendar" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>eSociety</title>
</head>
<body>
<h1>Welcome </h1>
<br>
<h1> In reports page..</h1>
<%int year = Calendar.getInstance().get(Calendar.YEAR);
%>

<br>

<form action="/yreports">
    <input type="text" name = "year"> <br>
    <input type="submit">
</form>

<form action="/unpaid_paymemnts">
    From -
    <input type = 'date' name = 'from'>
    to -
    <input type = 'date' name = 'to'>
    <input type="submit">
</form>


<a href="/reports/<%out.print(year);%>"><%out.print(year);%></a>
<a href="/reports/<%out.print(year - 1);%>"><%out.print(year - 1);%></a>
<a href="/reports/<%out.print(year - 2);%>"><%out.print(year - 2);%></a>
<a href="/reports/<%out.print(year - 3);%>"><%out.print(year - 3);%></a>
<a href="/reports/<%out.print(year - 4);%>"><%out.print(year - 4);%></a>
<a href="/reports/<%out.print(year - 5);%>"><%out.print(year - 5);%></a>



</body>
</html>