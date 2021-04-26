<%--
  Created by IntelliJ IDEA.
  User: BBeugnet
  Date: 21/04/2021
  Time: 09:49
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Event</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <style><%@include file="style/style.css"%></style>
</head>
<body>
<div class="div_background">
    <h1>Login</h1>
    <form method="post" action="${action}">
        <p>Title : <input value="${titre}" type="text" name="titre" id="titre"/></p>
        <p>Description :<input value="${description}" type="text" name="description" id="description"/></p>
        <p>Date : <input value="${date}" type="date" name="date" id="date"/></p>
        <p>Time : <input value="${time}" type="time" name="time" id="time"/></p>
        <p>Type :
            <Select name="type" id="type">
                <option value=""></option>
                <c:forEach items = "${type}" var="typeEvent">
                    <option value="${typeEvent.id}">${typeEvent.typeField}</option>
                </c:forEach>
            </Select>
            if your type is not here, please enter your type : <input type="text" name="typeadd" id="typeAdd"/>
        </p>
        <p>Localisation : <input value="${localisation}" type="text" name="localisation" id="localisation"/></p>
        <input type="submit" class="btn btn-success" value="${button}"/>
    </form>
    <p style="color:red">${error}</p>
    <a href="admin" class="btn btn-secondary">To back click here.</a>
</div>
</body>
</html>
