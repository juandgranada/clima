package edu.ucaldas.clima.domain;

import edu.ucaldas.clima.dto.EstacionDTO;
import edu.ucaldas.clima.model.Ciudad;
import edu.ucaldas.clima.model.Estacion;
import edu.ucaldas.clima.persistance.CiudadRepository;
import edu.ucaldas.clima.persistance.EstacionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstacionService {
    private final EstacionRepository repository;
    private final CiudadRepository ciudadRepository;

    public EstacionService(EstacionRepository repository, CiudadRepository ciudadRepository) {
        this.repository = repository;
        this.ciudadRepository = ciudadRepository;
    }

    public List<Estacion> listar() {
        return repository.findAll();
    }

    public Estacion buscar(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Estacion no encontrada: " + id));
    }

    public List<Estacion> listarPorCiudad(Long ciudadId) {
        validarCiudad(ciudadId);
        return repository.findByCiudadId(ciudadId);
    }

    public Estacion crear(EstacionDTO dto) {
        Ciudad ciudad = validarCiudad(dto.getCiudadId());
        return repository.save(new Estacion(dto.getNombre(), dto.getCodigo(), dto.getUbicacion(), dto.getEstado(), ciudad));
    }

    public Estacion actualizar(Long id, EstacionDTO dto) {
        Estacion estacion = buscar(id);
        estacion.setNombre(dto.getNombre());
        estacion.setCodigo(dto.getCodigo());
        estacion.setUbicacion(dto.getUbicacion());
        estacion.setEstado(dto.getEstado());
        estacion.setCiudad(validarCiudad(dto.getCiudadId()));
        return repository.save(estacion);
    }

    public void eliminar(Long id) {
        repository.delete(buscar(id));
    }

    private Ciudad validarCiudad(Long id) {
        return ciudadRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Ciudad no encontrada: " + id));
    }
}
