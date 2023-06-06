package org.prolis.departamento.service.impl;

import lombok.RequiredArgsConstructor;
import org.prolis.departamento.entity.Departamento;
import org.prolis.departamento.repository.DepartamentoRepository;
import org.prolis.departamento.service.DepartamentoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DepartamentoServiceImpl implements DepartamentoService {
    private final DepartamentoRepository departamentoRepository;
    @Override
    public Departamento guardarDepartamento(Departamento d) {
        return departamentoRepository.save(d);
    }

    @Override
    public Optional<Departamento> listarPorId(Long id) {
        return departamentoRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Departamento> obtenerDepartamento() {
        return departamentoRepository.findAll();
    }

    @Override
    public Departamento actualizarPais(Departamento p) {
        Departamento consulta = departamentoRepository.findById(p.getIdPais()).get();
        consulta.setDescripcion(p.getDescripcion());
        consulta.setIdPais(p.getIdPais());
        return departamentoRepository.save(consulta);
    }

    @Override
    public void eliminarDepartamento(Long id) {
        departamentoRepository.deleteById(id);
    }
}
