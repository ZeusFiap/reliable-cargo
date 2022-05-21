package br.com.zeus.reliablecargo.model;

import javax.persistence.*;

@Entity
@Table(name = "TB_CAMINHAO")
public class Caminhao {
    @Id
    @Column(name = "PLACA_CAMINHAO_PK", nullable = false, length = 7)
//    @GeneratedValue(strategy=GenerationType.TABLE)
    private String placa;

    @Column(name = "CHASSI", nullable = false, length = 17)
    private String chassi;

    @Column(name = "MARCA", nullable = false, length = 30)
    private String marca;

    @Column(name = "MODELO", nullable = false, length = 50)
    private String modelo;

    @Column(name = "ANO_MODELO", nullable = false)
    private Integer anoModelo;

    @Column(name = "COR", nullable = false, length = 20)
    private String cor;

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
}