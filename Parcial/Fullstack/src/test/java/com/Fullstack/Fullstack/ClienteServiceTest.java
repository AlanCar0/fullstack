package com.Fullstack.Fullstack;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.Fullstack.Fullstack.model.Cliente;
import com.Fullstack.Fullstack.repository.ClienteRepository;
import com.Fullstack.Fullstack.service.ClienteService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class ClienteServiceTest {

    @Autowired
    private ClienteService clienteService;

    @MockBean
    private ClienteRepository clienteRepository;

    @Test
    public void testGetAllClientes() {
        Cliente cliente1 = new Cliente();
        Cliente cliente2 = new Cliente();
        when(clienteRepository.findAll()).thenReturn(List.of(cliente1, cliente2));

        List<Cliente> clientes = clienteService.getAllClientes();
        assertEquals(2, clientes.size());
    }

    @Test
    public void testGetClienteById() {
        Long id = 1L;
        Cliente cliente = new Cliente();
        cliente.setNombre("Pedro");
        when(clienteRepository.findById(id)).thenReturn(Optional.of(cliente));

        Cliente foundCliente = clienteService.getClienteById(id);
        assertNotNull(foundCliente);
        assertEquals("Pedro", foundCliente.getNombre());
    }

    @Test
    public void testSaveCliente() {
        Cliente cliente = new Cliente();
        cliente.setRun("12.345.678-9");
        cliente.setNombre("Ana");
        cliente.setApellido("Rojas");
        cliente.setFec_naciemiento("1990-01-01");
        cliente.setEmail("ana.rojas@example.com");
        cliente.setDireccion("Av. Siempre Viva 123");

        when(clienteRepository.save(cliente)).thenReturn(cliente);

        Cliente savedCliente = clienteService.save(cliente);
        assertNotNull(savedCliente);
        assertEquals("Ana", savedCliente.getNombre());
    }

    @Test
    public void testDeleteCliente() {
        Long id = 1L;
        doNothing().when(clienteRepository).deleteById(id);

        String response = clienteService.delete(id);
        assertEquals("Cliente eliminado", response);
    }

    @Test
    public void testUpdateCliente() {
        Long id = 1L;
        Cliente existingCliente = new Cliente();
        existingCliente.setRun("12.345.678-9");
        existingCliente.setNombre("Pedro");
        existingCliente.setApellido("Pérez");
        existingCliente.setFec_naciemiento("1985-05-05");
        existingCliente.setEmail("pedro@example.com");
        existingCliente.setDireccion("Calle Falsa 123");

        when(clienteRepository.findById(id)).thenReturn(Optional.of(existingCliente));
        when(clienteRepository.save(any(Cliente.class))).thenReturn(existingCliente);

        Cliente updatedData = new Cliente();
        updatedData.setRun("12.345.678-9");
        updatedData.setNombre("Pedro Actualizado");
        updatedData.setApellido("López");
        updatedData.setFec_naciemiento("1985-05-05");
        updatedData.setEmail("pedro.lopez@example.com");
        updatedData.setDireccion("Nueva Dirección 456");

        Cliente updatedCliente = clienteService.updateCliente(id, updatedData);

        assertEquals("Pedro Actualizado", updatedCliente.getNombre());
        assertEquals("López", updatedCliente.getApellido());
        assertEquals("pedro.lopez@example.com", updatedCliente.getEmail());
        assertEquals("Nueva Dirección 456", updatedCliente.getDireccion());
    }
}