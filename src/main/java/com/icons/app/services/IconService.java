package com.icons.app.services;

import com.icons.app.dto.IconDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IconService {
    IconDTO save(IconDTO dto);
    List<IconDTO> getAllIcons();

    public void delete(Long id);
}
