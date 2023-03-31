package org.prolis.pais.service;

import org.prolis.pais.entity.Pais;

import java.util.List;

public interface PaisService {
    Pais guardarPais(Pais p);
    Pais listarPorId(Long id);
    List<Pais> obtenerPais();
    Pais actualizarPais(Pais p);
    void eliminarPais(Long id);
}
