package edu.ucaldas.clima.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class AlertaDTO {
    @NotBlank
    @Size(max = 250)
    private String descripcion;

    @NotBlank
    private String nivel;

    @NotNull
    private LocalDateTime fecha;

    @NotNull
    private Boolean activa;

    @NotNull
    private Long registroClimaId;
}
