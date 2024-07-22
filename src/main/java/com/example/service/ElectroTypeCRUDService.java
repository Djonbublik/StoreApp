package com.example.service;

import com.example.dto.ElectroTypeDto;
import com.example.Entity.guide.ElectroType;
import com.example.repository.ElectroTypesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Collection;

@Service
@RequiredArgsConstructor
public class ElectroTypeCRUDService implements CRUDService<ElectroTypeDto> {
    private final ElectroTypesRepository repository;
    @Override
    public ElectroTypeDto getById(Long id) {

        return mapToDto(repository.findById(id).orElseThrow());
    }


    @Override
    public Collection<ElectroTypeDto> getAll() {

        return repository.findAll()
                .stream()
                .map(ElectroTypeCRUDService::mapToDto)
                .toList();
    }

    @Override
    public void create(ElectroTypeDto item) {
        repository.save(mapToEntity(item));

    }

    @Override
    public void update(ElectroTypeDto item) {
        repository.save(mapToEntity(item));
    }


    @Override
    public void delete(Long id) {
        repository.deleteById(id);

    }
    public static ElectroType mapToEntity(ElectroTypeDto typesElectronicDto){
        ElectroType electroType = new ElectroType();
        electroType.setId(typesElectronicDto.getId());
        electroType.setNameTypeElectronic(typesElectronicDto.getNameTypeElectronic());
        return electroType;
    }

    public static ElectroTypeDto mapToDto(ElectroType electroType){
        ElectroTypeDto typesElectronicDto = new ElectroTypeDto();
        typesElectronicDto.setId(electroType.getId());
        typesElectronicDto.setNameTypeElectronic(electroType.getNameTypeElectronic());
        return typesElectronicDto;

    }
}
