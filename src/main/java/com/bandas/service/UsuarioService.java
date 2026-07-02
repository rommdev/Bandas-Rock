package com.bandas.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bandas.dto.ResultadoResponse;
import com.bandas.dto.UsuarioFilter;
import com.bandas.model.Usuario;
import com.bandas.repository.UsuarioRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioService {

	private final UsuarioRepository usuarioRepository;
	
	public List<Usuario> search(UsuarioFilter filter) {
		return usuarioRepository.findAllByFilters(filter.getIdTipo());
	}
	
	
	public Usuario getOne(Integer id) {
		return usuarioRepository.findById(id).orElseThrow();
	}
	
	
	public ResultadoResponse create(Usuario usuario) {
		
		var existe = usuarioRepository.existsByCorreo(usuario.getCorreo());
		
		if (existe) {
			return new ResultadoResponse (false, "Ya existe un usuario con esa cuenta");
		}
		
		try {
			var registro = usuarioRepository.save(usuario);
			var mensaje = String.format("Usuario con ese ID %s registrado", registro.getIdUsuario());

			return new ResultadoResponse(true, mensaje);
			
		} catch (Exception e) {
			e.printStackTrace();
			return new ResultadoResponse(false, "Hubo un error en la transaccion" );
		}
	}
	
	
	public ResultadoResponse update(Usuario usuario) {
		 
		var existe = usuarioRepository.existsByCorreoAndIdUsuarioNot(usuario.getCorreo(), usuario.getIdUsuario());
		
		if (existe) {
			return new ResultadoResponse(false, "Ya existe un usuario con esa cuenta");
		}
		
		try {
			var registro = usuarioRepository.save(usuario);
			var mensaje = String.format("Usuario con ID %s actualizado", registro.getIdUsuario());
			
			return new ResultadoResponse(true, mensaje);
			
		} catch (Exception e) {
			e.printStackTrace();
			return new ResultadoResponse(false, "Hubo un error en a transaccion");
		}
	}
	
	@Transactional
	public ResultadoResponse changeActive(Integer id) {
		var usuario = usuarioRepository.findById(id).orElse(null);
		
		try {
			usuario.setActivo(!usuario.getActivo());
			
			var estado = usuario.getActivo() ? "activado" : "desactivado";
			var mensaje = String.format("Usuario con ID %s %s", usuario.getIdUsuario(), estado);
			
			return new ResultadoResponse(true, mensaje);
			
		} catch (Exception e) {
			e.printStackTrace();
			return new ResultadoResponse(false, "Hubo un error en la transaccion");
		}
	}
	
	
	
}
