package com.cursojava.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import com.cursojava.repositorio.TiendaRepositorio;
import com.cursojava.service.TiendaService;

/**
 * Servlet implementation class ListarProductos
 */
public class ListarProductos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private TiendaRepositorio tienda = TiendaService.getTiendaRepositorio();
       
    public ListarProductos() {
        super();
    }

	/**
	 * Listar todos los productos llamando a listado.jsp
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		tienda.setProductosFiltrados(new ArrayList<>());
		RequestDispatcher rd = request.getRequestDispatcher("listado.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
