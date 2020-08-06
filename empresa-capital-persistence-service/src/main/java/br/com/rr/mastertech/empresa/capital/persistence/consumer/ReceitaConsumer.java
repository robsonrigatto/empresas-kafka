package br.com.rr.mastertech.empresa.capital.persistence.consumer;

import br.com.rr.mastertech.empresa.receita.dto.CapitalValidadoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class ReceitaConsumer {

    @Value("${receita.file.root.path}")
    private String rootPath;

    @Autowired
    private KafkaTemplate<String, CapitalValidadoDTO> producer;

    @Value("${empresa.persistence.topic}")
    private String topic;

    @KafkaListener(topics = "${empresa.persistence.topic}", groupId = "grupo-do-robson")
    public void consume(@Payload CapitalValidadoDTO receitaDTO) throws IOException {
        System.out.println("persistindo cnpj: " + receitaDTO.getCnpj());

        Path path = Paths.get(rootPath, "receita.csv");

        List<String> lines = Collections.singletonList(String.format("%s,%s",
                receitaDTO.getCnpj(), receitaDTO.getCapitalValido() ? "Sim" : "Não"));
        Files.write(path, lines, StandardCharsets.UTF_8, new StandardOpenOption[]{StandardOpenOption.CREATE, StandardOpenOption.APPEND});
    }
}

