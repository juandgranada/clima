package edu.ucaldas.clima.persistance;

import edu.ucaldas.clima.model.RegistroClima;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistroClimaRepository extends JpaRepository<RegistroClima, Long> {
}
