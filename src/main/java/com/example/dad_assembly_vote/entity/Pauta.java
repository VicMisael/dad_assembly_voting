package com.example.dad_assembly_vote.entity;

import jakarta.persistence.*;
import org.hibernate.Hibernate;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_pauta")
public class Pauta {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    private String descricao;

    @Column(nullable = true)
    private String opcao;

    @OneToMany(mappedBy = "pauta", orphanRemoval = true)
    private Set<Voto> votos = new LinkedHashSet<>();

    public Set<Voto> getVotos() {
        return votos;
    }

    public void setVotos(Set<Voto> votos) {
        this.votos = votos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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