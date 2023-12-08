package com.example.dad_assembly_vote.usecases.pauta.register;

import com.example.dad_assembly_vote.entity.Pauta;

import java.time.LocalDateTime;

public record PautaOut(Long id,
                       String descricao,
                       String fileUrl,
                       LocalDateTime horarioInicio,
                       LocalDateTime horarioTermino) {
    public static PautaOut fromPauta(Pauta pauta) {
        return new PautaOut(pauta.getId(), pauta.getDescricao(), pauta.getFileUrl(), pauta.getHorarioInicio(), pauta.getHorarioTermino());
    }

}
