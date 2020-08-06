package br.com.rr.mastertech.empresa.receita.dto;

public class CapitalValidadoDTO {

    private String cnpj;
    private Boolean capitalValido;

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Boolean getCapitalValido() {
        return capitalValido;
    }

    public void setCapitalValido(Boolean capitalValido) {
        this.capitalValido = capitalValido;
    }
}
