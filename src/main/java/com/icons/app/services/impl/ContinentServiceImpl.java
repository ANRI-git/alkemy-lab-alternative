package com.icons.app.services.impl;

import com.icons.app.mapper.ContinentMapper;
import com.icons.app.dto.ContinentDTO;
import com.icons.app.entities.ContinentEntity;
import com.icons.app.repository.ContinentRepository;
import com.icons.app.services.ContinentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContinentServiceImpl implements ContinentService {

    @Autowired
    private ContinentMapper continentMapper;
    @Autowired
    private ContinentRepository continentRepository;

    public ContinentDTO save(ContinentDTO dto) {
        ContinentEntity entity = continentMapper.continentDTO2Entity(dto);
        ContinentEntity savedEntity =  continentRepository.save(entity);
        ContinentDTO result = continentMapper.continentEntity2DTO(savedEntity);
        return result;
    }

    public List<ContinentDTO> getAllContinents() {
        List<ContinentEntity> entities = continentRepository.findAll();
        List<ContinentDTO> continents = continentMapper.continentEntityList2DTOList(entities);
        return continents;
    }
}
