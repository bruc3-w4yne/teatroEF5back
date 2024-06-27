package com.proyectoTeatro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.proyectoTeatro.model.Cliente;
import com.proyectoTeatro.service.ClienteService;

@RestController
@RequestMapping("/api/clientes")
@CrossOrigin(origins = "http://localhost:4200")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping("/listar")
	public List<Cliente> listarClientes() {
		return clienteService.listarClientes();
	}
	
	@GetMapping
	public ResponseEntity<Cliente> registrarCliente(@RequestBody Cliente cliente) {
		Cliente nuevoCliente = clienteService.registrarCliente(cliente);
		return new ResponseEntity<>(nuevoCliente, HttpStatus.CREATED);
	}

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestParam String username,
			@RequestParam String clave) {
		Cliente cliente = clienteService.login(username, clave);
		if (cliente != null) {
			return ResponseEntity.ok(cliente);
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).
					body("Correo o clave incorrectos");
		}
	}
}
