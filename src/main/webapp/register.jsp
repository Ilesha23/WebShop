<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Registration</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>

<jsp:include page="header.jsp"/>

<form action="register" method="post">
  <input type="text" name="login" value="${bean.login}" placeholder="login"> <br>
    <span class="err">${errors.login}</span> <br>
  <input type="text" name="pwd" value="${bean.password}" placeholder="password"> <br>
    <span class="err">${errors.pwd}</span> <br>
  Advertising: <input type="checkbox" name="advert" <c:if test="${bean.advertising}"> checked </c:if> > <br>
  <input type="submit" value="register">
</form>

<p>${registerStatus}</p>

<p>Name: ${name}</p>
<p>Pass: ${pass}</p>
<p>Info: ${info}</p>

</body>
</html>
