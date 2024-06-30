package com.proyectoTeatro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyectoTeatro.model.Funcion;

@Repository
public interface IFuncionRepository extends JpaRepository<Funcion, Integer>{
	List<Funcion> findByIdevento(int idevento);

}
