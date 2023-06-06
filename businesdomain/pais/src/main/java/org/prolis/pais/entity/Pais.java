package org.prolis.pais.entity;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
public class Pais{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idpais;
    private String descripcion;

}
