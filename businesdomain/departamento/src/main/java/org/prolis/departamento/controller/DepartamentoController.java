package org.prolis.departamento.controller;

import jakarta.ws.rs.Path;
import lombok.AllArgsConstructor;
import org.prolis.departamento.entity.Departamento;
import org.prolis.departamento.service.DepartamentoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("api/departamentos")
public class DepartamentoController {
    private DepartamentoService departamentoService;

    @GetMapping
    public ResponseEntity<List<Departamento>> listarDepartamentos(){
        List<Departamento> departamentos = departamentoService.obtenerDepartamento();
        return new ResponseEntity<>(departamentos, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Departamento> guardarDepartamento(@RequestBody Departamento d){
        Departamento dp = departamentoService.guardarDepartamento(d);
        return new ResponseEntity<>(dp, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Departamento> listarDepartamentoPorId(@PathVariable Long id){
        Optional<Departamento> d = departamentoService.listarPorId(id);
        if(d.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        else{
            return ResponseEntity.ok().body(d.get());
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<Departamento> actualizarDepartamento(@PathVariable Long id, @RequestBody Departamento departamento){
        Optional<Departamento> departamentoDb = departamentoService.listarPorId(id);
        if(departamentoDb.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        else{
            Departamento dp_edit = departamentoDb.get();
            dp_edit.setDescripcion(departamento.getDescripcion());
            dp_edit.setIdPais(departamento.getIdPais());
            return ResponseEntity.status(HttpStatus.CREATED).body(departamentoService.actualizarPais(dp_edit));
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> eliminarDepartamento(@PathVariable Long id){
        departamentoService.eliminarDepartamento(id);
        return new ResponseEntity<>("Departamento eliminado correctamente", HttpStatus.OK);
    }
}
