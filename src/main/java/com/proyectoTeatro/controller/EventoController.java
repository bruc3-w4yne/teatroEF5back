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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.proyectoTeatro.model.Evento;
import com.proyectoTeatro.repository.IEventoRepository;
import com.proyectoTeatro.service.EventoService;

@RestController
@RequestMapping("/api/eventos")
@CrossOrigin(origins = "http://localhost:4200")
public class EventoController {
	
	@Autowired
	private IEventoRepository repoEven;
	
	@Autowired
	private EventoService service;
	
	@GetMapping ("/listar")
	public ResponseEntity<List<Evento>> listarEventos() {
		return ResponseEntity.ok(service.listarEventos());
	}
	
	@PostMapping ("/agregarEventos")
	public ResponseEntity<Evento> agregarEventos(
			@RequestBody Evento evento) {
		Evento nuevo = service.agregarEventos(evento);		
		return new ResponseEntity<>(nuevo, HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Evento> buscarEventos(
			@PathVariable Integer id) {
		return ResponseEntity.ok(service.buscarEventos(id));
	}
	
	@PutMapping("/actualizar/{id}")
	public ResponseEntity<Evento> actualizarEventos(
			@PathVariable Integer id, 
			@RequestBody Evento evento) {
		Evento e = service.buscarEventos(id);
		e.setIdevento(evento.getIdevento());
		e.setNomevento(evento.getNomevento());
		e.setDesevento(evento.getDesevento());
		e.setIdcat(evento.getIdcat());

		service.actualizarEventos(e);

		return new ResponseEntity<>(e, HttpStatus.CREATED);
	}
	
	
	@DeleteMapping("/eliminar/{id}")
    @ResponseBody
    public ResponseEntity<?> eliminarFuncion(@PathVariable int id) {
        String mensaje = "Evento eliminada correctamente";
        HashMap<String, Object> salida = new HashMap<>();
        try {
            service.eliminarEventos(id);
            mensaje = "Se elimino correctamente";
        } catch (Exception ex) {
            mensaje = "Error al eliminar la funcion: " + ex.getMessage();
        }
        salida.put("mensaje", mensaje);
        return ResponseEntity.ok(salida) ;
    }
	
}
