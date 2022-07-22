package com.idat.e3jechsonrodriguez.servicio;

import java.util.List;

import com.idat.e3jechsonrodriguez.dto.ClienteDTOrequest;
import com.idat.e3jechsonrodriguez.dto.ClienteDTOresponse;

public interface ClienteServicio {
	
	public void guardarCliente(ClienteDTOrequest cliente);
	public void editarCliente(ClienteDTOrequest cliente);
	public void eliminarCliente(Integer id);
	public List<ClienteDTOresponse> listarClientes();
	public ClienteDTOresponse obtenerClienteId(Integer id);
}
