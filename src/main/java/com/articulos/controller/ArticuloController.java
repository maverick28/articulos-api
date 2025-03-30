package com.articulos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.articulos.model.Articulo;
import com.articulos.service.ArticuloServiceImpl;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api/articulos")
public class ArticuloController {
	
	private final ArticuloServiceImpl articuloService;
	
	@Autowired
    public ArticuloController(ArticuloServiceImpl articuloService) {
        this.articuloService = articuloService;
    }

    @Operation(summary = "getAllArticulos", description = "Devuelve una lista de todos los articulos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Articulo> getAllArticulos(@RequestParam(defaultValue = "0", required = true) int page,
			@RequestParam(defaultValue = "2", required = true) int size) {
        return articuloService.getAllArticulos(page, size);
    }

    @Operation(summary = "getArticuloById", description = "Devuelve un articulo por su ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved"),
            @ApiResponse(responseCode = "404", description = "Articulo not found")
    })
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Articulo getArticuloById(@Parameter(description = "ID del articulo a buscar") @PathVariable String id) {
        return articuloService.getArticuloById(id)
                .orElseThrow(() -> new RuntimeException("Articulo not found"));
    }

    @Operation(summary = "createArticulo", description = "Crea un nuevo articulo")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Successfully created"),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Articulo createArticulo(@RequestBody Articulo articulo) {
        return articuloService.createArticulo(articulo);
    }

    @Operation(summary = "updateArticulo", description = "Actualiza la descripcion y/o modelo de un articulo")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully updated"),
            @ApiResponse(responseCode = "404", description = "Articulo not found")
    })
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Articulo updateArticulo(@PathVariable String id, @RequestBody Articulo updatedArticulo) {
        return articuloService.updateArticulo(id, updatedArticulo);
    }

    @Operation(summary = "deleteArticulo", description = "Elimina con delete un articulo por su ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully deleted"),
            @ApiResponse(responseCode = "404", description = "Articulo not found")
    })
    @DeleteMapping(value = "/{id}")
    public void deleteArticulo(@PathVariable String id) {
        articuloService.deleteArticulo(id);
    }
}
