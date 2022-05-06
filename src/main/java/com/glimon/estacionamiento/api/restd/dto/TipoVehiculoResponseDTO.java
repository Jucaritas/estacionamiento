package com.glimon.estacionamiento.api.restd.dto;

import java.io.Serializable;

public class TipoVehiculoResponseDTO implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -6432519346829674312L;
	
	private int cveTipoVehiculo;
    private String descTipoVehiculo;
    private int tarifa;
    private int estatus;
    
    public TipoVehiculoResponseDTO(int cveTipoVehiculo, String descTipoVehiculo, int tarifa, int estatus) {
		super();
		this.cveTipoVehiculo = cveTipoVehiculo;
		this.descTipoVehiculo = descTipoVehiculo;
		this.tarifa = tarifa;
		this.estatus = estatus;
	}

	public int getTarifa() {
		return tarifa;
	}

	public void setTarifa(int tarifa) {
		this.tarifa = tarifa;
	}
	
	public int getCveTipoVehiculo() {
		return cveTipoVehiculo;
	}
	public void setCveTipoVehiculo(int cveTipoVehiculo) {
		this.cveTipoVehiculo = cveTipoVehiculo;
	}
	public String getDescTipoVehiculo() {
		return descTipoVehiculo;
	}
	public void setDescTipoVehiculo(String descTipoVehiculo) {
		this.descTipoVehiculo = descTipoVehiculo;
	}
	public int getEstatus() {
		return estatus;
	}
	public void setEstatus(int estatus) {
		this.estatus = estatus;
	}
    
}
