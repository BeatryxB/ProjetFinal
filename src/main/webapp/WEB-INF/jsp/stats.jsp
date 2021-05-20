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
    <title>Home</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <style><%@include file="style/style.css"%></style>
</head>
<body>
<div class="div_background">
<h1>welcome ${user}    <a href="logout" class="btn btn-danger"> log out </a></h1>
    <a class="btn btn-primary" href="/searchevent"> Click here to search other event</a>
    <a class="btn btn-primary" href="/panier"> Click here to checkout</a>
    <%@include file="Fragment/TableEventResByUser.jsp"%>
</div>
</body>
</html>
