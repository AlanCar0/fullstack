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
    private long run;
    @Column (nullable = false, length = 1)
    private String dv_run;

    @Column (nullable = false, length = 50)
    private String nombre;
    @Column (nullable = false, length = 50)
    private String apellido;
    @Column (nullable = false,length = 50)
    private String email;
    @Column (nullable = false,length = 50)
    private String telefono;
    @Column (nullable = false, length = 50)
    private String direccion;
    @Column (nullable = false, name = "FECHA_NACIMIENTO",length = 10)
    private String fec_naciemiento;

}


