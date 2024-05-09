<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.cursojava.model.Producto"%>
<%
Producto producto = null;
String id = "";
String nombre = "";
String seccion = "";
String precio = "";
String stock = "";
try {
	producto = (Producto) request.getAttribute("producto");
	nombre = (producto.getNombre() != null) ? producto.getNombre() : "";
	seccion = (producto.getSeccion() != null) ? producto.getSeccion() : "";
	precio = (producto.getPrecio() != null) ? producto.getPrecio().toString() : "";
	stock = (producto.getStock() != null) ? producto.getStock().toString() : "";
} catch (Exception e) {}

try {
	id = (producto.getId() != null) ? producto.getId().toString() : "";
} catch (Exception e) {}
%>