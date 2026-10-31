package edu.ucaldas.clima.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "alertas")
public class Alerta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 250)
    private String descripcion;

    @Column(nullable = false, length = 30)
    private String nivel;

    @Column(nullable = false)
    private LocalDateTime fecha;

    @Column(nullable = false)
    private Boolean activa;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "registro_clima_id", nullable = false)
    private RegistroClima registroClima;

    public Alerta(String descripcion, String nivel, LocalDateTime fecha, Boolean activa, RegistroClima registroClima) {
        this.descripcion = descripcion;
        this.nivel = nivel;
        this.fecha = fecha;
        this.activa = activa;
        this.registroClima = registroClima;
    }
}
