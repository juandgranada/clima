package edu.ucaldas.clima.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RolDTO {
    @NotBlank
    private String nombre;

    @Size(max = 200)
    private String descripcion;
}
