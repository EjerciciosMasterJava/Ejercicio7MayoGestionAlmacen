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
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarProductos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		tienda.setProductosFiltrados(new ArrayList<>());
		RequestDispatcher rd = request.getRequestDispatcher("listado.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
