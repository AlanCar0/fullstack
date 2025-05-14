package com.Fullstack.Fullstack.controller;

import com.Fullstack.Fullstack.model.Cliente;
import com.Fullstack.Fullstack.service.ClienteService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<Cliente> getAllClientes(){
        return clienteService.getAllClientes();
    }

    @PostMapping
    public Cliente addCliente(@RequestBody Cliente cliente){
        return clienteService.save(cliente);
    }

    @GetMapping("/{id}")
    public Cliente getClienteById(@PathVariable Long id){
        return clienteService.getClienteById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteCliente(@PathVariable Long id){
        return clienteService.delete(id);
    }

    @PutMapping("/{id}")
    public Cliente updateCliente(@PathVariable Long id, @RequestBody Cliente cliente){
        return clienteService.save(cliente);
    }
}