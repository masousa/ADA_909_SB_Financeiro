package tech.ada.samples.nine.six.six.payloads;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Builder
@Getter
public class HelloResponse {
    private String text;
}
