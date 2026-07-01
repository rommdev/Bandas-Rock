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
@Table(name="tbl_banda")
@Getter
@Setter
@DynamicInsert
@AllArgsConstructor
@NoArgsConstructor
public class Banda {

	@Id
	@Column(name = "id_banda")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idBanda;

	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "anio_formacion")
	private Integer anioFormacion;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_genero")
	private Genero genero;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_pais")
	private Pais pais;
}
