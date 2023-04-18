package tech.ada.samples.nine.six.six.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import tech.ada.samples.nine.six.six.entity.Fatura;
import tech.ada.samples.nine.six.six.repository.FaturaRepository;

@Service
@RequiredArgsConstructor
@Slf4j
public class CalcularFinalValorFaturaMesCorrenteService {
    public final FaturaRepository faturaRepository;

    public final GenerateFaturaUsuarioService generateFatura;
    @Cacheable(cacheNames = "rlfatura", key ="new org.springframework.cache.interceptor.SimpleKey(#usuarioID, #mes, #ano)" )
    public double execute(Long usuarioID, String mes, int ano){
        log.info("{} Realizando busca da fatura salva para o usuário {}", this.getClass().getSimpleName(), usuarioID);
        Fatura fatura = faturaRepository.findByMesAndAnoAndUsuarioId(mes,ano,usuarioID).orElse(generateFatura.execute(usuarioID));

        return fatura.getValor();
    }
}
