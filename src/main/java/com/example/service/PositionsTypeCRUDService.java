package com.example.service;

import com.example.Entity.guide.PositionType;
import com.example.dto.PositionTypeDto;
import com.example.repository.PositionTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@RequiredArgsConstructor
@Service
public class PositionsTypeCRUDService implements CRUDService<PositionTypeDto> {
    private final PositionTypeRepository repository;

    @Override
    public PositionTypeDto getById(Long id) {
        return null;
    }

    @Override
    public Collection<PositionTypeDto> getAll() {
        return repository.findAll().stream().map(PositionsTypeCRUDService::mapToDto).toList();
    }

    @Override
    public void create(PositionTypeDto item) {
        repository.save(mapToEntity(item));

    }

    @Override
    public void update(PositionTypeDto item) {
        repository.save(mapToEntity(item));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }


    public static PositionTypeDto mapToDto(PositionType positionType) {
        PositionTypeDto positionTypeDto = new PositionTypeDto();
        positionTypeDto.setId(positionType.getId());
        positionTypeDto.setName(positionType.getName());
        return positionTypeDto;
    }

    public static PositionType mapToEntity(PositionTypeDto positionTypeDto) {
        PositionType positionType = new PositionType();
        positionType.setId(positionTypeDto.getId());
        positionType.setName(positionTypeDto.getName());
        return positionType;
    }

}


