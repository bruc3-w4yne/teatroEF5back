package com.proyectoTeatro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectoTeatro.model.Ticket;
import com.proyectoTeatro.repository.ITicketRepository;

@Service
public class TicketServiceImpl implements TicketService {

	@Autowired
<<<<<<< HEAD
	private ITicketRepository repoTic;
	
	@Override
	public List<Ticket> listarTickets() {
		return repoTic.findAll();
=======
	private ITicketRepository service;
	
	@Override
	public List<Ticket> listarTickets() {
		return service.findAll();
>>>>>>> 3054d9b4d85409ca6b6d06d429e14d884c3cfdca
	}

	@Override
	public Ticket agregarTicket(Ticket t) {
<<<<<<< HEAD
		return repoTic.save(t);
=======
		return service.save(t);
>>>>>>> 3054d9b4d85409ca6b6d06d429e14d884c3cfdca
	}

	@Override
	public Ticket buscarTicket(Integer id) {
<<<<<<< HEAD
		return repoTic.findById(id).get();
=======
		return service.findById(id).get();
>>>>>>> 3054d9b4d85409ca6b6d06d429e14d884c3cfdca
	}

	@Override
	public Ticket actualizarTicket(Ticket t) {
<<<<<<< HEAD
		return repoTic.save(t);
=======
		return service.save(t);
>>>>>>> 3054d9b4d85409ca6b6d06d429e14d884c3cfdca
	}

}
