package br.com.zeus.goassistence.model;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ItensCargaId implements Serializable {
    private static final long serialVersionUID = 498016534054240638L;
    @Column(name = "ID_CARGA_PF", nullable = false)
    private Long idCargaPf;

    @Column(name = "ID_ITEM_PF", nullable = false)
    private Long idItemPf;

    public Long getIdCargaPf() {
        return idCargaPf;
    }

    public void setIdCargaPf(Long idCargaPf) {
        this.idCargaPf = idCargaPf;
    }

    public Long getIdItemPf() {
        return idItemPf;
    }

    public void setIdItemPf(Long idItemPf) {
        this.idItemPf = idItemPf;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ItensCargaId entity = (ItensCargaId) o;
        return Objects.equals(this.idItemPf, entity.idItemPf) &&
                Objects.equals(this.idCargaPf, entity.idCargaPf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idItemPf, idCargaPf);
    }

}