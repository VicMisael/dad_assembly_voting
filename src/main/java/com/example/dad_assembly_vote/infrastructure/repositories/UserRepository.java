package com.example.dad_assembly_vote.infrastructure.repositories;

import com.example.dad_assembly_vote.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long>, PagingAndSortingRepository<User, Long> {

    public Page<User> findAllByNameContainingIgnoreCase(String name, Pageable pageable);
}
