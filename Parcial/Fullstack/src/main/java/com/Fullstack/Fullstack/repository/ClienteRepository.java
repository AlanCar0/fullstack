package com.Fullstack.Fullstack.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.Fullstack.Fullstack.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {  // Usando Long para el ID

    // JpaRepository ya tiene:
    // findAll(), findById(), save(), deleteById()

    // Mantenlos SOLO si los necesitas:
    // List<Cliente> findByRunAndDvrun(Long run, String dvrun);
    // List<Cliente> findByNombreAndApellidoAndEmail(String nombre, String apellido, String email);
    // List<Cliente> findByNombreAndApellido(String nombre, String apellido);

}