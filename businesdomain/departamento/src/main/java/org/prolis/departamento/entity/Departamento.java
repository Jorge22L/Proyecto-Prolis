package org.prolis.departamento.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Departamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDepartamento;
    private String descripcion;
    private Long idPais;

}
