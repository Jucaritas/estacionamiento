package com.glimon.estacionamiento.api.rest.service;

public interface RegistroVisitasService {

	public String registraIngresoPorPlaca(String cvePlaca) throws Exception;
	public String registraSalidaPorPlaca(String cvePlaca) throws Exception;
	public void GenerarReporte() throws Exception;
	
}
