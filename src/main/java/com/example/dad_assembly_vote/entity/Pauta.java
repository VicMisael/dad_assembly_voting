package com.example.dad_assembly_vote.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_pauta")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Pauta {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue
    private Long id;

    private String descricao;

    private String fileUrl;


    private LocalDateTime horarioInicio;

    private LocalDateTime horarioTermino;

    @OneToMany(orphanRemoval = true)
    @JoinColumn(name = "pauta_id")
    private Set<Voto> votoes = new LinkedHashSet<>();

    public Pauta(String descricao, String fileUrl, LocalDateTime horarioInicio, LocalDateTime horarioTermino) {
        this.descricao = descricao;
        this.fileUrl = fileUrl;
        this.horarioInicio = horarioInicio;
        this.horarioTermino = horarioTermino;
    }

    public Pauta(String descricao, LocalDateTime horarioInicio, LocalDateTime horarioTermino) {
        this.descricao = descricao;
        this.horarioInicio = horarioInicio;
        this.horarioTermino = horarioTermino;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Pauta pauta = (Pauta) o;
        return id != null && Objects.equals(id, pauta.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}