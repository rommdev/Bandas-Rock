package com.bandas.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="tbl_tipo")
@Getter
@Setter
public class Tipo {

	@Id
	@Column(name = "id_tipo")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idTipo;

	@Column(name = "descripcion")
	private String descripcion;	
}
