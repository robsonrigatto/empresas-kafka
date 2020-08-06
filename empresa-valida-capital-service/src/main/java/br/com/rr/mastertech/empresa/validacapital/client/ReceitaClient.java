package br.com.rr.mastertech.empresa.validacapital.client;

import br.com.rr.mastertech.empresa.validacapital.client.dto.EmpresaReceitaDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "receita", url = "https://receitaws.com.br/v1")
public interface ReceitaClient {

    @GetMapping("/cnpj/{cnpj}")
    EmpresaReceitaDTO findByCnpj(@PathVariable String cnpj);
}
