package com.Fullstack.Fullstack.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.Fullstack.Fullstack.model.Carrito;

@Repository
public interface CarritoRepository extends JpaRepository<Carrito, Long> {
    //  JpaRepository<Carrito, Long>  <---  El 'Long' aquí debe coincidir con el tipo de 'id' en Carrito.java

}
