package tech.ada.exemplos.salao.beleza.payloads.request;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
@Data
public class ItemRequest {
    @NotNull
    private ProdutoRequest produto;
    @Min(value = 1, message = "Informe um valor válido para o preço do produto")
    private double preco;
    @Min(value = 1, message = "Informe um valor válido para a quantidade do produto")
    private int quantidade;
}
