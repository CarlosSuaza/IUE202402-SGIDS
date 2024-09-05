<%--
  Created by IntelliJ IDEA.
  User: juan pablo
  Date: 27/08/2024
  Time: 14:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>ERROR</title>
</head>
<body>
<h1>Ha ocurrido un error en la aplicacion :<%=exception.getMessage()%></h1>
<p>Error Interno:<%=exception.getCause().getMessage()%></p>
<a href="${pageContext.request.contextPath}">volver al principio</a>
</body>
</html>
