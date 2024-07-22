package com.example.service;

import com.example.Entity.Electronic;
import com.example.dto.ElectronicDto;
import com.example.Entity.guide.ElectroType;
import com.example.repository.ElectroTypesRepository;
import com.example.repository.ElectronicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class ElectronicCRUDService implements CRUDService<ElectronicDto>{

    private final ElectronicRepository electronicRepository;

    private final ElectroTypesRepository electroTypesRepository;

    @Override
    public ElectronicDto getById(Long id) {
        return mapToDto(electronicRepository.findById(id).orElseThrow());
    }

    @Override
    public Collection<ElectronicDto> getAll() {
        return electronicRepository.findAll().stream().map(ElectronicCRUDService::mapToDto).toList();
    }

    @Override
    public void create(ElectronicDto electronicDto) {
        electronicRepository.save(mapToEntity(electronicDto));
    }

    @Override
    public void update(ElectronicDto electronicDto) {
        electronicRepository.save(mapToEntity(electronicDto));
    }

    @Override
    public void delete(Long id) {
        electronicRepository.deleteById(id);
    }

    public static ElectronicDto mapToDto(Electronic electronic){
        ElectronicDto electronicDto = new ElectronicDto();
        ElectroType electroType = electronic.getElectroType();

        electronicDto.setId(electronic.getId());
        electronicDto.setNameProduct(electronic.getNameProduct());
        electronicDto.setPrice(electronic.getPrice());
        electronicDto.setCount(electronic.getCount());
        electronicDto.setInStock(electronic.isInStock());
        electronicDto.setInArchive(electronic.isInArchive());
        electronicDto.setDescription(electronic.getDescription());
        electronicDto.setIdElectroType(electroType.getId());
        return electronicDto;
    }




    public  Electronic mapToEntity(ElectronicDto electronicDto){
        Electronic electronic = new Electronic();
        ElectroType electroType = electroTypesRepository
                .findById(electronicDto.getIdElectroType())
                .orElseThrow();

        electronic.setId(electronicDto.getId());
        electronic.setInStock(electronicDto.isInStock());
        electronic.setNameProduct(electronicDto.getNameProduct());
        electronic.setPrice(electronicDto.getPrice());
        electronic.setCount(electronicDto.getCount());
        electronic.setInArchive(electronicDto.isInArchive());
        electronic.setDescription(electronicDto.getDescription());
        electronic.setElectroType(electroType);
        return electronic;

    }
}
