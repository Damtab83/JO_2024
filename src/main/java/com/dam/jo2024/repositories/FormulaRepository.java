package com.dam.jo2024.repositories;

import com.dam.jo2024.pojo.Formula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormulaRepository extends JpaRepository<Formula, Long> {
}
