package tech.ada.samples.nine.six.six.payloads;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PacoteRequest {
    private Long idPacote;
    @JsonProperty("valor")
    private double valorPacote;
}
