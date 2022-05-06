package com.glimon.estacionamiento.api.rest.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipo_vehiculo")
public class TipoVehiculoModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_vehiculo")
	private Long idTipoVehiculo;
	
    @Column(name = "cve_tipo_vehiculo")
    private int cveTipoVehiculo;
    
    @Column(name = "desc_tipo_vehiculo")
    private String descTipoVehiculo;
    
    @Column(name = "fecha_registro")
    private Date fechaRegistro;
    
    @Column(name = "estatus")
    private int estatus;

	public Long getIdTipoVehiculo() {
		return idTipoVehiculo;
	}

	public void setIdTipoVehiculo(Long idTipoVehiculo) {
		this.idTipoVehiculo = idTipoVehiculo;
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

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public int getEstatus() {
		return estatus;
	}

	public void setEstatus(int estatus) {
		this.estatus = estatus;
	}
    
}
