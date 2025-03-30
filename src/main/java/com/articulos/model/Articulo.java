package com.articulos.model;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "articulo")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Articulo implements Serializable {
	
	private static final long serialVersionUID = 3425546181848142641L;

	@Id
	@Column(name = "id", length = 10, unique = true, nullable = false, updatable = false)
    private String id;

	@Column(name = "nombre", length = 20, unique = true, nullable = false, updatable = false)
    private String nombre;

	@Column(name = "descripcion", length = 200, unique = false, nullable = true, updatable = true)
    private String descripcion;

	@Column(name = "precio", precision = 2, nullable = false, updatable = false)
    private float precio;

	@Column(name = "modelo", length = 256, unique = true, nullable = false, updatable = true)
    private String modelo;

}
