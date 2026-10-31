package edu.ucaldas.clima.domain;

import edu.ucaldas.clima.dto.CiudadDTO;
import edu.ucaldas.clima.model.Ciudad;
import edu.ucaldas.clima.persistance.CiudadRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CiudadService {
    private final CiudadRepository repository;

    public CiudadService(CiudadRepository repository) {
        this.repository = repository;
    }

    public List<Ciudad> listar() {
        return repository.findAll();
    }

    public Ciudad buscar(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Ciudad no encontrada: " + id));
    }

    public Ciudad crear(CiudadDTO dto) {
        return repository.save(new Ciudad(dto.getNombre(), dto.getDepartamento(), dto.getPoblacion()));
    }

    public Ciudad actualizar(Long id, CiudadDTO dto) {
        Ciudad ciudad = buscar(id);
        ciudad.setNombre(dto.getNombre());
        ciudad.setDepartamento(dto.getDepartamento());
        ciudad.setPoblacion(dto.getPoblacion());
        return repository.save(ciudad);
    }

    public void eliminar(Long id) {
        repository.delete(buscar(id));
    }
}
