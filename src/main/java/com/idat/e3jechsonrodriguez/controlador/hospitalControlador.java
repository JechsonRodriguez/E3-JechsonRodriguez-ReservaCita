package com.idat.e3jechsonrodriguez.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.idat.e3jechsonrodriguez.dto.HospitalDTOrequest;
import com.idat.e3jechsonrodriguez.dto.HospitalDTOresponse;
import com.idat.e3jechsonrodriguez.servicio.HospitalServicio;


@RestController
@RequestMapping("/hospital/op")
public class hospitalControlador {
	
	@Autowired
	private HospitalServicio servicio;
	
	@RequestMapping(path = "/listar", method = RequestMethod.GET)
	public ResponseEntity<List<HospitalDTOresponse>> listarProducto(){
		return new ResponseEntity<List<HospitalDTOresponse>>(servicio.listarHospitales(), HttpStatus.CREATED);
	}

	@RequestMapping(path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody HospitalDTOrequest hospital){
		
		servicio.guardarHospital(hospital);
		return new ResponseEntity<Void> (HttpStatus.CREATED);
	}
	
	@RequestMapping(path = "/listar/{id}")
	public ResponseEntity<HospitalDTOresponse> listarPorId(@PathVariable Integer id) {
		HospitalDTOresponse p = servicio.obtenerHospitalId(id);
		if(p != null)
			return new ResponseEntity<HospitalDTOresponse>(p, HttpStatus.OK);
					
		return new ResponseEntity<HospitalDTOresponse>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "/editar", method = RequestMethod.PUT)
	public ResponseEntity<Void> editar(@RequestBody HospitalDTOrequest hospital){
		
		HospitalDTOresponse p = servicio.obtenerHospitalId(hospital.getIdHospitalDTO());
		if(p != null) {
			servicio.editarHospital(hospital);
			return new ResponseEntity<Void>(HttpStatus.OK);
			
		}			
					
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminar(@PathVariable Integer id){
		
		HospitalDTOresponse p = servicio.obtenerHospitalId(id);
		if(p != null) {
			servicio.eliminarHospital(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
			
		}			
					
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);

	}

}
