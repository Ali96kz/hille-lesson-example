<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%--@elvariable id="user" type="com.hillel.car.shop.entity.Car"--%>
<html>
<head>
    <title>Profile </title>
</head>
<body>
<a href="basket">view my basket</a>

<c:forEach items="${cars}" var="car">
    <br>
    <c:out value="${car.id}"/>
    <c:out value="${car.name}"/>
    <a href="addToBasket?carId=${car.id}">Buy these car</a>
</c:forEach>


</body>
</html>
