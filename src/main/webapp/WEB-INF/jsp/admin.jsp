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
    <title>Login</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <style><%@include file="style/style.css"%></style>
</head>
<body>
<div class="div_background">
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>Liste des events</h2></caption>
            <tr>
                <th>Id</th>
                <th>Titre</th>
                <th>Description</th>
                <th>Date</th>
                <th>Localisation</th>
            </tr>
            <c:forEach var="eventList" items="${eventList}">
                <tr>
                    <td><c:out value="${eventList.idEvent}" /></td>
                    <td><c:out value="${eventList.titre}" /></td>
                    <td><c:out value="${eventList.description}" /></td>
                    <td><c:out value="${eventList.date}" /></td>
                    <td><c:out value="${eventList.localisation}" /></td>
                     <td>
                       <a href="edit?id=<c:out value='${eventList.idEvent}' />">Modifier</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="delete?id=<c:out value='${eventList.idEvent}' />">Supprimer</a>
                </tr>
            </c:forEach>
        </table>
    </div>


</div>
</body>
</html>
