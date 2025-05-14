package com.Fullstack.Fullstack.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Fullstack.Fullstack.model.Cliente;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    // Método heredado para encontrar todos los clientes:
    List<Cliente> findAll();

    List<Cliente> findByRunAndDvrun(Long run, String dvrun);

    List<Cliente> findByNombreAndApellidoAndEmail(String nombre, String apellido, String email);

    List<Cliente> findByNombreAndApellido(String nombre, String apellido);

    // Método para eliminar un cliente por su 'run' (asumiendo que 'run' es un identificador único)
    void deleteByRun(Long run);

    // Si tu clave primaria se llama 'id', usa el método heredado deleteById:
    // void deleteById(Long id);
}