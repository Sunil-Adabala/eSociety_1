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
<h1> In year_rep page..</h1>

<%--${year}--%>
<h2>Year wise payment history</h2>

<table style="width:50%;border: 1px solid black;text-align: center;">
    <tr>
        <th>Username</th>
        <th colspan="2">Amount</th>
    </tr>

    <c:forEach var="par" items="${year}">


        <tr>
            <td><c:out value="${par.username}"/></td>
            <td><c:out value="${par.amount}"/></td>

        </tr>

    </c:forEach>

</table>
</body>
</html>