package com.glimon.estacionamiento.api.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.glimon.estacionamiento.api.rest.commons.MensajeResp;
import com.glimon.estacionamiento.api.rest.service.TipoVehiculoService;
import com.glimon.estacionamiento.api.restd.dto.TipoVehiculoRequestDTO;
import com.glimon.estacionamiento.api.restd.dto.TipoVehiculoResponseDTO;

@RestController
@RequestMapping("/tipo_vehiculo")
public class TipoVehiculoController {

	@Autowired
	private TipoVehiculoService tipoVehiculoService;
	
	@GetMapping("/lista")
	public @ResponseBody List<TipoVehiculoResponseDTO> getListaTipoVehiculos() throws Exception{
		
		return tipoVehiculoService.getListaTipoVehiculos();
		
	}
	
	@GetMapping("/porClave/{cveTipoVehiculo}")
	public @ResponseBody TipoVehiculoResponseDTO getTipoVehiculoPorClave(@PathVariable int cveTipoVeihiculo) throws Exception{
		try {
			return tipoVehiculoService.getTipoVehiculoPorCveTipoVehiculo(cveTipoVeihiculo);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
	}
	
	@PostMapping("/nuevo")
	public @ResponseBody MensajeResp nuevoTipoDeVehiculo(@RequestBody TipoVehiculoRequestDTO tipoVehiculoRequestDTO) throws Exception{
		try {
			return new MensajeResp(tipoVehiculoService.creaNuevoTipoVehiculo(tipoVehiculoRequestDTO));
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}
	
	@DeleteMapping("/elimina/{cveTipoVehiculo}")
	public @ResponseBody MensajeResp eliminaTipoVehiculo(@PathVariable int cveTipoVehiculo) throws Exception{
		try {
			return new MensajeResp(tipoVehiculoService.eliminaTipoVehiculo(cveTipoVehiculo));
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
	}
	
}
