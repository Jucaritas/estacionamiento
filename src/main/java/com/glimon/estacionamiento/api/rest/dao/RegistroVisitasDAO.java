package com.glimon.estacionamiento.api.rest.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.glimon.estacionamiento.api.rest.model.RegistroVisitasModel;

@Repository
public interface RegistroVisitasDAO extends JpaRepository<RegistroVisitasModel, Long> {

	RegistroVisitasModel getRegistroVisitasByCvePlaca(String cvePlaca);
	
	@Query(value = "select v from RegistroVisitasModel v where v.estatus!=70" )
	RegistroVisitasModel getRegistroVisitaPorPlaca(String cvePlaca);
	
}
