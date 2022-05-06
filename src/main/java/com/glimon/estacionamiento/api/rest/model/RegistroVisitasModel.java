package com.glimon.estacionamiento.api.rest.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "registro_visitas")
public class RegistroVisitasModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="id_visita")
	private Long idVisita;
	
	@Column(name ="cve_placa")
	private String cvePlaca;
	
	@Column(name ="fecha_ingreso")
	private Date fechaIngreso;
	
	@Column(name ="fecha_salida")
	private Date fechaSalida;
	
	@Column(name ="costo_visita")
	private Long costoVisita;
	
	@Column(name = "minutos")
	private Long minutos;
	
	@Column(name = "tarifa")
	private int tarifa;
	
	@Column(name ="estatus")
	private int estatus;

	public Long getIdVisita() {
		return idVisita;
	}

	public void setIdVisita(Long idVisita) {
		this.idVisita = idVisita;
	}

	public String getCvePlaca() {
		return cvePlaca;
	}

	public void setCvePlaca(String cvePlaca) {
		this.cvePlaca = cvePlaca;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Date getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public Long getCostoVisita() {
		return costoVisita;
	}

	public void setCostoVisita(Long costoVisita) {
		this.costoVisita = costoVisita;
	}

	public Long getMinutos() {
		return minutos;
	}

	public void setMinutos(Long minutos) {
		this.minutos = minutos;
	}

	public int getTarifa() {
		return tarifa;
	}

	public void setTarifa(int tarifa) {
		this.tarifa = tarifa;
	}

	public int getEstatus() {
		return estatus;
	}

	public void setEstatus(int estatus) {
		this.estatus = estatus;
	}
	
}
