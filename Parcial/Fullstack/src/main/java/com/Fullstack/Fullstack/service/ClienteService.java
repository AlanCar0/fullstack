package com.Fullstack.Fullstack.service;

import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.Fullstack.Fullstack.model.Cliente;
import jakarta.transaction.Transactional;
import com.Fullstack.Fullstack.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import java.util.List;

@Service
@Transactional
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }

    public Cliente getClienteById(Long id_cliente) {
        return clienteRepository.findById(id_cliente)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente no encontrado"));
    }

    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public String delete(Long id_cliente) {
        clienteRepository.deleteById(id_cliente);
        return "Cliente eliminado";
    }
    public Cliente updateCliente(Long id_cliente, Cliente cliente) {
    Cliente existingCliente = clienteRepository.findById(id_cliente)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente no encontrado"));

    // Actualiza los campos necesarios (¡CUIDADO con seguridad!  No actualizar todo ciegamente)
        existingCliente.setNombre(cliente.getNombre());
        existingCliente.setApellido(cliente.getApellido());
        existingCliente.setEmail(cliente.getEmail());
        existingCliente.setDireccion(cliente.getDireccion());
        existingCliente.setRun(cliente.getRun());
        existingCliente.setFec_naciemiento(cliente.getFec_naciemiento());

        return clienteRepository.save(existingCliente);
    }
}
