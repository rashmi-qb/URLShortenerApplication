package com.urlshortener.repository;

import com.urlshortener.entity.UrlMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.LockModeType;
import java.util.List;
import java.util.Optional;

public interface UrlShortenerRepository extends JpaRepository<UrlMapping, Integer>{

    @Query(nativeQuery = true, value = "SELECT * " +
            "FROM URL_MAPPING where ID = ?1  For update ")
    Optional<UrlMapping> findById(Integer id);

    @Query(nativeQuery = true, value = "SELECT * " +
            "FROM URL_MAPPING where ID = (Select ID from URL_MAPPING where ORIGINAL_URL = '' limit 1) For update ")
    Optional<UrlMapping> findEmptyUrl();

    // We need to do row locking as above but for now keeping it simple
    @Query(nativeQuery = true,
            value = "Select * from URL_MAPPING where CALL_TIME = (Select min(CALL_TIME) from URL_MAPPING) limit 1")
    Optional<UrlMapping> findLeastUsedDate();
    

    List<UrlMapping> findAllByOrderByCountDesc();
  
}
