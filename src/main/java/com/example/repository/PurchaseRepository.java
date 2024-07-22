package com.example.repository;

import com.example.Entity.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseRepository  extends JpaRepository<Purchase, Long> {
}
