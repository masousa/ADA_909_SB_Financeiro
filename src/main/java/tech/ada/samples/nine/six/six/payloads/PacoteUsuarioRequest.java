package tech.ada.samples.nine.six.six.payloads;

import lombok.Data;

@Data
public class PacoteUsuarioRequest {

    private Long idUsuario;
    private Long idPacote;
    private double valor;
    private StatusSolicitacao status;
}
