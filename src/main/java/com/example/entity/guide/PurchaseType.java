package com.example.entity.guide;

import com.example.entity.Purchase;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@Entity
@Setter
@Getter
@Table(name = "types_purchases")

public class PurchaseType implements Serializable {

    @Id
    private Long id;

    @Column(name = "name_type_purchases", length = 100)
    private String nameTypePurchases;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "purchaseType")
    private Set<Purchase> purchases;

}
