package tech.ada.exemplos.salao.beleza.servico;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tech.ada.exemplos.salao.beleza.entities.Fornecedor;
import tech.ada.exemplos.salao.beleza.repositories.FornecedorRepository;

@Service
@RequiredArgsConstructor
public class RetrieveOrSaveFornecedorService {

    private final FornecedorRepository fornecedorRepository;

    public Fornecedor execute(Fornecedor fornecedor){
        return fornecedorRepository.findByIdentificador(fornecedor.getIdentificador())
                .orElse(fornecedorRepository.save(fornecedor));
    }
}
