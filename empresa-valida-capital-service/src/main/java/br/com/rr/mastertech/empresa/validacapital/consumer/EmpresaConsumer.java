package br.com.rr.mastertech.empresa.validacapital.consumer;

import br.com.rr.mastertech.empresa.receita.dto.CapitalValidadoDTO;
import br.com.rr.mastertech.empresa.receita.dto.ReceitaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EmpresaConsumer {

    @Autowired
    private KafkaTemplate<String, CapitalValidadoDTO> producer;

    @Value("${empresa.persistence.topic}")
    private String topic;

    @KafkaListener(topics = "${empresa.capital.topic}", groupId = "grupo-do-robson")
    public void consume(@Payload ReceitaDTO receitaDTO) {
        System.out.println("validando cnpj: " + receitaDTO.getCnpj());

        CapitalValidadoDTO dto = new CapitalValidadoDTO();
        dto.setCnpj(receitaDTO.getCnpj());
        dto.setCapitalValido(false);

        producer.send(topic, dto);
    }
}
