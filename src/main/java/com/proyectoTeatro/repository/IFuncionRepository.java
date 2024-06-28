package com.proyectoTeatro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyectoTeatro.model.Funcion;

@Repository
public interface IFuncionRepository extends JpaRepository<Funcion, Integer>{

}
