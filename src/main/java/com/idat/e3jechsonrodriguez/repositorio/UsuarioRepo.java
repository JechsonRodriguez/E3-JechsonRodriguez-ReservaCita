package com.idat.e3jechsonrodriguez.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idat.e3jechsonrodriguez.modelo.usuario;
@Repository
public interface UsuarioRepo extends JpaRepository<usuario, Integer>{
	usuario findByUsuario(String usuario);
}
