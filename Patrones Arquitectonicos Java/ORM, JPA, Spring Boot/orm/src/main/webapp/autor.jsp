<%@ page import="java.util.List" %>
<%@ page import="org.iuedesarrollosoftware.orm.entidades.AutorEntity" %><%--
  Created by IntelliJ IDEA.
  User: juan pablo
  Date: 05/09/2024
  Time: 8:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Autor</title>
</head>
<body>
    <main>
        <a href="${pageContext.request.contextPath}">Volver</a>
        <a href="${pageContext.request.contextPath}/form-autor.jsp">Agregar autor</a>
        <div>
            <h1>Lista de autores</h1>
            <%
                List<AutorEntity> autores = (List) session.getAttribute("autores");
                for (AutorEntity autor : autores) {
            %>
            <p>id: <%=autor.getId()%></p>
            <p>nombres: <%=autor.getNombres()%></p>
            <p>apellidos: <%=autor.getApellidos()%></p>
            <p>fecha de nacimiento: <%=autor.getFechanacimiento().toString()%></p>
            <p>fecha de muerte: <%=autor.getFechamuerte().toString()%></p>
            <%
                }
            %>
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
                <input type="text" name="biografia" id="biografia">
                <label for="fechaNacimiento">Fecha de nacimiento:</label>
                <input type="date" name="fechaNacimiento" id="fechaNacimiento">
                <label for="fechaMuerte">Fecha de muerte:</label>
                <input type=date name="fechaMuerte" id="fechaMuerte">
                <button type="submit">Actualizar</button>
            </form>
        </div>
        <div>
            <h1>Eliminar Autor</h1>
            <form action="${pageContext.request.contextPath}/autor">
                <input type="hidden" name="_method" value="delete">
                <label for="_id">Id</label>
                <input type="text" name="_id" id="_id">
                <button type="submit">borrar</button>
            </form>
        </div>
    </main>
</body>
</html>
