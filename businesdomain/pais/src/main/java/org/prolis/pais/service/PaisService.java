package org.prolis.pais.service;

import org.prolis.pais.entity.Pais;

import java.util.List;
import java.util.Optional;

public interface PaisService {
    Pais guardarPais(Pais p);
    Optional<Pais> listarPorId(Long id);
    List<Pais> obtenerPais();
    Pais actualizarPais(Pais p);
    void eliminarPais(Long id);
}
