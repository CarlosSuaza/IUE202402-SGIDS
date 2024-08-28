<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="org.app.dryprinciple.clases.Carro"%>
<%@ page import="java.util.List" %>
<html>
<head>
    <title>CARRO</title>
</head>
<body>
<main>
    <div>
        <a href="${pageContext.request.contextPath}">volver</a>
        <a href="${pageContext.request.contextPath}/form-carro.jsp">Agregar carro</a>
        <a href="${pageContext.request.contextPath}/carro">actualizar lista</a>
        <%
            List<Carro> carros = (List) session.getAttribute("carros");
            for (Carro carro : carros){
        %>

            <p>id: <%=carro.getId()%></p>
            <p>marca: <%=carro.getMarca()%></p>
            <p>modelo: <%=carro.getModelo()%></p>
            <p>----------------------------</p>
            <br>


        <%
            }
        %>
        <form method="post" action="${pageContext.request.contextPath}/carro">
            <h1>Actualizar un carro</h1>
            <input type="hidden" name="_method" value="put">
            <label for="id">id:</label>
            <input type="number" name="id" id="id">
            <label for="marca">marca:</label>
            <input type="text" name="marca" id="marca">
            <label for="modelo">modelo:</label>
            <input type="text" name="modelo" id="modelo">
            <button type="submit">actualizar</button>
        </form>
        <form method="post" action="${pageContext.request.contextPath}/carro">
            <h1>Borrar carro</h1>
            <input type="hidden" name="_method" value="delete">
            <label for="_id">id:</label>
            <input type="number" name="id" id="_id">
            <button type="submit">borrar</button>
        </form>
    </div>
</main>
</body>
</html>
