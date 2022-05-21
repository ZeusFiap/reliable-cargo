package br.com.zeus.reliablecargo.model;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "TB_LOG_CONTROLE_PORTAS")
public class LogControlePorta {
    @Id
    @Column(name = "ID_CONTROLE_PORTAS_PK", nullable = false)
    private Long id;

    @Column(name = "ABERTURA_EM", nullable = false)
    private Instant aberturaEm;

    @Column(name = "FECHAMENTO_EM", nullable = false)
    private Instant fechamentoEm;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_IOT_LOGGER_FK", nullable = false)
    private IotLogger idIotLoggerFk;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getAberturaEm() {
        return aberturaEm;
    }

    public void setAberturaEm(Instant aberturaEm) {
        this.aberturaEm = aberturaEm;
    }

    public Instant getFechamentoEm() {
        return fechamentoEm;
    }

    public void setFechamentoEm(Instant fechamentoEm) {
        this.fechamentoEm = fechamentoEm;
    }

    public IotLogger getIdIotLoggerFk() {
        return idIotLoggerFk;
    }

    public void setIdIotLoggerFk(IotLogger idIotLoggerFk) {
        this.idIotLoggerFk = idIotLoggerFk;
    }

}