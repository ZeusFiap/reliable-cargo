package br.com.zeus.reliablecargo.repository;

import br.com.zeus.reliablecargo.model.Caminhao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CaminhaoRepository extends JpaRepository<Caminhao, String> {
    Caminhao findByPlaca(String placa);
}