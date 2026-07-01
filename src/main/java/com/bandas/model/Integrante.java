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
@Table(name="tbl_integrante")
@Getter
@Setter
@DynamicInsert
@AllArgsConstructor
@NoArgsConstructor
public class Integrante {

	@Id
	@Column(name = "id_integrante")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idIntegrante;

	@Column(name = "nombre")
	private String nombre;	
	
	@Column(name = "instrumento")
	private String instrumento;	
	
	@Column(name = "fecha_nacimiento")
	private LocalDate fechaNacimiento;	
	
	@Column(name = "nacionalidad")
	private String nacionalidad;	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_banda")
	private Banda banda;
}
