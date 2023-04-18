package tech.ada.samples.nine.six.six.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tech.ada.samples.nine.six.six.entity.Fatura;
import tech.ada.samples.nine.six.six.entity.FaturaStatus;
import tech.ada.samples.nine.six.six.entity.PacoteUsuario;
import tech.ada.samples.nine.six.six.repository.FaturaRepository;
import tech.ada.samples.nine.six.six.repository.PacoteUsuarioRepository;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
@Slf4j
public class GenerateFaturaUsuarioService {
    private final PacoteUsuarioRepository pacoteUsuarioRepository;

    private final FaturaRepository faturaRepository;
    public Fatura execute(Long usuarioId){
        log.info("{} - Gerando valor de fatura do mes corrente para o usuario {}", this.getClass().getSimpleName(), usuarioId);
        LocalDate diaAtual = LocalDate.now();

        String mes = diaAtual.getMonth().name();
        Integer ano = diaAtual.getYear();
        Fatura fatura = new Fatura();
        fatura.setMes(mes);
        fatura.setAno(ano);
        fatura.setUsuarioId(usuarioId);
        fatura.setValor(pacoteUsuarioRepository.findByUsuarioId(usuarioId).stream().mapToDouble(PacoteUsuario::getValor).sum());
        fatura.setStatus(FaturaStatus.ABERTO);
        return faturaRepository.save(fatura);
    }

}
