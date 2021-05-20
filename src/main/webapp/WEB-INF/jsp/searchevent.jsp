<%--
  Created by IntelliJ IDEA.
  User: BBeugnet
  Date: 28/04/2021
  Time: 10:06
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search Event</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <style><%@include file="style/style.css"%></style>
</head>
<body>
<div class="div_background">
    <h1>Search event <a href="logout" class="btn btn-danger"> log out </a></h1>
<form action="/searchevent" method="post">
    <p>Title : <input type="text" name="title"></p>
    <p>Date : <input type="date" name="date"></p>
    <p>localisation : <input type="text" name="loc"></p>
    <p>Type :
        <Select name="type" id="type">
            <option value=""></option>
            <c:forEach items = "${type}" var="typeEvent">
                <option value="${typeEvent.id}">${typeEvent.typeField}</option>
            </c:forEach>
        </Select>
    <input type="submit" class="btn btn-primary" value="search">
</form>
    <p style="color:red">${error}</p>
    <div class="div_res">
        <table class="table">
            <thead class=".thead-light">
            <tr>
                <td>Title</td>
                <td>Description</td>
                <td>Type</td>
                <td>Date</td>
                <td>Time</td>
                <td>Localisation</td>
                <td>Reservate</td>
            </tr>
            </thead>

            <c:forEach items = "${eve}" var="event">
                <tbody>
                <tr>
                    <td><c:out value="${event.titre}"/></td>
                    <td><c:out value="${event.description}"/></td>
                    <td><c:out value="${event.type.typeField}"/></td>
                    <td><c:out value="${event.date}"/></td>
                    <td><c:out value="${event.time}"/></td>
                    <td><c:out value="${event.localisation}"/></td>
                    <td><a href="/addreservation/${event.idEvent}" class="btn btn-Secondary">reservate</a></td>
                </tr>
                </tbody>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>
