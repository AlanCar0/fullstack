package com.Fullstack.Fullstack;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.Fullstack.Fullstack.model.Producto;
import com.Fullstack.Fullstack.repository.ProductoRepository;
import com.Fullstack.Fullstack.service.ProductoService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class ProductoServiceTest {

    @Autowired
    private ProductoService productoService;

    @MockBean
    private ProductoRepository productoRepository;

    @Test
    public void testGetAllProductos() {
        Producto producto1 = new Producto();
        Producto producto2 = new Producto();
        when(productoRepository.findAll()).thenReturn(List.of(producto1, producto2));

        List<Producto> productos = productoService.getAllProductos();
        assertEquals(2, productos.size());
    }

    @Test
    public void testGetProductoById() {
        Long id = 1L;
        Producto producto = new Producto();
        producto.setNombre("Eros Flame");
        when(productoRepository.findById(id)).thenReturn(Optional.of(producto));

        Producto foundProducto = productoService.getProductoById(id);
        assertNotNull(foundProducto);
        assertEquals("Eros Flame", foundProducto.getNombre());
    }

    @Test
    public void testGetProductoByIdNotFound() {
        Long id = 99L;
        when(productoRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(ResponseStatusException.class, () -> {
            productoService.getProductoById(id);
        });
    }

    @Test
    public void testSaveProducto() {
        Producto producto = new Producto();
        producto.setNombre("Dior Sauvage");
        producto.setDescripcion("Perfume masculino intenso");
        producto.setPrecio(94990);
        producto.setStock(10);

        when(productoRepository.save(producto)).thenReturn(producto);

        Producto savedProducto = productoService.save(producto);
        assertNotNull(savedProducto);
        assertEquals("Dior Sauvage", savedProducto.getNombre());
    }

    @Test
    public void testDeleteProducto() {
        Long id = 1L;
        doNothing().when(productoRepository).deleteById(id);

        String response = productoService.delete(id);
        assertEquals("Producto eliminado", response);
    }

    @Test
    public void testUpdateProducto() {
        Long id = 1L;

        Producto existingProducto = new Producto();
        existingProducto.setNombre("Good Girl");
        existingProducto.setDescripcion("Perfume dulce y elegante");
        existingProducto.setPrecio(79990);
        existingProducto.setStock(5);

        Producto updatedData = new Producto();
        updatedData.setNombre("Good Girl Supreme");
        updatedData.setDescripcion("Versión intensa del perfume original");
        updatedData.setPrecio(89990);
        updatedData.setStock(8);

        when(productoRepository.findById(id)).thenReturn(Optional.of(existingProducto));
        when(productoRepository.save(any(Producto.class))).thenReturn(existingProducto);

        Producto updatedProducto = productoService.updateProducto(id, updatedData);

        assertEquals("Good Girl Supreme", updatedProducto.getNombre());
        assertEquals("Versión intensa del perfume original", updatedProducto.getDescripcion());
        assertEquals(89990, updatedProducto.getPrecio());
        assertEquals(8, updatedProducto.getStock());
    }
}