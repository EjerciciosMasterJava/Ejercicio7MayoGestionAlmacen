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
 * Servlet implementation class FiltrarProductos
 */
public class FiltrarProductos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private TiendaRepositorio tienda = TiendaService.getTiendaRepositorio();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FiltrarProductos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("listado.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String filtroNombre = request.getParameter("filtroNombre");
		String filtroSeccion = request.getParameter("filtroSeccion");
		
		System.out.println(tienda.getProductos().size());
		
		System.out.println("nombre = " + filtroNombre + "seccion " + filtroSeccion);
		
		List<Producto> productosFiltrados = tienda.filtrarProductos(new Producto(filtroNombre,filtroSeccion, null, null));
		System.out.println("size lista filtrados " + productosFiltrados.size());
		System.out.println("Lista de productos filtrados = " + productosFiltrados);
		
		request.setAttribute("productosFiltrados", productosFiltrados);
		
		doGet(request, response);
	}

}
