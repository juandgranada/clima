package edu.ucaldas.clima.domain;

import edu.ucaldas.clima.dto.AlertaDTO;
import edu.ucaldas.clima.model.Alerta;
import edu.ucaldas.clima.model.RegistroClima;
import edu.ucaldas.clima.persistance.AlertaRepository;
import edu.ucaldas.clima.persistance.RegistroClimaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlertaService {
    private final AlertaRepository repository;
    private final RegistroClimaRepository registroRepository;

    public AlertaService(AlertaRepository repository, RegistroClimaRepository registroRepository) {
        this.repository = repository;
        this.registroRepository = registroRepository;
    }

    public List<Alerta> listar() {
        return repository.findAll();
    }

    public Alerta buscar(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Alerta no encontrada: " + id));
    }

    public Alerta crear(AlertaDTO dto) {
        RegistroClima registro = registroRepository.findById(dto.getRegistroClimaId())
                .orElseThrow(() -> new RecursoNoEncontradoException("Registro de clima no encontrado: " + dto.getRegistroClimaId()));
        return repository.save(new Alerta(dto.getDescripcion(), dto.getNivel(), dto.getFecha(), dto.getActiva(), registro));
    }

    public List<Alerta> listarPorNivel(String nivel) {
        return repository.findByNivelIgnoreCase(nivel);
    }

    public List<Alerta> listarActivasPorCiudad(Long ciudadId) {
        return repository.findByActivaTrueAndRegistroClimaEstacionCiudadId(ciudadId);
    }
}
