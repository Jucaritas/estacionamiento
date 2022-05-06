package com.glimon.estacionamiento.api.rest.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.glimon.estacionamiento.api.rest.model.TipoClienteModel;

@Repository
public interface TipoClienteDAO extends JpaRepository<TipoClienteModel, Long>{
	
	TipoClienteModel getTipoClienteByCvePlaca(String cvePlaca);
	
}
