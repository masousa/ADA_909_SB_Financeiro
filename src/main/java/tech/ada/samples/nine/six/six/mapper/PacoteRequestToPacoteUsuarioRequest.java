package tech.ada.samples.nine.six.six.mapper;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import tech.ada.samples.nine.six.six.payloads.ContratoRequest;
import tech.ada.samples.nine.six.six.payloads.PacoteRequest;
import tech.ada.samples.nine.six.six.payloads.PacoteUsuarioRequest;
import tech.ada.samples.nine.six.six.payloads.StatusSolicitacao;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PacoteRequestToPacoteUsuarioRequest {
    public static PacoteUsuarioRequest map(PacoteRequest pacoteRequest, ContratoRequest contratoRequest) {
        PacoteUsuarioRequest pacoteUsuarioRequest = new PacoteUsuarioRequest();
        pacoteUsuarioRequest.setStatus(StatusSolicitacao.APROVADO);
        pacoteUsuarioRequest.setIdUsuario(contratoRequest.getUsuarioId());
        pacoteUsuarioRequest.setIdPacote(pacoteRequest.getIdPacote());
        pacoteUsuarioRequest.setValor(pacoteRequest.getValorPacote());
        return pacoteUsuarioRequest;
    }
}
