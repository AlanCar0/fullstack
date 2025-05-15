package com.Fullstack.Fullstack.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "carrito")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Carrito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_carrito; 

    @Column(nullable = false, name = "CANT_PRODUCTO")
    private int cant_producto; ;

    @Column(nullable = false)
    private String descripcion_carrito;

    @Column(nullable = false)
    private int precio_carrito;


}
