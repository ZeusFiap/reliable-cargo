package br.com.zeus.goassistence.model;

import javax.persistence.*;

@Entity
@Table(name = "TB_ESTADO")
public class Estado {
    @Id
    @Column(name = "ID_ESTADO_PK", nullable = false)
    private Long id;

    @Column(name = "NM_ESTADO", nullable = false, length = 60)
    private String nmEstado;

    @Column(name = "UF", nullable = false, length = 2)
    private String uf;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_PAIS_FK", nullable = false)
    private Pai idPaisFk;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNmEstado() {
        return nmEstado;
    }

    public void setNmEstado(String nmEstado) {
        this.nmEstado = nmEstado;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public Pai getIdPaisFk() {
        return idPaisFk;
    }

    public void setIdPaisFk(Pai idPaisFk) {
        this.idPaisFk = idPaisFk;
    }

}