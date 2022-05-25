package br.com.zeus.reliablecargo.service;

import br.com.zeus.reliablecargo.dto.CaminhaoDto;
import br.com.zeus.reliablecargo.model.Caminhao;
import br.com.zeus.reliablecargo.repository.CaminhaoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class CaminhaoService {
    @Autowired
    private CaminhaoRepository caminhaoRepository;
    @Autowired
    private ModelMapper mapper;

    public List<Caminhao> all() {
        return caminhaoRepository.findAll();
    }

    public Caminhao create(@Validated CaminhaoDto caminhaoDto) {
        Caminhao caminhao = mapper.map(caminhaoDto, Caminhao.class);
        return caminhaoRepository.save(caminhao);
    }

    public Caminhao findByPlaca(String placa) {
        Optional<Caminhao> caminhao = caminhaoRepository.findByPlaca(placa);
        if (caminhao.isPresent()) {
            return caminhao.get();
        }
        throw new ResponseStatusException(
            HttpStatus.NOT_FOUND, "Caminhão não encontrado"
        );
    }

    public Caminhao update(String placa, @Validated CaminhaoDto caminhaoDto) {
        var _caminhao = findByPlaca(placa);
        var caminhao = mapper.map(caminhaoDto, Caminhao.class);
        caminhao.setPlaca(_caminhao.getPlaca());
        return caminhaoRepository.save(caminhao);
    }

    public void delete(String placa) {
        var caminhao = findByPlaca(placa);
        caminhaoRepository.delete(caminhao);
    }
}
