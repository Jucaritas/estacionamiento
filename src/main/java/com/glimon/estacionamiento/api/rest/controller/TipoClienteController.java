package com.glimon.estacionamiento.api.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.glimon.estacionamiento.api.rest.commons.MensajeResp;
import com.glimon.estacionamiento.api.rest.service.TipoClienteService;
import com.glimon.estacionamiento.api.restd.dto.TipoClienteRequestDTO;
import com.glimon.estacionamiento.api.restd.dto.TipoClienteResponseDTO;

@RestController
@RequestMapping("/tipo_cliente")
public class TipoClienteController {

	@Autowired
	private TipoClienteService tipoClienteService;
	
	@GetMapping("/lista")
	public @ResponseBody List<TipoClienteResponseDTO> listaTipoClientes() throws Exception{
		return tipoClienteService.listaTipoClientes();
	}
	
	@GetMapping("/{cvePlaca}")
	public @ResponseBody TipoClienteResponseDTO getTipoClientePorCvePlaca(@PathVariable String cvePlaca) throws Exception{
		try {
			return tipoClienteService.getTipoClientePorClave(cvePlaca);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
	}
	
	@PostMapping("/nuevo")
	public @ResponseBody MensajeResp nuevoTipoCliente(@RequestBody TipoClienteRequestDTO tipoClienteRequestDTO) throws Exception{
		try {
			return new MensajeResp(tipoClienteService.nuevoTipoCliente(tipoClienteRequestDTO));
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}	
	}
}
