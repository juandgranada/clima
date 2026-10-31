package edu.ucaldas.clima.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CiudadDTO {
    @NotBlank
    private String nombre;

    @NotBlank
    private String departamento;

    @NotNull
    @Positive
    private Long poblacion;
}
