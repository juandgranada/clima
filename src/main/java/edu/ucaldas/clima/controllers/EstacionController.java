package edu.ucaldas.clima.controllers;

import edu.ucaldas.clima.domain.EstacionService;
import edu.ucaldas.clima.dto.EstacionDTO;
import edu.ucaldas.clima.model.Estacion;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estaciones")
public class EstacionController {
    private final EstacionService service;

    public EstacionController(EstacionService service) {
        this.service = service;
    }

    @GetMapping
    public List<Estacion> listar() { return service.listar(); }

    @GetMapping("/{id}")
    public Estacion buscar(@PathVariable Long id) { return service.buscar(id); }

    @GetMapping("/ciudad/{id}")
    public List<Estacion> listarPorCiudad(@PathVariable Long id) { return service.listarPorCiudad(id); }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Estacion crear(@Valid @RequestBody EstacionDTO dto) { return service.crear(dto); }

    @PutMapping("/{id}")
    public Estacion actualizar(@PathVariable Long id, @Valid @RequestBody EstacionDTO dto) { return service.actualizar(id, dto); }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) { service.eliminar(id); }
}
