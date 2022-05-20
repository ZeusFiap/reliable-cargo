package br.com.zeus.goassistence.model;

import javax.persistence.*;

@Entity
@Table(name = "TB_MOTORISTA_CAMINHAO")
public class MotoristaCaminhao {
    @EmbeddedId
    private MotoristaCaminhaoId id;

    @MapsId("idMotoristaPf")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_MOTORISTA_PF", nullable = false)
    private Motorista idMotoristaPf;

    @MapsId("placaCaminhaoPf")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "PLACA_CAMINHAO_PF", nullable = false)
    private Caminhao placaCaminhaoPf;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_IOT_LOGGER_FK", nullable = false)
    private IotLogger idIotLoggerFk;

    public MotoristaCaminhaoId getId() {
        return id;
    }

    public void setId(MotoristaCaminhaoId id) {
        this.id = id;
    }

    public Motorista getIdMotoristaPf() {
        return idMotoristaPf;
    }

    public void setIdMotoristaPf(Motorista idMotoristaPf) {
        this.idMotoristaPf = idMotoristaPf;
    }

    public Caminhao getPlacaCaminhaoPf() {
        return placaCaminhaoPf;
    }

    public void setPlacaCaminhaoPf(Caminhao placaCaminhaoPf) {
        this.placaCaminhaoPf = placaCaminhaoPf;
    }

    public IotLogger getIdIotLoggerFk() {
        return idIotLoggerFk;
    }

    public void setIdIotLoggerFk(IotLogger idIotLoggerFk) {
        this.idIotLoggerFk = idIotLoggerFk;
    }

}