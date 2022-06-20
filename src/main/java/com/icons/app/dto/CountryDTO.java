package com.icons.app.dto;

import com.icons.app.entities.ContinentEntity;
import com.icons.app.entities.IconEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Setter
@Getter
public class CountryDTO {
    private Long id;
    private String image;
    private String denomination;
    private Long numPopulation;
    private Long surface;
    private ContinentEntity continent;
    private Long continentId;
    private List<IconDTO> icons;
}
