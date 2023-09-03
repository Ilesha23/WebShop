
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Cart</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>

<jsp:include page="header.jsp"/>

<form action="remove-from-cart" method="post">
    <table>
        <thead>
            <tr>
                <td>Add</td>
                <td>Name</td>
                <td>Descr</td>
                <td>Price</td>
            </tr>
        </thead>
        <c:forEach var="prod" items="${cart.items}" varStatus="loop">
            <tr>
                <td><input type="submit" value="remove" name="${loop.index}"></td>
                <td> ${prod.name} </td>
                <td> ${prod.desc} </td>
                <td> ${prod.price} </td>
            </tr>
        </c:forEach>
    </table>
</form>

<c:if test="${cart.size ne 0}">
    <p>Price is: ${cart.price}</p>
    <form action="order" method="post">
        <input type="text" name="addr" placeholder="address">
        <input type="submit" value="Order">
    </form>
    <p>${error}</p>
</c:if>
<c:if test="${cart.size eq 0}">
    <p>Cart is empty</p>
</c:if>

</body>
</html>
