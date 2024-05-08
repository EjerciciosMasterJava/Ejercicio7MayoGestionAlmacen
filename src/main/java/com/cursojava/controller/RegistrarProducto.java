package com.cursojava.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.cursojava.model.Producto;
import com.cursojava.service.TiendaService;

/**
 * Servlet implementation class RegistrarProducto
 */
public class RegistrarProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private TiendaService tiendaService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrarProducto() {
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
		String ret = "";
		Producto producto = null;
		try {
			tiendaService = new TiendaService();
			String nombre = request.getParameter("nombre");
			String seccion = request.getParameter("seccion");
			Double precio = Double.parseDouble(request.getParameter("precio"));
			Integer stock = Integer.parseInt(request.getParameter("stock"));
			producto = new Producto(nombre, seccion, precio, stock);
			
			tiendaService.agregarProducto(producto);
			
			ret = "Producto registrado correctamente.";
		} catch (Exception e) {
			ret = "Error al registrar el producto.";
		}
		request.setAttribute("producto", producto);
		System.out.println(ret + producto);
		request.setAttribute("ret", ret);
		doGet(request, response);
	}

}
