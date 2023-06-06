package org.prolis.departamento.service;

import org.prolis.departamento.entity.Departamento;

import java.util.List;
import java.util.Optional;

public interface DepartamentoService {
    Departamento guardarDepartamento(Departamento p);
    Optional<Departamento> listarPorId(Long id);
    List<Departamento> obtenerDepartamento();
    Departamento actualizarPais(Departamento p);
    void eliminarDepartamento(Long id);
}
