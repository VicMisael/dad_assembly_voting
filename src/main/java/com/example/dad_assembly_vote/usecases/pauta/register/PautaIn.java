package com.example.dad_assembly_vote.usecases.pauta.register;

import com.example.dad_assembly_vote.entity.Pauta;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

public record PautaIn(String descricao,
                      LocalDateTime start,
                      LocalDateTime finish,
                      MultipartFile file
) {
    public Pauta toPauta(){
        return new Pauta();
    };
}
