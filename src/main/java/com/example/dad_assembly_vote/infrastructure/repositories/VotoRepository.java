package com.example.dad_assembly_vote.infrastructure.repositories;

import com.example.dad_assembly_vote.entity.Voto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VotoRepository extends JpaRepository<Voto, Long> {
}
