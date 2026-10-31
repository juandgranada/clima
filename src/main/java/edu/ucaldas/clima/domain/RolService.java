package edu.ucaldas.clima.domain;

import edu.ucaldas.clima.dto.RolDTO;
import edu.ucaldas.clima.model.Rol;
import edu.ucaldas.clima.persistance.RolRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolService {
    private final RolRepository repository;

    public RolService(RolRepository repository) {
        this.repository = repository;
    }

    public List<Rol> listar() {
        return repository.findAll();
    }

    public Rol buscar(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Rol no encontrado: " + id));
    }

    public Rol crear(RolDTO dto) {
        return repository.save(new Rol(dto.getNombre(), dto.getDescripcion()));
    }
}
