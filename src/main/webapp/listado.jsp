<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.cursojava.service.TiendaService"%>
<%@ page import="com.cursojava.repositorio.*"%>
<%@ page import="com.cursojava.model.Producto"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
<style>
.student-avathar {
  border: 1px solid var(--gray);
  border-radius: 50px;
  height: 3rem;
  width: 3rem;
}
.passed {
  color: green;
  background-color: rgba(185, 255, 218, 0.4);
  padding: 6px;
  border-radius: 2px;
  -webkit-border-radius: 2px;
  -moz-border-radius: 2px;
  -ms-border-radius: 2px;
  -o-border-radius: 2px;
}
.failed {
  color: red;
  background-color: rgba(241, 172, 172, 0.25);
  padding: 6px;
  border-radius: 2px;
  -webkit-border-radius: 2px;
  -moz-border-radius: 2px;
  -ms-border-radius: 2px;
  -o-border-radius: 2px;
}
.wrapper {
  background-color: #fdfdfd;
  box-shadow: 0px 1px 5px rgba(0, 0, 0, 0.16);
}
.custom-dropdown-toggle {
  border: none !important;
  background: none !important;
}
</style>
<head>
<meta charset="ISO-8859-1">
<title>Listado productos</title>
</head>
<body>

<div style="min-height: 600px;">
<!--  NAV  -->
	<%@ include file="nav.htm" %>

	<!--  LISTA PRODUCTOS  -->
	<%
	TiendaRepositorio tienda = TiendaService.getTiendaRepositorio();
	List<Producto> productosFiltrados = tienda.getProductosFiltrados();
	List<Producto> productos = tienda.getProductos();
	if(!productosFiltrados.isEmpty()) productos = productosFiltrados;
	%>
	
	<!--  FILTRAR PRODUCTO  -->
	<form class="container" action="FiltrarProductos" method="post" style="margin-top: 20px; margin-bottom: 0px;">
		<input type="text" name="filtroNombre">
		<button type="submit">Filtrar</button>
	</form>

	<!--  TABLA DETALLES PRODUCTO -->
	<section class="container g-2 py-5">
		<div class="table-responsive mt-4 p-4 wrapper rounded-3">
		  <table class="table table-scrollable">
		    <thead class="bg-light text-center">
		      <tr class="align-middle">
					<th>Id_Producto</th>
					<th>Nombre</th>
					<th>Seccion</th>
					<th>Precio</th>
					<th>Stock</th>
					<th>Modificar</th>
					<th>Eliminar</th>
		      </tr>
		    </thead>
		    <tbody class="table-hover text-center" id="productDetails">
		    <%for (int i = 0; i < productos.size(); i++) {%>
				<tr class="align-middle">
					<td><%=productos.get(i).getId()%></td>
					<td><%=productos.get(i).getNombre()%></td>
					<td><%=productos.get(i).getSeccion()%></td>
					<td><%=productos.get(i).getPrecio()%></td>
					<td><%=productos.get(i).getStock()%></td>
					<td>
						<form action="ModificarProducto" method="post">
							<%String id = productos.get(i).getId().toString();%>
							<input type="number" name="idProducto" value="<%=id%>" hidden="true">
							<button type="submit" value="Entrar" class="passed">Editar</button>
						</form>
					</td>
					<td>
						<form action="EliminarProducto" method="post">
							<input type="number" id="" name="idProducto" value="<%=id%>" hidden="true">
							<input type="submit" onclick="clicked(event)" class="failed" value="Eliminar"/>
						</form>
					</td>
				</tr>
				<%}%>
		     </tbody>
		  </table>
		</div>
	</section>
	

 
    <script>
    function clicked(e)
    {
        if(!confirm('Are you sure?')) {
            e.preventDefault();
        }
    }

    </script>

</div>
	
    

</body>
<footer>
    <%@ include file="footer.htm" %>
</footer>
</html>