package com.idat.e3jechsonrodriguez.servicio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.e3jechsonrodriguez.dto.ClienteDTOrequest;
import com.idat.e3jechsonrodriguez.dto.ClienteDTOresponse;
import com.idat.e3jechsonrodriguez.modelo.cliente;
import com.idat.e3jechsonrodriguez.repositorio.ClienteRepo;

@Service
public class ClienteServicioImpl implements ClienteServicio {

	@Autowired
	private ClienteRepo repositorio;
	
	@Override
	public void guardarCliente(ClienteDTOrequest cliente) {
		
		cliente obj = new cliente();
		obj.setIdCliente(cliente.getIdClienteDTO());
		obj.setCliente(cliente.getClienteDTO());
		obj.setCelular(cliente.getCelularDTO());

		repositorio.save(obj);
	}

	@Override
	public void editarCliente(ClienteDTOrequest cliente) {
		cliente obj = new cliente();
		obj.setIdCliente(cliente.getIdClienteDTO());
		obj.setCliente(cliente.getClienteDTO());
		obj.setCelular(cliente.getCelularDTO());

		repositorio.saveAndFlush(obj);

	}

	@Override
	public void eliminarCliente(Integer id) {
		repositorio.deleteById(id);;

	}

	@Override
	public List<ClienteDTOresponse> listarClientes() {

		List<ClienteDTOresponse> lista = new ArrayList<ClienteDTOresponse>();
		ClienteDTOresponse obj = null;
		
		for(cliente cliente : repositorio.findAll()) {
			obj = new ClienteDTOresponse();
			obj.setIdClienteDTO(cliente.getIdCliente());
			obj.setClienteDTO(cliente.getCliente());
			obj.setCelularDTO(cliente.getCelular());
			lista.add(obj);
		}
		return lista;
	}

	@Override
	public ClienteDTOresponse obtenerClienteId(Integer id) {
		cliente cliente =  repositorio.findById(id).orElse(null);
		
		ClienteDTOresponse obj = new ClienteDTOresponse();
		obj.setIdClienteDTO(cliente.getIdCliente());
		obj.setClienteDTO(cliente.getCliente());
		obj.setCelularDTO(cliente.getCelular());
		
		return obj;
	}

}
