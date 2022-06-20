package com.icons.app.mapper;

import com.icons.app.dto.ContinentDTO;
import com.icons.app.entities.ContinentEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ContinentMapper {

    public ContinentEntity continentDTO2Entity(ContinentDTO dto) {
        ContinentEntity continentEntity = new ContinentEntity();
        continentEntity.setImage(dto.getImage());
        continentEntity.setDenomination(dto.getDenomination());
        return continentEntity;
    }

    public ContinentDTO continentEntity2DTO(ContinentEntity entity) {
        ContinentDTO dto = new ContinentDTO();
        dto.setImage(entity.getImage());
        dto.setDenomination(entity.getDenomination());
        dto.setId(entity.getId());
        return dto;
    }

    public List<ContinentDTO> continentEntityList2DTOList(List<ContinentEntity> entities) {
        List<ContinentDTO> dtos = new ArrayList<>();
        for (ContinentEntity entity : entities) {
            dtos.add(this.continentEntity2DTO(entity));
        }
        return dtos;
    }
}
