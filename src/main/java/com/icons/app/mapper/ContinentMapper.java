package com.icons.app;

import com.icons.app.dto.ContinentDTO;
import com.icons.app.entities.ContinentEntity;
import org.springframework.stereotype.Component;

@Component
public class ContinentMapper {

    public ContinentEntity continentDTO2Entity(ContinentDTO dto) {
        ContinentEntity continentEntity = new ContinentEntity();
        continentEntity.setImage(dto.getImage());
        continentEntity.setDenomination(dto.getDenomination());
        return continentEntity;
    }
}
