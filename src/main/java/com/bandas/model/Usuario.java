package com.bandas.model;

import org.hibernate.annotations.DynamicInsert;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="tbl_usuario")
@Getter
@Setter
@DynamicInsert
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

	@Id
	@Column(name = "id_usuario")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idUsuario;

	@Column(name = "nombres")
	private String nombres;	
	
	@Column(name = "apellidos")
	private String apellidos;	
	
	@Column(name = "correo")
	private String correo;	
	
	@Column(name = "password")
	private String password;	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_tipo")
	private Tipo tipo;
	
	public String getFullName() {
		return String.format("%s %s", nombres, apellidos);
	}
	
	
	
}
