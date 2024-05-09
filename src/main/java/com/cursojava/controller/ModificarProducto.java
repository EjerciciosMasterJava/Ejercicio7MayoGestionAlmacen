package com.cursojava.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.cursojava.model.Producto;
import com.cursojava.service.TiendaService;
import com.cursojava.repositorio.*;

/**
 * Servlet implementation class ModificarProducto
 */
public class ModificarProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private TiendaRepositorio tienda = TiendaService.getTiendaRepositorio();
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificarProducto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("alta.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Entrando ModificarProducto POST");
		Long idProducto = Long.parseLong(request.getParameter("idProducto"));
		System.out.println("ModificarProducto POST - idProducto = " + idProducto);
		Producto producto = tienda.getProductoById(idProducto);
		request.setAttribute("producto", producto);
		request.setAttribute("edit", "Editar producto" + producto.getNombre());
		doGet(request, response);
	}

}
