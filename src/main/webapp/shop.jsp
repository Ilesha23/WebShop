<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>ITEMS</title>
    <link rel="stylesheet" href="style.css">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <script src="jquery.js"></script>
    <script>
        function addToCart(item_id) {
            $.ajax({
                type: "POST",
                url: '<c:url value="/cart"/>',
                data: {
                    id: item_id,
                },
                success: function (msg) {
                    var $html = $(msg);
                    var $span = $html.find('span#countt');
                    var text = $span.text();
                    $("#countt").html(text);
                    console.log(text);
                }
            })
        }
    </script>
</head>
<body class="items">
<jsp:include page="header.jsp"/>

<div>

    <table>
        <thead>
        <tr>
            <th></th>
            <th>Name</th>
            <th>Description</th>
            <th>price</th>
        </tr>
        </thead>
        <c:forEach var="prod" items="${cont}" varStatus="loop">
            <tr>
                <th><input type="button" value="add to cart" name="${loop.index}" onclick="addToCart(${prod.id})"></th>
                <th>${prod.name}</th>
                <th>${prod.desc}</th>
                <th>${prod.price}</th>
            </tr>
        </c:forEach>
    </table>

</div>

</body>
</html>
