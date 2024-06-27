package com.proyectoTeatro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyectoTeatro.model.Ticket;

@Repository
public interface ITicketRepository extends JpaRepository<Ticket, Integer>{

}
