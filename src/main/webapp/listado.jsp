<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.cursojava.service.TiendaService" %>
    <%@ page import="com.cursojava.model.Producto" %>
    <%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listado productos</title>
<style type="text/css">
table{
border: 1;
}
</style>

</head>
<body>
<%
TiendaService service = new TiendaService();
List<Producto> productos = TiendaService.getTiendaRepositorio().getProductos();
%>
<table>
<tr><th>Id_Producto</th><th>Nombre</th><th>Seccion</th><th>Precio</th><th>Stock</th><th>Modificar</th><th>Eliminar</th></tr>
<%
for(int i = 0; i < productos.size(); i++){
	%><tr>
	<td><%=productos.get(i).getId() %></td>
	<td><%=productos.get(i).getNombre() %></td>
	<td><%=productos.get(i).getSeccion() %></td>
	<td><%=productos.get(i).getPrecio() %></td>
	<td><%=productos.get(i).getStock() %></td>
	<td>
		<form action="ModificarProducto" method="post">
<%String id =  productos.get(i).getId().toString();%>
		<input type="number" name="idProducto" value="<%=id%>" hidden="true">
		<button	type="submit" value="Entrar" >Editar</button>
	</form>
	</td>
	<td>delete/producto=<%=productos.get(i).getId() %></td>
	</tr> <%
}
%>
</table>
<a href="inicio.html">Inicio</a>
</body>
</html>