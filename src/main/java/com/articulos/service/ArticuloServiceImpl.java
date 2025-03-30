package com.articulos.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.articulos.model.Articulo;
import com.articulos.repository.ArticuloRepository;

@Service
public class ArticuloServiceImpl implements ArticuloService {

    private final ArticuloRepository articuloRepository;

    @Autowired
    public ArticuloServiceImpl(ArticuloRepository articuloRepository) {
        this.articuloRepository = articuloRepository;
    }

    public List<Articulo> getAllArticulos(int page, int size) {
		List<Articulo> listaProducto = articuloRepository.findAll(PageRequest.of(page, size)).getContent();
		return listaProducto.stream().collect(Collectors.toList());
    }

    public Optional<Articulo> getArticuloById(String id) {
        return articuloRepository.findById(id);
    }

    public Articulo createArticulo(Articulo articulo) {
        return articuloRepository.save(articulo);
    }

    public Articulo updateArticulo(String id, Articulo updatedArticulo) {
        Optional<Articulo> articuloOptional = articuloRepository.findById(id);
        if (articuloOptional.isPresent()) {
            Articulo articulo = articuloOptional.get();
            articulo.setDescripcion(updatedArticulo.getDescripcion());
            articulo.setModelo(updatedArticulo.getModelo());
            return articuloRepository.save(articulo);
        }
        return null;
    }

    public void deleteArticulo(String id) {
        articuloRepository.deleteById(id);
    }
}