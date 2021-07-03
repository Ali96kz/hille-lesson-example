<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%--@elvariable id="car" type="com.hillel.car.shop.entity.Car"--%>
<%--@elvariable id="basket" type="com.hillel.car.shop.entity.Basket"--%>
<html>
<head>
    <title>Profile </title>
</head>
<body>
<c:forEach items="${basket.cars}" var="car">
    <br>
    <c:out value="${car.id}"/>
    <c:out value="${car.name}"/>
    <br>
</c:forEach>

<a href="cars">view all cars</a>

</body>
</html>
