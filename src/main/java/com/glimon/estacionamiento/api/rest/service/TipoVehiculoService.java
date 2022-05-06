package com.glimon.estacionamiento.api.rest.service;

import java.util.List;

import com.glimon.estacionamiento.api.restd.dto.TipoVehiculoRequestDTO;
import com.glimon.estacionamiento.api.restd.dto.TipoVehiculoResponseDTO;

public interface TipoVehiculoService {
	
	public List<TipoVehiculoResponseDTO> getListaTipoVehiculos() throws Exception;
	public TipoVehiculoResponseDTO getTipoVehiculoPorCveTipoVehiculo(int cveTipoVehiculo) throws Exception;
	public String creaNuevoTipoVehiculo(TipoVehiculoRequestDTO tipoVehiculoRequestDTO) throws Exception;
	public String eliminaTipoVehiculo(int cveTipoVehiculo) throws Exception;
	
}
