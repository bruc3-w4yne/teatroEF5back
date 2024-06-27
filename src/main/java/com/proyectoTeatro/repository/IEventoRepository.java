package com.proyectoTeatro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyectoTeatro.model.Evento;

@Repository
public interface IEventoRepository extends JpaRepository<Evento, Integer>{

}
