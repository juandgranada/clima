package edu.ucaldas.clima.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "configuraciones_estacion")
public class ConfiguracionEstacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer intervaloMinutos;

    @Column(nullable = false, length = 100)
    private String proveedor;

    @OneToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "estacion_id", nullable = false, unique = true)
    private Estacion estacion;

    public ConfiguracionEstacion(Integer intervaloMinutos, String proveedor, Estacion estacion) {
        this.intervaloMinutos = intervaloMinutos;
        this.proveedor = proveedor;
        this.estacion = estacion;
    }
}
