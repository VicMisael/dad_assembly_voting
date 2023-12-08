package com.example.dad_assembly_vote.usecases.pauta.query;

import java.time.LocalDateTime;
import java.util.List;

public record PautaQueryOut(
        String descricao,
        String fileUrl,
        LocalDateTime horarioInicio,
        LocalDateTime horarioTermino,
        List<VotoOut> votos
        ) {
}
