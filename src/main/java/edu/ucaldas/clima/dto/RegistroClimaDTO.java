package edu.ucaldas.clima.dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistroClimaDTO {

    private Double temperatura;
    private Integer humedad;
    private String descripcion;
}
