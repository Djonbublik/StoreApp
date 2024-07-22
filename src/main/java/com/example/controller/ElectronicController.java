package com.example.controller;

import com.example.dto.ElectronicDto;
import com.example.service.ElectronicCRUDService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RequestMapping("/electronic")
@RestController
@RequiredArgsConstructor
public class ElectronicController {

    private final ElectronicCRUDService service;

    @GetMapping
    public Collection<ElectronicDto> getAll() {
        return service.getAll();
    }

    @PostMapping
    public void  create(@RequestBody ElectronicDto electronicDto){
        service.create(electronicDto);

    }
    @RequestMapping("/update")
    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody ElectronicDto electronicDto){
        electronicDto.setId(id);
        service.update(electronicDto);


    }
    @RequestMapping("/delete")
    @PutMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);

    }
}
