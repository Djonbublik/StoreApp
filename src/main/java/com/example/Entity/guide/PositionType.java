package com.example.Entity.guide;

import com.example.Entity.Employee;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Set;
@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "position_type")
public class PositionType {

    @Id
    private Long id;
    @Column(name = "name",length = 100)
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "positionType")
    private Set<Employee> employees;


}
