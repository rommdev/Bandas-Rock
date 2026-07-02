package com.bandas.service;

import org.springframework.stereotype.Service;

import com.bandas.dto.AutenticacionFilter;
import com.bandas.model.Usuario;
import com.bandas.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AutenticacionService {

	private final UsuarioRepository usuarioRepository;
	
	public Usuario atenticathe(AutenticacionFilter autenticacionFilter) {
		return usuarioRepository.findByCorreoAndPassword(autenticacionFilter.getCorreo(), autenticacionFilter.getPassword());
	}
}
