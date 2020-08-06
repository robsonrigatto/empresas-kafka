package br.com.rr.mastertech.empresa.cadastro.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EmpresaResponse {

    private Integer id;

    @JsonProperty("razao_social")
    private String razaoSocial;

    private String cnpj;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}
