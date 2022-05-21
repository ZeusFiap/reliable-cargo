package br.com.zeus.reliablecargo.dto;

import java.io.Serializable;
import java.util.Objects;

public class MotoristaDto implements Serializable {
    private final String nmCompleto;
    private final Long cnhUk;
    private final String tel;
    private final Boolean emAtividade;

    public MotoristaDto(String nmCompleto, Long cnhUk, String tel, Boolean emAtividade) {
        this.nmCompleto = nmCompleto;
        this.cnhUk = cnhUk;
        this.tel = tel;
        this.emAtividade = emAtividade;
    }

    public String getNmCompleto() {
        return nmCompleto;
    }

    public Long getCnhUk() {
        return cnhUk;
    }

    public String getTel() {
        return tel;
    }

    public Boolean getEmAtividade() {
        return emAtividade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MotoristaDto entity = (MotoristaDto) o;
        return Objects.equals(this.nmCompleto, entity.nmCompleto) &&
                Objects.equals(this.cnhUk, entity.cnhUk) &&
                Objects.equals(this.tel, entity.tel) &&
                Objects.equals(this.emAtividade, entity.emAtividade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nmCompleto, cnhUk, tel, emAtividade);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "nmCompleto = " + nmCompleto + ", " +
                "cnhUk = " + cnhUk + ", " +
                "tel = " + tel + ", " +
                "emAtividade = " + emAtividade + ")";
    }
}
