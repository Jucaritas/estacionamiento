package com.glimon.estacionamiento.api.restd.dto;

import java.io.Serializable;
import java.util.Date;

public class TipoClienteResponseDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4961277078983258918L;
	
	private String cvePlaca;
	private int tipoVehiculo;
	private Date fechaRegistro;
	
	
	public TipoClienteResponseDTO(String cvePlaca, int tipoVehiculo, Date fechaRegistro) {
		super();
		this.cvePlaca = cvePlaca;
		this.tipoVehiculo = tipoVehiculo;
		this.fechaRegistro = fechaRegistro;
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
