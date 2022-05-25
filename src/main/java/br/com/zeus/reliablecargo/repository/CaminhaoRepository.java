package br.com.zeus.reliablecargo.repository;

import br.com.zeus.reliablecargo.model.Caminhao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CaminhaoRepository extends JpaRepository<Caminhao, String> {
    Optional<Caminhao> findByPlaca(String placa);
}