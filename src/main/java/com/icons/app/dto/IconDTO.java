package com.icons.app.dto;

import com.icons.app.entities.CountryEntity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class IconDTO {
    private Long id;
    private String image;
    private String denomination;
    private LocalDate creationDate;
    private Long height;
    private String history;
    private List<CountryDTO> countries;
}
