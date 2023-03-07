package tech.ada.exemplos.salao.beleza.client;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import tech.ada.exemplos.salao.beleza.client.payload.EstoqueRequest;

@Service
@Slf4j
public class EstoqueClient {
    @Value("${business.estoque.url}")
    private String requestAddress;


    @Async
    public void solicitarCadastroEstoque(EstoqueRequest estoqueRequest){
        WebClient webClient = WebClient.create();
        Mono<EstoqueRequest> estoqueRequestMono =  webClient.post().uri(requestAddress)
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(estoqueRequest), EstoqueRequest.class)
                .retrieve().bodyToMono(EstoqueRequest.class);
        estoqueRequestMono.subscribe(respostaEstoque -> log.info("retorno do estoque {}", respostaEstoque));

    }

}
