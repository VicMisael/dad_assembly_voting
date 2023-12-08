package com.example.dad_assembly_vote.usecases.pauta;

import com.example.dad_assembly_vote.usecases.pauta.query.PautaQueryOut;
import com.example.dad_assembly_vote.usecases.pauta.register.PautaIn;
import com.example.dad_assembly_vote.usecases.pauta.register.PautaOut;
import com.example.dad_assembly_vote.usecases.pauta.vote.VoteIn;
import com.example.dad_assembly_vote.utils.QueryIn;
import com.example.dad_assembly_vote.utils.Queryable;

public interface IPautaService {
    public PautaOut registerPauta(PautaIn pauta);

    public PautaQueryOut queryPautas(QueryIn query);

    public void RegisterVote(VoteIn in);
}
