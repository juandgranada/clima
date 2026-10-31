package edu.ucaldas.clima.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "registros_clima")
public class RegistroClima {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Double temperatura;

    @Column(nullable = false)
    private Integer humedad;

    @Column(nullable = false)
    private Double presion;

    @Column(nullable = false)
    private LocalDateTime fecha;

    @Column(length = 50)
    private String descripcion;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "estacion_id", nullable = false)
    private Estacion estacion;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "registros_tipos_medicion",
            joinColumns = @JoinColumn(name = "registro_clima_id"),
            inverseJoinColumns = @JoinColumn(name = "tipo_medicion_id"))
    private List<TipoMedicion> tiposMedicion = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "registroClima", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Alerta> alertas = new ArrayList<>();

    public RegistroClima(Double temperatura, Integer humedad, String descripcion) {
        this.temperatura = temperatura;
        this.humedad = humedad;
        this.presion = 0.0;
        this.fecha = LocalDateTime.now();
        this.descripcion = descripcion;
    }

    public RegistroClima(Double temperatura, Integer humedad, Double presion,
                          LocalDateTime fecha, String descripcion, Estacion estacion) {
        this.temperatura = temperatura;
        this.humedad = humedad;
        this.presion = presion;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.estacion = estacion;
    }
}

