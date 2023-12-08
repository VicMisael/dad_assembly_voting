package com.example.dad_assembly_vote.usecases.services.impl;

import com.example.dad_assembly_vote.infrastructure.repositories.PautaRepository;
import com.example.dad_assembly_vote.usecases.pauta.IPautaService;
import com.example.dad_assembly_vote.usecases.pauta.query.PautaQueryOut;
import com.example.dad_assembly_vote.usecases.pauta.register.PautaIn;
import com.example.dad_assembly_vote.usecases.pauta.register.PautaOut;
import com.example.dad_assembly_vote.usecases.pauta.vote.VoteIn;
import com.example.dad_assembly_vote.utils.QueryIn;
import org.springframework.stereotype.Service;

@Service
public class PautaServiceImpl implements IPautaService {

    private final PautaRepository pautaRepository;

    public PautaServiceImpl(PautaRepository pautaRepository) {
        this.pautaRepository = pautaRepository;
    }

    @Override
    public PautaOut registerPauta(PautaIn pauta) {
        var out = pautaRepository.save(pauta.toPauta());
        return PautaOut.fromPauta(out);
    }

    @Override
    public PautaQueryOut queryPautas(QueryIn query) {
        return null;
    }

    @Override
    public void RegisterVote(VoteIn in) {

    }
}
