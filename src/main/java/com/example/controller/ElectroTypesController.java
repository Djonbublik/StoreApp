package com.example.controller;

import com.example.dto.ElectroTypeDto;
import com.example.service.ElectroTypeCRUDService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RequestMapping("/typesElectronic")
@RestController
@RequiredArgsConstructor
public class ElectroTypesController {
    private final ElectroTypeCRUDService typesEService;


    @GetMapping
    public Collection<ElectroTypeDto> getAll() {
        return typesEService.getAll();
    }

    @PostMapping
    public void  create(@RequestBody ElectroTypeDto electroTypeDto){
        typesEService.create(electroTypeDto);

    }
    @RequestMapping("/update")
    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody ElectroTypeDto electroTypeDto){
        electroTypeDto.setId(id);
        typesEService.update(electroTypeDto);


    }
    @RequestMapping("/delete")
    @PutMapping("/{id}")
    public void delete(@PathVariable Long id){
        typesEService.delete(id);
    }

}
