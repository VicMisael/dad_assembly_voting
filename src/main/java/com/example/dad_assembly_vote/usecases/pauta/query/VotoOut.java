package com.example.dad_assembly_vote.usecases.pauta.query;

import com.example.dad_assembly_vote.entity.Opcao;
import com.example.dad_assembly_vote.entity.Voto;

public record VotoOut(Opcao opcao,
                      String username) {
    public static VotoOut fromVoto(Voto voto) {
        return new VotoOut(voto.getOpcao(), voto.getUser().getName());
    }

}
