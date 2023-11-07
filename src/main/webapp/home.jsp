<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 11/7/2023
  Time: 8:44 AM
  To change this template use File | Settings | File Templates.
--%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <title>Document</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
          integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
            integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
            integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js"
            integrity="sha384-+sLIOodYLS7CIrQpBjl+C7nPvqq+FbNUBDunl/OZv93DB7Ln/533i8e/mZXLi/P+"
            crossorigin="anonymous"></script>
</head>
<body>
<form class="input-group input-group-outline" action="/student" method="get" style="width: 20%;display: flex">
    <input type="text" hidden="hidden" name="action" value="home">
    <input type="text" class="form-control" name="search">
    <button class="btn btn-info" type="submit">Search
    </button>
</form>
<a href="http://localhost:8080/student?action=create">Add Student</a>
<table class="table">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>DateOfBirth</th>
        <th>Email</th>
        <th>Address</th>
        <th>Phone</th>
        <th>ClassRoom</th>
        <th>Action</th>
    </tr>

   <c:forEach var="items" items="${list}">

       <tr>
           <td>${items.id}</td>
           <td>${items.name}</td>
           <td>${items.date}</td>
           <td>${items.address}</td>
           <td>${items.phone}</td>
           <td>${items.email}</td>
           <td>${items.classroom}</td>
           <td><a href="http://localhost:8080/student?action=update&id=${items.id}">
               <button class="btn btn-primary">Edit</button></a></td>
           <td><a href=http://localhost:8080/student?action=delete&id=${items.id}>
               <button class="btn btn-danger">Delete</button></a></td>
       </tr>

   </c:forEach>
</table>
</body>
</html>