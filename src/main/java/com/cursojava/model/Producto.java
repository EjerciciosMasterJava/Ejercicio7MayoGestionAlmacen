package com.cursojava.model;

import com.cursojava.service.TiendaService;

public class Producto {

	private Long id;
	private String nombre;
	private String seccion;
	private Double precio;
	private Integer stock;
	
	/**
	 * Constructor por defecto
	 */
	public Producto() {
		super();
	}
	
	/**
	 * Constructor de producto con todos los parametros
	 * @param id el id del producto
	 * @param nombre el nombre del producto
	 * @param seccion la seccion a la que pertenece el producto
	 * @param precio el precio del producto
	 * @param stock la cantidad de stock
	 */
	public Producto(Long id, String nombre, String seccion, Double precio, Integer stock) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.seccion = seccion;
		this.precio = precio;
		this.stock = stock;
	}
	
	/**
	 * Constructor de producto con todos los parametros menos el id
	 * @param nombre el nombre del producto
	 * @param seccion la seccion a la que pertenece el producto
	 * @param precio el precio del producto
	 * @param stock la cantidad de stock
	 */
	public Producto(String nombre, String seccion, Double precio, Integer stock) {
		super();
		this.id = TiendaService.getTiendaRepositorio().getNextId();
		this.nombre = nombre;
		this.seccion = seccion;
		this.precio = precio;
		this.stock = stock;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getSeccion() {
		return seccion;
	}
	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Producto [nombre=");
		builder.append(nombre);
		builder.append(", seccion=");
		builder.append(seccion);
		builder.append(", precio=");
		builder.append(precio);
		builder.append(", stock=");
		builder.append(stock);
		builder.append("]");
		return builder.toString();
	}
	
}
