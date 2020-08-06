package br.com.rr.mastertech.empresa.capital.persistence.consumer;

import br.com.rr.mastertech.empresa.receita.dto.CapitalValidadoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class ReceitaConsumer {

    @Autowired
    private KafkaTemplate<String, CapitalValidadoDTO> producer;

    @Value("${empresa.persistence.topic}")
    private String topic;

    @KafkaListener(topics = "${empresa.persistence.topic}", groupId = "grupo-do-robson")
    public void consume(@Payload CapitalValidadoDTO receitaDTO) {
        System.out.println("persistindo cnpj: " + receitaDTO.getCnpj());
    }
}

