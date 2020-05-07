<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lohpi
  Date: 05.05.2020
  Time: 15:43
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>view</title>
</head>
<body>
<table border="1" cellpadding="2" width="100%">
    <tr>
        <th>Maker</th>
        <th>Model</th>
        <th>Price</th>
        <th>Color</th>
        <th>Year</th>
        <th>Hp</th>
        <th>Action</th>
    </tr>
    <tr>
            <td>${car.maker_name}</td>
            <td>${car.name}</td>
            <td>${car.price}</td>
            <td>${car.color}</td>
            <td>${car.year}</td>
            <td>${car.hp}</td>
        </tr>


    <input type="button" onclick="history.back();" value="Back"/>
</table>
<security:authorize access="hasAuthority('ADMIN')">
    <a id="" href="/editCar?id=${car.id}">Edit</a>

    <a id="" href="/cars">Delete</a>
</security:authorize>

<script>





</script>
</body>
</html>
