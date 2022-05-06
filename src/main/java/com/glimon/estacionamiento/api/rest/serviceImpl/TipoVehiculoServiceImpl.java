package com.glimon.estacionamiento.api.rest.serviceImpl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.glimon.estacionamiento.api.rest.dao.TipoVehiculoDAO;
import com.glimon.estacionamiento.api.rest.model.TipoVehiculoModel;
import com.glimon.estacionamiento.api.rest.service.TipoVehiculoService;
import com.glimon.estacionamiento.api.restd.dto.TipoVehiculoRequestDTO;
import com.glimon.estacionamiento.api.restd.dto.TipoVehiculoResponseDTO;

@Service
public class TipoVehiculoServiceImpl implements TipoVehiculoService {

	@Autowired
	private TipoVehiculoDAO tipoVehiculoDAO;
	
	@Override
	public List<TipoVehiculoResponseDTO> getListaTipoVehiculos() throws Exception {
		//cargamos la lista completa desde la base de datos
		List<TipoVehiculoModel> lstTipoVeihiculos = this.tipoVehiculoDAO.findAll();
		//convertimos la entitad a un dto
		List<TipoVehiculoResponseDTO> listaTipoVehiculos = lstTipoVeihiculos.stream().map(tipoVehiculo -> {
			return new TipoVehiculoResponseDTO(tipoVehiculo.getCveTipoVehiculo(), tipoVehiculo.getDescTipoVehiculo(),tipoVehiculo.getTarifa(),tipoVehiculo.getEstatus());
		}).collect(Collectors.toList());
		//retornamos la lista ya convertida en dto
		return listaTipoVehiculos;
	}

	@Override
	public TipoVehiculoResponseDTO getTipoVehiculoPorCveTipoVehiculo(int cveTipoVehiculo) throws Exception {
		//traemos el tipo de vehiculo por clave
		TipoVehiculoModel tipoVehiculo = tipoVehiculoDAO.getTipoVehiculoByCveTipoVehiculo(cveTipoVehiculo);
		//validamos si existe la clave del tipo de vehiculo
		if(tipoVehiculo == null) {
			throw new Exception("La clave del tipo de veiculo, no existe ");
		}
		//si existe el tipo de vehiculo con esa clave, lo convertimos a dto para responder con el
		TipoVehiculoResponseDTO vehiculo = new TipoVehiculoResponseDTO(tipoVehiculo.getCveTipoVehiculo(), tipoVehiculo.getDescTipoVehiculo(),tipoVehiculo.getTarifa(),tipoVehiculo.getEstatus());
		
		return vehiculo;
	}

	@Override
	public String creaNuevoTipoVehiculo(TipoVehiculoRequestDTO tipoVehiculoRequestDTO) throws Exception {
		//creamos una entidad y asignamos los valores del dto request
		TipoVehiculoModel nuevoTipoVehiculo = new TipoVehiculoModel();
		//validamos si no existe la clave del tipo de vehiculo
		//traemos una nueva clave desde la secuencia de la base de datos
		int nvaClaveTipoVehiculo = tipoVehiculoDAO.getNextTipoVehiculoKey();
		//convertimos el dto a entidad para guardarlo en la base de datos
		nuevoTipoVehiculo.setCveTipoVehiculo(nvaClaveTipoVehiculo);
		nuevoTipoVehiculo.setDescTipoVehiculo(tipoVehiculoRequestDTO.getDescTipoVehiculo());
		nuevoTipoVehiculo.setEstatus(20);//el estatus 20 es activo
		nuevoTipoVehiculo.setTarifa(tipoVehiculoRequestDTO.getTarifa());
		nuevoTipoVehiculo.setFechaRegistro(new Date());
		
		tipoVehiculoDAO.save(nuevoTipoVehiculo);
		
		return "Se ha creado el tipo de vehiculo con exito";
	}

	@Override
	public String eliminaTipoVehiculo(int cveTipoVehiculo) throws Exception {
		//traemos el tipo de vehiculo por clave
		TipoVehiculoModel tipoVehiculo = tipoVehiculoDAO.getTipoVehiculoByCveTipoVehiculo(cveTipoVehiculo);
		//validamos si existe la clave del tipo de vehiculo
		if(tipoVehiculo == null) {
			throw new Exception("La clave del tipo de veiculo, no existe ");
		}
		
		tipoVehiculoDAO.deleteById(tipoVehiculo.getIdTipoVehiculo());
		
		return "Se ha eliminado el tipo de vehiculo";
	}

}
