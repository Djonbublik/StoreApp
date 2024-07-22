package com.example.Entity;


import com.example.Entity.guide.PurchaseType;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;
@Getter
@Setter
@Entity
@Table(name = "purchases")
public class Purchase implements Serializable {
    @Id
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "electrold", nullable = false)
    private Electronic electronic;

    @Column(name = "date_purchases", columnDefinition = "date")
    private Date datePurchases; // дата покупки

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "employeeld", nullable = false)
    private Employee employee; // id сотрудника

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "type", nullable = false)
    private PurchaseType purchaseType; // тип покупки


}
