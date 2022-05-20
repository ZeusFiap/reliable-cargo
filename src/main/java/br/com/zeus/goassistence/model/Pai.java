package br.com.zeus.goassistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_PAIS")
public class Pai {
    @Id
    @Column(name = "ID_PAIS_PK", nullable = false)
    private Integer id;

    @Column(name = "NM_PAIS_UK", nullable = false, length = 50)
    private String nmPaisUk;

    @Column(name = "SG_PAIS_UK", nullable = false, length = 2)
    private String sgPaisUk;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNmPaisUk() {
        return nmPaisUk;
    }

    public void setNmPaisUk(String nmPaisUk) {
        this.nmPaisUk = nmPaisUk;
    }

    public String getSgPaisUk() {
        return sgPaisUk;
    }

    public void setSgPaisUk(String sgPaisUk) {
        this.sgPaisUk = sgPaisUk;
    }

}