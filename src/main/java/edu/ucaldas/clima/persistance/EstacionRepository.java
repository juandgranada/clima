package edu.ucaldas.clima.persistance;

import edu.ucaldas.clima.model.Estacion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EstacionRepository extends JpaRepository<Estacion, Long> {
    List<Estacion> findByCiudadId(Long ciudadId);
}
