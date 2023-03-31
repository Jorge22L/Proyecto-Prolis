package org.prolis.pais.service.Impl;

import lombok.RequiredArgsConstructor;
import org.prolis.pais.entity.Pais;
import org.prolis.pais.repository.PaisRepository;
import org.prolis.pais.service.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaisServiceImpl implements PaisService {

    @Autowired
    private final PaisRepository paisRepository;
    @Override
    public Pais guardarPais(Pais p) {
        return paisRepository.save(p);
    }

    @Override
    public Pais listarPorId(Long id) {
        return null;
    }

    @Override
    public List<Pais> obtenerPais() {
        return paisRepository.findAll();
    }

    @Override
    public Pais actualizarPais(Pais p) {
        return null;
    }

    @Override
    public void eliminarPais(Long id) {

    }
}
