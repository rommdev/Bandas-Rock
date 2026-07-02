package com.bandas.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bandas.model.Tipo;
import com.bandas.repository.TipoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TipoService {

	private final TipoRepository tiporepository;
	
	public List<Tipo> getAll() {
		return tiporepository.findAll();
	}
}
