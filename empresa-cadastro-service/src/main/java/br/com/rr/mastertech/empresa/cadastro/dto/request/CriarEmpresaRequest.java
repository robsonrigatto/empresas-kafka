package br.com.rr.mastertech.empresa.cadastro.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CriarEmpresaRequest {

    @JsonProperty("razao_social")
    private String razaoSocial;

    private String cnpj;

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
