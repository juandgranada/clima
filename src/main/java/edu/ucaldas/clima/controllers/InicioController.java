package edu.ucaldas.clima.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class InicioController {
    @GetMapping("/")
    public Map<String, String> inicio() {
        return Map.of(
                "aplicacion", "clima",
                "estado", "activa",
                "api", "/api",
                "documentacion", "README.md"
        );
    }
}
