package com.example.dad_assembly_vote.usecases.services.impl;

import com.example.dad_assembly_vote.entity.Pauta;
import com.example.dad_assembly_vote.entity.Voto;
import com.example.dad_assembly_vote.infrastructure.repositories.PautaRepository;
import com.example.dad_assembly_vote.infrastructure.repositories.UserRepository;
import com.example.dad_assembly_vote.infrastructure.repositories.VotoRepository;
import com.example.dad_assembly_vote.usecases.pauta.IPautaService;
import com.example.dad_assembly_vote.usecases.pauta.query.PautaQueryOut;
import com.example.dad_assembly_vote.usecases.pauta.register.PautaIn;
import com.example.dad_assembly_vote.usecases.pauta.register.PautaOut;
import com.example.dad_assembly_vote.usecases.pauta.vote.VoteIn;
import com.example.dad_assembly_vote.utils.EstadoUtils;
import com.example.dad_assembly_vote.utils.QueryIn;
import com.example.dad_assembly_vote.utils.Queryable;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

@Service
public class PautaServiceImpl implements IPautaService {

    private final PautaRepository pautaRepository;
    private final VotoRepository votoRepository;
    private final UserRepository userRepository;

    public PautaServiceImpl(PautaRepository pautaRepository, VotoRepository votoRepository, UserRepository userRepository) {
        this.pautaRepository = pautaRepository;
        this.votoRepository = votoRepository;
        this.userRepository = userRepository;
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
        var pageConfig = PageRequest.of(query.page(), query.perPage() == 0 ? 10 : query.perPage());

        var page = query.query().isBlank() ? pautaRepository.findAll(pageConfig) : pautaRepository.findAllByDescricaoContainingIgnoreCase(query.query(), pageConfig);

        return new Queryable<>(page.getNumber(), (int) pautaRepository.count(), query.perPage(), page.getContent()
                .stream().map(PautaQueryOut::fromPauta).toList());
    }

    @Override
    public void RegisterVote(VoteIn in) {
        var pauta = pautaRepository.findById(in.idPauta());
        var user = userRepository.existsById(in.idUser());

        if (pauta.isPresent() && user) {
            var pautaObj = pauta.get();
            var estado = EstadoUtils.checkEstadoSessao(pautaObj.getHorarioInicio(), pautaObj.getHorarioTermino());
            switch (estado) {
                case NAOINICIADA -> {
                    throw new ResponseStatusException(
                            HttpStatus.BAD_REQUEST, "Votacao nao inciada"
                    );
                }
                case TERMINADA -> {
                    throw new ResponseStatusException(
                            HttpStatus.NOT_FOUND, "Votacao Encerrada"
                    );
                }
            }
            votoRepository.save(new Voto(in.opcao(), in.idUser(), in.idPauta()));
        } else
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "entity not found"
            );
    }
}
