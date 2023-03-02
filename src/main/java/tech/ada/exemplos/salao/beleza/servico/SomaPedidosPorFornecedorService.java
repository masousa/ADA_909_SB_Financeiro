package tech.ada.exemplos.salao.beleza.servico;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import tech.ada.exemplos.salao.beleza.entities.Pagamento;
import tech.ada.exemplos.salao.beleza.payloads.response.RelatorioFornecedor;
import tech.ada.exemplos.salao.beleza.repositories.PagamentoRepository;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class SomaPedidosPorFornecedorService {
    private final PagamentoRepository pagamentoRepository;
    @Cacheable(cacheNames = "rlfornecedor", key ="#identificadorFornecedor" )
    public RelatorioFornecedor execute(String identificadorFornecedor){

        log.info("Relatorio do fornecedor invocado");
        List<Pagamento> pagamentos = pagamentoRepository.findByFornecedorIdentificador(identificadorFornecedor);
        RelatorioFornecedor relatorioFornecedor = new RelatorioFornecedor();
        relatorioFornecedor.setIdentificador(identificadorFornecedor);
        relatorioFornecedor.setValor(pagamentos.stream().flatMap(pagamento -> pagamento.getItems().stream())
                .map(item -> item.getQuantidade()*item.getPreco()).reduce(0.0, Double::sum));
        return relatorioFornecedor;
    }
}
