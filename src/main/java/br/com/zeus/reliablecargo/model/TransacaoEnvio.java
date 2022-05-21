package br.com.zeus.reliablecargo.model;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "TB_TRANSACAO_ENVIO")
public class TransacaoEnvio {
    @Id
    @Column(name = "ID_TRANSACAO_ENVIO_PK", nullable = false)
    private Long id;

    @Column(name = "INICIADA_EM")
    private Instant iniciadaEm;

    @Column(name = "FINALIZADA_EM")
    private Instant finalizadaEm;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_STATUS_TRANSACAO_FK", nullable = false)
    private StatusEnvio idStatusTransacaoFk;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_CARGA_FK", nullable = false)
    private Carga idCargaFk;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumns({
            @JoinColumn(name = "ID_MOTORISTA_FK", referencedColumnName = "ID_MOTORISTA_PF", nullable = false),
            @JoinColumn(name = "PLACA_CAMINHAO_FK", referencedColumnName = "PLACA_CAMINHAO_PF", nullable = false)
    })
    private MotoristaCaminhao motoristaCaminhao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getIniciadaEm() {
        return iniciadaEm;
    }

    public void setIniciadaEm(Instant iniciadaEm) {
        this.iniciadaEm = iniciadaEm;
    }

    public Instant getFinalizadaEm() {
        return finalizadaEm;
    }

    public void setFinalizadaEm(Instant finalizadaEm) {
        this.finalizadaEm = finalizadaEm;
    }

    public StatusEnvio getIdStatusTransacaoFk() {
        return idStatusTransacaoFk;
    }

    public void setIdStatusTransacaoFk(StatusEnvio idStatusTransacaoFk) {
        this.idStatusTransacaoFk = idStatusTransacaoFk;
    }

    public Carga getIdCargaFk() {
        return idCargaFk;
    }

    public void setIdCargaFk(Carga idCargaFk) {
        this.idCargaFk = idCargaFk;
    }

    public MotoristaCaminhao getTbMotoristaCaminhao() {
        return motoristaCaminhao;
    }

    public void setTbMotoristaCaminhao(MotoristaCaminhao motoristaCaminhao) {
        this.motoristaCaminhao = motoristaCaminhao;
    }

}