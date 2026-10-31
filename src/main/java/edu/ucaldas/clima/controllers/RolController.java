package edu.ucaldas.clima.controllers;

import edu.ucaldas.clima.domain.RolService;
import edu.ucaldas.clima.dto.RolDTO;
import edu.ucaldas.clima.model.Rol;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class RolController {
    private final RolService service;

    public RolController(RolService service) {
        this.service = service;
    }

    @GetMapping
    public List<Rol> listar() { return service.listar(); }

    @GetMapping("/{id}")
    public Rol buscar(@PathVariable Long id) { return service.buscar(id); }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Rol crear(@Valid @RequestBody RolDTO dto) { return service.crear(dto); }
}
