package br.com.zeus.reliablecargo.model;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "TB_LOG_PESO")
public class LogPeso {
    @Id
    @Column(name = "ID_PESO_PK", nullable = false)
    private Long id;

    @Column(name = "PESO", nullable = false)
    private Double peso;

    @Column(name = "REGISTRADO_EM")
    private Instant registradoEm;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_IOT_LOGGER_FK", nullable = false)
    private IotLogger idIotLoggerFk;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Instant getRegistradoEm() {
        return registradoEm;
    }

    public void setRegistradoEm(Instant registradoEm) {
        this.registradoEm = registradoEm;
    }

    public IotLogger getIdIotLoggerFk() {
        return idIotLoggerFk;
    }

    public void setIdIotLoggerFk(IotLogger idIotLoggerFk) {
        this.idIotLoggerFk = idIotLoggerFk;
    }

}