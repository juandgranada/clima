package edu.ucaldas.clima.controllers;

import edu.ucaldas.clima.domain.TipoMedicionService;
import edu.ucaldas.clima.dto.TipoMedicionDTO;
import edu.ucaldas.clima.model.TipoMedicion;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tipos-medicion")
public class TipoMedicionController {
    private final TipoMedicionService service;

    public TipoMedicionController(TipoMedicionService service) {
        this.service = service;
    }

    @GetMapping
    public List<TipoMedicion> listar() { return service.listar(); }

    @GetMapping("/{id}")
    public TipoMedicion buscar(@PathVariable Long id) { return service.buscar(id); }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TipoMedicion crear(@Valid @RequestBody TipoMedicionDTO dto) { return service.crear(dto); }

    @PutMapping("/{id}")
    public TipoMedicion actualizar(@PathVariable Long id, @Valid @RequestBody TipoMedicionDTO dto) { return service.actualizar(id, dto); }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) { service.eliminar(id); }
}
