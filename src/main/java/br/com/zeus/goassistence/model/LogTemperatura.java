package br.com.zeus.goassistence.model;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "TB_LOG_TEMPERATURA")
public class LogTemperatura {
    @Id
    @Column(name = "ID_TEMPERATURA_PK", nullable = false)
    private Long id;

    @Column(name = "TEMPERATURA", nullable = false)
    private Double temperatura;

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

    public Double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(Double temperatura) {
        this.temperatura = temperatura;
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