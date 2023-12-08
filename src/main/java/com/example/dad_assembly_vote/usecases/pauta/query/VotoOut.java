package com.example.dad_assembly_vote.usecases.pauta.query;

import com.example.dad_assembly_vote.entity.Opcao;

public record VotoOut(Opcao opcao,
                      String username) {
}
