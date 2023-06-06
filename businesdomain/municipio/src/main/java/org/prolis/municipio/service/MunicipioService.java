package org.prolis.municipio.service;

import org.prolis.municipio.entity.Municipio;

import java.util.List;
import java.util.Optional;

public interface MunicipioService {
    Municipio guardarMunicipio(Municipio m);

    Optional<Municipio> listarPorId(Long id);
    List<Municipio> listar();
    Municipio actualizarMunicipio(Municipio m);
    void eliminarMunicipio(Long id);
}
