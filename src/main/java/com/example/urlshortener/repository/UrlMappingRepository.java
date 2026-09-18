package com.example.urlshortener.repository;

import com.example.urlshortener.models.UrlMapping;
import com.example.urlshortener.models.User;
import jakarta.transaction.Transactional;
import org.hibernate.annotations.TypeRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UrlMappingRepository extends JpaRepository<UrlMapping,Long> {
    UrlMapping findByShortUrl(String shortUrl);
    List<UrlMapping> findByUser(User user);

    @Modifying
    @Transactional
    @Query("UPDATE UrlMAPPING u SET u.click_count=u.click_count+1 WHERE u.id = :id")
    void incrementClickAsync(@Param("id") Long id);
}
