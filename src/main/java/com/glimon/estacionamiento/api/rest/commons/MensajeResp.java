package com.glimon.estacionamiento.api.rest.commons;

public class MensajeResp {

	private String mensaje;

	public MensajeResp(String mensaje) {
		super();
		this.mensaje = mensaje;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
}
