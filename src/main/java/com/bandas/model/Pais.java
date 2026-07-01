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
@Table(name="tbl_pais")
@Getter
@Setter
public class Pais {
	
	@Id
	@Column(name = "id_pais")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPais;

	@Column(name = "nombre")
	private String nombre;

}
