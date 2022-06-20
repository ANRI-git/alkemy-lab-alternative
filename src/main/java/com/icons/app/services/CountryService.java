package com.icons.app.services;

import com.icons.app.dto.CountryDTO;

import java.util.List;

public interface CountryService {
    CountryDTO save(CountryDTO dto);
    List<CountryDTO> getAllCountries();
}
