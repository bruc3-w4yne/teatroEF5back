package com.proyectoTeatro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectoTeatro.model.Cliente;
import com.proyectoTeatro.repository.IClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private IClienteRepository repoCli;
	
	public List<Cliente> listarClientes() {
		return repoCli.findAll();
	}
	
	public Cliente registrarCliente(Cliente cliente) {
		return repoCli.save(cliente);
	}
	
	public Cliente login(String username, String clave) {
		return repoCli.findByUsernameAndClave(username, clave);
	}	
	public Cliente actualizarCliente(Cliente cliente) {
		return repoCli.save(cliente);
	}
	
	public Cliente buscarCliente(Integer id) {
		return repoCli.findById(id).get();
	}

}
