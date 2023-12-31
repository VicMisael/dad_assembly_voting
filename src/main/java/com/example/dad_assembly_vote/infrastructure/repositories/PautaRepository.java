package com.example.dad_assembly_vote.infrastructure.repositories;

import com.example.dad_assembly_vote.entity.Pauta;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PautaRepository extends JpaRepository<Pauta, Long>, PagingAndSortingRepository<Pauta, Long> {

    public Page<Pauta> findAllByDescricaoContainingIgnoreCase(String descricao, Pageable pageable);


}
