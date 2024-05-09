package com.cursojava.repositorio;

import java.util.ArrayList;
import java.util.List;

import com.cursojava.model.Producto;

public class TiendaRepositorio {
	
	// Lista de productos de la tienda
	private List<Producto> productos = new ArrayList<>(List.of(
			new Producto(1l,"Teclado", "Periferico", 20d, 10),
			new Producto(2l, "Raton", "Periferico", 15d, 10),
			new Producto(3l,"Auriculares", "Audio", 20d, 10)
			));
	
	// Lista de productos filtrados
	private List<Producto> productosFiltrados = new ArrayList<>();
	
	/**
	 * Metodo para obtener una lista de productos de prueba al inicializar el programa
	 * @return la lista de productos
	 */
	public List<Producto> getProductosPrueba(){
		return List.of(
				new Producto(1l,"Teclado", "Periferico", 20d, 10),
				new Producto(2l, "Raton", "Periferico", 15d, 10),
				new Producto(3l,"Auriculares", "Audio", 20d, 10)
				);
	}
	
	/**
	 * Eliminar un producto por su id
	 * @param id el id del producto
	 */
	public void eliminarProductoById(Long id) {
		if(id != null && id > 0) {
			try {
				Producto producto = getProductoById(id);
				if(producto != null) {
					productos.remove(producto);
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
	
	/**
	 * Filtrar productos de la lista de la tienda
	 * @param filtro un Producto del que cogeremos los datos a filtrar
	 * @return una nueva lista con los productos filtrados
	 */
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
	
	/**
	 * Modificar un producto
	 * @param id el id del producto a modificar
	 * @param nuevo el Producto con los nuevos datos a modificar
	 */
	public void modificaProducto(Long id, Producto nuevo) {
		if((id != null && id > 0) && nuevo != null) {
			// Obtener el producto a modificar
			Producto actual = getProductoById(id);
			// Si existe ese producto a modificar le asignamos los nuevos datos
			if(actual != null) {
				if(nuevo.getNombre() != null && !nuevo.getNombre().isEmpty()) actual.setNombre(nuevo.getNombre());
				if(nuevo.getPrecio() != null) actual.setPrecio(nuevo.getPrecio());
				if(nuevo.getSeccion() != null && !nuevo.getSeccion().isEmpty()) actual.setSeccion(nuevo.getSeccion());
				if(nuevo.getStock() != null) actual.setStock(nuevo.getStock());
			}else {
				System.out.println("No existe ningun producto con el id " + id);
			}
		}
	}
	
	public List<Producto> getProductosBySeccion(String seccion) {
		return productos.parallelStream().filter(p -> p.getSeccion().equalsIgnoreCase(seccion)).toList();
	}
	
	public void setProductosFiltrados(List<Producto> productosFiltrados) {
		this.productosFiltrados = productosFiltrados;
	}
	
	public List<Producto> getProductosFiltrados() {
		return productosFiltrados;
	}

	public List<Producto> listarProductos() {
		return productos;
	}

	public void agregarNuevoProducto(Producto p) {
		productos.add(p);
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
