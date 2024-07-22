package com.example.service;

import com.example.Entity.Employee;
import com.example.dto.EmployeeDto;
import com.example.Entity.guide.PositionType;
import com.example.repository.EmployeeRepository;
import com.example.repository.PositionTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@RequiredArgsConstructor
@Service
public class EmployeeCRUDService implements CRUDService<EmployeeDto> {
    private final EmployeeRepository employeeRepository;
    private final PositionTypeRepository positionTypeRepository;

    @Override
    public EmployeeDto getById(Long id) {
        return mapToDto(employeeRepository.findById(id).orElseThrow());
    }

    @Override
    public Collection<EmployeeDto> getAll() {
        return employeeRepository.findAll()
                .stream()
                .map(EmployeeCRUDService::mapToDto)
                .toList();
    }

    @Override
    public void create(EmployeeDto item) {
        employeeRepository.save(mapToEntity(item));
    }

    @Override
    public void update(EmployeeDto item) {
        employeeRepository.save(mapToEntity(item));
    }

    @Override
    public void delete(Long id) {
        employeeRepository.deleteById(id);
    }

    public Employee mapToEntity(EmployeeDto employeeDto){
        Employee employee = new Employee();
        PositionType  positionType = positionTypeRepository
                .findById(employeeDto.getPosition())
                .orElseThrow();

        employee.setId(employeeDto.getId());
        employee.setBirthday(employeeDto.getBirthday());
        employee.setGender(employeeDto.getGender());
        employee.setPatronymic(employeeDto.getPatronymic());
        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setPositionType(positionType);

        return employee;

    }
    public static EmployeeDto mapToDto(Employee employee){
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(employee.getId());
        employeeDto.setBirthday(employee.getBirthday());
        employeeDto.setGender(employee.getGender());
        employeeDto.setLastName(employee.getLastName());
        employeeDto.setPatronymic(employee.getPatronymic());
        employeeDto.setPosition(employee.getPositionType().getId());
        employeeDto.setFirstName(employee.getFirstName());

        return employeeDto;

    }

}
