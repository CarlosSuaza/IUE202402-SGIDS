<%@ page import="org.iuedesarrollosoftware.orm.entidades.AutorEntity" %><%--
  Created by IntelliJ IDEA.
  User: juan pablo
  Date: 06/09/2024
  Time: 8:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Detalle autor</title>
</head>
<body>
<main>
    <div>
        <%
            AutorEntity autorEntity = (AutorEntity) session.getAttribute("autor");
        %>
        <p>Id: <%=autorEntity.getId()%></p>
        <p>Nombres: <%=autorEntity.getNombres()%></p>
        <p>Apellidos: <%=autorEntity.getApellidos()%></p>
        <p>Biografia: <%=autorEntity.getBiografia()%></p>
        <p>Fecha de nacimiento: <%=autorEntity.getFechanacimiento()%></p>
        <p>Fecha de muerte: <%=autorEntity.getFechamuerte()%></p>
    </div>
    <div>
        <form action="${pageContext.request.contextPath}/autor" method="post">
            <input type="hidden" name="_method" value="put">
            <label for="id">Id:</label>
            <input type="text" name="id" id="id">
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
            <button type="submit">Actualizar</button>
        </form>
    </div>
    <a href="${pageContext.request.contextPath}/autor">volver</a>
</main>
</body>
</html>
