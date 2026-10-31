package edu.ucaldas.clima.persistance;

import edu.ucaldas.clima.model.RegistroClima;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RegistroClimaRepository extends JpaRepository<RegistroClima, Long> {
	List<RegistroClima> findByEstacionId(Long estacionId);

	List<RegistroClima> findByTemperaturaGreaterThan(Double temperatura);

	@Query("SELECT AVG(r.temperatura) FROM RegistroClima r WHERE r.estacion.ciudad.id = :ciudadId")
	Double obtenerTemperaturaPromedio(@Param("ciudadId") Long ciudadId);
}
