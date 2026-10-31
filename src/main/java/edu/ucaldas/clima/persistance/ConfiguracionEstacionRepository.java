package edu.ucaldas.clima.persistance;

import edu.ucaldas.clima.model.ConfiguracionEstacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConfiguracionEstacionRepository extends JpaRepository<ConfiguracionEstacion, Long> {
}
