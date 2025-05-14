package com.Fullstack.Fullstack.service;

import org.springframework.stereotype.Service;
import com.Fullstack.Fullstack.model.Cliente;
import jakarta.transaction.Transactional;
import com.Fullstack.Fullstack.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
@Transactional
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }

    public Cliente getClienteById(Long run) {
        return clienteRepository.findById(run).orElse(null);
    }

    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public String delete(Long run) {
        clienteRepository.deleteById(run);
        return "Cliente eliminado";
    }
}
