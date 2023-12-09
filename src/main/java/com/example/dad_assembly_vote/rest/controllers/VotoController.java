package com.example.dad_assembly_vote.rest.controllers;

import com.example.dad_assembly_vote.usecases.pauta.IPautaService;
import com.example.dad_assembly_vote.usecases.pauta.vote.VoteIn;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("voto")
public class VotoController {

    private final IPautaService pautaService;

    public VotoController(IPautaService pautaService) {
        this.pautaService = pautaService;
    }

    @PutMapping
    public void Vote(VoteIn in) {
        pautaService.RegisterVote(in);
    }
}
