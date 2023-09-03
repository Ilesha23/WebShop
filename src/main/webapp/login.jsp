<%--
  Created by IntelliJ IDEA.
  User: Note
  Date: 13.05.2023
  Time: 12:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>

<jsp:include page="header.jsp"/>

<form action="login" method="post">
  <input type="text" name="login" placeholder="login">
    <span class="err">${errors.login}</span>
  <input type="text" name="pwd" placeholder="pass">
  <input type="submit" value="Login">
</form>

<p>${status}</p>

</body>
</html>
