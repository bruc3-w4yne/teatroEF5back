package com.proyectoTeatro.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="tb_evento")
@Data
public class Evento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idevento;
	private String nomevento;
	private String desevento;
	private int idcat;
	
	@ManyToOne
	@JoinColumn(name="idcat", insertable = false, updatable = false)
	private Categoria objCategoria;
}
