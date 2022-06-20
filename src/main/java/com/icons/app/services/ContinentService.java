package com.icons.app.services;

import com.icons.app.dto.ContinentDTO;

import java.util.List;

public interface ContinentService {
    ContinentDTO save(ContinentDTO dto);
    List<ContinentDTO> getAllContinents();
}
