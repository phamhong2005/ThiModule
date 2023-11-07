<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 11/7/2023
  Time: 10:31 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="http://localhost:8080/student?action=update&id=${id}"method="post">
    <input type="text" name="name" value="${student.name}">
    <input type="text" name="date" value="${student.date}">
    <input type="text" name="address" value="${student.address}">
    <input type="text" name="phone" value="${student.phone}">
    <input type="text" name="email" value="${student.email}">
    <input type="text" name="idClass" value="${student.classroom}">
    <button type="submit">Enter</button>
</form>
</body>
</html>
