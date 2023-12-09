package com.example.dad_assembly_vote.entity;

import lombok.Getter;

@Getter
public enum EstadoSessao {
    NAOINICIADA(), EMCURSO(), TERMINADA(),
    NAO_CONFIGURADA();

}