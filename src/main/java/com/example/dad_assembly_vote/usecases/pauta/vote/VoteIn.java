package com.example.dad_assembly_vote.usecases.pauta.vote;

import com.example.dad_assembly_vote.entity.Opcao;

public record VoteIn(
        Long idUser,
        Long idPauta,
        Opcao opcao
) {
}
