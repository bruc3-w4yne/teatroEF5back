package com.proyectoTeatro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectoTeatro.model.Evento;
import com.proyectoTeatro.repository.IEventoRepository;

@Service
public class EventoServiceImpl implements EventoService {

	@Autowired
	private IEventoRepository repoEven;
	
	@Override
	public List<Evento> listarEventos() {
		return repoEven.findAll();
	}

	@Override
	public Evento agregarEventos(Evento e) {
		return repoEven.save(e);
	}

	@Override
	public Evento buscarEventos(Integer id) {
		return repoEven.findById(id).get();
	}

	@Override
	public Evento actualizarEventos(Evento e) {
		return repoEven.save(e);
	}

}
