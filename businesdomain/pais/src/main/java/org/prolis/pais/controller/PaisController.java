package org.prolis.pais.controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.prolis.pais.entity.Pais;
import org.prolis.pais.service.PaisService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("api/pais")
public class PaisController {
    private PaisService paisService;

    @PostMapping
    public ResponseEntity<Pais> guardarPais(@RequestBody Pais p)
    {
        Pais pais = paisService.guardarPais(p);
        return new ResponseEntity<>(pais, HttpStatus.CREATED);
    }

    // http://localhost:8080/api/pacientes
    @GetMapping
    public ResponseEntity<List<Pais>> listarPais(){
        List<Pais> paises = paisService.obtenerPais();
        return new ResponseEntity<>(paises, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Pais> listarPaisPorId(@PathVariable("id") Long id){
        Optional<Pais> p = paisService.listarPorId(id);
        if(p.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        else {
            return ResponseEntity.ok().body(p.get());
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<Pais> actualizarPais(@PathVariable("id") Long id, @RequestBody Pais pais){
        Optional<Pais> paisDb = paisService.listarPorId(id);
        if(paisDb.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        else{
            Pais pais_edit = paisDb.get();
            pais_edit.setDescripcion(pais.getDescripcion());
            return ResponseEntity.status(HttpStatus.CREATED).body(paisService.actualizarPais(pais_edit));
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> eliminarPais(@PathVariable Long id){
        paisService.eliminarPais(id);
        return new ResponseEntity<>("Pais eliminado correctamente", HttpStatus.OK);
    }
}
