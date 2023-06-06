package org.prolis.departamento.repository;

import org.prolis.departamento.entity.Departamento;
import org.prolis.departamento.service.DepartamentoService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {
}
