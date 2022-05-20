package br.com.zeus.goassistence.model;

import javax.persistence.*;

@Entity
@Table(name = "TB_CIDADE")
public class Cidade {
    @Id
    @Column(name = "ID_CIDADE_PK", nullable = false)
    private Long id;

    @Column(name = "NM_CIDADE", nullable = false, length = 60)
    private String nmCidade;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_ESTADO_FK", nullable = false)
    private Estado idEstadoFk;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNmCidade() {
        return nmCidade;
    }

    public void setNmCidade(String nmCidade) {
        this.nmCidade = nmCidade;
    }

    public Estado getIdEstadoFk() {
        return idEstadoFk;
    }

    public void setIdEstadoFk(Estado idEstadoFk) {
        this.idEstadoFk = idEstadoFk;
    }

}