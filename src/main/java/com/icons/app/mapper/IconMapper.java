package com.icons.app.mapper;

import com.icons.app.dto.CountryDTO;
import com.icons.app.dto.IconDTO;
import com.icons.app.entities.IconEntity;
import com.icons.app.repository.CountryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class IconMapper {
    @Autowired
    private CountryMapper countryMapper;
    
    public IconEntity iconDTO2Entity(IconDTO dto) {
        IconEntity iconEntity = new IconEntity();
        iconEntity.setImage(dto.getImage());
        iconEntity.setDenomination(dto.getDenomination());
        iconEntity.setCreationDate(dto.getCreationDate());
        iconEntity.setHeight(dto.getHeight());
        iconEntity.setHistory(dto.getHistory());
        return iconEntity;
    }

    public IconDTO iconEntity2DTO(IconEntity entity, boolean loadCountries) {
        IconDTO iconDTO = new IconDTO();
        iconDTO.setId(entity.getId());
        iconDTO.setImage(entity.getImage());
        iconDTO.setDenomination(entity.getDenomination());
        iconDTO.setCreationDate(entity.getCreationDate());
        iconDTO.setHeight(entity.getHeight());
        iconDTO.setHistory(entity.getHistory());
        if (loadCountries) {
            List<CountryDTO> countriesDTO = this.countryMapper.countryEntityList2DTOList(entity.getCountries(), false);
            iconDTO.setCountries(countriesDTO);
        }
        return iconDTO;
    }

    public List<IconDTO> iconEntitySet2DTOList(Set<IconEntity> entities, boolean loadCountry) {
        List<IconDTO> dtos = new ArrayList<>();
        for (IconEntity entity : entities) {
            dtos.add(iconEntity2DTO(entity, loadCountry));
        }
        return dtos;
    }

    public Set<IconEntity> iconDTOList2EntitySet(List<IconDTO> dtos) {
        Set<IconEntity> entities = new HashSet<>();
        for (IconDTO dto : dtos) {
            entities.add(iconDTO2Entity(dto));
        }
        return entities;
    }
}
