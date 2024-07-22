package com.example.repository;

import com.example.Entity.guide.ElectroType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElectroTypesRepository extends JpaRepository<ElectroType, Long> {
}
