package br.com.zeus.goassistence.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "TB_LOG_LOCALIZACAO")
public class LogLocalizacao {
    @Id
    @Column(name = "ID_LOCALIZACAO_PK", nullable = false)
    private Long id;

    @Column(name = "COORD_X", nullable = false, precision = 9, scale = 6)
    private BigDecimal coordX;

    @Column(name = "COORD_Y", nullable = false, precision = 9, scale = 6)
    private BigDecimal coordY;

    @Column(name = "REGISTRADA_EM")
    private Instant registradaEm;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_IOT_LOGGER_FK", nullable = false)
    private IotLogger idIotLoggerFk;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getCoordX() {
        return coordX;
    }

    public void setCoordX(BigDecimal coordX) {
        this.coordX = coordX;
    }

    public BigDecimal getCoordY() {
        return coordY;
    }

    public void setCoordY(BigDecimal coordY) {
        this.coordY = coordY;
    }

    public Instant getRegistradaEm() {
        return registradaEm;
    }

    public void setRegistradaEm(Instant registradaEm) {
        this.registradaEm = registradaEm;
    }

    public IotLogger getIdIotLoggerFk() {
        return idIotLoggerFk;
    }

    public void setIdIotLoggerFk(IotLogger idIotLoggerFk) {
        this.idIotLoggerFk = idIotLoggerFk;
    }

}