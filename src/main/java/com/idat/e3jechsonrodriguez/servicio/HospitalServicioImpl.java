package com.idat.e3jechsonrodriguez.servicio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.e3jechsonrodriguez.dto.HospitalDTOrequest;
import com.idat.e3jechsonrodriguez.dto.HospitalDTOresponse;
import com.idat.e3jechsonrodriguez.modelo.hospital;
import com.idat.e3jechsonrodriguez.repositorio.HospitalRepo;

@Service
public class HospitalServicioImpl implements HospitalServicio {

	@Autowired
	public HospitalRepo repositorio;
	
	@Override
	public void guardarHospital(HospitalDTOrequest hospital) {
		hospital obj = new hospital();
		obj.setIdHospital(hospital.getIdHospitalDTO());
		obj.setNombre(hospital.getNombreDTO());
		obj.setDescripcion(hospital.getDescripcionDTO());
		obj.setDistrito(hospital.getDistritoDTO());
		
		repositorio.save(obj);

	}

	@Override
	public void editarHospital(HospitalDTOrequest hospital) {
		hospital obj = new hospital();
		obj.setIdHospital(hospital.getIdHospitalDTO());
		obj.setNombre(hospital.getNombreDTO());
		obj.setDescripcion(hospital.getDescripcionDTO());
		obj.setDistrito(hospital.getDistritoDTO());
		
		repositorio.saveAndFlush(obj);

	}

	@Override
	public void eliminarHospital(Integer id) {
		repositorio.deleteById(id);

	}

	@Override
	public List<HospitalDTOresponse> listarHospitales() {
		List<HospitalDTOresponse> lista = new ArrayList<HospitalDTOresponse>();
		HospitalDTOresponse obj = null;
		
		for(hospital hospital : repositorio.findAll()) {
			obj = new HospitalDTOresponse();
			obj.setIdHospitalDTO(hospital.getIdHospital());
			obj.setNombreDTO(hospital.getNombre());
			obj.setDescripcionDTO(hospital.getDescripcion());
			obj.setDistritoDTO(hospital.getDistrito());
			
			lista.add(obj);
		}
		return lista;
	}

	@Override
	public HospitalDTOresponse obtenerHospitalId(Integer id) {
		
		hospital hospital= repositorio.findById(id).orElse(null);
		
		HospitalDTOresponse obj = new HospitalDTOresponse();
		obj.setIdHospitalDTO(hospital.getIdHospital());
		obj.setNombreDTO(hospital.getNombre());
		obj.setDescripcionDTO(hospital.getDescripcion());
		obj.setDistritoDTO(hospital.getDistrito());		
		
		return obj;
	}

}
