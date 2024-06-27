package com.proyectoTeatro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyectoTeatro.model.Area;
import com.proyectoTeatro.repository.IAreaRepository;

@RestController
@RequestMapping("/api/areas")
@CrossOrigin(origins = "http://localhost:4200")
public class AreaController {
	
	@Autowired
	private IAreaRepository repoArea;
	
	@GetMapping
	public List<Area> listarAreas() {
		return repoArea.findAll();
	}

}
