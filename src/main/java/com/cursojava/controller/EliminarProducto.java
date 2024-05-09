package com.cursojava.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.cursojava.repositorio.TiendaRepositorio;
import com.cursojava.service.TiendaService;

/**
 * Servlet implementation class EliminarProducto
 */
public class EliminarProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private TiendaRepositorio tienda = TiendaService.getTiendaRepositorio();

	public EliminarProducto() {
		super();
	}

	/**
	 * Forward para volver al listado luego de eliminar el producto
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("listado.jsp");
		rd.forward(request, response);
	}

	/**
	 * Post para eliminar un producto por su id, cogemos el id de los parametros de la request,
	 * llamamos a eliminarProductoById
	 * 
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Long id = Long.parseLong(request.getParameter("idProducto"));
			if(id != null && id > 0) {
				tienda.eliminarProductoById(id);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		doGet(request, response);
	}

}
