package com.Fullstack.Fullstack.controller;

import com.Fullstack.Fullstack.model.Carrito;
import com.Fullstack.Fullstack.service.CarritoService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/carrito")
public class CarritoController {
    @Autowired
    private CarritoService carritoService;

    @GetMapping
    public List<Carrito> getAllCarritos() {
        return carritoService.getAllCarritos();
    }

    @PostMapping
    public Carrito addCarrito(@RequestBody Carrito carrito) {
        return carritoService.save(carrito);
    }

    @GetMapping("/{id}")  // Usa 'id'
    public Carrito getCarritoById(@PathVariable Long id_carrito) {  // Usa 'id'
        return carritoService.getCarritoById(id_carrito);
    }

    @DeleteMapping("/{id}")  // Usa 'id'
    public ResponseEntity<Void> deleteCarrito(@PathVariable Long id_carrito) {  // Usa 'id'
        carritoService.delete(id_carrito);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")  // Usa 'id'
    public Carrito updateCarrito(@PathVariable Long id_carrito, @RequestBody Carrito carrito) {  // Usa 'id'
        return carritoService.updateCarrito(id_carrito, carrito);
    }

        @ExceptionHandler(ResponseStatusException.class)
        public ResponseEntity<String> handleNotFound(ResponseStatusException ex) {
            return ResponseEntity.status(ex.getStatusCode()).body(ex.getReason());
        }

}
