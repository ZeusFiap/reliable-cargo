package br.com.zeus.reliablecargo.model;

import javax.persistence.*;

@Entity
@Table(name = "TB_ENDERECO_DESTINATARIO")
public class EnderecoDestinatario {
    @Id
    @Column(name = "ID_END_DESTINATARIO_PK", nullable = false)
    private Long id;

    @Column(name = "CEP", nullable = false, length = 8)
    private String cep;

    @Column(name = "NRO", nullable = false, length = 7)
    private String nro;

    @Column(name = "RUA", nullable = false, length = 70)
    private String rua;

    @Column(name = "BAIRRO", nullable = false, length = 50)
    private String bairro;

    @Column(name = "COMPLEMENTO", length = 100)
    private String complemento;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_DESTINATARIO_FK", nullable = false)
    private Destinatario idDestinatarioFk;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_CIDADE_FK", nullable = false)
    private Cidade idCidadeFk;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getNro() {
        return nro;
    }

    public void setNro(String nro) {
        this.nro = nro;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public Destinatario getIdDestinatarioFk() {
        return idDestinatarioFk;
    }

    public void setIdDestinatarioFk(Destinatario idDestinatarioFk) {
        this.idDestinatarioFk = idDestinatarioFk;
    }

    public Cidade getIdCidadeFk() {
        return idCidadeFk;
    }

    public void setIdCidadeFk(Cidade idCidadeFk) {
        this.idCidadeFk = idCidadeFk;
    }

}