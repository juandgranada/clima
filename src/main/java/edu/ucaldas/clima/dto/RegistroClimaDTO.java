package edu.ucaldas.clima.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class RegistroClimaDTO {

    @NotNull
    private Double temperatura;

    @NotNull
    @Min(0)
    @Max(100)
    private Integer humedad;

    @NotNull
    private Double presion;

    @NotNull
    private LocalDateTime fecha;

    @Size(max = 50)
    private String descripcion;

    @NotNull
    private Long estacionId;

    private List<Long> tiposMedicionIds = new ArrayList<>();
}
