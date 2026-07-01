package com.bandas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bandas.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

	Usuario findByCorreoAndPassword(String correo, String password);
	
	@Query("""
			select u
			from Usuario as u
			where
				(u.tipo.idTipo = :idTipo or :idTipo is null)
			""")
	List<Usuario> findAllByFilters(@Param("idTipo") Integer idTipo);
	
	boolean existsByCorreo(String correo);
	
	boolean existsByCorreoAndIdUsuarioNot(String correo, Integer idUsuario);
}
