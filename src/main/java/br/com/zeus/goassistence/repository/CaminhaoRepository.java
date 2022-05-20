package br.com.zeus.goassistence.repository;

import br.com.zeus.goassistence.model.Caminhao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CaminhaoRepository extends JpaRepository<Caminhao, String> {
    Caminhao findByPlaca(String placa);
}