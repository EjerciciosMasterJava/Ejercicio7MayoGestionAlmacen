<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.cursojava.model.Producto"%>
<!DOCTYPE html>

<!-- BOOTSTRAP -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registro</title>
<style>
@media ( min-width : 1025px) {
	.h-custom {
		height: 100vh !important;
	}
}
</style>

</head>
<body>

<!--  GET DETALLES DEL PRODUCTO PARA CUANDO EDITAMOS EN LUGAR DE ALTA -->
<%@ include file="script/altaproductodetail.jsp" %>

<%@ include file="nav.htm" %>

	<%try {
		String ret = request.getParameter("ret");
		if (!ret.isEmpty()) {
	%><h3><%=ret%></h3><%}} catch (Exception e) {}%>

	<section class="h-100 h-custom" style="background-color: #8fc4b7; min-width: 400px;">
		<div class="container py-5 h-100">
			<div
				class="row d-flex justify-content-center align-items-center h-100">
				<div class="col-lg-8 col-xl-6">
					<div class="card rounded-3">
						<img
							src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-registration/img3.webp"
							class="w-100"
							style="border-top-left-radius: .3rem; border-top-right-radius: .3rem; height: 80px"
							alt="Sample photo">
						<div class="card-body p-4 p-md-5">

							<!-- TITULO DE LA CARD -->
							<h3 class="mb-4 pb-2 pb-md-0 mb-md-5 px-md-2">Detalles producto</h3>

							<form class="px-md-2" action="RegistrarProducto" method="post">

								<!--  INPUT NOMBRE PRODUCTO -->
								<div data-mdb-input-init class="form-outline mb-4">
									<label class="form-label" for="nombre">Nombre</label> <input
										type="text" id="nombre" class="form-control" name="nombre" value="<%=nombre%>"/>
								</div>

								<!--  INPUT SECCION PRODUCTO -->
								<div data-mdb-input-init class="form-outline mb-4">
									<label class="form-label" for="seccion">Seccion</label> <select
										data-mdb-select-init id="seccion" name="seccion" value="<%=seccion%>">
										<option value="1" disabled>Seccion</option>
										<option value="Perifericos">Perifericos</option>
										<option value="Ordenadores">Ordenadores</option>
										<option value="Almacenamiento">Almacenamiento</option>
									</select>
								</div>
								
								<div data-mdb-input-init class="form-outline mb-4">
									<label class="form-label" for="id" hidden="true">id</label> <input type="number" id="id" class="form-control" name="id" value="<%=id%>" hidden="true"/>
								</div>

								<!--  INPUT PRECIO PRODUCTO -->
								<div data-mdb-input-init class="form-outline mb-4">
									<label class="form-label" for="precio">Precio</label> <input
										type="number" id="precio" class="form-control" name="precio" value="<%=precio%>"/>
								</div>
								
								<!--  INPUT STOCK PRODUCTO -->
								<div data-mdb-input-init class="form-outline mb-4">
									<label class="form-label" for="stock">Stock</label> <input
										type="number" id="stock" class="form-control" name="stock" value="<%=stock%>"/>
								</div>

								<!--  BOTON ENVIAR -->
								<button type="submit" data-mdb-button-init data-mdb-ripple-init
									class="btn btn-success btn-lg mb-1">Submit</button>

							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	

</body>
<footer>

	<!--  FOOTER  -->
	<%@ include file="footer.htm" %>
	
</footer>
</html>