package com.icons.app.services.impl;

import com.icons.app.dto.IconDTO;
import com.icons.app.entities.IconEntity;
import com.icons.app.mapper.IconMapper;
//import com.icons.app.repository.IconCountryRepository;
import com.icons.app.repository.IconRepository;
import com.icons.app.services.IconService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class IconServiceImpl implements IconService {

    @Autowired
    private IconMapper iconMapper;
    @Autowired
    private IconRepository iconRepository;

    public IconDTO save(IconDTO dto) {
        IconEntity entity = iconMapper.iconDTO2Entity(dto);
        IconEntity savedEntity = iconRepository.save(entity);
        return iconMapper.iconEntity2DTO(savedEntity, false);
    }

    public List<IconDTO> getAllIcons() {
        List<IconEntity> entities = iconRepository.findAll();
        Set<IconEntity> entitiesSet = new HashSet<>(entities);
        return iconMapper.iconEntitySet2DTOList(entitiesSet, true);
    }

//    public List<IconDTO> getCountryIcons(Long iconId, Long countryId) {
//        List<IconEntity> entities = iconCountryRepository.findAllCountryIcons(iconId, countryId);
//        Set<IconEntity> entitiesSet = new HashSet<>(entities);
//        return iconMapper.iconEntitySet2DTOList(entitiesSet, false);
//    }

    public void delete(Long id) {
        iconRepository.deleteById(id);
    }
}
