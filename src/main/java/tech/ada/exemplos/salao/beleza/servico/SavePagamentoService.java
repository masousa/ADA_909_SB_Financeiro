package tech.ada.exemplos.salao.beleza.servico;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tech.ada.exemplos.salao.beleza.entities.Pagamento;
import tech.ada.exemplos.salao.beleza.repositories.PagamentoRepository;

@Service
@RequiredArgsConstructor
public class SavePagamentoService {

    private final PagamentoRepository pagamentoRepository;

    public Pagamento executar(Pagamento pagamento){
        return pagamentoRepository.save(pagamento);
    }
}
