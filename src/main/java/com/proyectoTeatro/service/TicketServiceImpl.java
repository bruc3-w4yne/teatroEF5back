package com.proyectoTeatro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectoTeatro.model.Ticket;
import com.proyectoTeatro.repository.ITicketRepository;

@Service
public class TicketServiceImpl implements TicketService {

	@Autowired
	private ITicketRepository service;
	
	@Override
	public List<Ticket> listarTickets() {
		return service.findAll();
	}

	@Override
	public Ticket agregarTicket(Ticket t) {
		return service.save(t);
	}

	@Override
	public Ticket buscarTicket(Integer id) {
		return service.findById(id).get();
	}

	@Override
	public Ticket actualizarTicket(Ticket t) {
		return service.save(t);
	}

}
