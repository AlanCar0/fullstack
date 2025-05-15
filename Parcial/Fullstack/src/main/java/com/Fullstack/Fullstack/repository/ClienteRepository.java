package com.Fullstack.Fullstack.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.Fullstack.Fullstack.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    //  JpaRepository<Cliente, Long>  <---  El 'Long' aquí debe coincidir con el tipo de 'id' en Cliente.java
}