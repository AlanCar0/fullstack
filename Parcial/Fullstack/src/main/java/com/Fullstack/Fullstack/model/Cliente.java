package com.Fullstack.Fullstack.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cliente")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Para generar un ID único automáticamente
    private Long id;
    @Column (nullable = false, unique = true)
    private String run;  
    @Column (nullable = false)
    private String nombre;
    @Column (nullable = false)
    private String apellido;
    @Column (nullable = false, name = "FECHA_NACIMIENTO")
    private String fec_naciemiento;
    @Column (nullable = false)
    private String email;
    @Column (nullable = false)
    private String direccion;

}


