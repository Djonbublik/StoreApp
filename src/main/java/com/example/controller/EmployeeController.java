package com.example.controller;

import com.example.dto.EmployeeDto;
import com.example.service.EmployeeCRUDService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
@RequestMapping("/employee")
@RestController
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeCRUDService service;




    @GetMapping
    public Collection<EmployeeDto> getAll() {
        return service.getAll();
    }


    @PostMapping
    public void  create(@RequestBody EmployeeDto employeeDto){
        service.create(employeeDto);

    }
    @RequestMapping("/update")
    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody EmployeeDto employeeDto){
        employeeDto.setId(id);
        service.update(employeeDto);


    }
    @RequestMapping("/delete")
    @PutMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);

    }
}
