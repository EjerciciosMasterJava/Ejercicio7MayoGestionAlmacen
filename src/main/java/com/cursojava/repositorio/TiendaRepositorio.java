package com.cursojava.repositorio;

import java.util.ArrayList;
import java.util.List;

import com.cursojava.model.Producto;

public class TiendaRepositorio {
	
	private List<Producto> productos = new ArrayList<>(List.of(
			new Producto(1l,"Teclado", "Periferico", 20d, 10),
			new Producto(2l, "Raton", "Periferico", 15d, 10),
			new Producto(3l,"Auriculares", "Audio", 20d, 10)
			));
	
	private List<Producto> productosFiltrados = new ArrayList<>();
	
	public void setProductosFiltrados(List<Producto> productosFiltrados) {
		this.productosFiltrados = productosFiltrados;
	}

	public List<Producto> getProductosPrueba(){
		return List.of(
				new Producto(1l,"Teclado", "Periferico", 20d, 10),
				new Producto(2l, "Raton", "Periferico", 15d, 10),
				new Producto(3l,"Auriculares", "Audio", 20d, 10)
				);
	}
	
	public void eliminarProductoById(Long id) {
		if(id != null) {
			try {
				Producto p = getProductoById(id);
				if(p != null) {
					productos.remove(p);
					System.out.println("Se ha eliminado el producto con id " + id);
				}else {
					System.out.println("No se puede eliminar el producto porque no existe en la base de datos ningun producto con id " + id);
				}
			} catch (Exception e) {
				System.out.println("No se ha podido eliminar el producto con id " + id);
				e.printStackTrace();
			}
		}
	}
	
	public List<Producto> filtrarProductos(Producto filtro){
		List<Producto> filtrados = new ArrayList();
		if(filtro != null) {
			if(filtro.getNombre() != null) {
				filtrados = productos.parallelStream().filter(p -> p.getNombre().contains(filtro.getNombre())).toList();
			}
		}
		this.productosFiltrados = filtrados;
		return filtrados;
	}

	public List<Producto> getProductosFiltrados() {
		return productosFiltrados;
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

	public Long getNextId() {
		if(productos == null) return 1L;
		return ((Integer)productos.size()).longValue() + 1;
	}
	
	public Producto getProductoById(Long id){
		return productos.parallelStream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
	}
	
}
