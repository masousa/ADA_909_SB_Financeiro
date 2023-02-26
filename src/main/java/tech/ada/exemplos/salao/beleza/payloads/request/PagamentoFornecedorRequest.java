package tech.ada.exemplos.salao.beleza.payloads.request;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class PagamentoFornecedorRequest {
    @NotNull
    private FornecedorRequest fornecedor;

    @NotNull
    private List<ItemRequest> items;

}
