<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="style.css">
</head>
<body class="shop">
<h1><%= "SHOP" %>
</h1>
<br/>

<div class="parent">
    <div class="child">
        <form action="shop" method="get">
            <input type="submit" value="Shop">
        </form>
    </div>
    
    <div class="child">
        <form action="show-cart" method="post">
            <input type="submit" value="Cart">
        </form>
    </div>
    
    <div class="child">
        <a href="register.jsp"><input type="submit" value="Registration"></a>
    </div>
</div>



</body>
</html>