package com.proyectoTeatro.controller;

import java.util.HashMap;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyectoTeatro.model.Funcion;
import com.proyectoTeatro.repository.IFuncionRepository;
import com.proyectoTeatro.service.FuncionService;

@RestController
@RequestMapping("/api/funciones")
@CrossOrigin(origins = "http://localhost:4200")
public class FuncionController {

	@Autowired
	private IFuncionRepository repoFun;
	
	@Autowired
	private FuncionService service;
	
	/*@GetMapping ("/listar")
	public ResponseEntity<List<Funcion>> listarFunciones() {
		return ResponseEntity.ok(service.listarFunciones());
	}*/
	
	@PostMapping ("/agregarFuncion")
	public ResponseEntity<Funcion> agregarFuncion(
			@RequestBody Funcion funcion) {
		Funcion nuevo = service.agregarFuncion(funcion);		
		return new ResponseEntity<>(nuevo, HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Funcion> buscarFuncion(
			@PathVariable Integer id) {
		return ResponseEntity.ok(service.buscarFuncion(id));
	}
	
	@PutMapping("/actualizar/{id}")
	public ResponseEntity<Funcion> actualizarFuncion(
			@PathVariable Integer id, 
			@RequestBody Funcion funcion) {
		Funcion e = service.buscarFuncion(id);
		e.setIdfuncion(funcion.getIdfuncion());
		e.setIdevento(funcion.getIdevento());
		e.setFecha(funcion.getFecha());
		e.setHorainicio(funcion.getHorainicio());
		e.setHorafin(funcion.getHorafin());

		service.actualizarFuncion(e);

		return new ResponseEntity<>(e, HttpStatus.CREATED);
	}
	
	
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<?> eliminarFuncion(@PathVariable int id){
        String mensaje = "Funcion eliminada correctamente";
        HashMap<String, Object> salida = new HashMap<>();
        try {service.eliminar(id);
        mensaje = "Se elimino correctamente";
    } catch (Exception ex) {
        mensaje = "Error al eliminar la funcion: " + ex.getMessage();
    }
    salida.put("mensaje", mensaje);
    return ResponseEntity.ok(salida) ;
        	
	}
	
	
	
	@GetMapping("/listar")
	public List<Funcion> listarFunciones() {
		return repoFun.findAll();
	}
}
