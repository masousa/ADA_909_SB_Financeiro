package tech.ada.samples.nine.six.six.payloads;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class ContratoRequest {

    private Long idContrato;
    List<PacoteRequest> pacotes = List.of();
    @JsonProperty("usuario")
    private Long usuarioId;

}
