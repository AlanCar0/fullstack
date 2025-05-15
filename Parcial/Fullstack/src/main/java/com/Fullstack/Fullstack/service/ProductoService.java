package com.Fullstack.Fullstack.service;

import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.Fullstack.Fullstack.model.Producto;
import jakarta.transaction.Transactional;
import com.Fullstack.Fullstack.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import java.util.List;

@Service
@Transactional
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> getAllProductos() {
        return productoRepository.findAll();
    }

    public Producto getProductoById(Long id_producto) {
        return productoRepository.findById(id_producto)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Producto no encontrado"));
    }

    public Producto save(Producto producto) {
        return productoRepository.save(producto);
    }

    public String delete(Long id_producto) {
        productoRepository.deleteById(id_producto);
        return "Producto eliminado";
    }
    
    public Producto updateProducto(Long id_producto, Producto producto) {
        Producto existingProducto = productoRepository.findById(id_producto)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Producto no encontrado"));

        // Actualiza los campos necesarios (¡CUIDADO con seguridad!  No actualizar todo ciegamente)
            existingProducto.setNombre(producto.getNombre());
            existingProducto.setPrecio(producto.getPrecio());
            existingProducto.setStock(producto.getStock());
            existingProducto.setDescripcion(producto.getDescripcion());

            return productoRepository.save(existingProducto);
    }


}
