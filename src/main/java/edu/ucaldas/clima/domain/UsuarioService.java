package edu.ucaldas.clima.domain;

import edu.ucaldas.clima.dto.UsuarioDTO;
import edu.ucaldas.clima.model.Rol;
import edu.ucaldas.clima.model.Usuario;
import edu.ucaldas.clima.persistance.RolRepository;
import edu.ucaldas.clima.persistance.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsuarioService {
    private final UsuarioRepository repository;
    private final RolRepository rolRepository;

    public UsuarioService(UsuarioRepository repository, RolRepository rolRepository) {
        this.repository = repository;
        this.rolRepository = rolRepository;
    }

    public List<Usuario> listar() {
        return repository.findAll();
    }

    public Usuario buscar(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Usuario no encontrado: " + id));
    }

    public Usuario crear(UsuarioDTO dto) {
        return repository.save(new Usuario(dto.getNombre(), dto.getCorreo(), dto.getContrasena()));
    }

    @Transactional
    public Usuario asignarRol(Long usuarioId, Long rolId) {
        Usuario usuario = buscar(usuarioId);
        Rol rol = rolRepository.findById(rolId)
                .orElseThrow(() -> new RecursoNoEncontradoException("Rol no encontrado: " + rolId));
        if (!usuario.getRoles().contains(rol)) {
            usuario.getRoles().add(rol);
        }
        return repository.save(usuario);
    }

    public List<Usuario> listarPorRol(String nombre) {
        return repository.findByRolesNombreIgnoreCase(nombre);
    }
}
