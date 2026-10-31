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
@Table(name = "tipos_medicion")
public class TipoMedicion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 60)
    private String nombre;

    @Column(nullable = false, length = 20)
    private String unidad;

    @Column(length = 200)
    private String descripcion;

    @JsonIgnore
    @ManyToMany(mappedBy = "tiposMedicion")
    private List<RegistroClima> registros = new ArrayList<>();

    public TipoMedicion(String nombre, String unidad, String descripcion) {
        this.nombre = nombre;
        this.unidad = unidad;
        this.descripcion = descripcion;
    }
}
