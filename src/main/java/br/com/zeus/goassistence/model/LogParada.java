package br.com.zeus.goassistence.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "TB_LOG_PARADA")
public class LogParada {
    @Id
    @Column(name = "ID_PARADA_PK", nullable = false)
    private Long id;

    @Column(name = "PARADA_EM", nullable = false)
    private Instant paradaEm;

    @Column(name = "RETOMADA_EM", nullable = false)
    private Instant retomadaEm;

    @Column(name = "COORD_X_PARADA", nullable = false, precision = 9, scale = 6)
    private BigDecimal coordXParada;

    @Column(name = "COORD_Y_PARADA", nullable = false, precision = 9, scale = 6)
    private BigDecimal coordYParada;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_IOT_LOGGER_FK", nullable = false)
    private IotLogger idIotLoggerFk;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getParadaEm() {
        return paradaEm;
    }

    public void setParadaEm(Instant paradaEm) {
        this.paradaEm = paradaEm;
    }

    public Instant getRetomadaEm() {
        return retomadaEm;
    }

    public void setRetomadaEm(Instant retomadaEm) {
        this.retomadaEm = retomadaEm;
    }

    public BigDecimal getCoordXParada() {
        return coordXParada;
    }

    public void setCoordXParada(BigDecimal coordXParada) {
        this.coordXParada = coordXParada;
    }

    public BigDecimal getCoordYParada() {
        return coordYParada;
    }

    public void setCoordYParada(BigDecimal coordYParada) {
        this.coordYParada = coordYParada;
    }

    public IotLogger getIdIotLoggerFk() {
        return idIotLoggerFk;
    }

    public void setIdIotLoggerFk(IotLogger idIotLoggerFk) {
        this.idIotLoggerFk = idIotLoggerFk;
    }

}