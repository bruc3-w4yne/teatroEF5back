package com.proyectoTeatro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyectoTeatro.model.Ticket;
import com.proyectoTeatro.service.TicketService;

@RestController
@RequestMapping("/api/tickets")
@CrossOrigin(origins = "http://localhost:4200")
public class TicketController {
	
	@Autowired
	private TicketService service;
	
	@GetMapping("/listar")
	public ResponseEntity<List<Ticket>> listarTickets() {
		return ResponseEntity.ok(service.listarTickets());
	}
	
	
	

}
