package com.glimon.estacionamiento.api.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.glimon.estacionamiento.api.rest.commons.MensajeResp;
import com.glimon.estacionamiento.api.rest.service.RegistroVisitasService;

@RestController
@RequestMapping("/registro-visita")
public class RegistroVisitasController {

	@Autowired
	private RegistroVisitasService registroVisitasService;
	
	@GetMapping("/entrada/{cvePlaca}")
	public @ResponseBody MensajeResp registraEntredaVehiculo(@PathVariable String cvePlaca) throws Exception{
		try {
			return new MensajeResp(registroVisitasService.registraIngresoPorPlaca(cvePlaca));
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}
	
	@PatchMapping("/salida/{cvePlaca}")
	public @ResponseBody MensajeResp registraSalidaVehiculo(@PathVariable String cvePlaca) throws Exception{
		try {
			return new MensajeResp(registroVisitasService.registraSalidaPorPlaca(cvePlaca));
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}
	
	@GetMapping("/reporte")
	public @ResponseBody MensajeResp getReporte() throws Exception{
		registroVisitasService.GenerarReporte();
		return new MensajeResp("-----------");
	}
	
}
