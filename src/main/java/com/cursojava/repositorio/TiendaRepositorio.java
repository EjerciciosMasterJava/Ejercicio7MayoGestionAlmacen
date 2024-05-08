package com.cursojava.repositorio;

import java.util.ArrayList;
import java.util.List;

import com.cursojava.model.Producto;

public class TiendaRepositorio {
	
	private List<Producto> productos = new ArrayList<Producto>();

	public List<Producto> getProductosPrueba() {
		return List.of(new Producto("Teclado", "Informatica", 20.5, 5));
	}

	public List<Producto> listarProductos() {
		return productos;
	}

	public List<Producto> getProductosBySeccion(String seccion) {
		return productos.parallelStream().filter(p -> p.getSeccion().equalsIgnoreCase(seccion)).toList();
	}

	public void agregarNuevoProducto(Producto p) {
		productos.add(p);
	}
	
	public void modificaProducto(Long id, Producto nuevo) {
		Producto actual = getProductoById(id);
		if(actual != null) {
			if(nuevo.getNombre() != null) actual.setNombre(nuevo.getNombre());
			if(nuevo.getPrecio() != null) actual.setPrecio(nuevo.getPrecio());
			if(nuevo.getSeccion() != null) actual.setSeccion(nuevo.getSeccion());
			if(nuevo.getStock() != null) actual.setStock(nuevo.getStock());
		}else {
			System.out.println("No existe ningun producto con el id " + id);
		}

	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	public Long getNextId() {
		return ((Integer)productos.size()).longValue() + 1;
	}
	
	public Producto getProductoById(Long id){
		return productos.parallelStream().filter(p -> p.getId().equals(id)).findFirst().get();
	}
	
}
