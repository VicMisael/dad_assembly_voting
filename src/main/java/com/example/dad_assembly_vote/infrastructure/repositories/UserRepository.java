package com.example.dad_assembly_vote.infrastructure.repositories;

import com.example.dad_assembly_vote.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository extends JpaRepository<User, Long>, PagingAndSortingRepository<User, Long> {
}
