package tech.ada.exemplos.salao.beleza.queue.in;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import tech.ada.exemplos.salao.beleza.payloads.request.PagamentoFornecedorRequest;
import tech.ada.exemplos.salao.beleza.servico.SalvarPagamentoService;

@Component
@RequiredArgsConstructor
public class PagamentoFornecedorMessageConsumer {
    private final ObjectMapper objectMapper;
    private final SalvarPagamentoService pagamentoService;
    @RabbitListener(queues = {"${business.message.queue.pagamento_fornecedor}"})
    public void receiveMessage(String message) throws JsonProcessingException {
        PagamentoFornecedorRequest pagamentoFornecedorRequest = objectMapper.readValue(message, PagamentoFornecedorRequest.class);
        pagamentoService.execute(pagamentoFornecedorRequest);
    }
}
