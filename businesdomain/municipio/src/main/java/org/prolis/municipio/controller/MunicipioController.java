package org.prolis.municipio.controller;

import lombok.AllArgsConstructor;
import org.prolis.municipio.entity.Municipio;
import org.prolis.municipio.service.MunicipioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("api/municipios")
public class MunicipioController {
    private MunicipioService municipioService;

    @GetMapping
    public ResponseEntity<List<Municipio>> listarMunicipio(){
        List<Municipio> municipios = municipioService.listar();
        return new ResponseEntity<>(municipios, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Municipio> listarPorId(@PathVariable Long id){
        Optional<Municipio> municipio = municipioService.listarPorId(id);
        if(municipio.isEmpty())
        {
            return ResponseEntity.notFound().build();
        }
        else{
            return ResponseEntity.ok().body(municipio.get());
        }
    }

    @PostMapping
    public ResponseEntity<Municipio> guardarMunicipio(@RequestBody Municipio municipio){
        Municipio m = municipioService.guardarMunicipio(municipio);
        return new ResponseEntity<>(m,HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<Municipio> actualizarMunicipio(@PathVariable Long id, @RequestBody Municipio municipio){
        Optional<Municipio> consulta = municipioService.listarPorId(id);
        if(consulta.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        else{
            Municipio municipio_edit = consulta.get();
            municipio_edit.setDescripcion(municipio.getDescripcion());
            municipio_edit.setIdDepartamento(municipio.getIdDepartamento());
            municipio_edit.setIdPais(municipio.getIdPais());
            return ResponseEntity.status(HttpStatus.CREATED).body(municipioService.actualizarMunicipio(municipio_edit));
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> eliminarMunicipio(@PathVariable Long id){
        municipioService.eliminarMunicipio(id);
        return new ResponseEntity<>("Municipio eliminado correctamente", HttpStatus.OK);
    }
}
