package edu.ucaldas.clima.controllers;

import edu.ucaldas.clima.domain.AlertaService;
import edu.ucaldas.clima.dto.AlertaDTO;
import edu.ucaldas.clima.model.Alerta;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alertas")
public class AlertaController {
    private final AlertaService service;

    public AlertaController(AlertaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Alerta> listar() { return service.listar(); }

    @GetMapping("/{id}")
    public Alerta buscar(@PathVariable Long id) { return service.buscar(id); }

    @GetMapping("/nivel/{nivel}")
    public List<Alerta> listarPorNivel(@PathVariable String nivel) { return service.listarPorNivel(nivel); }

    @GetMapping("/activas/ciudad/{id}")
    public List<Alerta> listarActivasPorCiudad(@PathVariable Long id) { return service.listarActivasPorCiudad(id); }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Alerta crear(@Valid @RequestBody AlertaDTO dto) { return service.crear(dto); }
}
