package com.glimon.estacionamiento.api.rest.service;

import java.util.List;

import com.glimon.estacionamiento.api.restd.dto.TipoClienteRequestDTO;
import com.glimon.estacionamiento.api.restd.dto.TipoClienteResponseDTO;

public interface TipoClienteService {

	public List<TipoClienteResponseDTO> listaTipoClientes() throws Exception;
	public TipoClienteResponseDTO getTipoClientePorClave(String cvePlaca) throws Exception;
	public String nuevoTipoCliente(TipoClienteRequestDTO tipoClienteRequestDTO) throws Exception;
	
}
