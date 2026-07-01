package com.bandas.model;

import java.time.LocalDate;

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
@Table(name="tbl_concierto")
@Getter
@Setter
@DynamicInsert
@AllArgsConstructor
@NoArgsConstructor
public class Concierto {

	@Id
	@Column(name = "id_concierto")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idConcierto;

	@Column(name = "nombre")
	private String nombre;	
	
	@Column(name = "ciudad")
	private String ciudad;	
	
	@Column(name = "pais")
	private String pais;	
	
	@Column(name = "fecha")
	private LocalDate fecha;	

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_banda")
	private Banda banda;
}
