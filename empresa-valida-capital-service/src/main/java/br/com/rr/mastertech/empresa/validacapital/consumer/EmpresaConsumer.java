package br.com.rr.mastertech.empresa.validacapital.consumer;

import br.com.rr.mastertech.empresa.receita.dto.CapitalValidadoDTO;
import br.com.rr.mastertech.empresa.receita.dto.ReceitaDTO;
import br.com.rr.mastertech.empresa.validacapital.client.ReceitaClient;
import br.com.rr.mastertech.empresa.validacapital.client.dto.EmpresaReceitaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class EmpresaConsumer {

    @Autowired
    private KafkaTemplate<String, CapitalValidadoDTO> producer;

    @Autowired
    private ReceitaClient receitaClient;

    @Value("${empresa.persistence.topic}")
    private String topic;

    @Value("${empresa.capital.valor.minimo.aceito}")
    private BigDecimal valorMinimoAceito;

    @KafkaListener(topics = "${empresa.capital.topic}", groupId = "grupo-do-robson")
    public void consume(@Payload ReceitaDTO receitaDTO) {
        System.out.println("validando cnpj: " + receitaDTO.getCnpj());

        EmpresaReceitaDTO empresaReceitaDTO = receitaClient.findByCnpj(receitaDTO.getCnpj()
                .replace("-", "")
                .replace("/", "")
                .replaceAll("\\.", ""));

        CapitalValidadoDTO dto = new CapitalValidadoDTO();
        dto.setCnpj(receitaDTO.getCnpj());
        dto.setCapitalValido(empresaReceitaDTO.getCapitalSocial().compareTo(valorMinimoAceito) >= 0);

        producer.send(topic, dto);
    }
}
