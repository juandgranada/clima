package edu.ucaldas.clima.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "estaciones", uniqueConstraints = @UniqueConstraint(name = "uk_estacion_codigo", columnNames = "codigo"))
public class Estacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false, length = 50)
    private String codigo;

    @Column(nullable = false, length = 150)
    private String ubicacion;

    @Column(nullable = false, length = 30)
    private String estado;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "ciudad_id", nullable = false)
    private Ciudad ciudad;

    @JsonIgnore
    @OneToMany(mappedBy = "estacion", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RegistroClima> registros = new ArrayList<>();

    @JsonIgnore
    @OneToOne(mappedBy = "estacion", cascade = CascadeType.ALL, orphanRemoval = true)
    private ConfiguracionEstacion configuracion;

    public Estacion(String nombre, String codigo, String ubicacion, String estado, Ciudad ciudad) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.ubicacion = ubicacion;
        this.estado = estado;
        this.ciudad = ciudad;
    }
}
