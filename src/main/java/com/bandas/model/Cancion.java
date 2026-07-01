package com.bandas.model;

import java.time.LocalTime;

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
@Table(name="tbl_cancion")
@Getter
@Setter
@DynamicInsert
@AllArgsConstructor
@NoArgsConstructor
public class Cancion {
	
	@Id
	@Column(name = "id_cancion")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCancion;

	@Column(name = "nombre")
	private String nombre;	
	
	@Column(name = "duracion")
	private LocalTime duracion;	
	
	@Column(name = "numero_pista")
	private Integer numeroPista;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_album")
	private Album album;
}
