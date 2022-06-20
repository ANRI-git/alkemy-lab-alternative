package com.icons.app.controller;

import com.icons.app.dto.ContinentDTO;
import com.icons.app.dto.CountryDTO;
import com.icons.app.services.ContinentService;
import com.icons.app.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("countries")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping
    public ResponseEntity<List<CountryDTO>> getAll() {
        List<CountryDTO> countries = countryService.getAllCountries();
        return ResponseEntity.ok().body(countries);
    }

    @PostMapping
    public ResponseEntity<CountryDTO> save(@RequestBody CountryDTO country) {
        CountryDTO savedCountry = countryService.save(country);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCountry);
    }
}
