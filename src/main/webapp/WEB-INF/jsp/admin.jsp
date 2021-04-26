<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
           <h2>Event list</h2>
            <tr>
                <th>Id</th>
                <th>Title</th>
                <th>Description</th>
                <th>Date</th>
                <th>Localisation</th>
                <th>Type</th>
            </tr>
            <c:forEach var="eventLists" items="${eventList}">
                <tr>
                    <td><c:out value="${eventLists.idEvent}" /></td>
                    <td><c:out value="${eventLists.titre}" /></td>
                    <td><c:out value="${eventLists.description}" /></td>
                    <td><c:out value="${eventLists.date}" /></td>
                    <td><c:out value="${eventLists.localisation}" /></td>
                    <td><c:out value="${eventLists.type.typeField}" /></td>
                    <td>
                        <a href="edit?id=<c:out value='${eventLists.idEvent}' />">Update</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;

                        <a href="/deleteeven/${eventLists.idEvent}"class="btn btn-danger" />Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <a href="event" class="btn btn-secondary">Add Event.</a>
    </div>


    <div align="center">
        <table border="1" cellpadding="5">
            <h2>User list</h2>
            <tr>
                <th>Id</th>
                <th>Pseudo</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Date of Birth</th>
                <th>Gender</th>
            </tr>
            <c:forEach var="userLists" items="${userList}">
                <tr>
                    <td><c:out value="${userLists.idUser}" /></td>
                    <td><c:out value="${userLists.pseudo}" /></td>
                    <td><c:out value="${userLists.firstName}" /></td>
                    <td><c:out value="${userLists.lastName}" /></td>
                    <td><c:out value="${userLists.dateOfBirth}" /></td>
                    <td><c:out value="${userLists.gender}" /></td>
                    <td>
                        <a href="/updateuser/${userLists.idUser}" class="btn btn-danger"> Update</a>
                        &nbsp;&nbsp;&nbsp;&nbsp
                        <a href="/deleteuser/${userLists.idUser}" class="btn btn-danger"> Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>

    </div>
    </div>

</div>
</body>
</html>
