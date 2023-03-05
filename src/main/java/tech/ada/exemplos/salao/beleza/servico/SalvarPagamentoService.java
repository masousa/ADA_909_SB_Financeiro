package tech.ada.exemplos.salao.beleza.servico;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.StopWatch;
import org.springframework.beans.BeanUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;
import tech.ada.exemplos.salao.beleza.client.EstoqueClient;
import tech.ada.exemplos.salao.beleza.client.payload.EstoqueRequest;
import tech.ada.exemplos.salao.beleza.entities.Fornecedor;
import tech.ada.exemplos.salao.beleza.entities.Item;
import tech.ada.exemplos.salao.beleza.entities.Pagamento;
import tech.ada.exemplos.salao.beleza.entities.Produto;
import tech.ada.exemplos.salao.beleza.payloads.request.ItemRequest;
import tech.ada.exemplos.salao.beleza.payloads.request.PagamentoFornecedorRequest;
import tech.ada.exemplos.salao.beleza.repositories.PagamentoRepository;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class SalvarPagamentoService {

    private final RetrieveOrCreateProdutoService retrieveOrCreateProdutoService;
    private final RetrieveOrSaveFornecedorService retrieveOrSaveFornecedorService;

    private final PagamentoRepository pagamentoRepository;

    private final EstoqueClient estoqueClient;

    @CacheEvict(cacheNames = "rlfornecedor", allEntries = true)

    public void execute(PagamentoFornecedorRequest pagamentoFornecedorRequest){
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Fornecedor fornecedor = new Fornecedor();
        BeanUtils.copyProperties(pagamentoFornecedorRequest.getFornecedor(),fornecedor);
        List<Item> items = pagamentoFornecedorRequest.getItems().stream().map(this::getItems)
                .collect(Collectors.toList());

        Fornecedor fornecedorSaved = retrieveOrSaveFornecedorService.execute(fornecedor);

        Pagamento pagamento = new Pagamento();
        pagamento.setFornecedor(fornecedorSaved);
        pagamento.adicionarItems(items);
        enviarSolicitacaoAoEstoque(fornecedor, items);
        pagamentoRepository.save(pagamento);
        stopWatch.stop();
        log.info("Tempo de execução {} ms", stopWatch.getTime(TimeUnit.MILLISECONDS));
    }

    private void enviarSolicitacaoAoEstoque(Fornecedor fornecedor, List<Item> items) {

        for (Item item: items) {
            EstoqueRequest estoqueRequest = new EstoqueRequest();
            estoqueRequest.setIdentificador(item.getProduto().getIdentificador());
            estoqueRequest.setMarca(item.getProduto().getNome());
            estoqueRequest.setNome(item.getProduto().getNome());
            estoqueRequest.setQuantidadeAdicionada(item.getQuantidade());
            estoqueRequest.setUnidade("UN");
            estoqueRequest.setQuantidadeDaUnidade(1.0);
            estoqueClient.solicitarCadastroEstoque(estoqueRequest);
        }

    }

    private Item getItems(ItemRequest itemRequest) {
        Item item = new Item();
        BeanUtils.copyProperties(itemRequest, item);
        Produto produto = new Produto();
        BeanUtils.copyProperties(itemRequest.getProduto(), produto);
        item.setProduto(retrieveOrCreateProdutoService.execute(produto));
        return item;
    }
}
