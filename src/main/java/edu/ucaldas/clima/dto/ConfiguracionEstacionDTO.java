package edu.ucaldas.clima.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConfiguracionEstacionDTO {
    @NotNull
    @Positive
    private Integer intervaloMinutos;

    @NotBlank
    private String proveedor;

    @NotNull
    private Long estacionId;
}
