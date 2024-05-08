package com.cursojava.service;

import java.util.ArrayList;
import java.util.List;

import com.cursojava.model.Producto;

public class TiendaService {

	private static List<Producto> productos = new ArrayList<Producto>();

	public TiendaService() {
	}

	public List<Producto> getProductosPrueba() {
		return List.of(new Producto("Teclado", "Informatica", 20.5, 5));
	}

	public List<Producto> listarProductos() {
		return productos;
	}

	public List<Producto> getProductosBySeccion(String seccion) {
		return productos.parallelStream().filter(p -> p.getSeccion().equalsIgnoreCase(seccion)).toList();
	}

	public void agregarProducto(Producto p) {
		productos.add(p);
	}

	public static List<Producto> getProductos() {
		return productos;
	}

	public static void setProductos(List<Producto> productos) {
		TiendaService.productos = productos;
	}
	
	public static Long getNextId() {
		return ((Integer)TiendaService.productos.size()).longValue() + 1;
	}



}
