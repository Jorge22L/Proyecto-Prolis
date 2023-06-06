package org.prolis.municipio.service.impl;

import lombok.RequiredArgsConstructor;
import org.prolis.municipio.entity.Municipio;
import org.prolis.municipio.repository.MunicipioRepository;
import org.prolis.municipio.service.MunicipioService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MunicipioServiceImpl implements MunicipioService {
    private final MunicipioRepository municipioRepository;
    @Override
    public Municipio guardarMunicipio(Municipio m) {
        return municipioRepository.save(m);
    }

    @Override
    public Optional<Municipio> listarPorId(Long id) {
        return municipioRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Municipio> listar() {
        return municipioRepository.findAll();
    }

    @Override
    public Municipio actualizarMunicipio(Municipio m) {
        Municipio consulta = municipioRepository.findById(m.getIdMunicipio()).get();
        consulta.setIdPais(m.getIdPais());
        consulta.setIdDepartamento(m.getIdDepartamento());
        consulta.setDescripcion(m.getDescripcion());
        return municipioRepository.save(consulta);
    }

    @Override
    public void eliminarMunicipio(Long id) {
        municipioRepository.deleteById(id);
    }
}
