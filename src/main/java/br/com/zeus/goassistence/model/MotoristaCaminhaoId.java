package br.com.zeus.goassistence.model;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class MotoristaCaminhaoId implements Serializable {
    private static final long serialVersionUID = 474193765364809398L;
    @Column(name = "ID_MOTORISTA_PF", nullable = false)
    private Long idMotoristaPf;

    @Column(name = "PLACA_CAMINHAO_PF", nullable = false, length = 7)
    private String placaCaminhaoPf;

    public Long getIdMotoristaPf() {
        return idMotoristaPf;
    }

    public void setIdMotoristaPf(Long idMotoristaPf) {
        this.idMotoristaPf = idMotoristaPf;
    }

    public String getPlacaCaminhaoPf() {
        return placaCaminhaoPf;
    }

    public void setPlacaCaminhaoPf(String placaCaminhaoPf) {
        this.placaCaminhaoPf = placaCaminhaoPf;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        MotoristaCaminhaoId entity = (MotoristaCaminhaoId) o;
        return Objects.equals(this.idMotoristaPf, entity.idMotoristaPf) &&
                Objects.equals(this.placaCaminhaoPf, entity.placaCaminhaoPf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idMotoristaPf, placaCaminhaoPf);
    }

}