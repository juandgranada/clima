package edu.ucaldas.clima.persistance;

import edu.ucaldas.clima.model.TipoMedicion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoMedicionRepository extends JpaRepository<TipoMedicion, Long> {
}
