package com.idat.e3jechsonrodriguez.modelo;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name = "Clientes")
@Entity


public class cliente {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer idCliente;
		private String cliente;
		private String celular;
		
		@OneToOne
		@JoinColumn(name = "id_usuario", nullable = false, unique = true, 
		foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(id_usuario) references usuarios (id_usuario)"))
		private usuario usuario;
		
		@ManyToMany(mappedBy = "cliente", cascade = {CascadeType.PERSIST,CascadeType.MERGE})
		private List<hospital> hospital = new ArrayList<hospital>();
		
		public Integer getIdCliente() {
			return idCliente;
		}
		public void setIdCliente(Integer idCliente) {
			this.idCliente = idCliente;
		}
		public String getCliente() {
			return cliente;
		}
		public void setCliente(String cliente) {
			this.cliente = cliente;
		}
		public String getCelular() {
			return celular;
		}
		public void setCelular(String celular) {
			this.celular = celular;
		}
		
}
