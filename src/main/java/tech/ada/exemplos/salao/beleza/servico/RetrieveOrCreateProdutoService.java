package tech.ada.exemplos.salao.beleza.servico;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tech.ada.exemplos.salao.beleza.entities.Produto;
import tech.ada.exemplos.salao.beleza.repositories.ProdutoRepository;

@Service
@RequiredArgsConstructor
public class RetrieveOrCreateProdutoService {
    private final ProdutoRepository produtoRepository;
    public Produto execute(Produto produto){
        return produtoRepository.findByIdentificador(produto.getIdentificador())
                .orElse(produtoRepository.save(produto));
    }
}
