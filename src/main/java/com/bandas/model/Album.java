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
@Table(name="tbl_album")
@Getter
@Setter
@DynamicInsert
@AllArgsConstructor
@NoArgsConstructor
public class Album {
	
	@Id
	@Column(name = "id_album")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idAlbum;

	@Column(name = "nombre")
	private String nombre;	
	
	@Column(name = "anio")
	private Integer anio;	
	
	@Column(name = "portada")
	private String portada;	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_banda")
	private Banda banda;
	

}
