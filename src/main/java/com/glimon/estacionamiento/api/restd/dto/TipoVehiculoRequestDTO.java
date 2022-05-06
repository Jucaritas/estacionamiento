package com.glimon.estacionamiento.api.restd.dto;

import java.io.Serializable;

public class TipoVehiculoRequestDTO implements Serializable{
	

    /**
	 * 
	 */
	private static final long serialVersionUID = -3594073930932206320L;
	private String descTipoVehiculo;
    

	public String getDescTipoVehiculo() {
		return descTipoVehiculo;
	}

	public void setDescTipoVehiculo(String descTipoVehiculo) {
		this.descTipoVehiculo = descTipoVehiculo;
	}
    
}
