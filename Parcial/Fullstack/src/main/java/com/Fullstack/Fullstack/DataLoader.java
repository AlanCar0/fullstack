package com.Fullstack.Fullstack;

import net.datafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import java.util.Date;
import java.util.List;
import java.util.Random;
import com.Fullstack.Fullstack.model.*;
import com.Fullstack.Fullstack.repository.*;

@Component
@Profile("dev")
public class DataLoader implements CommandLineRunner {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private CarritoRepository carritoRepository;

    @Autowired
    private ProductoRepository productoRepository;

    private Faker faker = new Faker();
    private Random random = new Random();

    @Override
    public void run(String... args) throws Exception {
        cargarDatos();
    }

    private void cargarDatos() {
        // Cargar datos de ejemplo en las tablas
        cargarClientes();
        cargarCarritos();
        cargarProductos();
    }

    private void cargarClientes() {
        for (int i = 0; i < 10; i++) {
            Cliente cliente = new Cliente();
            cliente.setNombre(faker.name().fullName());
            cliente.setEmail(faker.internet().emailAddress());
            cliente.setFechaRegistro(faker.date().past(365, TimeUnit.DAYS));
            clienteRepository.save(cliente);
        }
    }

    private void cargarCarritos() {
        List<Cliente> clientes = clienteRepository.findAll();
        for (Cliente cliente : clientes) {
            Carrito carrito = new Carrito();
            carrito.setCliente(cliente);
            carrito.setFechaCreacion(new Date());
            carritoRepository.save(carrito);
        }
    }

    private void cargarProductos() {
        for (int i = 0; i < 20; i++) {
            Producto producto = new Producto();
            producto.setNombre(faker.commerce().productName());
            producto.setPrecio(faker.commerce().price(10.0, 100.0));
            producto.setDescripcion(faker.lorem().sentence());
            productoRepository.save(producto);
        }
    }
}
