package org.prolis.usuario.service;

import org.prolis.usuario.entity.Paciente;

import java.util.List;

public interface PacienteService {
    Paciente crearPaciente(Paciente p);
    Paciente listarPorId(Long id);
    List<Paciente> obtenerPacientes();
    Paciente actualizarPaciente(Paciente p);
    void eliminarPaciente(Long id);
}
