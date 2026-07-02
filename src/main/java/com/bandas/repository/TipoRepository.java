package com.bandas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bandas.model.Tipo;

@Repository
public interface TipoRepository extends JpaRepository<Tipo, Integer>{

}
