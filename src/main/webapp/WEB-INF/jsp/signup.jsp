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
</head>
<body>
<h1>Create your account</h1>
<form method="post">
    <p>Pseudo :<input type="text" name="pseudo" id="pseudo"/></p>
    <p>FirstName :<input type="text" name="firstName" id="firstname"/></p>
    <p>LastName :<input type="text" name="lastName" id="lastname"/></p>
    <p>Date of birth :<input type="date" name="dateOfBirth" id="date"/></p>
    <p>Gender :
        <select name="gender" id="gender">
        <option value=""></option>
        <option value="Female">Female</option>
        <option value="Male">Male</option>
        <option value="Other">Other</option>
        </select>
    </p>
    <p>Password :<input type="password" name="password" id="password1"/></p>
    <p>Retype Password :<input type="password" name="password" id="password2"/></p>
    <input type="submit"/>
    <p style="color:red">${error}</p>
    <a href="login">If you have any account, you can click here.</a>
</form>
</body>
</html>
