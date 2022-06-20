package com.icons.app.services.impl;

import com.icons.app.dto.CountryDTO;
import com.icons.app.entities.CountryEntity;
//import com.icons.app.entities.IconCountry;
import com.icons.app.mapper.CountryMapper;
import com.icons.app.repository.CountryRepository;
//import com.icons.app.repository.IconCountryRepository;
import com.icons.app.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryMapper countryMapper;
    @Autowired
    private CountryRepository countryRepository;

    public CountryDTO save(CountryDTO dto) {
        CountryEntity entity = countryMapper.countryDTO2Entity(dto);
        System.out.println(entity);
        CountryEntity entitySaved = countryRepository.save(entity);
        CountryDTO result = countryMapper.countryEntity2DTO(entitySaved, false);
//        dto.getIcons().forEach(icon -> {
//                IconCountry iconCountry = new IconCountry();
//                iconCountry.setIconId(icon.getId());
//                iconCountry.setCountryId(result.getId());
//                iconCountryRepository.save(iconCountry);
//        });
        return result;
    }

    public List<CountryDTO> getAllCountries() {
        List<CountryEntity> entities = countryRepository.findAll();
        return countryMapper.countryEntityList2DTOList(entities, true);
    }
}
