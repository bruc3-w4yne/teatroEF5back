package com.proyectoTeatro.service;

import java.util.List;

import com.proyectoTeatro.model.Evento;

public interface EventoService {

	public List<Evento> listarEventos();
	
	public Evento agregarEventos(Evento e);
	
	public Evento buscarEventos(Integer id);
	
	public Evento actualizarEventos(Evento e);
	
	public void eliminarEventos(Integer id);
}
