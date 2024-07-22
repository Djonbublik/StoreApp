package com.example.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@RequiredArgsConstructor
public class PurchaseDto {

    private Long id;
    private Long electroLd;
    private Date datePurchases; // дата покупки
    private Long employeeLd; // id сотрудника
    private Long purchaseType; // тип покупки
}
