<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: BBeugnet
  Date: 21/04/2021
  Time: 19:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Panier</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <style><%@include file="style/style.css"%></style>
</head>
<body>
<div class="div_background">
<h1><a href="logout" class="btn btn-danger"> log out </a></h1>
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
                <td>Delete ?</td>
            </tr>
            </thead>

            <c:forEach items = "${res}" var="reservation">
                <tbody>
                <tr>
                    <td><c:out value="${reservation.event.titre}"/></td>
                    <td><c:out value="${reservation.event.description}"/></td>
                    <td><c:out value="${reservation.event.type.typeField}"/></td>
                    <td><c:out value="${reservation.event.date}"/></td>
                    <td><c:out value="${reservation.event.time}"/></td>
                    <td><c:out value="${reservation.event.localisation}"/></td>
                    <td><a href="/deleteres/${reservation.idReservation}" class="btn btn-danger">Delete this participation</a></td>
                </tr>
                </tbody>
            </c:forEach>
        </table>
    </div>
    <a href="/panier/validate" class="btn btn-success">Checkout</a>
</div>
</body>
</html>
