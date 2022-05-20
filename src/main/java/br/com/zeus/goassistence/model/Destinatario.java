package br.com.zeus.goassistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_DESTINATARIO")
public class Destinatario {
    @Id
    @Column(name = "ID_DESTINATARIO_PK", nullable = false)
    private Long id;

    @Column(name = "NM_FANTASIA", nullable = false, length = 50)
    private String nmFantasia;

    @Column(name = "RAZAO_SOCIAL", nullable = false, length = 100)
    private String razaoSocial;

    @Column(name = "CNPJ_UK", nullable = false, length = 14)
    private String cnpjUk;

    @Column(name = "EMAIL", nullable = false, length = 64)
    private String email;

    @Column(name = "TEL", nullable = false, length = 14)
    private String tel;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNmFantasia() {
        return nmFantasia;
    }

    public void setNmFantasia(String nmFantasia) {
        this.nmFantasia = nmFantasia;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCnpjUk() {
        return cnpjUk;
    }

    public void setCnpjUk(String cnpjUk) {
        this.cnpjUk = cnpjUk;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

}