package edu.ucaldas.clima.controllers;

import edu.ucaldas.clima.dto.RegistroClimaDTO;
import edu.ucaldas.clima.model.RegistroClima;
import edu.ucaldas.clima.domain.RegistroClimaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/registros-clima")
public class RegistroClimaController {
    private final RegistroClimaService service;

    public RegistroClimaController(RegistroClimaService service) {
        this.service = service;
    }

    @GetMapping
    public List<RegistroClima> listar() { return service.listar(); }

    @GetMapping("/{id}")
    public RegistroClima buscar(@PathVariable Long id) {
        return service.buscar(id);
    }

    @PostMapping("/")
    public void buscar(@RequestBody RegistroClimaDTO registroClima) {
        service.crear(registroClima);
    }
    // Agregar POST, PUT /{id} y DELETE /{id}
}

