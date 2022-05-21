package br.com.zeus.reliablecargo.model;

import javax.persistence.*;

@Entity
@Table(name = "TB_CARGA")
public class Carga {
    @Id
    @Column(name = "ID_CARGA_PK", nullable = false)
    private Long id;

    @Column(name = "ALTURA", nullable = false)
    private Double altura;

    @Column(name = "LARGURA", nullable = false)
    private Double largura;

    @Column(name = "COMPRIMENTO", nullable = false)
    private Double comprimento;

    @Column(name = "FRAGIL", nullable = false)
    private Boolean fragil = false;

    @Column(name = "OBSERVACOES", length = 300)
    private String observacoes;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_REMETENTE_FK", nullable = false)
    private Remetente idRemetenteFk;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_DESTINATARIO_FK", nullable = false)
    private Destinatario idDestinatarioFk;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Double getComprimento() {
        return comprimento;
    }

    public void setComprimento(Double comprimento) {
        this.comprimento = comprimento;
    }

    public Boolean getFragil() {
        return fragil;
    }

    public void setFragil(Boolean fragil) {
        this.fragil = fragil;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Remetente getIdRemetenteFk() {
        return idRemetenteFk;
    }

    public void setIdRemetenteFk(Remetente idRemetenteFk) {
        this.idRemetenteFk = idRemetenteFk;
    }

    public Destinatario getIdDestinatarioFk() {
        return idDestinatarioFk;
    }

    public void setIdDestinatarioFk(Destinatario idDestinatarioFk) {
        this.idDestinatarioFk = idDestinatarioFk;
    }

}