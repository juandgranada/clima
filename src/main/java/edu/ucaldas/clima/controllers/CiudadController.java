package edu.ucaldas.clima.controllers;

import edu.ucaldas.clima.domain.CiudadService;
import edu.ucaldas.clima.dto.CiudadDTO;
import edu.ucaldas.clima.model.Ciudad;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ciudades")
public class CiudadController {
    private final CiudadService service;

    public CiudadController(CiudadService service) {
        this.service = service;
    }

    @GetMapping
    public List<Ciudad> listar() { return service.listar(); }

    @GetMapping("/{id}")
    public Ciudad buscar(@PathVariable Long id) { return service.buscar(id); }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Ciudad crear(@Valid @RequestBody CiudadDTO dto) { return service.crear(dto); }

    @PutMapping("/{id}")
    public Ciudad actualizar(@PathVariable Long id, @Valid @RequestBody CiudadDTO dto) { return service.actualizar(id, dto); }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) { service.eliminar(id); }
}
