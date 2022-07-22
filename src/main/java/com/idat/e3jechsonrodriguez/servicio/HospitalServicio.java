package com.idat.e3jechsonrodriguez.servicio;

import java.util.List;

import com.idat.e3jechsonrodriguez.dto.HospitalDTOrequest;
import com.idat.e3jechsonrodriguez.dto.HospitalDTOresponse;

public interface HospitalServicio {
	
	public void guardarHospital(HospitalDTOrequest hospital);
	public void editarHospital(HospitalDTOrequest hospital);
	public void eliminarHospital(Integer id);
	public List<HospitalDTOresponse> listarHospitales();
	public HospitalDTOresponse obtenerHospitalId(Integer id);
}
