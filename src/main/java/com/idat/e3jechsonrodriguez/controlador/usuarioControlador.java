package com.idat.e3jechsonrodriguez.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.idat.e3jechsonrodriguez.dto.UsuarioDTOrequest;
import com.idat.e3jechsonrodriguez.dto.UsuarioDTOresponse;
import com.idat.e3jechsonrodriguez.seguridad.JwtUtil;
import com.idat.e3jechsonrodriguez.seguridad.UserDetailService;



@RestController
public class usuarioControlador {
	
	@Autowired
	private JwtUtil util;
	@Autowired
	private UserDetailService service;
	
	@RequestMapping(path = "/crearToken", method = RequestMethod.POST)
	public ResponseEntity<?> crearTokenn(@RequestBody UsuarioDTOrequest dto){
		UserDetails details = service.loadUserByUsername(dto.getUsuario());
		
		return ResponseEntity.ok(new UsuarioDTOresponse(util.generateToken(details.getUsername())));
	}
}
