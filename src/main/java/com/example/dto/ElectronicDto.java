package com.example.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class ElectronicDto {

    private Long id;
    private String nameProduct;
    private Integer count;
    private boolean InArchive;
    private Long Price;
    private  boolean InStock;
    private Long idElectroType;
    private String description;
}
