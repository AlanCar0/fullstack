package com.Fullstack.Fullstack.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.Fullstack.Fullstack.model.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long>  {

}
