<%--
  Created by IntelliJ IDEA.
  User: juan pablo
  Date: 27/08/2024
  Time: 14:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>FORM-CARRO</title>
</head>
<body>
<form method="post" action="${pageContext.request.contextPath}/carro">
    <label for="marca">marca:</label>
    <input type="text" name="marca" id="marca">
    <label for="modelo">modelo:</label>
    <input type="text" name="modelo" id="modelo">
    <button type="submit">agregar</button>
</form>
</body>
</html>
