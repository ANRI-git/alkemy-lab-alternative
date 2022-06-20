package com.icons.app.repository;

import com.icons.app.dto.IconDTO;
import com.icons.app.entities.IconEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IconRepository extends JpaRepository<IconEntity, Long> {
}
