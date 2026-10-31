package edu.ucaldas.clima.domain;

import edu.ucaldas.clima.dto.ConfiguracionEstacionDTO;
import edu.ucaldas.clima.model.ConfiguracionEstacion;
import edu.ucaldas.clima.model.Estacion;
import edu.ucaldas.clima.persistance.ConfiguracionEstacionRepository;
import edu.ucaldas.clima.persistance.EstacionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConfiguracionEstacionService {
    private final ConfiguracionEstacionRepository repository;
    private final EstacionRepository estacionRepository;

    public ConfiguracionEstacionService(ConfiguracionEstacionRepository repository, EstacionRepository estacionRepository) {
        this.repository = repository;
        this.estacionRepository = estacionRepository;
    }

    public List<ConfiguracionEstacion> listar() {
        return repository.findAll();
    }

    public ConfiguracionEstacion crear(ConfiguracionEstacionDTO dto) {
        Estacion estacion = estacionRepository.findById(dto.getEstacionId())
                .orElseThrow(() -> new RecursoNoEncontradoException("Estacion no encontrada: " + dto.getEstacionId()));
        return repository.save(new ConfiguracionEstacion(dto.getIntervaloMinutos(), dto.getProveedor(), estacion));
    }
}
