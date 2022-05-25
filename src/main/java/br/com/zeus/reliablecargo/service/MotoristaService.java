package br.com.zeus.reliablecargo.service;

import br.com.zeus.reliablecargo.dto.MotoristaDto;
import br.com.zeus.reliablecargo.model.Motorista;
import br.com.zeus.reliablecargo.repository.MotoristaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class MotoristaService {
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private MotoristaRepository repository;

    public List<Motorista> all() {
        return repository.findAll();
    }

    public Motorista findById(Long id) {
        var motorista = repository.findById(id);
        if (motorista.isPresent()) {
            return motorista.get();
        }
        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Caminhão não encontrado"
        );
    }

    public Motorista create(MotoristaDto dto) {
        Motorista motorista = mapper.map(dto, Motorista.class);
        return repository.save(motorista);
    }

    public Motorista update(Long id, MotoristaDto dto) {
        var motorista = mapper.map(dto, Motorista.class);
        motorista.setId(id);
        return repository.save(motorista);
    }

    public void delete(Long id) {
        var motorista = findById(id);
        repository.delete(motorista);
    }
}
