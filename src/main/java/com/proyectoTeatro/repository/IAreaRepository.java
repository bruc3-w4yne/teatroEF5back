package com.proyectoTeatro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyectoTeatro.model.Area;

@Repository
public interface IAreaRepository extends JpaRepository<Area, Integer>{

}
