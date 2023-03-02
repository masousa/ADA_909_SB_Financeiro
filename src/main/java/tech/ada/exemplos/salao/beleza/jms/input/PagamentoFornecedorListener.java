package tech.ada.exemplos.salao.beleza.jms.input;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import tech.ada.exemplos.salao.beleza.payloads.request.PagamentoFornecedorRequest;
import tech.ada.exemplos.salao.beleza.servico.SalvarPagamentoService;

@Service
@RequiredArgsConstructor
@Slf4j
public class PagamentoFornecedorListener {

    private final SalvarPagamentoService salvarPagamentoService;

    @KafkaListener(topics = "${business.mensagem.entrada.pagamento_fornecedor}", groupId = "${spring.kafka.consumer.group-id}")
    public void receive(PagamentoFornecedorRequest request){
        log.info("Recebendo uma nova requisição para pagamento do fornecedor {}", request);
        salvarPagamentoService.execute(request);
    }
}
