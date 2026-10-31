package edu.ucaldas.clima.persistance;

import edu.ucaldas.clima.model.Ciudad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CiudadRepository extends JpaRepository<Ciudad, Long> {
}
