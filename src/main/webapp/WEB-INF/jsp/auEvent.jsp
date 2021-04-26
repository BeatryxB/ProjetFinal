<%--
  Created by IntelliJ IDEA.
  User: BBeugnet
  Date: 21/04/2021
  Time: 09:49
  To change this template use File | Settings | File Templates.
--%>
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
    <form method="post">
        <p>Title : <input  type="text" name="titre" id="titre"/></p>
        <p>Description :<input  type="text" name="description" id="description"/></p>
        <p>Date : <input type="date" name="date" id="date"/></p>
        <p>Time : <input  type="text" name="time" id="time"/></p>
        <p>Type : <input  type="text" name="type" id="type"/></p>
        <p>Localisation : <input type="text" name="localisation" id="localisation"/></p>
        <input type="submit" class="btn btn-success" value="AUEvent"/>
    </form>
    <p style="color:red">${error}</p>
    <a href="admin" class="btn btn-secondary">To back click here.</a>
</div>
</body>
</html>
