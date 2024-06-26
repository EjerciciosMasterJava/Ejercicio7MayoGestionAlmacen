package com.cursojava.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.cursojava.model.Producto;
import com.cursojava.repositorio.TiendaRepositorio;
import com.cursojava.service.TiendaService;

/**
 * Servlet implementation class RegistrarProducto
 */
public class RegistrarProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private TiendaRepositorio tienda = TiendaService.getTiendaRepositorio();

    public RegistrarProducto() {
        super();
    }

	/**
	 * Forward al mismo formulario por si queremos dar de alta un producto nuevo.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("alta.jsp");
		rd.forward(request, response);
	}

	/**
	 * Metodo para registrar un producto, si el id es null lo damos de alta, pero si hemos hecho click en editar un producto
	 * el id no será null entonces actualizamos sus datos en lugar de dar uno nuevo de alta.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("section = " + request.getParameter("seccion"));
		String ret = "";
		Producto producto = null;
		try {
			Long id = null;
			String nombre = request.getParameter("nombre");
			String seccion = request.getParameter("seccion");
			Double precio = Double.parseDouble(request.getParameter("precio"));
			Integer stock = Integer.parseInt(request.getParameter("stock"));
			
			// Intentar parsear el id cogiendolo de la request, si estamos modificando el id no sera null
			try {
				id = Long.parseLong(request.getParameter("id"));
				System.out.println("Modificando producto con id " + id);
			}catch(Exception e) {}
			
			// Crear nuevo producto con los datos de la request
			producto = new Producto(nombre, seccion, precio, stock);
			
			// Si el id es null agregamos un producto nuevo
			if(id == null) {
				System.out.println("id producto = " + id);
				tienda.agregarNuevoProducto(producto);
				ret = "Producto registrado correctamente.";
				
				// Si no es null lo modificamos
			}else {
				System.out.println("entrando en actualizar producto");
				tienda.modificaProducto(id, producto);
				ret = "Producto actualizado correctamente.";
			}
			
		} catch (Exception e) {
			ret = "Error al registrar el producto.";
		}

		System.out.println(ret + producto);
		request.setAttribute("ret", ret);
		doGet(request, response);
	}

}
