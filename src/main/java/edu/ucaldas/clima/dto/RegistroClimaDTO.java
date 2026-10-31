package edu.ucaldas.clima.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistroClimaDTO {

    private Double temperatura;
    private Integer humedad;
    private String descripcion;
}
