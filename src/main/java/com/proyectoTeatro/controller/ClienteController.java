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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.proyectoTeatro.model.Cliente;
import com.proyectoTeatro.repository.IClienteRepository;
import com.proyectoTeatro.service.ClienteService;

@RestController
@RequestMapping("/api/clientes")
@CrossOrigin(origins = "http://localhost:4200")
public class ClienteController {
	
	@Autowired	
	private IClienteRepository repoCli;
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping("/listar")
	public List<Cliente> listarClientes() {
		return clienteService.listarClientes();
	}
	
	@PostMapping("/registrar")
	public ResponseEntity<Cliente> registrarCliente(@RequestBody Cliente cliente) {
		Cliente nuevoCliente = clienteService.registrarCliente(cliente);
		return new ResponseEntity<>(nuevoCliente, HttpStatus.CREATED);
	}
	
	
	
	@PutMapping("/actualizar/{id}")
	public ResponseEntity<Cliente> actualizarCliente(
			@PathVariable Integer id, 
			@RequestBody Cliente cliente) {
		Cliente c = clienteService.buscarCliente(id);
		c.setIdcli(cliente.getIdcli());
		c.setNomcli(cliente.getNomcli());
		c.setApecli(cliente.getApecli());
		c.setDni(cliente.getDni());
		c.setUsername(cliente.getUsername());
		c.setClave(cliente.getClave());

		clienteService.actualizarCliente(c);

		return new ResponseEntity<>(c, HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> buscarCliente(
			@PathVariable Integer id) {
		return ResponseEntity.ok(clienteService.buscarCliente(id));
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
	
	@DeleteMapping("/eliminar/{id}")
	public String eliminarFuncion(@PathVariable Integer id){
		repoCli.deleteById(id);
		return "Cliente eliminado";
	}
	
}
