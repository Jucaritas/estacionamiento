package com.glimon.estacionamiento.api.rest.serviceImpl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.glimon.estacionamiento.api.rest.dao.RegistroVisitasDAO;
import com.glimon.estacionamiento.api.rest.dao.TipoClienteDAO;
import com.glimon.estacionamiento.api.rest.dao.TipoVehiculoDAO;
import com.glimon.estacionamiento.api.rest.model.RegistroVisitasModel;
import com.glimon.estacionamiento.api.rest.model.TipoClienteModel;
import com.glimon.estacionamiento.api.rest.model.TipoVehiculoModel;
import com.glimon.estacionamiento.api.rest.service.RegistroVisitasService;

@Service
public class RegistroVisitasServiceImpl implements RegistroVisitasService {

	@Autowired
	private RegistroVisitasDAO registroVisitasDAO;
	
	@Autowired
	private TipoClienteDAO tipoClienteDAO;
	
	@Autowired
	private TipoVehiculoDAO tipoVehiculoDAO;
	
	@Override
	public String registraIngresoPorPlaca(String cvePlaca) throws Exception {
		RegistroVisitasModel registroIngreso = registroVisitasDAO.getRegistroVisitaPorPlaca(cvePlaca);
		TipoClienteModel tipoCliente = tipoClienteDAO.getTipoClienteByCvePlaca(cvePlaca);
		int tarifa = 3;
		
		if(tipoCliente != null) {
			TipoVehiculoModel vehiculo = tipoVehiculoDAO.getTipoVehiculoByCveTipoVehiculo(tipoCliente.getTipoVehiculo());
			tarifa = vehiculo.getTarifa();
		}
		
		RegistroVisitasModel nuevoRegistroIngreso = new RegistroVisitasModel();
		
		nuevoRegistroIngreso.setCvePlaca(cvePlaca);
		nuevoRegistroIngreso.setEstatus(60);
		nuevoRegistroIngreso.setFechaIngreso(new Date());
		nuevoRegistroIngreso.setTarifa(tarifa);
		
		registroVisitasDAO.save(nuevoRegistroIngreso);
		
		return "Se ha registrado el ingreso";
	}

	@Override
	public String registraSalidaPorPlaca(String cvePlaca) throws Exception {
		RegistroVisitasModel actualRegistroIngreso = registroVisitasDAO.getRegistroVisitaPorPlaca(cvePlaca);
		if(actualRegistroIngreso == null) {
			throw new Exception("El cliente con clave "+cvePlaca+" no esta en el estacionamiento");
		}
		Date entrada = actualRegistroIngreso.getFechaIngreso();
		Date salida = new Date();
		
		actualRegistroIngreso.setFechaSalida(salida);
		
		long difTiempo = salida.getTime() - entrada.getTime();
		long difMinutos = difTiempo / (60 * 1000) % 60;
		
		actualRegistroIngreso.setMinutos(difMinutos);
		actualRegistroIngreso.setCostoVisita(difMinutos*actualRegistroIngreso.getTarifa());
		actualRegistroIngreso.setEstatus(70);
		registroVisitasDAO.save(actualRegistroIngreso);
		
		return "Se ha registrado al salida";
	}

	@Override
	public void GenerarReporte() throws Exception {
		Date date = Calendar.getInstance().getTime();  
	    DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
	    
		String fecha = "23/03/2022 10:00:00";
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		Date data = formato.parse(fecha);
		Calendar calendar = Calendar.getInstance();
		System.out.println(data);
	    calendar.setTime(data); // Configuramos la fecha que se recibe	
	    calendar.add(Calendar.HOUR, 1);  // numero de horas a añadir, o restar en caso de horas<0
	    
	    
	    
	    String strDate = dateFormat.format(date);  
	    
	    System.out.println(calendar.getTime());
		
	}

}
