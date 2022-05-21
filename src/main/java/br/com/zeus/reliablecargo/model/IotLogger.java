package br.com.zeus.reliablecargo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "TB_IOT_LOGGER")
public class IotLogger {
    @Id
    @Column(name = "ID_IOT_LOGGER_PK", nullable = false)
    private Long id;

    @Column(name = "VIDA_UTIL", nullable = false, length = 30)
    private String vidaUtil;

    @Column(name = "DT_FABRICACAO", nullable = false)
    private LocalDate dtFabricacao;

    @Column(name = "DT_IMPORTACAO", nullable = false)
    private LocalDate dtImportacao;

    @Column(name = "ALTURA")
    private Double altura;

    @Column(name = "LARGURA")
    private Double largura;

    @Column(name = "PESO")
    private Double peso;

    @Column(name = "DESCRICAO", length = 180)
    private String descricao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVidaUtil() {
        return vidaUtil;
    }

    public void setVidaUtil(String vidaUtil) {
        this.vidaUtil = vidaUtil;
    }

    public LocalDate getDtFabricacao() {
        return dtFabricacao;
    }

    public void setDtFabricacao(LocalDate dtFabricacao) {
        this.dtFabricacao = dtFabricacao;
    }

    public LocalDate getDtImportacao() {
        return dtImportacao;
    }

    public void setDtImportacao(LocalDate dtImportacao) {
        this.dtImportacao = dtImportacao;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public Double getLargura() {
        return largura;
    }

    public void setLargura(Double largura) {
        this.largura = largura;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}