package br.com.rr.mastertech.empresa.cadastro.producer;

import br.com.rr.mastertech.empresa.receita.dto.ReceitaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class ReceitaProducer {

    @Autowired
    private KafkaTemplate<String, ReceitaDTO> producer;

    @Value("${empresa.capital.topic}")
    private String topic;

    public void send(String cnpj) {
        ReceitaDTO dto = new ReceitaDTO();
        dto.setCnpj(cnpj);

        producer.send(topic, dto);

    }
}
