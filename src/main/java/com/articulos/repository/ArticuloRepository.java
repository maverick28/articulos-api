package com.articulos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.articulos.model.Articulo;

@Repository
public interface ArticuloRepository extends JpaRepository<Articulo, String> {
	
}
