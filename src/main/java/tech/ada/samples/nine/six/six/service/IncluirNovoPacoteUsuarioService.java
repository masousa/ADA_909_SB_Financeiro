package tech.ada.samples.nine.six.six.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tech.ada.samples.nine.six.six.mapper.PacoteRequestToPacoteUsuarioRequest;
import tech.ada.samples.nine.six.six.payloads.ContratoRequest;
import tech.ada.samples.nine.six.six.payloads.PacoteUsuarioRequest;
import tech.ada.samples.nine.six.six.sms.SendRecebimentoPacoteProducer;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class IncluirNovoPacoteUsuarioService {

    private final SendRecebimentoPacoteProducer sendRecebimentoPacoteProducer;
    public void execute(ContratoRequest contratoRequest){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        List<PacoteUsuarioRequest> pacoteUsuarioRequestList = contratoRequest.getPacotes()
                .stream().map(pacoteRequest -> PacoteRequestToPacoteUsuarioRequest.map(pacoteRequest,contratoRequest)).collect(Collectors.toList());

        sendRecebimentoPacoteProducer.sendRetornoPacotes(
                pacoteUsuarioRequestList);

        log.info("Pacote retornado com sucesso");
    }
}
