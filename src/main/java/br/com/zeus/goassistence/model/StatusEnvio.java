package br.com.zeus.goassistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_STATUS_ENVIO")
public class StatusEnvio {
    @Id
    @Column(name = "ID_STATUS_ENVIO_PK", nullable = false)
    private Long id;

    @Column(name = "NM_STATUS", nullable = false, length = 20)
    private String nmStatus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNmStatus() {
        return nmStatus;
    }

    public void setNmStatus(String nmStatus) {
        this.nmStatus = nmStatus;
    }

}