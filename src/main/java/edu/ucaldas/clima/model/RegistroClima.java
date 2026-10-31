package edu.ucaldas.clima.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Entity(name = "RegistroClima")
public class RegistroClima {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double temperatura;
    private Integer humedad;

    @Column(length = 50)
    private String descripcion;

    public RegistroClima(){}

    public RegistroClima(Double temperatura, Integer humedad, String descripcion) {
        this.temperatura = temperatura;
        this.humedad = humedad;
        this.descripcion = descripcion;
    }
}

