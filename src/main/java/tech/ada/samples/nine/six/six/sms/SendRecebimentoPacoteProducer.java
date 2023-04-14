package tech.ada.samples.nine.six.six.sms;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import tech.ada.samples.nine.six.six.payloads.PacoteUsuarioRequest;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class SendRecebimentoPacoteProducer {

    private final RabbitTemplate rabbitTemplate;
    private final ObjectMapper objectMapper;
    private final Queue queue;

    public void sendRetornoPacotes(List<PacoteUsuarioRequest> pacotesUsuariosRequest){
      log.info("Retornando mensagem de situação do pacote {}", pacotesUsuariosRequest);
        try {
            String message = objectMapper.writeValueAsString(pacotesUsuariosRequest);
            rabbitTemplate.convertAndSend(queue.getName(), message);
        } catch (JsonProcessingException e) {
            log.error("Erro ao tentar converter o objeto");
            throw new RuntimeException(e);
        }
    }
}
