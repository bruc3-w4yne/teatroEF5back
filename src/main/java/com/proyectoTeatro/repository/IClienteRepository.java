package com.proyectoTeatro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyectoTeatro.model.Cliente;

@Repository
public interface IClienteRepository extends JpaRepository<Cliente, Integer>{

	Cliente findByUsernameAndClave(String username, String clave);
}
