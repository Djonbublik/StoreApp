package com.example.controller;

import com.example.dto.PositionTypeDto;
import com.example.service.PositionsTypeCRUDService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RequiredArgsConstructor
@RestController
@RequestMapping("/position")
public class PositionTypeController {
    private final PositionsTypeCRUDService service;
    @GetMapping
    public Collection<PositionTypeDto> getAll() {
        return service.getAll();
    }

    @PostMapping
    public void  create(@RequestBody PositionTypeDto positionTypeDto){
        service.create(positionTypeDto);

    }
    @RequestMapping("/update")
    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody PositionTypeDto positionTypeDto){
        positionTypeDto.setId(id);
        service.update(positionTypeDto);


    }
    @RequestMapping("/delete")
    @PutMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);

    }
}
