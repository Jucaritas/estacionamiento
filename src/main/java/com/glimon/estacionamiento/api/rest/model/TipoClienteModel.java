package com.glimon.estacionamiento.api.rest.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipo_cliente")
public class TipoClienteModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_tipo_cliente")
	private Long idTipoCliente;
	
	@Column(name = "cve_placa")
	private String cvePlaca;
	
	@Column(name = "tipo_vehiculo")
	private int tipoVehiculo;
	
	@Column(name = "fecha_registro")
	private Date fechaRegistro;

	public Long getIdTipoCliente() {
		return idTipoCliente;
	}

	public void setIdTipoCliente(Long idTipoCliente) {
		this.idTipoCliente = idTipoCliente;
	}

	public String getCvePlaca() {
		return cvePlaca;
	}

	public void setCvePlaca(String cvePlaca) {
		this.cvePlaca = cvePlaca;
	}

	public int getTipoVehiculo() {
		return tipoVehiculo;
	}

	public void setTipoVehiculo(int tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	
}
