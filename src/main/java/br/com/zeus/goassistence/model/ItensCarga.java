package br.com.zeus.goassistence.model;

import javax.persistence.*;

@Entity
@Table(name = "TB_ITENS_CARGA")
public class ItensCarga {
    @EmbeddedId
    private ItensCargaId id;

    @MapsId("idCargaPf")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_CARGA_PF", nullable = false)
    private Carga idCargaPf;

    @MapsId("idItemPf")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_ITEM_PF", nullable = false)
    private Item idItemPf;

    @Column(name = "QTD_ITEM_CARGA", nullable = false)
    private Long qtdItemCarga;

    public ItensCargaId getId() {
        return id;
    }

    public void setId(ItensCargaId id) {
        this.id = id;
    }

    public Carga getIdCargaPf() {
        return idCargaPf;
    }

    public void setIdCargaPf(Carga idCargaPf) {
        this.idCargaPf = idCargaPf;
    }

    public Item getIdItemPf() {
        return idItemPf;
    }

    public void setIdItemPf(Item idItemPf) {
        this.idItemPf = idItemPf;
    }

    public Long getQtdItemCarga() {
        return qtdItemCarga;
    }

    public void setQtdItemCarga(Long qtdItemCarga) {
        this.qtdItemCarga = qtdItemCarga;
    }

}