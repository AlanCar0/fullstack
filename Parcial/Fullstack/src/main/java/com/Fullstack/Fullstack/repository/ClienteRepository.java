package com.Fullstack.Fullstack.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.Fullstack.Fullstack.model.Cliente;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    List<Cliente> findByRunAndDv_run(Long run, String dv_run);

    List<Cliente> findByNombreAndApellido(String nombre, String apellido);

    List<Cliente> findByEmail(String email);

}
