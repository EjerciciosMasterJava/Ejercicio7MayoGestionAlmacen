package com.cursojava.service;

import com.cursojava.repositorio.TiendaRepositorio;

public class TiendaService {

	public static TiendaRepositorio tienda = null;

	public static TiendaRepositorio getTiendaRepositorio() {
		if(tienda == null) {
			tienda = new TiendaRepositorio();
		}
		return tienda;
	}

}
