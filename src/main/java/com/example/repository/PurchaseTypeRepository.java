package com.example.repository;

import com.example.Entity.guide.PurchaseType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseTypeRepository extends JpaRepository<PurchaseType,Long> {
}
