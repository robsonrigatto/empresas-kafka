package br.com.rr.mastertech.empresa.cadastro.mapper;

import br.com.rr.mastertech.empresa.cadastro.domain.Empresa;
import br.com.rr.mastertech.empresa.cadastro.dto.request.CriarEmpresaRequest;
import br.com.rr.mastertech.empresa.cadastro.dto.response.EmpresaResponse;
import org.springframework.stereotype.Component;

@Component
public class EmpresaMapper {

    public EmpresaResponse toEmpresaResponse(Empresa empresa) {
        EmpresaResponse response = new EmpresaResponse();
        response.setId(empresa.getId());
        response.setCnpj(empresa.getCnpj());
        response.setRazaoSocial(empresa.getRazaoSocial());

        return response;
    }

    public Empresa toEmpresa(CriarEmpresaRequest request) {
        Empresa empresa = new Empresa();
        empresa.setRazaoSocial(request.getRazaoSocial());
        empresa.setCnpj(request.getCnpj());

        return empresa;
    }
}
