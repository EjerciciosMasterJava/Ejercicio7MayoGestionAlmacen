<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.cursojava.model.Producto" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Alta producto</title>
</head>
<%
Producto producto = null;
String id = "";
String nombre = "";
String seccion = "";
String precio = "";
String stock = "";
try{
	producto = (Producto)request.getAttribute("producto");
	nombre = (producto.getNombre() != null)? producto.getNombre() : "";
	seccion = (producto.getSeccion() != null) ? producto.getSeccion() : "";
	precio = (producto.getPrecio() != null)? producto.getPrecio().toString() : "";
	stock = (producto.getStock() != null)? producto.getStock().toString() : "";
}catch(Exception e){
	
}

try{
	id = (producto.getId() != null)? producto.getId().toString() : "";
}catch(Exception e){
	
}

%>
<body>

	<form action="RegistrarProducto" method="post">
		<input type="number" name="idProducto" value="<%=id%>"><br>
		Nombre:<input type="text" name="nombre" value="<%=nombre%>"><br>
		Seccion:<input type="text" name="seccion" value="<%=seccion%>"><br>
		Precio:<input type="number" name="precio" value="<%=precio%>"><br>
		Stock:<input type="number" name="stock" value="<%=stock%>"><br>
		
		<button	type="submit" value="Entrar" >Registrar</button>

	</form>
	<%
	if(producto != null){
		%> <h3>Producto registrado correctamente : <%=producto %></h3><%
	}
	%>

<a href="inicio.html">Inicio</a>
</body>
</html>