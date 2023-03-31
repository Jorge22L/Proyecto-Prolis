package org.prolis.pais.controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.prolis.pais.entity.Pais;
import org.prolis.pais.service.PaisService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
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
}
