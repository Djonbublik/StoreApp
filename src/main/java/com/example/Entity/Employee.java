package com.example.Entity;

import com.example.Entity.guide.ElectroType;
import com.example.Entity.guide.PositionType;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "employee")
public class Employee implements Serializable {
    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "last_name", length = 100)
    private String lastName;// фамилия
    @Column(name = "first_name", length = 100)
    private String firstName;
    @Column(name = "patronymic", length = 100)
    private String patronymic; // отчество

    @Column(columnDefinition = "date", name = "birthday")
    private Date birthday;// день рождения

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "position", nullable = false)
    private PositionType positionType;// id должности

    @Column(name = "gender")
    private Boolean gender;// пол

    @JsonBackReference
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name="electroemployee",
            joinColumns=  @JoinColumn(name="e_type"),
            inverseJoinColumns= @JoinColumn(name="employeeld"))
    private Set<ElectroType> electroTypes;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
    private Set<Purchase> purchases;


}
