<%--
  Created by IntelliJ IDEA.
  User: BBeugnet
  Date: 21/04/2021
  Time: 15:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign Up</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <style><%@include file="style/style.css"%></style>
</head>
<body>
<div class="div_background">
    <h1>Create your account</h1>
    <form method="post">
        <p>Pseudo :<input  type="text" name="pseudo" id="pseudo" value="${user.idUser}"/></p>
        <p>FirstName :<input value="${user.firstName}" type="text" name="firstName" id="firstname"/></p>
        <p>LastName :<input value="${user.lastName}" type="text" name="lastName" id="lastname"/></p>
        <p>Date of birth :<input value="${user.dateOfBirth}" type="date" name="dateOfBirth" id="date"/></p>
        <p>Gender :
            <select name="gender" id="gender ">
                <option value="${user.gender}">${user.gender}</option>
                <option value="Female">Female</option>
                <option value="Male">Male</option>
                <option value="Other">Other</option>
            </select>
        </p>
        <p>Password :<input type="password" name="password" id="password1"/></p>
        <p>Retype Password :<input type="password" name="password" id="password2"/></p>
        <input type="submit" class="btn btn-success" value="SignUp"/>
        <p style="color:red">${error}</p>
        <a href="admin" class="btn btn-secondary">Back Admin you can click here.</a>
    </form>
</div>
</body>
</html>
