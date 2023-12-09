package com.example.dad_assembly_vote.usecases.pauta.query;

import com.example.dad_assembly_vote.entity.Pauta;

import java.time.LocalDateTime;
import java.util.List;

public record PautaQueryOut(
        Long id,
        String descricao,
        String fileUrl,
        LocalDateTime horarioInicio,
        LocalDateTime horarioTermino,
        List<VotoOut> votos
) {
    public static PautaQueryOut fromPauta(Pauta pauta) {
        return new PautaQueryOut(pauta.getId(), pauta.getDescricao(), pauta.getFileUrl(), pauta.getHorarioInicio(), pauta.getHorarioTermino(), pauta
                .getVotoes().stream().map(VotoOut::fromVoto).toList());
    }
}
