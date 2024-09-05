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
            <form action="${pageContext.request.contextPath}/autor">
                <label for="nombres">Nombres:</label>
                <input type="text" name="nombres" id="nombres">
                <label for="apellidos">Apellidos:</label>
                <input type="text" name="apellidos" id="apellidos">
                <label for="biografia">Nombres:</label>
                <input type="text" name="biografia" id="biografia">

            </form>
        </div>
    </main>
</body>
</html>
