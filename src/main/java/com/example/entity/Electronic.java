package com.example.entity;

import com.example.entity.guide.ElectroType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@Setter
@Getter
@Entity
@Table (name = "Electronic")
@RequiredArgsConstructor
public class Electronic implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 150)
    private String nameProduct;

    @Column(name = "count")
    private Integer count;

    @Column(name = "archive")
    private boolean InArchive;

    @Column(name = "price")
    private Long Price;

    @Column(name = "stock")
    private  boolean InStock;

    @Column(name = "description")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "e_type", nullable = false)
    private ElectroType electroType;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "electronic")
    private Set<Purchase> purchases;

}
