package com.example.urlshortener.repository;

import com.example.urlshortener.models.ClickEvent;
import com.example.urlshortener.models.UrlMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ClickEventRepository extends JpaRepository<ClickEvent, Long> {

    List<ClickEvent> findByUrlMappingAndClickedDateBetween(
            UrlMapping mapping,
            LocalDateTime startDate,
            LocalDateTime endDate
    );

    List<ClickEvent> findByUrlMappingInAndClickedDateBetween(
            List<UrlMapping> mappings,
            LocalDateTime startDate,
            LocalDateTime endDate
    );
}