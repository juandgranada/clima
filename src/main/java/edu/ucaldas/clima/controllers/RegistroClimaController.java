package edu.ucaldas.clima.controllers;

import edu.ucaldas.clima.dto.RegistroClimaDTO;
import edu.ucaldas.clima.model.RegistroClima;
import edu.ucaldas.clima.domain.RegistroClimaService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/api/registros-clima", "/api/mediciones"})
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

    @GetMapping("/estacion/{id}")
    public List<RegistroClima> listarPorEstacion(@PathVariable Long id) {
        return service.listarPorEstacion(id);
    }

    @GetMapping("/temperatura-superior")
    public List<RegistroClima> listarTemperaturaSuperior(@RequestParam Double valor) {
        return service.listarTemperaturaSuperior(valor);
    }

    @GetMapping("/promedio/ciudad/{id}")
    public Double promedioPorCiudad(@PathVariable Long id) {
        return service.promedioTemperaturaPorCiudad(id);
    }

    @PostMapping
    @ResponseStatus(org.springframework.http.HttpStatus.CREATED)
    public RegistroClima crear(@Valid @RequestBody RegistroClimaDTO registroClima) {
        return service.crear(registroClima);
    }

    @PutMapping("/{id}")
    public RegistroClima actualizar(@PathVariable Long id, @Valid @RequestBody RegistroClimaDTO registroClima) {
        return service.actualizar(id, registroClima);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(org.springframework.http.HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}

