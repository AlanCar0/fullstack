package com.Fullstack.Fullstack.controller;

import com.Fullstack.Fullstack.model.Producto;
import com.Fullstack.Fullstack.service.ProductoService;

import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/producto")
@Tag(name = "Producto", description = "Operaciones relacionadas con productos")
public class ProductoController {
    @Autowired
    private ProductoService productoService;

    @GetMapping
    public List<Producto> getAllProductos() {
        return productoService.getAllProductos();
    }

    @PostMapping
    public Producto addProducto(@RequestBody Producto producto) {
        return productoService.save(producto);
    }

    @GetMapping("/{id_producto}")  // Usa 'id'
    public Producto getProductoById(@PathVariable Long id_producto) {  // Usa 'id'
        return productoService.getProductoById(id_producto);
    }

    @DeleteMapping("/{id_producto}")  // Usa 'id'
    public ResponseEntity<Void> deleteProducto(@PathVariable Long id_producto) {  // Usa 'id'
        productoService.delete(id_producto);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id_producto}")  // Usa 'id'
    public Producto updateProducto(@PathVariable Long id_producto, @RequestBody Producto producto) {  // Usa 'id'
        return productoService.updateProducto(id_producto, producto);
    }

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<String> handleNotFound(ResponseStatusException ex) {
        return ResponseEntity.status(ex.getStatusCode()).body(ex.getReason());
    }

}
