package br.com.zeus.reliablecargo.dto;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

public class CaminhaoDto implements Serializable {
    @NotBlank(message = "A placa é obrigatória")
    @Size(min = 7, max = 7, message = "Informe uma placa válida")
    private String placa;
    @Size(max = 17, message = "Informe um chassi válido")
    @NotBlank(message = "O chassi é obrigatório")
    private String chassi;
    @NotBlank(message = "A marca é obrigatória")
    private String marca;
    @NotBlank(message = "O modelo é obrigatório")
    private String modelo;
    @Min(value = 1980, message = "Esse caminhão é muito velho")
    @Max(value = 2024, message = "Não aceitamos caminhões do futuro")
    private Integer anoModelo;
    @NotBlank(message = "A cor é obrigatória")
    private String cor;

    public CaminhaoDto() {
    }

    public CaminhaoDto(String placa, String chassi, String marca, String modelo, Integer anoModelo, String cor) {
        this.placa = placa;
        this.chassi = chassi;
        this.marca = marca;
        this.modelo = modelo;
        this.anoModelo = anoModelo;
        this.cor = cor;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getAnoModelo() {
        return anoModelo;
    }

    public void setAnoModelo(Integer anoModelo) {
        this.anoModelo = anoModelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CaminhaoDto entity = (CaminhaoDto) o;
        return Objects.equals(this.placa, entity.placa) &&
                Objects.equals(this.chassi, entity.chassi) &&
                Objects.equals(this.marca, entity.marca) &&
                Objects.equals(this.modelo, entity.modelo) &&
                Objects.equals(this.anoModelo, entity.anoModelo) &&
                Objects.equals(this.cor, entity.cor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(placa, chassi, marca, modelo, anoModelo, cor);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "placa = " + placa + ", " +
                "chassi = " + chassi + ", " +
                "marca = " + marca + ", " +
                "modelo = " + modelo + ", " +
                "anoModelo = " + anoModelo + ", " +
                "cor = " + cor + ")";
    }
}
