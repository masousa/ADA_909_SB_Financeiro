package tech.ada.samples.nine.six.six.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AtualizarValorFaturaMesCorrenteService {

    @CacheEvict(cacheNames = "rlfatura", key = "new org.springframework.cache.interceptor.SimpleKey(#usuarioID, #mes, #ano)" )
    public double execute(Long usuarioID, String mes, Integer ano){

        log.info("{} - removendo valores de cache para o usuario {}", this.getClass().getSimpleName(), usuarioID);
        return 0.0;
    }
}
