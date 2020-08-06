package br.com.rr.mastertech.empresa.validacapital.client;

import br.com.rr.mastertech.empresa.validacapital.client.dto.ReceitaDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "receita", url = "https://receitaws.com.br/v1")
public interface ReceitaClient {

    @GetMapping("/cnpj/{cnpj}")
    ReceitaDTO findByCnpj(String cnpj);
}
