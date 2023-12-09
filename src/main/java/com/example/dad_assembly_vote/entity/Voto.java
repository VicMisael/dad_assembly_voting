package com.example.dad_assembly_vote.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.util.Objects;

@Entity
@Table(name = "tb_voto")
@Getter
@Setter
public class Voto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private Opcao opcao;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "user_id")
    private Long pautaId;
    @ManyToOne
    @JoinColumn(name = "pauta_id")
    private Pauta pauta;

    public Voto(Opcao opcao, Long userId, Long pautaId) {
        this.userId = userId;
        this.pautaId = pautaId;
        this.opcao = opcao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Voto voto = (Voto) o;
        return id != null && Objects.equals(id, voto.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}