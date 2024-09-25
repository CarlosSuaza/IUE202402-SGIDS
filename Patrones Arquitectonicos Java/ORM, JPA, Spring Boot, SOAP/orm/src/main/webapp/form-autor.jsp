<%--
  Created by IntelliJ IDEA.
  User: juan pablo
  Date: 05/09/2024
  Time: 13:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Formulario de autor</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/autor">volver</a>
<div>
    <form action="${pageContext.request.contextPath}/autor" method="post">
        <label for="nombres">Nombres:</label>
        <input type="text" name="nombres" id="nombres">
        <label for="apellidos">Apellidos:</label>
        <input type="text" name="apellidos" id="apellidos">
        <label for="biografia">Biografia:</label>
        <textarea name="biografia" id="biografia"></textarea>
        <label for="fechaNacimiento">Fecha de nacimiento:</label>
        <input type="date" name="fechaNacimiento" id="fechaNacimiento">
        <label for="fechaMuerte">Fecha de muerte:</label>
        <input type=date name="fechaMuerte" id="fechaMuerte">
        <button type="submit">Guardar</button>
    </form>
</div>
</body>
</html>
