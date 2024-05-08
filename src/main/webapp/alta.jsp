<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.cursojava.model.Producto" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Alta producto</title>
</head>
<body>

	<form action="RegistrarProducto" method="post">

		Nombre:<input type="text" name="nombre"><br>
		Seccion:<input type="text" name="seccion"><br>
		Precio:<input type="number" name="precio"><br>
		Stock:<input type="number" name="stock"><br>
		
		<button	type="submit" value="Entrar" >Registrar</button>

	</form>
	<%
	Producto producto = (Producto)request.getAttribute("producto");
	if(producto != null){
		%> <h3>Producto registrado correctamente : <%=producto %></h3><%
	}
	%>

<a href="inicio.html">Inicio</a>
</body>
</html>