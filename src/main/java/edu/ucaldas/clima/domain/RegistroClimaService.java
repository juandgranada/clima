package edu.ucaldas.clima.domain;

import edu.ucaldas.clima.dto.RegistroClimaDTO;
import edu.ucaldas.clima.model.RegistroClima;
import edu.ucaldas.clima.persistance.RegistroClimaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RegistroClimaService {

    @Autowired
    private RegistroClimaRepository repository;

    public List<RegistroClima> listar() {
        return repository.findAll();
    }

    public RegistroClima buscar(Long id) {
        return repository.findById(id).get();
    }

    public void crear(RegistroClimaDTO registroClimaDTO){
        RegistroClima registroClima = new RegistroClima(registroClimaDTO.getTemperatura(), registroClimaDTO.getHumedad(), registroClimaDTO.getDescripcion());
        repository.save(registroClima);
    }
}
// Crear, actualizar y eliminar completan el CRUD

