package com.glimon.estacionamiento.api.restd.dto;

public class TipoClienteRequestDTO {

	private String cvePlaca;
	private int tipoVehiculo;
	
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
	
}
