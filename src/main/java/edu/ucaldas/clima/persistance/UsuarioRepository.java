package edu.ucaldas.clima.persistance;

import edu.ucaldas.clima.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    List<Usuario> findByRolesNombreIgnoreCase(String nombre);
}
