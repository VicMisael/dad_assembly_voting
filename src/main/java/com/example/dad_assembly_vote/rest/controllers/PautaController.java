package com.example.dad_assembly_vote.rest.controllers;

import com.example.dad_assembly_vote.usecases.pauta.IPautaService;
import com.example.dad_assembly_vote.usecases.pauta.register.PautaIn;
import com.example.dad_assembly_vote.usecases.pauta.register.PautaOut;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("pauta")
public class PautaController {

    private final IPautaService pautaService;

    public PautaController(IPautaService pautaService) {

        this.pautaService = pautaService;
    }

    @PostMapping
    public PautaOut RegisterPauta(PautaIn pauta) {
        return pautaService.registerPauta(pauta);

    }
}
