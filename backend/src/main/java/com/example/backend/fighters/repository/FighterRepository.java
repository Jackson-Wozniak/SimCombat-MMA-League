package com.example.backend.fighters.repository;

import com.example.backend.fighters.entity.Fighter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FighterRepository extends JpaRepository<Fighter, String> {
}
