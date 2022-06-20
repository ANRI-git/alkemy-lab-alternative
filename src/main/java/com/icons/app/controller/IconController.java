package com.icons.app.controller;

import com.icons.app.dto.IconDTO;
import com.icons.app.services.IconService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("icons")
public class IconController {

    @Autowired
    private IconService iconService;

    @GetMapping("/all")
    public ResponseEntity<List<IconDTO>> getAll() {
        List<IconDTO> icons = iconService.getAllIcons();
        return ResponseEntity.ok().body(icons);
    }

    @PostMapping
    public ResponseEntity<IconDTO> save(@RequestBody IconDTO icon) {
        IconDTO savedIcon = iconService.save(icon);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedIcon);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.iconService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
