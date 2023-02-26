package tech.ada.exemplos.salao.beleza.payloads;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Builder
@Getter
public class HelloResponse {
    private String text;
}
