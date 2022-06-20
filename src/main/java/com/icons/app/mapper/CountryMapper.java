package com.icons.app.mapper;

import com.icons.app.controller.IconController;
import com.icons.app.dto.CountryDTO;
import com.icons.app.dto.IconDTO;
import com.icons.app.entities.CountryEntity;
import com.icons.app.entities.IconEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class CountryMapper {

    @Autowired
    private IconMapper iconMapper;

    public CountryEntity countryDTO2Entity(CountryDTO dto) {
        CountryEntity countryEntity = new CountryEntity();
        countryEntity.setImage(dto.getImage());
        countryEntity.setDenomination(dto.getDenomination());
        countryEntity.setNumPopulation(dto.getNumPopulation());
        countryEntity.setContinent(dto.getContinent());
        countryEntity.setContinentId(dto.getContinentId());
        countryEntity.setSurface(dto.getSurface());
        countryEntity.setIcons(iconMapper.iconDTOList2EntitySet(dto.getIcons()));
        return countryEntity;
    }

    public CountryDTO countryEntity2DTO(CountryEntity entity, boolean loadIcons) {
        CountryDTO countryDTO = new CountryDTO();
        countryDTO.setId(entity.getId());
        countryDTO.setImage(entity.getImage());
        countryDTO.setDenomination(entity.getDenomination());
        countryDTO.setNumPopulation(entity.getNumPopulation());
        countryDTO.setContinent(entity.getContinent());
        countryDTO.setContinentId(entity.getContinentId());
        countryDTO.setSurface(entity.getSurface());
        if (loadIcons) {
            List<IconDTO> iconDTOS = this.iconMapper.iconEntitySet2DTOList(entity.getIcons(), false);
            countryDTO.setIcons(iconDTOS);
        }
        return countryDTO;
    }

    public List<CountryDTO> countryEntityList2DTOList(List<CountryEntity> entities, boolean loadIcons) {
        List<CountryDTO> dtos = new ArrayList<>();
        for (CountryEntity entity : entities) {
            dtos.add(countryEntity2DTO(entity, loadIcons));
        }
        return dtos;
    }
}
