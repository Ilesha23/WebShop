<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title></title>
</head>
<body>

<div class="header">
    <div class="left">
        <a href="shop">SHOP</a>
    </div>
    <div class="right">
<%--        <form action="show-cart" method="post">--%>
<%--            <input type="submit" value="Cart">--%>
<%--            <span class="countt">${countt}</span>--%>
<%--        </form>--%>

<%--    <a href="<c:url value="/show-cart"/>">Cart [<span id="countt"> ${cart.size}</span>]</a>--%>

    <form id="myform" action="show-cart" method="post">
        <a href="#" onclick="subm()">Cart [<span id="countt">${0 + cart.size}</span>]</a>
    </form>
    <script>
        function subm(){
            document.getElementById('myform').submit();
        }
    </script>

        <c:choose>
            <c:when test="${empty login}">
<%--                <form action="register.jsp">--%>
<%--                    <input type="submit" value="Register">--%>
<%--                </form>--%>
<%--                <form action="login.jsp">--%>
<%--                    <input type="submit" value="Login">--%>
<%--                </form>--%>
                <a href="register.jsp">Register</a>
                <a href="login.jsp">Login</a>
            </c:when>
            <c:otherwise>
                <form action="logout" method="post">
                    <input type="submit" value="Logout">
                </form>
            </c:otherwise>
        </c:choose>
    </div>
</div>

</body>
</html>
