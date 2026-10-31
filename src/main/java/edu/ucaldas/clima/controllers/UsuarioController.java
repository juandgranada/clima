package edu.ucaldas.clima.controllers;

import edu.ucaldas.clima.domain.UsuarioService;
import edu.ucaldas.clima.dto.UsuarioDTO;
import edu.ucaldas.clima.model.Usuario;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @GetMapping
    public List<Usuario> listar() { return service.listar(); }

    @GetMapping("/{id}")
    public Usuario buscar(@PathVariable Long id) { return service.buscar(id); }

    @GetMapping("/rol/{nombre}")
    public List<Usuario> listarPorRol(@PathVariable String nombre) { return service.listarPorRol(nombre); }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario crear(@Valid @RequestBody UsuarioDTO dto) { return service.crear(dto); }

    @PostMapping("/{id}/roles/{rolId}")
    public Usuario asignarRol(@PathVariable Long id, @PathVariable Long rolId) { return service.asignarRol(id, rolId); }
}
