package edu.ucaldas.clima.domain;

import edu.ucaldas.clima.dto.RegistroClimaDTO;
import edu.ucaldas.clima.model.Estacion;
import edu.ucaldas.clima.model.RegistroClima;
import edu.ucaldas.clima.model.TipoMedicion;
import edu.ucaldas.clima.persistance.EstacionRepository;
import edu.ucaldas.clima.persistance.RegistroClimaRepository;
import edu.ucaldas.clima.persistance.TipoMedicionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistroClimaService {
    private final RegistroClimaRepository repository;
    private final EstacionRepository estacionRepository;
    private final TipoMedicionRepository tipoMedicionRepository;

    public RegistroClimaService(RegistroClimaRepository repository,
                                EstacionRepository estacionRepository,
                                TipoMedicionRepository tipoMedicionRepository) {
        this.repository = repository;
        this.estacionRepository = estacionRepository;
        this.tipoMedicionRepository = tipoMedicionRepository;
    }

    public List<RegistroClima> listar() {
        return repository.findAll();
    }

    public RegistroClima buscar(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Registro de clima no encontrado: " + id));
    }

    public List<RegistroClima> listarPorEstacion(Long estacionId) {
        validarEstacion(estacionId);
        return repository.findByEstacionId(estacionId);
    }

    public List<RegistroClima> listarTemperaturaSuperior(Double temperatura) {
        return repository.findByTemperaturaGreaterThan(temperatura);
    }

    public Double promedioTemperaturaPorCiudad(Long ciudadId) {
        return repository.obtenerTemperaturaPromedio(ciudadId);
    }

    public RegistroClima crear(RegistroClimaDTO dto) {
        Estacion estacion = validarEstacion(dto.getEstacionId());
        RegistroClima registro = new RegistroClima(dto.getTemperatura(), dto.getHumedad(), dto.getPresion(),
                dto.getFecha(), dto.getDescripcion(), estacion);
        registro.setTiposMedicion(resolverTipos(dto.getTiposMedicionIds()));
        return repository.save(registro);
    }

    public RegistroClima actualizar(Long id, RegistroClimaDTO dto) {
        RegistroClima registro = buscar(id);
        registro.setTemperatura(dto.getTemperatura());
        registro.setHumedad(dto.getHumedad());
        registro.setPresion(dto.getPresion());
        registro.setFecha(dto.getFecha());
        registro.setDescripcion(dto.getDescripcion());
        registro.setEstacion(validarEstacion(dto.getEstacionId()));
        registro.setTiposMedicion(resolverTipos(dto.getTiposMedicionIds()));
        return repository.save(registro);
    }

    public void eliminar(Long id) {
        repository.delete(buscar(id));
    }

    private Estacion validarEstacion(Long id) {
        return estacionRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Estacion no encontrada: " + id));
    }

    private List<TipoMedicion> resolverTipos(List<Long> ids) {
        if (ids == null || ids.isEmpty()) {
            return List.of();
        }
        return ids.stream().map(tipoMedicionRepository::findById)
                .map(opcional -> opcional.orElseThrow(() -> new RecursoNoEncontradoException("Tipo de medicion no encontrado")))
                .toList();
    }
}

