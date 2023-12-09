package com.example.dad_assembly_vote.rest.controllers;

import com.example.dad_assembly_vote.usecases.pauta.IPautaService;
import com.example.dad_assembly_vote.usecases.pauta.query.PautaQueryOut;
import com.example.dad_assembly_vote.usecases.pauta.register.PautaIn;
import com.example.dad_assembly_vote.usecases.pauta.register.PautaOut;
import com.example.dad_assembly_vote.utils.QueryIn;
import com.example.dad_assembly_vote.utils.Queryable;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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

    @GetMapping
    public Queryable<PautaQueryOut> getPautas(@RequestParam Optional<String> query,
                                             @RequestParam Optional<Integer> page,
                                             @RequestParam Optional<Integer> perPage) {
        int perPageFiltered = perPage.orElse(10);
        int pageFiltered = page.orElse(0);
        var queryIn = new QueryIn(query.orElse(""), Math.max(pageFiltered, 0), perPageFiltered <= 0 ? 10 : perPageFiltered);
        return pautaService.queryPautas(queryIn);
    }


}
