package org.prolis.pais.service.Impl;

import lombok.RequiredArgsConstructor;
import org.prolis.pais.entity.Pais;
import org.prolis.pais.repository.PaisRepository;
import org.prolis.pais.service.PaisService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PaisServiceImpl implements PaisService {
    private final PaisRepository paisRepository;
    @Override
    public Pais guardarPais(Pais p) {
        return paisRepository.save(p);
    }

    @Override
    public Optional<Pais> listarPorId(Long id) {
        return paisRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Pais> obtenerPais() {
        return paisRepository.findAll();
    }

    @Override
    public Pais actualizarPais(Pais p) {
        Pais consulta = paisRepository.findById(p.getIdpais()).get();
        consulta.setDescripcion(p.getDescripcion());
        return paisRepository.save(consulta);

    }

    @Override
    public void eliminarPais(Long id) {
        paisRepository.deleteById(id);
    }
}
