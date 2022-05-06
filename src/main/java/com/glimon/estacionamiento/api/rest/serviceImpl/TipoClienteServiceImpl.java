package com.glimon.estacionamiento.api.rest.serviceImpl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.glimon.estacionamiento.api.rest.dao.TipoClienteDAO;
import com.glimon.estacionamiento.api.rest.model.TipoClienteModel;
import com.glimon.estacionamiento.api.rest.service.TipoClienteService;
import com.glimon.estacionamiento.api.restd.dto.TipoClienteRequestDTO;
import com.glimon.estacionamiento.api.restd.dto.TipoClienteResponseDTO;

@Service
public class TipoClienteServiceImpl implements TipoClienteService{

	@Autowired
	private TipoClienteDAO tipoClienteDAO;
	
	@Override
	public List<TipoClienteResponseDTO> listaTipoClientes() throws Exception {
		List<TipoClienteModel> lstTipoClientes = tipoClienteDAO.findAll();
		
		List<TipoClienteResponseDTO> listaTipoClientes = lstTipoClientes.stream().map(tipoCliente -> {
			return new TipoClienteResponseDTO(
					tipoCliente.getCvePlaca(),
					tipoCliente.getTipoVehiculo(),
					tipoCliente.getFechaRegistro());
		}).collect(Collectors.toList());
		
		return listaTipoClientes;
	}

	@Override
	public TipoClienteResponseDTO getTipoClientePorClave(String cvePlaca) throws Exception {
		TipoClienteModel tipoCliente = tipoClienteDAO.getTipoClienteByCvePlaca(cvePlaca);
		
		if(tipoCliente == null) {
			throw new Exception("La cliente con clave "+cvePlaca+" no existe ");
		}
		
		TipoClienteResponseDTO tipoClientePorClavePlaca = new TipoClienteResponseDTO(
				tipoCliente.getCvePlaca(),
				tipoCliente.getTipoVehiculo(),
				tipoCliente.getFechaRegistro());
		
		return tipoClientePorClavePlaca;
	}

	@Override
	public String nuevoTipoCliente(TipoClienteRequestDTO tipoClienteRequestDTO) throws Exception {
		TipoClienteModel nvoTipoCliente = new TipoClienteModel();
		TipoClienteModel actTipoCliente = tipoClienteDAO.getTipoClienteByCvePlaca(tipoClienteRequestDTO.getCvePlaca());
		
		if(actTipoCliente != null) {
			throw new Exception("La cliente con clave "+tipoClienteRequestDTO.getCvePlaca()+" ya se ha registrado");
		}
		
		nvoTipoCliente.setCvePlaca(tipoClienteRequestDTO.getCvePlaca());
		nvoTipoCliente.setTipoVehiculo(tipoClienteRequestDTO.getTipoVehiculo());
		nvoTipoCliente.setFechaRegistro(new Date());
		
		tipoClienteDAO.save(nvoTipoCliente);
		
		return "Se ha regitrado el cliente";
		
	}

}
