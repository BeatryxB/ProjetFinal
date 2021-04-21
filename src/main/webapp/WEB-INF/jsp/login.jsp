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
</head>
<body>
<h1>Login here</h1>
<form method="post" action="login">
<p>Pseudo :<input type="text" name="pseudo" id="pseudo"/></p>
<p>Password :<input type="password" name="password" id="password"/></p>
<input type="submit"/>
</form>
<p style="color:red">${error}</p>
<a href="signup">If you want one account, you can click here.</a>

</body>
</html>
