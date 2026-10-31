package edu.ucaldas.clima.controllers;

import edu.ucaldas.clima.domain.ConfiguracionEstacionService;
import edu.ucaldas.clima.dto.ConfiguracionEstacionDTO;
import edu.ucaldas.clima.model.ConfiguracionEstacion;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/configuraciones-estacion")
public class ConfiguracionEstacionController {
    private final ConfiguracionEstacionService service;

    public ConfiguracionEstacionController(ConfiguracionEstacionService service) {
        this.service = service;
    }

    @GetMapping
    public List<ConfiguracionEstacion> listar() { return service.listar(); }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ConfiguracionEstacion crear(@Valid @RequestBody ConfiguracionEstacionDTO dto) { return service.crear(dto); }
}
