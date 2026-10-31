package edu.ucaldas.clima.persistance;

import edu.ucaldas.clima.model.Alerta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlertaRepository extends JpaRepository<Alerta, Long> {
    List<Alerta> findByNivelIgnoreCase(String nivel);

    List<Alerta> findByActivaTrueAndRegistroClimaEstacionCiudadId(Long ciudadId);
}
