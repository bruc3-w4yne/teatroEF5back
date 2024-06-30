package com.proyectoTeatro.service;

import java.util.List;

import com.proyectoTeatro.model.Funcion;

public interface FuncionService {

	public List<Funcion> listarFunciones();
	
	public Funcion agregarFuncion(Funcion f);
	
	public Funcion buscarFuncion(Integer id);
	
	public Funcion actualizarFuncion(Funcion f);
	
    void eliminar(int id);
	
}
