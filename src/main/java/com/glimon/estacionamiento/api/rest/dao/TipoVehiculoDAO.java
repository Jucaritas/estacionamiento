package com.glimon.estacionamiento.api.rest.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.glimon.estacionamiento.api.rest.model.TipoVehiculoModel;

@Repository
public interface TipoVehiculoDAO extends JpaRepository<TipoVehiculoModel, Long> {

	TipoVehiculoModel getTipoVehiculoByCveTipoVehiculo(int cveTipoVehiculo);
	
	@Query(value = "select nextval(glimon.nva_cve_tipo_persona)",nativeQuery = true)
	int getNextTipoVehiculoKey();
	
}
