package edu.ucaldas.clima.domain;

import edu.ucaldas.clima.dto.TipoMedicionDTO;
import edu.ucaldas.clima.model.TipoMedicion;
import edu.ucaldas.clima.persistance.TipoMedicionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoMedicionService {
    private final TipoMedicionRepository repository;

    public TipoMedicionService(TipoMedicionRepository repository) {
        this.repository = repository;
    }

    public List<TipoMedicion> listar() {
        return repository.findAll();
    }

    public TipoMedicion buscar(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Tipo de medicion no encontrado: " + id));
    }

    public TipoMedicion crear(TipoMedicionDTO dto) {
        return repository.save(new TipoMedicion(dto.getNombre(), dto.getUnidad(), dto.getDescripcion()));
    }

    public TipoMedicion actualizar(Long id, TipoMedicionDTO dto) {
        TipoMedicion tipo = buscar(id);
        tipo.setNombre(dto.getNombre());
        tipo.setUnidad(dto.getUnidad());
        tipo.setDescripcion(dto.getDescripcion());
        return repository.save(tipo);
    }

    public void eliminar(Long id) {
        repository.delete(buscar(id));
    }
}
