<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Your order</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<jsp:include page="header.jsp"/>

<p>Receipt</p>
<p>Order number: ${order.orderNumber}</p>
<p>Your items:</p>
<c:forEach var="item" items="${cart.items}">
    <p>${item}</p>
</c:forEach>
<p>Price: ${price}</p>

</body>
</html>
