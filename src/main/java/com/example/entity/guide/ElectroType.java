package com.example.entity.guide;

import com.example.entity.Electronic;
import com.example.entity.Employee;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Set;

@Setter
@Getter
@Entity
@ToString(exclude = "electronics")
@Table(name = "electro_type")

public class ElectroType implements Serializable {


    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = " name", length = 100)
    private String nameTypeElectronic;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "electroType")
    private Set<Electronic> electronics;
    @JsonBackReference
    @ManyToMany(mappedBy = "electroTypes", fetch = FetchType.LAZY)
    private Set<Employee> employees;

//    @JsonBackReference
//    @ManyToMany(mappedBy = "typesP", fetch = FetchType.LAZY)
//    @Column(name = "typesE")
//    private Set<Product> typesE;

}
