<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>DRY-PRINCIPLE</title>
</head>
<body>
<%String word = "java";%>
<h1>hello world from <%=word%></h1>
<a href="${pageContext.request.contextPath}/carro">Ir a los carros</a>
</body>
</html>