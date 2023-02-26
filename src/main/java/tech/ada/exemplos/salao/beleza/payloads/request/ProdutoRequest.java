package tech.ada.exemplos.salao.beleza.payloads.request;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class ProdutoRequest {
    @NotEmpty(message = "O identificador do produto é requerido")
    private String identificador;
    private String nome;
}
