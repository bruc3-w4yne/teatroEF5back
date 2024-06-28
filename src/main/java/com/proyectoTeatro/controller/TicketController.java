package com.proyectoTeatro.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.proyectoTeatro.model.Ticket;
import com.proyectoTeatro.repository.ITicketRepository;
import com.proyectoTeatro.service.TicketService;

@RestController
@RequestMapping("/api/tickets")
@CrossOrigin(origins = "http://localhost:4200")
public class TicketController {
	
	@Autowired
	private ITicketRepository repoTic;
	
	@Autowired
	private TicketService service;
	
	@GetMapping("/listar")
	public ResponseEntity<List<Ticket>> listarTickets() {
		return ResponseEntity.ok(service.listarTickets());
	}
	
	
	@PostMapping ("/agregarTicket")
	public ResponseEntity<Ticket> agregarTicket (
			@RequestBody Ticket ticket) {
		Ticket nuevo = service.agregarTicket(ticket);		
		return new ResponseEntity<>(nuevo, HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Ticket> buscarTicket(
			@PathVariable Integer id) {
		return ResponseEntity.ok(service.buscarTicket(id));
	}
	
	@PutMapping("/actualizar/{id}")
	public ResponseEntity<Ticket> actualizarTicket(
			@PathVariable Integer id, 
			@RequestBody Ticket ticket) {
		Ticket t = service.buscarTicket(id);
		t.setIdticket(ticket.getIdticket());
		t.setIdarea(ticket.getIdarea());
		t.setIdcli(ticket.getIdcli());
		t.setUnidades(ticket.getUnidades());
		t.setTotal(ticket.getTotal());
		

		service.actualizarTicket(t);

		return new ResponseEntity<>(t, HttpStatus.CREATED);
	}
	
	
	@DeleteMapping("/eliminar/{id}")
	public String eliminarFuncion(@PathVariable Integer id){
		repoTic.deleteById(id);
		return "Ticket eliminado";
	}

}
