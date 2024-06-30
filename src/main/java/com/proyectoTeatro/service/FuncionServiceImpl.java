package com.proyectoTeatro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.proyectoTeatro.model.Funcion;
import com.proyectoTeatro.repository.IFuncionRepository;

@Service

public class FuncionServiceImpl implements FuncionService {

	
	@Autowired
	private IFuncionRepository repoFun;
	
	@Override
	public List<Funcion> listarFunciones() {
		return repoFun.findAll();
	}
	

	@Override
	public Funcion agregarFuncion(Funcion f) {
		return repoFun.save(f);
	}

	@Override
	public Funcion buscarFuncion(Integer id) {
		return repoFun.findById(id).get();
	}

	@Override
	public Funcion actualizarFuncion(Funcion f) {
		
		return repoFun.save(f);
	}


	@Override
	public void eliminar(int id) {
		repoFun.deleteById(id);		
	}


	@Override
	public List<Funcion> listarFuncionporEvento(int id) {
		return repoFun.findByIdevento(id);
	}

	

}
