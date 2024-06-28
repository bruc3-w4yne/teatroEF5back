package com.proyectoTeatro.service;

import java.util.List;

import com.proyectoTeatro.model.Ticket;

public interface TicketService {

	public List<Ticket> listarTickets();
	public Ticket agregarTicket(Ticket t);
	public Ticket buscarTicket(Integer id);
	public Ticket actualizarTicket(Ticket t);
}
