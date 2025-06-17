// filepath: [CarritoServiceTest.java](http://_vscodecontentref_/8)
package com.Fullstack.Fullstack;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.Fullstack.Fullstack.model.Carrito;
import com.Fullstack.Fullstack.repository.CarritoRepository;
import com.Fullstack.Fullstack.service.CarritoService; // Asegúrate de que el paquete es correcto
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class CarritoServiceTest {

    @Autowired
    private CarritoService carritoService;

    @MockBean
    private CarritoRepository carritoRepository;

    @Test
    public void testGetAllCarritos() {
        Carrito carrito1 = new Carrito();
        Carrito carrito2 = new Carrito();
        when(carritoRepository.findAll()).thenReturn(List.of(carrito1, carrito2));

        List<Carrito> carritos = carritoService.getAllCarritos();
        assertEquals(2, carritos.size());
    }

    @Test
    public void testGetCarritoById() {
        Long id = 1L;
        Carrito carrito = new Carrito();
        when(carritoRepository.findById(id)).thenReturn(Optional.of(carrito));

        Carrito foundCarrito = carritoService.getCarritoById(id);
        assertNotNull(foundCarrito);
    }

    @Test
    public void testSaveCarrito() {
        Carrito carrito = new Carrito();
        when(carritoRepository.save(carrito)).thenReturn(carrito);

        Carrito savedCarrito = carritoService.saveCarrito(carrito); // Usa el nombre correcto del método
        assertNotNull(savedCarrito);
    }

    @Test
    public void testDeleteCarrito() {
        Long id = 1L;
        doNothing().when(carritoRepository).deleteById(id);

        String response = carritoService.deleteCarrito(id); // Usa el nombre correcto del método
        assertEquals("Carrito eliminado", response);
    }

    @Test
    public void testUpdateCarrito() {
        Long id = 1L;
        Carrito existingCarrito = new Carrito();
        existingCarrito.setCant_producto(5);
        existingCarrito.setDescripcion_carrito("Old Description");
        existingCarrito.setPrecio_carrito(100);

        when(carritoRepository.findById(id)).thenReturn(Optional.of(existingCarrito));
        when(carritoRepository.save(any(Carrito.class))).thenReturn(existingCarrito);

        Carrito updatedData = new Carrito();
        updatedData.setCant_producto(10);
        updatedData.setDescripcion_carrito("New Description");
        updatedData.setPrecio_carrito(200);

        Carrito updatedCarrito = carritoService.updateCarrito(id, updatedData);

        assertEquals(10, updatedCarrito.getCant_producto());
        assertEquals("New Description", updatedCarrito.getDescripcion_carrito());
        assertEquals(200.0, updatedCarrito.getPrecio_carrito());
    }
}