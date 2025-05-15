package com.Fullstack.Fullstack.controller;

import com.Fullstack.Fullstack.model.Cliente;
import com.Fullstack.Fullstack.service.ClienteService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<Cliente> getAllClientes() {
        return clienteService.getAllClientes();
    }

    @PostMapping
    public Cliente addCliente(@RequestBody Cliente cliente) {
        return clienteService.save(cliente);
    }

    @GetMapping("/{id_cliente}")  // Usa 'id'
    public Cliente getClienteById(@PathVariable Long id_cliente) {  // Usa 'id'
        return clienteService.getClienteById(id_cliente);
    }

    @DeleteMapping("/{id_cliente}")  // Usa 'id'
    public ResponseEntity<Void> deleteCliente(@PathVariable Long id_cliente) {  // Usa 'id'
        clienteService.delete(id_cliente);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id_cliente}")  // Usa 'id'
    public Cliente updateCliente(@PathVariable Long id_cliente, @RequestBody Cliente cliente) {  // Usa 'id'
        return clienteService.updateCliente(id_cliente, cliente);
    }

        @ExceptionHandler(ResponseStatusException.class)
        public ResponseEntity<String> handleNotFound(ResponseStatusException ex) {
            return ResponseEntity.status(ex.getStatusCode()).body(ex.getReason());
        }
    
}