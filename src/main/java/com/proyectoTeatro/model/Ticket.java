package com.proyectoTeatro.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

@Entity
@Table (name = "tb_ticket")
@Data
public class Ticket {

	@Id
	private int idticket;
	private int idfuncion;
	private int idarea;
	private int idcli;
	
	@PositiveOrZero(message = "El precio debse ser mayor o igual a cero")
	private int unidades;
	
	private double total;
	
	@ManyToOne
	@JoinColumn(name="idfuncion", insertable = false, updatable = false)
	private Funcion objFuncion;
	
	@ManyToOne
	@JoinColumn(name="idarea", insertable = false, updatable = false)
	private Area objArea;
	
	
	@ManyToOne
	@JoinColumn(name="idcli", insertable = false, updatable = false)
	private Cliente objCli;
}
