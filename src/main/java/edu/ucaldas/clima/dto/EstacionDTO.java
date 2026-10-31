package edu.ucaldas.clima.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EstacionDTO {
    @NotBlank
    private String nombre;

    @NotBlank
    private String codigo;

    @NotBlank
    private String ubicacion;

    @NotBlank
    private String estado;

    @NotNull
    private Long ciudadId;
}
