package br.com.zeus.reliablecargo.model;

import javax.persistence.*;

@Entity
@Table(name = "TB_MOTORISTA")
public class Motorista {
    @Id
    @Column(name = "ID_MOTORISTA_PK", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="motorista_seq")
    @SequenceGenerator(name="motorista_seq", sequenceName="motorista_seq", allocationSize = 1)
    private Long id;

    @Column(name = "NM_COMPLETO", nullable = false, length = 70)
    private String nmCompleto;

    @Column(name = "CNH_UK", nullable = false)
    private Long cnhUk;

    @Column(name = "TEL", nullable = false, length = 14)
    private String tel;

    @Column(name = "EM_ATIVIDADE", nullable = false)
    private Boolean emAtividade = false;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNmCompleto() {
        return nmCompleto;
    }

    public void setNmCompleto(String nmCompleto) {
        this.nmCompleto = nmCompleto;
    }

    public Long getCnhUk() {
        return cnhUk;
    }

    public void setCnhUk(Long cnhUk) {
        this.cnhUk = cnhUk;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Boolean getEmAtividade() {
        return emAtividade;
    }

    public void setEmAtividade(Boolean emAtividade) {
        this.emAtividade = emAtividade;
    }

}