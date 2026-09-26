package com.example.urlshortener.service;

import com.example.urlshortener.models.ClickEvent;
import com.example.urlshortener.repository.ClickEventRepository;
import com.example.urlshortener.repository.UrlMappingRepository;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class ClickTrackingService {
    private UrlMappingRepository urlMappingRepository;
    private ClickEventRepository clickEventRepository;

    @Async
    public void trackClickAsync(Long urlMappingId){
        urlMappingRepository.incrementClickAsync(urlMappingId);
        ClickEvent clickEvent = new ClickEvent();
        clickEvent.setClickedDate(LocalDateTime.now());
        clickEvent.setUrlMapping(urlMappingRepository.getReferenceById(urlMappingId));
        clickEventRepository.save(clickEvent);
    }
}
