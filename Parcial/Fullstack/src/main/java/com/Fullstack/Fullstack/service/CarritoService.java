package com.Fullstack.Fullstack.service;

import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.Fullstack.Fullstack.model.Carrito;
import jakarta.transaction.Transactional;
import com.Fullstack.Fullstack.repository.CarritoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import java.util.List;

@Service
@Transactional
public class CarritoService {

    @Autowired
    private CarritoRepository carritoRepository;

    public List<Carrito> getAllCarritos() {
        return carritoRepository.findAll();
    }

    public Carrito getCarritoById(Long id_carrito) {
        return carritoRepository.findById(id_carrito)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Carrito no encontrado"));
    }

    public Carrito save(Carrito carrito) {
        return carritoRepository.save(carrito);
    }

    public String delete(Long id_carrito) {
        carritoRepository.deleteById(id_carrito);
        return "Carrito eliminado";
    }
    
    public Carrito updateCarrito(Long id_carrito, Carrito carrito) {
        Carrito existingCarrito = carritoRepository.findById(id_carrito)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Carrito no encontrado"));

        // Actualiza los campos necesarios (¡CUIDADO con seguridad!  No actualizar todo ciegamente)
            existingCarrito.setCant_producto(carrito.getCant_producto());
            existingCarrito.setDescripcion_carrito(carrito.getDescripcion_carrito());
            existingCarrito.setPrecio_carrito(carrito.getPrecio_carrito());


            return carritoRepository.save(existingCarrito);
    }

}
