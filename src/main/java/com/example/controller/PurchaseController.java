package com.example.controller;

import com.example.dto.PurchaseDto;
import com.example.service.PurchaseCRUDService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
@RequestMapping("/purchase")
@RestController
@RequiredArgsConstructor
public class PurchaseController {
    private final PurchaseCRUDService service;

    @GetMapping
    public Collection<PurchaseDto> getAll() {
        return service.getAll();
    }

    @PostMapping
    public void  create(@RequestBody PurchaseDto items){
        service.create(items);

    }
    @RequestMapping("/update")
    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody PurchaseDto items){
        items.setId(id);
        service.update(items);


    }
    @RequestMapping("/delete")
    @PutMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);

    }
}