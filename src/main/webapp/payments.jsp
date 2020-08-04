<%@ page import="java.util.Iterator" %>
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
<h1> In payments page..</h1>
<h2>Your due is ${total}  </h2>

<table style="width:50%;border: 1px solid black;text-align: center;">
    <tr>
        <th>User_id</th>
        <th>User_name</th>
        <th>Amount</th>
    </tr>

    <c:forEach var="par" items="${obj}">


        <tr>
            <td><c:out value="${par.id}"/></td>
            <td><c:out value="${par.username}"/></td>
            <td><c:out value="${par.amount}"/></td>

        </tr>

    </c:forEach>

</table>

<a href="/reports">Reports</a>

<%--<c:out value = '${obj.get(0).id}'/>--%>
<%--<c:forEach var="par" items="${obj}">--%>

<%--    <c:out value="${par.username}"/> <br>--%>
<%--    <c:out value="${par.id}"/> <br>--%>

    <%--    <c:out value="${par.user_id}"/> <br>--%>
<%--    <c:out value="${par.paid_at}"/> <br>--%>

<%--</c:forEach>--%>
<%--${obj.get(0).id}--%>

</body>
</html>