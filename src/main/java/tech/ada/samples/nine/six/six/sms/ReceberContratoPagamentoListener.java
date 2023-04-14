package tech.ada.samples.nine.six.six.sms;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import tech.ada.samples.nine.six.six.payloads.ContratoRequest;
import tech.ada.samples.nine.six.six.service.IncluirNovoPacoteUsuarioService;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReceberContratoPagamentoListener {

    private final ObjectMapper objectMapper;
    private final IncluirNovoPacoteUsuarioService incluirNovoPacoteUsuarioService;


    @KafkaListener(topics = "${business.in.fatura}", groupId = "${spring.kafka.consumer.group-id}")
    public void receive(String request){
        log.info("Recebendo uma nova requisição para pagamento do fornecedor {}", request);
        try {
            ContratoRequest contratoRequest = objectMapper.readValue(request, ContratoRequest.class);
            incluirNovoPacoteUsuarioService.execute(contratoRequest);
        } catch (JsonProcessingException e) {
            log.error("Error parsing response to object", e);
            throw new RuntimeException(e);
        }

    }

}
