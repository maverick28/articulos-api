package com.articulos.service;

import java.util.List;
import java.util.Optional;

import com.articulos.model.Articulo;

public interface ArticuloService {
	/**
     * Obtiene la lista de todos los articulos.
     *
     * @return List<Articulo>
     */
    List<Articulo> getAllArticulos(int page, int size);

    /**
     * Obtiene un articulo por su ID.
     *
     * @param id
     * @return Optional<Articulo>
     */
    Optional<Articulo> getArticuloById(String id);

    /**
     * Crea un nuevo Articulo.
     *
     * @param articulo
     * @return Articulo
     */
    Articulo createArticulo(Articulo articulo);

    /**
     * Actualiza un Articulo.
     *
     * @param id
     * @param updatedArticulo.
     * @return Articulo
     */
    Articulo updateArticulo(String id, Articulo updatedArticulo);

    /**
     * Elimina con delete un Articulo.
     *
     * @param id
     */
    void deleteArticulo(String id);
}
