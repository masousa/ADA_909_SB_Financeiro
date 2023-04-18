package tech.ada.samples.nine.six.six.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tech.ada.samples.nine.six.six.service.AtualizarValorFaturaMesCorrenteService;
import tech.ada.samples.nine.six.six.service.CalcularFinalValorFaturaMesCorrenteService;

import java.time.LocalDate;

@RestController
@RequestMapping("/fatura")
@RequiredArgsConstructor
public class EmissaoController {

    public final CalcularFinalValorFaturaMesCorrenteService calcularFinalValorFaturaMesCorrenteService;

    public final AtualizarValorFaturaMesCorrenteService atualizarValorFaturaMesCorrenteService;
    @GetMapping(path = "/{usuarioId}")
    public double valorFatura(@PathVariable("usuarioId") Long usuarioId){
        LocalDate diaAtual = LocalDate.now();

        String mes = diaAtual.getMonth().name();
        Integer ano = diaAtual.getYear();
        return calcularFinalValorFaturaMesCorrenteService.execute(usuarioId,mes,ano);
    }

    @PatchMapping(path = "/{usuarioId}")
    public double atualizarValorFaturaAtual(@PathVariable("usuarioId") Long usuarioId){
        LocalDate diaAtual = LocalDate.now();

        String mes = diaAtual.getMonth().name();
        Integer ano = diaAtual.getYear();
        return atualizarValorFaturaMesCorrenteService.execute(usuarioId,mes,ano);
    }
}
