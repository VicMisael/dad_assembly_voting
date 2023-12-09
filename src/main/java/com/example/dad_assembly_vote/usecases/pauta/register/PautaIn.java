package com.example.dad_assembly_vote.usecases.pauta.register;

import com.example.dad_assembly_vote.entity.Pauta;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Date;

public record PautaIn(String descricao,
                      @DateTimeFormat(pattern="yyyy-MM-dd")
                      Date start,
                      @DateTimeFormat(pattern="yyyy-MM-dd")
                      Date finish
) {
    public Pauta toPauta() {
        return new Pauta(descricao, LocalDateTime.ofInstant(start.toInstant(), ZoneId.systemDefault()),  LocalDateTime.ofInstant(finish.toInstant(), ZoneId.systemDefault()));
    }

    ;
}
