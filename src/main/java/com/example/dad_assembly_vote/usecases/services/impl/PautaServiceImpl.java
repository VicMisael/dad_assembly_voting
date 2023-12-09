package com.example.dad_assembly_vote.usecases.services.impl;

import com.example.dad_assembly_vote.entity.Pauta;
import com.example.dad_assembly_vote.entity.Voto;
import com.example.dad_assembly_vote.infrastructure.repositories.PautaRepository;
import com.example.dad_assembly_vote.infrastructure.repositories.VotoRepository;
import com.example.dad_assembly_vote.usecases.pauta.IPautaService;
import com.example.dad_assembly_vote.usecases.pauta.query.PautaQueryOut;
import com.example.dad_assembly_vote.usecases.pauta.register.PautaIn;
import com.example.dad_assembly_vote.usecases.pauta.register.PautaOut;
import com.example.dad_assembly_vote.usecases.pauta.vote.VoteIn;
import com.example.dad_assembly_vote.utils.QueryIn;
import com.example.dad_assembly_vote.utils.Queryable;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class PautaServiceImpl implements IPautaService {

    private final PautaRepository pautaRepository;
    private final VotoRepository votoRepository;

    public PautaServiceImpl(PautaRepository pautaRepository, VotoRepository votoRepository) {
        this.pautaRepository = pautaRepository;
        this.votoRepository = votoRepository;
    }

    @Override
    public PautaOut registerPauta(PautaIn pauta) {
        final Pauta pauta1 = pauta.toPauta();
        var out = pautaRepository.save(pauta1);
        return PautaOut.fromPauta(out);
    }

    @Override
    public PautaOut AddDocument(Long id, MultipartFile file) {
        return null;
    }

    @Override
    public Queryable<PautaQueryOut> queryPautas(QueryIn query) {
        var page = pautaRepository.findAll(Pageable.ofSize(query.perPage()));

        return new Queryable<>(page.getNumber(), (int) pautaRepository.count(), query.perPage(), page.getContent()
                .stream().map(PautaQueryOut::fromPauta).toList());
    }

    @Override
    public void RegisterVote(VoteIn in) {
        votoRepository.save(new Voto(in.opcao(), in.idUser(), in.idPauta()));
    }
}
