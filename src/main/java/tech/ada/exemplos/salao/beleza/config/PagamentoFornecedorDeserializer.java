package tech.ada.exemplos.salao.beleza.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.serialization.Deserializer;
import org.springframework.context.annotation.Configuration;
import tech.ada.exemplos.salao.beleza.payloads.request.PagamentoFornecedorRequest;

import java.nio.charset.StandardCharsets;

@Configuration
@Slf4j
@RequiredArgsConstructor
public class PagamentoFornecedorDeserializer implements Deserializer<PagamentoFornecedorRequest> {

    private final ObjectMapper objectMapper;

    @Override
    public PagamentoFornecedorRequest deserialize(String s, byte[] bytes) {
        log.info("Deserializando um objeto no tópico {}", s);
        String message = new String(bytes, StandardCharsets.UTF_8);
        try {
            return objectMapper.readValue(message, PagamentoFornecedorRequest.class);
        } catch (JsonProcessingException e) {
            log.error("Não foi possível converter a mensagem no objeto desejado");
            return null;
        }

    }

    public PagamentoFornecedorDeserializer(){
        this.objectMapper = new ObjectMapper();
    }
}
