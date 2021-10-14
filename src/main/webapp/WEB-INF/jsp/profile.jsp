<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--@elvariable id="client" type="com.hillel.car.shop.entity.User"--%>
<html>
<head>
    <title>Profile </title>
</head>
<body>
<p>Id : ${client.id} </p>
<p>Name : ${client.name}</p>
<p>Password : ${client.password}</p>
</body>
</html>
