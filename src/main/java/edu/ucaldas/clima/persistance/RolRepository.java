package edu.ucaldas.clima.persistance;

import edu.ucaldas.clima.model.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolRepository extends JpaRepository<Rol, Long> {
}
